
package TeamProject;

import java.io.Serializable;
import java.util.ArrayList;

public class SwitchPlayer implements Serializable {
  private GuessData guessData;

  public SwitchPlayer() {
   guessData = new GuessData();
  }

  public GuessData getGuessData()
  {
    return guessData;
  }

  public void setGuessData(GuessData guessData)
  {
    this.guessData = guessData;
  }
}
