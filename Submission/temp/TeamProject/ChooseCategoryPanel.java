package TeamProject;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class ChooseCategoryPanel extends JPanel{
	private JLabel lblNewLabel;
  private JButton btnAnimals;
  private JButton btnMovies;
  private JButton btnBrand;
  private JButton btnCountries;
  private JLabel lblSelectACategory;
  
  
//  
//	public JButton getBtnAnimals()
//  {
//    return btnAnimals;
//  }
//
//
//  public void setBtnAnimals(JButton btnAnimals)
//  {
//    this.btnAnimals.setVisible(false);
//  }
//
//
//  public JButton getBtnMovies()
//  {
//    return btnMovies;
//  }
//
//
//  public void setBtnMovies(JButton btnMovies)
//  {
//    this.btnMovies.setVisible(false);
//  }
//
//
//  public JButton getBtnBrand()
//  {
//    return btnBrand;
//  }
//
//
//  public void setBtnBrand(JButton btnBrand)
//  {
//    this.btnBrand.setVisible(false);
//  }
//
//
//  public JButton getBtnCountries()
//  {
//    return btnCountries;
//  }
//
//
//  public void setBtnCountries(JButton btnCountries)
//  {
//    this.btnCountries.setVisible(false);
//  }
//
//
//  public JLabel getLblNewLabel()
//  {
//    return lblNewLabel;
//  }
//
//
////  public void setLblNewLabel(String lblNewLabel)
////  {
////    this.lblNewLabel.setText(lblNewLabel);
////  }


  public ChooseCategoryPanel(ChooseCategoryControl ccc) {
	  	  
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(225, 5, 0, 0);
		add(label);
		
		lblSelectACategory = new JLabel("Select A Category To Begin");
		lblSelectACategory.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblSelectACategory.setBounds(92, 16, 255, 29);
		
		add(lblSelectACategory);
		
		btnAnimals = new JButton("Animals");
		btnAnimals.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		btnAnimals.setBounds(164, 75, 89, 23);
		btnAnimals.addActionListener(ccc);
		ccc.setBtnAnimals(btnAnimals);
		add(btnAnimals);
		
		btnMovies = new  JButton("Movies"); 
		btnMovies.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		btnMovies.setBounds(164, 123, 89, 23);
		btnMovies.addActionListener(ccc);
		ccc.setBtnMovies(btnMovies);
		add(btnMovies);
		
		btnBrand = new JButton("Brands");
		btnBrand.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		btnBrand.setBounds(164, 173, 89, 23);
		btnBrand.addActionListener(ccc);
		ccc.setBtnBrand(btnBrand);
		add(btnBrand); 
		
		btnCountries = new JButton("Countries");
		btnCountries.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		btnCountries.setBounds(164, 224, 89, 23); 
		btnCountries.addActionListener(ccc);
		ccc.setBtnCountries(btnCountries);
		add(btnCountries);

		lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setVisible(true);
		lblNewLabel.setBounds(107, 258, 191, 29);
		ccc.setwaitLabel(lblNewLabel);
		add(lblNewLabel);
		
		
	}
  
  public void choose() {
    lblNewLabel.setText("");
    btnAnimals.setVisible(true);
    btnMovies.setVisible(true);
    btnBrand.setVisible(true);
    btnCountries.setVisible(true);
  }

}