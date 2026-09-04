const NULLED_GUI_MESSAGES = Object.freeze(["Good luck.", ")="]);

export function nulledGuiDefinition() {
  return {
    title: "NulledGui",
    messages: [...NULLED_GUI_MESSAGES],
  };
}

export function nulledGuiBody() {
  return NULLED_GUI_MESSAGES.join("\n\n");
}
