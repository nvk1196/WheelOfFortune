package TeamProject;

import java.sql.*;
import java.io.*;
import java.util.*;

public class Database
{
  private Connection conn;
  //Add any other data fields you like – at least a Connection object is mandatory

  public Database()
  {
    //Read properties file
    Properties prop = new Properties();//Inherits hashmap
    FileInputStream fis = null;

    try
    {
      fis = new FileInputStream("TeamProject/db.properties");
    } catch (FileNotFoundException e1)
    {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    try
    {
      prop.load(fis);
    } catch (IOException e1)
    {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }  // figure where is = sign. find the (key=value) structure 
    String url = prop.getProperty("url");
    String user = prop.getProperty("user");
    String pass = prop.getProperty("password");    


    try
    {
      //Read the connection properties as Strings
      //Perform the Connection
      conn = DriverManager.getConnection(url,user,pass);

      System.out.println("Connect to DB");
    } 
    catch (SQLException e)
    {      e.printStackTrace();    } 

  }



  public ArrayList<String> query(String query) throws SQLException
  {
    //Create a comma Delimited record using ResultMetaData and SesultSet
    //1. Get the number of colums
    //2. iterate trough each bracket while (rs.next())
    //3. for loop base on the number of columns
    //4. for( i=1; i<=no_columns; i++)
    //5. Append the field followed comma

    System.out.println("inside Query method of Database class");
    ArrayList<String> rows = new ArrayList<String>();

    ResultSet rs; 
    Statement stmt;
    ResultSetMetaData rmd;

    //Create a statement
    stmt=conn.createStatement();  

    //Execute a query
    rs=stmt.executeQuery(query);  

    //Get metadata about the query
    //metadata: data describing another data
    rmd = rs.getMetaData();

    //Get the # of columns
    int no_columns = rmd.getColumnCount();

    //Fetch each row (use numeric numbering 
    //never for loop, don't know how many data are there in DB
    while(rs.next()) 
    {
      String temp = "";
      // no  matter what we used to store(int, data, double), we can use getString() to return as a String
      for(int i=1; i<=no_columns; i++)
      {
        temp += rs.getString(i) +"/";
      }
      rows.add(temp);

    }

    return rows;
  }

  public void executeDML(String dml) throws SQLException
  {

    ResultSet rs; 
    Statement stmt;
    ResultSetMetaData rmd;

    //Create a statement
    stmt=conn.createStatement();  

    //Execute a DML statement
    stmt.execute(dml);

    conn.close();  

    System.out.println("Success");
  }

  public boolean verifyAccount(String username,String password) throws SQLException
  {
    String query = "select username,aes_decrypt(password,'key') from users";

    ResultSet rs; 
    Statement stmt;
    ResultSetMetaData rmd;

    //Create a statement
    stmt=conn.createStatement();  

    //Execute a query
    rs=stmt.executeQuery(query);  

    rmd = rs.getMetaData();

    //Get the # of columns
    int no_columns = rmd.getColumnCount();
    ArrayList<String> rows = new ArrayList<String>();

    //Fetch each row (use numeric numbering 
    //never for loop, don't know how many data are there in DB
    while(rs.next()) 
    {
      if(rs.getString(1).equals(username) && rs.getString(2).equals(password))
        return true;
    }

    return false;

  }


  public boolean addAccount(String username, String password) throws SQLException
  {

    //	insert into user values('jsmith@uca.edu',aes_encrypt('hello123','key'))

    String dml = "insert into users values('" + username +
        "',aes_encrypt('" + password + "','key'))" ;

    ResultSet rs; 
    Statement stmt;
    ResultSetMetaData rmd;

    //Create a statement
    stmt=conn.createStatement();  

    //Execute a DML statement
    try {

      stmt.execute(dml);
      return true;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public String chooseWord(String category) throws SQLException {
    Random rand = new Random();

    Integer randomNum = rand.nextInt(5);

    String select_words = "select words, hints from " + category ;
    ArrayList<String> words_from_db = new ArrayList<String>();
    words_from_db = query(select_words);

    return words_from_db.get(randomNum).toString();
  }
  
  public Connection getConnection ()
  {
    return conn;
  }

  public void setConnection(String fn) 
	{
		Properties prop = new Properties();//Inherits hashmap
		FileInputStream fis = null;

		try
		{
			fis = new FileInputStream("TeamProject/db.properties");
		} catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			prop.load(fis);
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  // figure where is = sign. find the (key=value) structure 
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String pass = prop.getProperty("password");    


		try
		{
			//Read the connection properties as Strings
			//Perform the Connection
			conn = DriverManager.getConnection(url,user,pass);

			System.out.println("Connect to DB");
		} 
		catch (SQLException e)
		{      e.printStackTrace();    } 

		
		
	}
}
