# AEGIS Mobile — starter scaffold

AEGIS is designed as a permission-aware, voice-first personal AI assistant.

## Planned modules
- AI orchestrator: intent detection -> planner -> tool execution -> verifier
- Web research and local-file search
- Math/physics solver and coding workspace
- File generation: PDF, images, audio/video and archives
- Persistent memory with user-controlled retention
- Multiple chat inboxes / workspaces
- Voice wake-word + foreground service
- Device tools through Android-approved APIs
- Trading research dashboard with market-data adapters, portfolio analytics,
  risk controls and paper-trading mode

## Android limitations
Android does not allow an ordinary app to silently perform every device action.
Screen power, other-app termination, accessibility/global actions, protected
settings and background microphone use are permission/API constrained. AEGIS
must show the relevant Android permission/consent screen and degrade gracefully.

## Trading safety architecture
The trading module is an analysis/research assistant, not a guaranteed predictor.
It should display sources, timestamp data, assumptions, uncertainty and risk.
Real-money order execution should require an explicit user confirmation step.
Paper trading and backtesting should be enabled before live execution.

## Next implementation order
1. Replace the placeholder AI button with a secure backend/API client.
2. Add Room-based encrypted/local memory and multiple chat threads.
3. Add SAF file picker + document/media generation workers.
4. Add web-search connector and citation pipeline.
5. Add math/physics/code tool adapters.
6. Add permission-gated Android device tools.
7. Add market-data adapters, portfolio analytics and paper trading.
8. Add polished glassmorphism animations, settings, voice persona and name editor.
