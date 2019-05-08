package TeamProject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class LoginControl implements ActionListener
{
	// Private data fields for the container and chat client.
	private JPanel container;

	private PlayerClient client;


	// Constructor for the login controller.
	public LoginControl(JPanel container, PlayerClient client)
	{
		this.container = container;
		this.client = client;

	}



	// Handle button clicks.
	public void actionPerformed(ActionEvent ae)
	{
		// Get the name of the button clicked.
		String command = ae.getActionCommand();

		// The Cancel button takes the user back to the initial panel.
		if (command == "Cancel")
		{
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "1");
		}
		// The Submit button submits the login information to the server.
		else if (command == "Submit")
		{
			// Get the username and password the user entered.
			LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
			//      LoginData data = new LoginData(loginPanel.getUsername(), loginPanel.getPassword());
			LoginData data = new LoginData(loginPanel.getUsername(), loginPanel.getPassword());


			// Check the validity of the information locally first.
			if (data.getUsername().equals("") || data.getPassword().equals(""))
			{
				displayError("You must enter a username and password.");

				return;
			}
			else
			{
				// Submit the login information to the server.
				try
				{
					displayError("Sent user/pas to server.");
					
					client.setLoginControl(this);
					client.sendToServer(data);

				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	// After the login is successful, set the User object and display the contacts screen. 
	//- this method would be invoked by the ChatClient
	public void loginSuccess()
	{
		LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
		loginPanel.setuserName("");
		loginPanel.setPassword("");
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, "4");
	}

	// Method that displays a message in the error - could be invoked by ChatClient or by this class (see above)
	public void displayError(String error)
	{
		LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
		loginPanel.setError(error);

	}
}
