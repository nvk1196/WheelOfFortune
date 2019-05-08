package TeamProject;

import java.io.Serializable;
import java.util.ArrayList;

public class GuessLetterData implements Serializable {
	private Integer prizeMoney;
	private String wordToGuess;
	private ArrayList<Character> chosenLetter;
	private Integer score;
	private Integer score_2;
	private Integer letterLeft;

	public GuessLetterData() {
		prizeMoney =0;
		wordToGuess="";
		score=0;
		score_2=0;

		chosenLetter = new ArrayList<Character>();
	}
	public String getWordToGuess()
	{
		return wordToGuess;
	}
	public void setWordToGuess(String wordToGuess)
	{
		this.wordToGuess = wordToGuess;
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

	public void setwordToGuess(String wordToGuess) {
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

	public String getwordToGuess() {
		return wordToGuess;
	}

	public ArrayList<Character> getchosenLetter() {
		return chosenLetter;
	}
	public Integer getLetterLeft() {
		return letterLeft;
	}


}
