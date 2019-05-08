package TeamProject;
import static org.junit.Assert.*;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;



public class PlayerClientTest
{ 
 // private Database db;  
 // private int rando;
  private ServerGUI serverGUI;
  private PlayerGUI clientGUI;
  private GameServer server;
  private PlayerClient client;
  //String [] animals = {"chimpanzee","octopus","porcupine","sheep","giraffe"};
  
  @Before
  public void setUp() throws Exception 
  {
    //Start Server GUI
    serverGUI = new ServerGUI("8300", "500");
    //Get server
    server = serverGUI.getGameServer();
    server.listen();

    //Start Client GUI
    clientGUI = new PlayerGUI("localhost","8300");
    //Get client
    client = clientGUI.getClient();
    

  }
  @Test
  public void testClientConnection() throws IOException
  {
    //Check if client if connected
    assertTrue(client.isConnected());
  }
  
}