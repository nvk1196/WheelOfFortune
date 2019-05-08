package TeamProject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class CreateAccountControl implements ActionListener
{
	// Private data fields for the container and chat client.
	private JPanel container;
	private PlayerClient client;


	// Constructor for the login controller.
	public CreateAccountControl(JPanel container, PlayerClient client)
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

			CreateAccountPanel createPanel = (CreateAccountPanel) container.getComponent(2);
			createPanel.setuserName("");
			createPanel.setPassword("");
			createPanel.setverifyPassword("");
		}
		// The Submit button submits the login information to the server.
		else if (command == "Submit")
		{
			System.out.println("Sending create");
			// Get the username and password the user entered.
			CreateAccountPanel createPanel = (CreateAccountPanel) container.getComponent(2);
			CreateAccountData data = new CreateAccountData(createPanel.getUsername(), 
					createPanel.getPassword(), createPanel.getVerifyPassword() );



			// Check the validity of the information locally first.
			if (data.getUsername().equals("") || data.getPassword().equals("") 
					||data.getVerifyPassword().equals(""))
			{
				System.out.println("inside if empty method");

				displayError("You must enter a username/password and verify password.");
				return;
			}

			// Check the if password and verifying password is identical
			else if (!data.getPassword().equals(data.getVerifyPassword()) )
			{
				displayError("You must correctly re-enter password in order to verify it.");
				return;
			}
			// Check the if password is more than 6 characters
			else if (data.getPassword().length() < 6)
			{
				displayError("The password should be at least 6 characters.");
				return;
			}
			else
			{
				System.out.println("right befoer send to server");

				// Submit the login information to the server.
				//				System.out.println("right before sending data to server");

				try
				{
					displayError("Sent user/pass to server.");

					client.setCreateAccountControl(this);
					client.sendToServer(data);

				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	// After the login is successful, set the User object and display the contacts screen. - this method would be invoked by 
	//the ChatClient
	public void addSuccess()	{
		CreateAccountPanel createPanel = (CreateAccountPanel) container.getComponent(2);
		createPanel.setuserName("");
		createPanel.setPassword("");
		createPanel.setverifyPassword("");

		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, "2");
	}

	// Method that displays a message in the error - could be invoked by ChatClient or by this class (see above)
	public void displayError(String error)
	{
		System.out.println("Get and displaying error message");
		CreateAccountPanel createPanel = (CreateAccountPanel)container.getComponent(2);
		createPanel.setError(error);
	}
}
