package TeamProject;

import java.io.Serializable;

public class CategoryData implements Serializable 
{

  private String word;
  private String category;
  
  public CategoryData(String category, String word)
  {
    this.category = category;
    this.word = word;
  }
  
  public String getWord() {return word;}
  public String getCategory() {return category;}
  
  public void setWord(String word) {this.word = word;}
  public void setCategory(String category) {this.category = category;}
  
}  
  
  

  
  
