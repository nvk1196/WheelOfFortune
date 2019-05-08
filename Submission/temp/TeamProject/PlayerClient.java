package TeamProject;
import java.awt.CardLayout;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

import javax.swing.JPanel;

import com.mysql.fabric.xmlrpc.Client;

import ocsf.client.AbstractClient;

public class PlayerClient extends AbstractClient  implements Serializable 
{
  private InitialControl InitialControl;
  private LoginControl loginControl;
  private CreateAccountControl createAccountControl;
  private GuessLetterControl guessLetterControl;
  private SpinWheelControl spinWheelControl;
  private ChooseCategoryControl chooseCategoryControl;
  private ResultControl resultControl;

  private LoginData loginData;
  
  private GuessData tempGuessData;

  private Integer totalPrice =0;
  private Integer winRounds =0;
  private Integer totalRounds =0;


  private SwitchPlayer players;


  //Constructor
  public PlayerClient() {
    super("localhost",8300);
    tempGuessData = new GuessData();

  }
  public PlayerClient(String host, int port) {
    super(host,port);
    tempGuessData = new GuessData();

  }

  public InitialControl getInitialControl() {
    return InitialControl;
  }
  public void setInitialControl(InitialControl initialControl) {
    InitialControl = initialControl;
  }

  public LoginControl getLoginControl() {
    return loginControl;
  }
  public void setLoginControl(LoginControl loginControl) {
    this.loginControl = loginControl;
  }

  public CreateAccountControl getCreateAccountControl() {
    return createAccountControl;
  }
  public void setCreateAccountControl(CreateAccountControl createAccountControl) {
    this.createAccountControl = createAccountControl;
  }

  public GuessLetterControl getGuessLetterControl() {
    return guessLetterControl;
  }
  public void setGuessLetterControl(GuessLetterControl guessLetterControl) {
    this.guessLetterControl = guessLetterControl;
  }

  public SpinWheelControl getSpinWheelControl() {
    return spinWheelControl;
  }
  public void setSpinWheelControl(SpinWheelControl spinWheelControl) {
    this.spinWheelControl = spinWheelControl;
  }

  public ChooseCategoryControl getChooseCategoryControl() {
    return chooseCategoryControl;
  }
  public void setChooseCategoryControl(ChooseCategoryControl chooseCategoryControl) {
    this.chooseCategoryControl = chooseCategoryControl;
  }

  public ResultControl getResultControl() {
    return resultControl;
  }
  public void setResultControl( ResultControl resultControl ) {
    this.resultControl = resultControl;
  }

  public LoginData getLoginData() {
    return loginData;
  }
  public void setLoginData(LoginData loginData) {
    this.loginData = loginData;
  }
  public GuessData getTempGuessData() {
    return tempGuessData;
  }
  public void setTempGuessData(GuessData tempGuessData) {
    this.tempGuessData = tempGuessData;
  }
  public Integer getTotalPrice() {
    return totalPrice;
  }
  public void setTotalPrice(Integer totalPrice) {
    this.totalPrice = totalPrice;
  }
  public Integer getWinRounds() {
    return winRounds;
  }
  public void setWinRounds(Integer winRounds) {
    this.winRounds = winRounds;
  }
  public Integer getTotalRounds() {
    return totalRounds;
  }
  public void setTotalRounds(Integer totalRounds) {
    this.totalRounds = totalRounds;
  }






  protected void handleMessageFromServer(Object arg0)
  {
    //LOGIN
    if (arg0 instanceof LoginData)
    {
      loginData = (LoginData) arg0;

      if(loginData.getUsername().equals(""))
      {
        System.out.println("Server Message sent to Client fail to login");
        loginControl.displayError("The username and password are incorrect");
      }
      else
      {
        System.out.println("Server Message sent to Client succed to login");
        //				try {
        //					sendToServer(this);
        //				} catch (IOException e) {
        //					e.printStackTrace();
        //				}
        loginControl.loginSuccess();
      }
    }
    else if( arg0 instanceof CreateAccountData)
    {
      CreateAccountData accountData = (CreateAccountData) arg0;
      if(accountData.getUsername().equals(""))
      {
        System.out.println("Server Message sent to Client fail to add account");
        createAccountControl.displayError("Username is already being used");
      }

      else
      {
        System.out.println("Server Message sent to Client added account");
        createAccountControl.addSuccess();

      }
    }

    else if(arg0 instanceof CategoryData) {
      System.out.println("got a categoryData from server");
      CategoryData tempcategory = (CategoryData) arg0;
      int score1=0;
      int score2=0;
      
      if(  !tempGuessData.getWordToGuess().equals(tempcategory.getWord() ))
      {
        score1= tempGuessData.getScore();
        score2= tempGuessData.getScore_2();
      }
  
      
      GuessData newGuessData = new GuessData();
      
      newGuessData.setWordToGuess(tempcategory.getWord());
      
      tempGuessData = newGuessData;

      tempGuessData.setScore(score1);
      tempGuessData.setScore_2(score2);
      
      spinWheelControl.setGld(tempGuessData);
      spinWheelControl.startSpin();

      guessLetterControl.updateDisplay(tempGuessData);
      guessLetterControl.setData(tempGuessData);
      guessLetterControl.myTurn();

    }
    //"WORD DATA" FROM SERVER
    else if (arg0 instanceof GuessData)
    { 			
      System.out.println("got a GuessData from server");
      
      GuessData newGuess = (GuessData) arg0;
      int score1=0;
      int score2=0;
      
      //if it is new round
      if(  !tempGuessData.getWordToGuess().equals(newGuess.getWordToGuess()))
      {
        score2 = tempGuessData.getScore() + newGuess.getScore();
        score1 = tempGuessData.getScore_2()+newGuess.getScore_2();

      }
      else 
      {
        score1 = newGuess.getScore();
        score2 =  newGuess.getScore_2();
      }
            
      tempGuessData = newGuess;

      tempGuessData.setScore(score2);
      tempGuessData.setScore_2(score1);


//      int tempscore = tempGuessData.getScore();
//      tempGuessData.setScore(tempGuessData.getScore_2());
//      tempGuessData.setScore_2(tempscore);

      int a = tempGuessData.getLetterLeft();

      if (a == 0)
      {
        totalRounds++;


        //Setting win rounds
        //tempGuessData.setScore(tempGuessData.getScore() + totalPrice);

        if(totalRounds == 3) 		  
        {
          if(winRounds >= 2)
            resultControl.winner(tempGuessData);
          else
            resultControl.loser(tempGuessData);
        }
        else 
        {
          guessLetterControl.getlblError().setText("");
          guessLetterControl.getWinningRounds().setText(winRounds.toString());
          chooseCategoryControl.drawPanel();

        }
      }
      else {
        //when player receive GuessData which mean he get it wrong
        guessLetterControl.waitScreen();
      }

      guessLetterControl.updateDisplay(tempGuessData); 
    }

    //HANDLE SWITCH PLAYER REQUEST FROM SERVER
    else if (arg0 instanceof SwitchPlayer)
    {
      SwitchPlayer tempSwitch = (SwitchPlayer) arg0;
      tempGuessData = tempSwitch.getGuessData();

      int tempscore = tempGuessData.getScore();
      tempGuessData.setScore(tempGuessData.getScore_2());
      tempGuessData.setScore_2(tempscore);

      spinWheelControl.setGld(tempGuessData);
      guessLetterControl.updateDisplay(tempGuessData);

      guessLetterControl.myTurn();
      spinWheelControl.startSpin();
    }


  }

}
