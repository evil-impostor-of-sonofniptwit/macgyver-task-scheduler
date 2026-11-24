/*
  should run on each SLAVE unit
  should recieve new tasks from MASTER unit and process them
  keep security in mind
*/

import java.io.*;
import java.net.*;

protected static final boolean local = false; // limit client to local host when connecting to server?

public class client {
  //private BufferedReader in;
  //private DataOutputStream out;

  private Socket sock;

  // Client constructors
  public static Socket conn(String addr, int port) {
    System.out.println("Connecting to service at "+sAdd+":"+Integer.toString(port)+"...");
    try {
      sock = new Socket(sAdd,port);
      System.out.println("  + Socket established");
      System.out.println("Succeeded!");
      return sock;
    } catch (UnknownHostException e) {
      System.out.println("Failed; could not resolve host \""+sAdd+"\"");
    } catch (Exception e) {
      System.out.println("Failed with the following unrecognized Exception:");
      System.out.println(e.toString());
    }
    return null;
  }

  public client(int port) {
    // assumes local host
    this.sock = conn("127.0.0.1",port) // FIXME: issue #6
  }

  public client(String sAdd, int port) {
    if (local) { // resolve issue #5
      System.out.println("'client' constructor #2 with signature 'client(String sAdd, int port)' invoked under condition 'local'.\n\tDefaulting to local host; source address parameter will NOT be respected!");
      this(port);return;
    }
    this.sock = conn(sAdd,port);
  }
}
