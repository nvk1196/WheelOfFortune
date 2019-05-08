package TeamProject;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.*;
  
public class SpinWheelPanel extends JPanel {
	private JTextField txtScoreToBe;
	private JLabel lblWheelOfFortune;
	private JLabel lblNewLabel;
	private JLabel lbl;
	private JButton btnStopTheWheel;
	private JButton btnStartGame;
	private Timer timer;
	Graphics2D g2;
	private ImageIcon icon;
	private JPanel contentPane;
	static double rot = 0.0;
	
	private JTextField txtYourScore;
	
	public SpinWheelPanel(SpinWheelControl swc){
		setLayout(null);
		
		lblWheelOfFortune = new JLabel("Wheel OF Fortune");
		lblWheelOfFortune.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblWheelOfFortune.setBounds(114, 17, 173, 23);
		add(lblWheelOfFortune);
		
		


		icon = new ImageIcon("TeamProject\\WheelOfFortune.png"); // has image path
		//contentPane.setLayout(null);
		
		lblNewLabel = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {

				g2 = (Graphics2D) g;
				g2.rotate(rot,   icon.getIconWidth() / 2, icon.getIconHeight() / 2);
				g2.drawImage(icon.getImage(), 1, 1, null);
				rot += .005; 

				lblNewLabel.repaint(); 

			} 

		};
		
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(70, 42, 338, 271);
		swc.setLblNewLabel(lblNewLabel);
		this.add(lblNewLabel);
		
		
		JLabel lbl = new JLabel();
		lbl.setBounds(70, 30, 338, 271);
		lbl.setIcon(icon);
		lbl.repaint();
		lbl.setVisible(false);
		swc.setLbl(lbl);
		this.add(lbl);
		
		
//		lblNewLabel.setIcon(new ImageIcon(SpinWheelPanel.class.getResource("/TeamProject/WheelOfFortune.png")));
//		lblNewLabel.setBounds(67, 51, 238, 223);
//		add(lblNewLabel);
//		
		btnStopTheWheel = new JButton("Stop The Wheel");
		btnStopTheWheel.setBounds(20, 343, 130, 23);
		btnStopTheWheel.addActionListener( swc);
		swc.setBtnStopTheWheel(btnStopTheWheel);
		add(btnStopTheWheel);
		
		btnStartGame = new JButton("Start the Game");
		btnStartGame.setBounds(237, 343, 122, 23);
		btnStartGame.setEnabled(false);
		btnStartGame.addActionListener(swc);
		swc.setBtnStartGame(btnStartGame);
		add(btnStartGame);
		
		txtScoreToBe = new JTextField();
		txtScoreToBe.setText("Your Score");
		txtScoreToBe.setBounds(140, 287, 116, 20);
		txtScoreToBe.setEditable(false);
		swc.setTxtScoreToBe(txtScoreToBe);
		add(txtScoreToBe);
		txtScoreToBe.setColumns(10);
		
	}
	
	
	public void startSpin() {
		lblNewLabel.setVisible(true);
		btnStartGame.setEnabled(false);

		btnStopTheWheel.setEnabled(true); 

	}
}