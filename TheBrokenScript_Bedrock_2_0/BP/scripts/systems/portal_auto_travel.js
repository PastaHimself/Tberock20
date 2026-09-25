import * as operationDiagnostics from "../core/operation_diagnostics.js";
import {
  automaticPortalTarget,
  insidePortalVolume,
  linkedPortalDestinationExists,
  portalKey,
  portalReferenceFromKey,
} from "./ported_feature_logic.js";

// Java's controller scans its linked volume every tick. Bedrock stores one
// controller block per anchor, so this adapter uses the two air blocks above
// each controller as the entry volume and keeps an arrival guard until exit.
export class PortalSweep {
  /** @param {{ getDimension: (id: string) => import("@minecraft/server").Dimension | undefined, getEntity: (id: string) => import("@minecraft/server").Entity | undefined, shouldSkipEntity?: (entity: import("@minecraft/server").Entity) => boolean, onPlayerTravel?: (player: import("@minecraft/server").Entity) => void }} options */
  constructor({ getDimension, getEntity, shouldSkipEntity = () => false, onPlayerTravel = () => {} }) {
    this.getDimension = getDimension;
    this.getEntity = getEntity;
    this.shouldSkipEntity = shouldSkipEntity;
    this.onPlayerTravel = onPlayerTravel;
    this.arrivals = new Map();
  }

  markArrival(entity, destination) {
    this.arrivals.set(entity.id, destination);
  }

  clear() {
    this.arrivals.clear();
  }

  refreshArrivals() {
    for (const [id, destination] of this.arrivals) {
      try {
        const entity = this.getEntity(id);
        if (!entity || (entity.dimension && entity.dimension.id !== destination.dimensionId)
            || !insidePortalVolume(destination, entity.location)) this.arrivals.delete(id);
      } catch (error) {
        this.arrivals.delete(id);
        operationDiagnostics.warnOnce("portal.arrival_refresh", "portal: failed to inspect arriving entity", error);
      }
    }
  }

  step(links) {
    this.refreshArrivals();
    let moved = 0;
    for (const [sourceKey, destination] of Object.entries(links ?? {})) {
      const source = portalReferenceFromKey(sourceKey);
      if (!source || !destination || source.dimensionId !== destination.dimensionId) continue;
      try {
        const dimension = this.getDimension(source.dimensionId);
        if (!dimension || !linkedPortalDestinationExists(dimension, source)
            || !linkedPortalDestinationExists(dimension, destination)) continue;
        const nearby = dimension.getEntities({
          location: { x: source.x + 0.5, y: source.y + 1.5, z: source.z + 0.5 },
          maxDistance: 2.5,
        });
        for (const entity of nearby) {
          try {
            if (!entity?.id
                || (this.arrivals.has(entity.id) && portalKey(this.arrivals.get(entity.id)) === sourceKey)
                || this.shouldSkipEntity(entity)
                || (entity.typeId !== "minecraft:player" && !entity.getComponent("minecraft:health"))) continue;
            const target = automaticPortalTarget(source, destination, entity.location);
            if (!target) continue;
            // Bedrock declines the move when the exit is obstructed. The source
            // controller remains untouched and the entity can retry next tick.
            entity.teleport(target, { dimension, keepVelocity: true, checkForBlocks: true });
            this.markArrival(entity, destination);
            moved++;
            if (entity.typeId === "minecraft:player") this.onPlayerTravel(entity);
          } catch (error) {
            operationDiagnostics.warnOnce("portal.auto_entity", "portal: automatic linked entity travel failed", error);
          }
        }
      } catch (error) {
        operationDiagnostics.warnOnce("portal.auto_travel", "portal: automatic linked travel failed", error);
      }
    }
    return moved;
  }
}
