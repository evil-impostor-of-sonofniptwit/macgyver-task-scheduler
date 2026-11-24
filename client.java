/*
  should run on each SLAVE unit
  should recieve new tasks from MASTER unit and process them
  keep security in mind
*/

import java.io.*;
import java.net.*;

public class client {

  private Socket sock;
  //private BufferedReader in;
  //private DataOutputStream out;

  // Client constructors
  public client(String sAdd, int port) {
    System.out.println("Connection to service at "+sAdd+":"+Integer.toString(port)+"...");
    try {
      sock = new Socket(sAdd,port);
      System.out.println("  + Socket established");
      System.out.println("Succeeded!");
    } catch (UnknownHostException e) {
      System.out.println("Failed; could not resolve host \""+sAdd+"\"");
    } catch (Exception e) {
      System.out.println("Failed with the following unrecognized Exception:");
      System.out.println(e.toString());
    }
  }
}
