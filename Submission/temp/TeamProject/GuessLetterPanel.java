package TeamProject;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class GuessLetterPanel extends JPanel {
	private JTextField GuessTxtField;
	private JTextField txtAchi;
	private JTextField textField_Price;
	private JTextField textFieldOponent;

	private JLabel turnLabel;
	private JLabel guessinglbl;
	private JLabel lblError;
	private JLabel lblLettersSoFar;
	private JButton btnGuess;
	private JLabel WinningRounds;
	
	private JPanel Word_Panel;

	public String getLetter() {
		return GuessTxtField.getText();
	}

	public Integer getPrice() {
		return Integer.parseInt(textField_Price.getText());
	}

	public JTextField getGuessTxtField() {
		return GuessTxtField;

	}

	public void setGuessTxtField(String guessText) {
		GuessTxtField.setText(guessText);
	}

	public JTextField getTextField_Score() {
		return txtAchi;
	}

	public void setTextField_Score(String text) {
		this.txtAchi.setText(text);
	}

	public JTextField getTextField_Price() {
		return textField_Price;
	}

	public void setTextField_Price(Integer textField_Price) {
		this.textField_Price.setText(textField_Price.toString());
	}

	public GuessLetterPanel(GuessLetterControl cc) {
		setLayout(null);
		this.setBounds(400, 600, 457, 418);

		JLabel lblGuessALetter = new JLabel("Guess a Letter below:");
		lblGuessALetter.setForeground(Color.BLACK);
		lblGuessALetter.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lblGuessALetter.setBounds(42, 25, 219, 26);
		add(lblGuessALetter);

		GuessTxtField = new JTextField();
		GuessTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		GuessTxtField.setFont(new Font("Tahoma", Font.PLAIN, 29));
		GuessTxtField.setBounds(87, 93, 96, 41);
		add(GuessTxtField);
		GuessTxtField.setColumns(10);
		cc.setJTextField(GuessTxtField);

		btnGuess = new JButton("Guess");
		btnGuess.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		btnGuess.setBounds(207, 108, 96, 26);
		cc.setGuessButton(btnGuess);
		add(btnGuess);
		btnGuess.addActionListener(cc);

		JLabel lblScore = new JLabel("Your Score: ");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.BLACK);
		lblScore.setFont(new Font("Tarzan", Font.PLAIN, 17));
		lblScore.setBounds(22, 235, 96, 26);
		add(lblScore);

		JLabel lblPrice = new JLabel("Prize:-");
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Tarzan", Font.PLAIN, 17));
		lblPrice.setBounds(304, 235, 62, 26);
		add(lblPrice);

		txtAchi = new JTextField();
		txtAchi.setHorizontalAlignment(SwingConstants.CENTER);
		txtAchi.setForeground(Color.BLACK);
		txtAchi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAchi.setBounds(22, 272, 73, 41);
		txtAchi.setEditable(false);
		cc.setTextField_Score(txtAchi);
		add(txtAchi);
		txtAchi.setColumns(10);

		textField_Price = new JTextField();
		textField_Price.setText("");
		textField_Price.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Price.setForeground(Color.BLACK);
		textField_Price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_Price.setColumns(10);
		textField_Price.setBounds(304, 272, 73, 42);
		textField_Price.setEditable(false);
		cc.setTextField_Price(textField_Price);
		add(textField_Price);

		Word_Panel = new JPanel();
		Word_Panel.setBackground(Color.LIGHT_GRAY);
		Word_Panel.setBounds(28, 157, 353, 54);
		add(Word_Panel);
		Word_Panel.setLayout(new BorderLayout());

		guessinglbl = new JLabel("Word with correct letters");
		guessinglbl.setHorizontalAlignment(SwingConstants.CENTER);
		Word_Panel.add(guessinglbl, BorderLayout.CENTER);
		guessinglbl.setForeground(Color.WHITE);
		guessinglbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		cc.setGuessinglbl(guessinglbl);

		JLabel lblChoosenLettes = new JLabel("Choosen Letters:-");
		lblChoosenLettes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblChoosenLettes.setForeground(Color.RED);
		lblChoosenLettes.setBounds(22, 329, 157, 26);
		add(lblChoosenLettes);

		lblLettersSoFar = new JLabel("letters");
		lblLettersSoFar.setForeground(new Color(0, 0, 0));
		lblLettersSoFar.setFont(new Font("Roland", Font.PLAIN, 18));
		lblLettersSoFar.setBounds(174, 326, 219, 33);
		cc.setlblLettersSoFar(lblLettersSoFar);
		add(lblLettersSoFar);

		lblError = new JLabel("Error Messages");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblError.setBounds(42, 49, 328, 33);
		lblError.setVisible(false);
		
		cc.setlblError(lblError);
		add(lblError);

		JLabel lblOponentScore = new JLabel("Oponent's Score:-");
		lblOponentScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblOponentScore.setForeground(Color.BLACK);
		lblOponentScore.setFont(new Font("Tarzan", Font.PLAIN, 15));
		lblOponentScore.setBounds(139, 235, 143, 26);
		add(lblOponentScore);

		textFieldOponent = new JTextField();
		textFieldOponent.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldOponent.setText("");
		textFieldOponent.setForeground(Color.BLACK);
		textFieldOponent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldOponent.setColumns(10);
		textFieldOponent.setBounds(164, 271, 73, 42);
		textFieldOponent.setEditable(false);
		cc.setOpponent_Score(textFieldOponent);
		add(textFieldOponent);

		turnLabel = new JLabel("Who's turn?\r\n");
		turnLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		turnLabel.setForeground(Color.BLUE);
		turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		turnLabel.setBounds(231, 23, 219, 35);
//		turnLabel.setVisible(false);
		cc.setTurnLabel(turnLabel);
		add(turnLabel);

		JLabel label = new JLabel("$");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setForeground(Color.BLACK);
		label.setBounds(208, 263, 169, 54);
		add(label);
		
		JLabel lblWinning = new JLabel("Win:");
		lblWinning.setForeground(new Color(34, 139, 34));
		lblWinning.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWinning.setBounds(22, 371, 44, 31);
		add(lblWinning);
		
		WinningRounds = new JLabel("");
		WinningRounds.setForeground(new Color(34, 139, 34));
		WinningRounds.setFont(new Font("Dialog", Font.BOLD, 18));
		WinningRounds.setBounds(66, 371, 69, 31);
		cc.setWinningRounds(WinningRounds);
		add(WinningRounds);
	}

  public JLabel getWinningRounds()
  {
    return WinningRounds;
  }

  public void setWinningRounds(JLabel winningRounds)
  {
    this.WinningRounds = winningRounds;
  }
}
