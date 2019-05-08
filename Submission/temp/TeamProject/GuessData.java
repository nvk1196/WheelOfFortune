
package TeamProject;

import java.io.Serializable;
import java.util.ArrayList;

public class GuessData implements Serializable {
	private Integer prizeMoney;
	private String wordToGuess;
	
	private ArrayList<Character> chosenLetter;

	private Integer score;
	private Integer score_2;
	private Integer letterLeft;
	private Integer totalPrice =0;
  private Integer winRounds =0;
  private Integer totalRounds =0;
	
	public Integer getTotalPrice()
  {
    return totalPrice;
  }
  public void setTotalPrice(Integer totalPrice)
  {
    this.totalPrice = totalPrice;
  }
  public Integer getWinRounds()
  {
    return winRounds;
  }
  public void setWinRounds(Integer winRounds)
  {
    this.winRounds = winRounds;
  }
  public Integer getTotalRounds()
  {
    return totalRounds;
  }
  public void setTotalRounds(Integer totalRounds)
  {
    this.totalRounds = totalRounds;
  }

  private PlayerClient currentPlayer;
	private PlayerClient nextPlayer;

	

	
	public GuessData() {
		prizeMoney =0;
		wordToGuess="";
		score=0;
		score_2=0;
		winRounds = 0;
		totalRounds = 0;

		chosenLetter = new ArrayList<Character>();
	}
	public String getWordToGuess()
	{
		return wordToGuess;
	}


	public ArrayList<Character> getChosenLetter()
	{
		return chosenLetter;
	}
	public void setChosenLetter(ArrayList<Character> chosenLetter)
	{
		this.chosenLetter = chosenLetter;
	}
	public Integer getScore_2()
	{
		return score_2;
	}
	public void setScore(Integer score)
	{
		this.score = score;
	}
	public void setLetterLeft(Integer letterLeft)
	{
		this.letterLeft = letterLeft;
	}
	public void setScore_2(Integer score_2) {
		this.score_2 = score_2;	
	}

	public void setPrizeMoney(Integer prizeMoney) {
		this.prizeMoney = prizeMoney;
	}

	public void setWordToGuess(String wordToGuess) {
		this.wordToGuess = wordToGuess;
		this.letterLeft = (int) wordToGuess.chars().distinct().count();

	}

	public void setchosenLetter(Character chosenLetter) {
		this.chosenLetter.add(chosenLetter);
	}

	public Integer getPrizeMoney() {
		return prizeMoney;
	}

	public Integer getScore() {
		return score;
	}

	public ArrayList<Character> getchosenLetter() {
		return chosenLetter;
	}
	public Integer getLetterLeft() {
		return letterLeft;
	}
	
	
	
	


	public GuessData(PlayerClient currentPlayer, PlayerClient nextPlayer) {
		this.currentPlayer = currentPlayer;
		this.nextPlayer = nextPlayer;
	}

	public PlayerClient getCurrentPlayer() {
		return currentPlayer;
	}

	public PlayerClient getNextPlayer() {
		return nextPlayer;
	}

	public void setCurrentPlayer(PlayerClient CurrentPlayer) {
		this.currentPlayer = CurrentPlayer;
	}

	public void setNextPlayer(PlayerClient nextPlayer) {
		this.nextPlayer = nextPlayer;
	}
	

}
