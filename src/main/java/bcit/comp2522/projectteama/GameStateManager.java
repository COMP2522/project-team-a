package bcit.comp2522.projectteama;

public class GameStateManager {
  public enum GameState {
    START_MENU,
    IN_GAME,
    GAME_OVER
  }
  private GameState currentState;

  public GameState getCurrentState() {
    return currentState;
  }

  public GameStateManager() {
    currentState = GameState.START_MENU;
  }

  public void setInGameState() {
    currentState = GameState.IN_GAME;
  }

  public void setGameOverState() {
    currentState = GameState.GAME_OVER;
  }

  public boolean isPlaying() {
    return currentState == GameState.IN_GAME;
  }

  public boolean isGameOver() {
    return currentState == GameState.GAME_OVER;
  }

}
