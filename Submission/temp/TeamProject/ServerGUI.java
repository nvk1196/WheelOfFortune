package TeamProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;



public class ServerGUI extends JFrame
{
	//Data Fields go here
	private JLabel status; //Initialized to “Not Connected”
	private String[] labels = {"Port #", "Timeout"};
	private JTextField[] textFields = new JTextField[labels.length];
	private JTextArea log;

	private JButton listen;
	private JButton close;
	private JButton stop;
	private JButton quit;

	private GameServer server;

	//Methods go here
	public ServerGUI(String port, String timeout) throws IOException
	{    
		this.setTitle("SpinWheel_Server");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//North layout
		//**************************************************************************


		//ADD YOUR CODE HERE TO CREATE THE STATUS JLABEL AND THE JBUTTONS
		JLabel label = new JLabel("Status: ");
		status = new JLabel("Not Connected",JLabel.RIGHT);
		status.setForeground(Color.RED);

		//add label to "north" Panel
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		north.add(label);
		north.add(status);

		//add north panel to main panel located on north part(top)
		this.add(north,BorderLayout.NORTH);


		//Center layout
		//**************************************************************************


		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2,2,10,10));

		for(int i = 0;i<labels.length; i++)
		{
			JPanel temp1 = new JPanel(new FlowLayout( FlowLayout.LEFT) );// CENTER_ALIGNMENT);

			String str_label = "Label " + (i+1) ;

			//Create JLabel
			JLabel jlabel = new  JLabel(labels[i],JLabel.RIGHT);
			textFields[i] = new JTextField("",16);
			if(i==1)
				textFields[i] = new JTextField("",6);

			// textFields[i].setSize(10, 10);

			//Add label then a button

			jp.add(jlabel);
			temp1.add(textFields[i]);
			jp.add(temp1);
		}
		textFields[0].setText(port);
		textFields[1].setText(timeout);
		

		
		//Add label then a button
		JPanel c1 = new JPanel();
		c1.add(jp);

		JPanel jp2 = new JPanel(new GridLayout(2,1,-50,-50) );
		JLabel clientLabel = new JLabel("Server Log Below", JLabel.CENTER);

		log = new JTextArea(9,40);

		JScrollPane clientScroll = new JScrollPane(log);
		clientScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		clientScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);



		//add center panel to main panel located on north part(top)
		jp2.add(clientLabel);   
		jp2.add(clientScroll);


		JPanel c2 = new JPanel();
		c2.add(jp2);

		JPanel center = new JPanel();//new GridLayout(2,1,2,2) );
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

		center.add(c1);
		center.add(c2);

		//implent south as flowlayout
		this.add(center,BorderLayout.CENTER);


		//South layout
		//**************************************************************************
		// declare the buttons

		listen = new JButton("Listen");
		close = new JButton("Close");
		stop = new JButton("Stop");
		quit = new JButton("Quit");

		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		south.add(listen);
		south.add(close);
		south.add(stop);
		south.add(quit);
		
		this.add(south,BorderLayout.SOUTH);
		
		Database database = new Database();

		server = new GameServer();
		server.setLog(log);
		server.setStatus(status);
		server.setDatabase(database);

		
		listen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				status.setForeground(Color.red);
				
				if(textFields[0].getText().equals("") 
						&& textFields[1].getText().equals("") )
				{
					log.setText("Port Number/timeout not entered before pressing Listen");
				}
				else
				{	
					server.setPort(Integer.parseInt(textFields[0].getText()));
					server.setTimeout(Integer.parseInt(textFields[0].getText()));
					
					

					server.serverStarted();
					try
					{
						server.listen();
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}    });

		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				status.setForeground(Color.red);

				//if the listen button is not clicked
				if( status.getText().equals("Listening")  )
				{					
					server.stopListening();			
				}
				else
				{
					log.setText("Server not currently started");
					System.out.println(arg0.getActionCommand());
				}
				

			}    });

		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				status.setForeground(Color.red);

				//if the listen button is not clicked
				if( status.getText().equals("Listening")
						|| status.getText().equals("Stopped") )
				{
						try {
							server.close();
						} catch (IOException e) {
							e.printStackTrace();
						}

				}
				else					
					log.setText("Server not currently started");
			}    });



		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);      }    });

		setSize(500,500);
		setVisible(true);


		//**********************************************
		//end of GUI
		//**********************************************
		//server private

	}

	public static void main(String[] args) throws IOException
	{
//		new ServerGUI("Server");//args[0]); //args[0] represents the title of the GUI
		new ServerGUI("8300","500"); //args[0] represents the title of the GUI
//		new ServerGUI(args[0],args[1]); //args[0] represents the title of the GUI

	}

	public GameServer getGameServer() {
		return server;
	}
}
