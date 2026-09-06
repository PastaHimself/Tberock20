const FAKE_DISCONNECT_DEFINITION = Object.freeze({
  heading: "Connection Lost",
  title: "Timed out",
  body: "Timed out",
  button: "Back to title screen",
  canCloseOnEsc: false,
  autoCloseTicks: 100,
  panorama: true,
});

export function fakeDisconnectDefinition() {
  return { ...FAKE_DISCONNECT_DEFINITION };
}
