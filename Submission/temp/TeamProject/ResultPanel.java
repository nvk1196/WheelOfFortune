package TeamProject;

import javax.swing.*;
import java.awt.*;


public class ResultPanel extends JPanel
{
  private JLabel TopLabel;
  private JLabel Scores;
  private JLabel Player1;
  private JLabel YourScore;
  private JLabel Player2;
  private JLabel Player2Score;
  private JButton btnPlayAgain;
  private JButton btnQuit;
  
  //Getter and Setters
  public void setPlayer1Score(String player1Score) {YourScore.setText(player1Score);}
  public void setPlayer2Score(String player2Score) {Player2Score.setText(player2Score);}
 
	public ResultPanel(ResultControl rc) {
		setLayout(null);
		TopLabel = new JLabel("TBD", JLabel.CENTER);
		TopLabel.setForeground(Color.RED);
		TopLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TopLabel.setBounds(77, 40, 289, 27);
		rc.setTopLabel(TopLabel);
		add(TopLabel);
		
//		Winner = new JLabel("TBD");
//		Winner.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
//		Winner.setBounds(230, 18, 46, 14);
//		add(Winner);
		
		Scores = new JLabel("Scores", JLabel.CENTER);
		Scores.setForeground(Color.BLUE);
		Scores.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		Scores.setBounds(142, 93, 158, 27);
		add(Scores);
		
		Player1 = new JLabel("Your Score :");
		Player1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		Player1.setBounds(88, 154, 152, 27);
		add(Player1);
		
		YourScore = new JLabel("TBD1");
		YourScore.setFont(new Font("Berlin Sans FB", Font.PLAIN, 21));
		YourScore.setBounds(250, 160, 106, 23);
    rc.setPlayer1Score(YourScore);
		add(YourScore);
		
		Player2 = new JLabel("Opponent Score :");
		Player2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		Player2.setBounds(34, 207, 206, 27);
		add(Player2);
		
		Player2Score = new JLabel("TBD2");
		Player2Score.setFont(new Font("Berlin Sans FB", Font.PLAIN, 21));
		Player2Score.setBounds(250, 215, 106, 19);
    rc.setPlayer2Score(Player2Score);
		add(Player2Score);
		
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setBounds(67, 295, 117, 39);
		btnPlayAgain.addActionListener(rc);
		add(btnPlayAgain);
		
		
		btnQuit = new JButton("Exit");
		btnQuit.setBounds(261, 295, 105, 39);
		btnQuit.addActionListener(rc);
		add(btnQuit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(123, 192, 177, 2);
		add(separator);
	}
}
