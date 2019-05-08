package TeamProject;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultControl implements ActionListener{

  // Private data fields for the container and chat client.
  private JPanel container;
  private JLabel YourScore;
  private JLabel Player2Score;
  private JLabel TopLabel;
  
  private PlayerClient client;
  private JFrame PlayerGUI;
  
  // Constructor for the login controller.
  public ResultControl(JPanel container, PlayerClient client)
  {
    this.container = container;
    this.client = client;
  }
  public void setPlayerGUI (JFrame PlayerGUI) {this.PlayerGUI = PlayerGUI;}
  public void setPlayer1Score(JLabel Player1Score){this.YourScore = Player1Score;}
  public void setPlayer2Score(JLabel Player2Score){this.Player2Score = Player2Score;}
  public void setTopLabel(JLabel TopLabel){this.TopLabel = TopLabel;}

  // Handle button clicks.
  public void actionPerformed(ActionEvent ae)
  {
    // Get the name of the button clicked.
    String command = ae.getActionCommand();


    if (command.equals("Play Again"))
    {
      ChooseCategoryPanel choosePanel = (ChooseCategoryPanel) container.getComponent(3);
      choosePanel.choose();
      
      
      GuessData a = new GuessData();
      client.setTempGuessData(a);
      client.setTotalPrice(0);
      client.setWinRounds(0);
      client.setTotalRounds(0);
      
      //Send the user back to the Choose Category Panel
      CardLayout cardLayout = (CardLayout) container.getLayout();
      cardLayout.show(container, "4");
      
    }
    else if(command.equals("Exit"))
    {
      //Exit the program
    	System.exit(0); 
    }
  }

  public void winner(GuessData gld) 
  {   
    CardLayout cardLayout = (CardLayout) container.getLayout();
    cardLayout.show(container, "7");

    YourScore.setText(Integer.toString(gld.getScore())); 
    Player2Score.setText(Integer.toString(gld.getScore_2()));
    TopLabel.setText("You are the Winner!");
  }

  public void loser(GuessData gld) 
  {
    CardLayout cardLayout = (CardLayout) container.getLayout();
    cardLayout.show(container, "7");
    YourScore.setText(Integer.toString(gld.getScore())); 
    Player2Score.setText(Integer.toString(gld.getScore_2()));
    TopLabel.setText("You are the Loser!");
  }
}