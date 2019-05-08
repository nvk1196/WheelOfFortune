package TeamProject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PlayerGUI extends JFrame
{
	private PlayerClient clients;

	// Constructor that creates the client GUI.
	public PlayerGUI(String host, String port)
	{

		// Set the title and default close operation.
		this.setTitle("Client");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		clients = new PlayerClient("10.252.40.97",8300); 
		clients = new PlayerClient(host,Integer.parseInt(port)); 

//		clients = new PlayerClient(); 


		try
		{
			clients.openConnection();

		} catch (IOException e)
		{e.printStackTrace();}


		// Create the card layout container.
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);

		//Create the Controllers next
		//Next, create the Controllers
		InitialControl ic = new InitialControl(container); 
		LoginControl lc = new LoginControl(container, clients); //Probably will want to pass in ChatClient here
		CreateAccountControl cac = new CreateAccountControl(container, clients);

		ChooseCategoryControl ccc = new ChooseCategoryControl(container,clients);
		SpinWheelControl swc = new SpinWheelControl(container,clients);
		GuessLetterControl glc = new GuessLetterControl(container,clients);
		
		ResultControl rc = new ResultControl(container,clients);

		clients.setLoginControl(lc);
		clients.setCreateAccountControl(cac);
		clients.setChooseCategoryControl(ccc);
		clients.setSpinWheelControl(swc);
		clients.setGuessLetterControl(glc);
		clients.setResultControl(rc);


		// Create the four views. (need the controller to register with the Panels
		JPanel view1 = new InitialPanel(ic);
		JPanel view2 = new LoginPanel(lc);
		JPanel view3 = new CreateAccountPanel(cac);
		
		JPanel view4 = new ChooseCategoryPanel(ccc);
		JPanel view5 = new SpinWheelPanel(swc);
		JPanel view6 = new GuessLetterPanel(glc);
		JPanel view7 = new ResultPanel(rc);

		//    JPanel view4 = new ContactPanel();



		// Add the views to the card layout container.
		container.add(view1, "1");
		container.add(view2, "2");
		container.add(view3, "3");
		container.add(view4, "4");
		container.add(view5, "5");
		container.add(view6, "6");
		container.add(view7, "7");

		
		// Show the initial view in the card layout.
		cardLayout.show(container, "1");

		// Add the card layout container to the JFrame.
		this.add(container, BorderLayout.CENTER);

		// Show the JFrame.
		this.setSize(440, 500);
		this.setVisible(true);
	}

	// Main function that creates the client GUI when the program is started.
	public static void main(String[] args)
	{
		new PlayerGUI(args[0],args[1]);
//		new PlayerGUI("","");

	}

	public PlayerClient getClient() {
		return clients;
	}
}
