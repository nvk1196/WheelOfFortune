package TeamProject;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseCategoryControl implements ActionListener
{
	// Private data field for storing the container.
	private JPanel container;
	private PlayerClient client;
	private JLabel waitLabel;
	private JButton btnAnimals;
	private JButton btnMovies;
	private JButton btnBrand;
	private JButton btnCountries;

	public JButton getBtnAnimals()
	{
		return btnAnimals;
	}

	public void setBtnAnimals(JButton btnAnimals)
	{
		this.btnAnimals = btnAnimals;
	}

	public JButton getBtnMovies()
	{
		return btnMovies;
	}

	public void setBtnMovies(JButton btnMovies)
	{
		this.btnMovies = btnMovies;
	}

	public JButton getBtnBrand()
	{
		return btnBrand;
	}

	public void setBtnBrand(JButton btnBrand)
	{
		this.btnBrand = btnBrand;
	}

	public JButton getBtnCountries()
	{
		return btnCountries;
	}

	public void setBtnCountries(JButton btnCountries)
	{
		this.btnCountries = btnCountries;
	}


	public ChooseCategoryControl(JPanel container, PlayerClient client)
	{
		this.container = container;
		this.client = client;
	}

	public void setwaitLabel(JLabel waitLabel)
	{
		this.waitLabel = waitLabel;
	}

	// Handle button clicks.
	public void actionPerformed(ActionEvent ae)
	{
		// Get the name of the button clicked.
		String command = ae.getActionCommand();
		waitLabel.setText("Wating for other player...");
		btnAnimals.setVisible(false);
		btnMovies.setVisible(false);
		btnBrand.setVisible(false);
		btnCountries.setVisible(false);

		if (command.equals("Animals"))
		{
			CategoryData category = new CategoryData("Animals", "");
			try
			{
				client.sendToServer(category);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

			// get animals panel

			// CardLayout cardLayout = (CardLayout)container.getLayout(5);
			// cardLayout.show(container, "6");
		} 

		else if (command.equals("Brands"))
		{
			CategoryData category = new CategoryData("Brands", "");
			try
			{
				client.sendToServer(category);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		} 

		else if (command.equals("Countries"))
		{
			CategoryData category = new CategoryData("Countries", "");
			try
			{
				client.sendToServer(category);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		} 

		else if (command.equals("Movies"))
		{
			CategoryData category = new CategoryData("Movies", "");
			try
			{
				client.sendToServer(category);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void drawPanel() {
	  ChooseCategoryPanel choosePanel = (ChooseCategoryPanel) container.getComponent(3);
    choosePanel.choose();
	  
	  CardLayout cardLayout = (CardLayout) container.getLayout();
    cardLayout.show(container, "4");
	  
	}
}