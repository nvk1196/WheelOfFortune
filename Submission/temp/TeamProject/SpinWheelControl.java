package TeamProject;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SpinWheelControl implements ActionListener {
	public JPanel getContainer()
	{
		return container;
	}


	public void setContainer(JPanel container)
	{
		this.container = container;
	}


	public JTextField getTxtScoreToBe()
	{
		return txtScoreToBe;
	}


	public void setTxtScoreToBe(JTextField txtScoreToBe)
	{
		this.txtScoreToBe = txtScoreToBe;
	}


	public JButton getBtnStopTheWheel()
	{
		return btnStopTheWheel;
	}


	public void setBtnStopTheWheel(JButton btnStopTheWheel)
	{
		this.btnStopTheWheel = btnStopTheWheel;
	}


	public JButton getBtnStartGame()
	{
		return btnStartGame;
	}


	public void setBtnStartGame(JButton btnStartGame)
	{
		this.btnStartGame = btnStartGame;
	}


	public JLabel getLblNewLabel()
	{
		return lblNewLabel;
	}


	public void setLblNewLabel(JLabel lblNewLabel)
	{
		this.lblNewLabel = lblNewLabel;
	}


	public JLabel getLbl()
	{
		return lbl;
	}


	public void setLbl(JLabel lbl)
	{
		this.lbl = lbl;
	}


	// Private data fields for the container and chat client.
	private JPanel container;
	private PlayerClient client;
	private GuessData gld ;


	private JTextField txtScoreToBe = new JTextField();
	private JButton btnStopTheWheel = new JButton();
	private JButton btnStartGame = new JButton();
	private JLabel lblNewLabel = new JLabel();
	private ImageIcon icon = new ImageIcon("TeamProject\\WheelOfFortune.png");
	private JLabel lbl = new JLabel();
	private int scores[] = {100,200,300,400,500,600,700,800,900,1000};
	private int x;

	// Constructor for the login controller.
	public SpinWheelControl(JPanel container, PlayerClient client)
	{
		gld= new GuessData();
		this.container = container;
		this.client = client;
	}


	public GuessData getGld() {
		return gld;
	}


	public void setGld(GuessData gld) {
		this.gld = gld;
	}


	public void startSpin() {
		lblNewLabel.setVisible(true);
		btnStartGame.setEnabled(false);
		btnStopTheWheel.setEnabled(true); 
		CardLayout cardLayout = (CardLayout) container.getLayout(); // send user to spine wheel panel
		cardLayout.show(container, "5");

	}

	public void actionPerformed(ActionEvent ae)
	{
		// Get the name of the button clicked.
		String command = ae.getActionCommand();


		if (command.equals("Stop The Wheel")) // if stop button pressed 
		{
			lblNewLabel.setVisible(false);
			lbl.setVisible(true);

			btnStopTheWheel.setEnabled(false);  // disables the stop the wheel button so that start the game btn is only clickable
			btnStartGame.setEnabled(true);   // enabling the start game button

			Random rand = new Random();
			x = rand.nextInt(9);
			txtScoreToBe.setText("$" + scores[x]);  // determining the random score that player will get


			gld.setPrizeMoney(scores[x]);

			try {
				client.sendToServer(gld);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("Start the Game")) // start game button pressed
		{
			GuessLetterPanel guessPanel = (GuessLetterPanel) container.getComponent(5);
			guessPanel.setTextField_Price(scores[x]);
			txtScoreToBe.setText("");
			

			CardLayout cardLayout = (CardLayout) container.getLayout(); // send user to guess letter panel
			cardLayout.show(container, "6");
		}
	}
}