package TeamProject;

import java.io.Serializable;

public class CreateAccountData implements Serializable 
{
 private String username;
 private String password;
 private String verifyPassword;
 
 // Getter
 public String getUsername() {return username;}
 public String getPassword() {return password;}
 public String getVerifyPassword() {return verifyPassword;}
 // Setter
 public void setUsername(String username) {this.username = username;}
 public void setPassword(String password) {this.password = password;}
 
 public void setVerifyPassword(String verifyPassword){this.verifyPassword = verifyPassword;}

 // Constructor that initializes the username and password.
 public CreateAccountData(String username, String password, String verifyPassword)
 {
   setUsername(username);
   setPassword(password);
   setVerifyPassword(verifyPassword);
 }
  
  
}
