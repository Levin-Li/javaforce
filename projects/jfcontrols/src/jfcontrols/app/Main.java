package jfcontrols.app;

/** jfControls : Main
 *
 * @author pquiring
 */

import java.io.*;

import javaforce.*;
import javaforce.webui.*;
import jfcontrols.panels.*;
import jfcontrols.functions.*;
import jfcontrols.sql.*;
import jfcontrols.images.*;

public class Main implements WebUIHandler {

  public static String version = "0.1B";
  public static ClassLoader loader;

  public static void main(String args[]) {
    //start database
    SQLService.start();
    //start logic server
    FunctionService.main();
    //start webui server
    WebUIServer server = new WebUIServer();
    server.start(new Main(), 34000, false);
  }

  public Panel getRootPanel(WebUIClient client) {
    System.out.println("getRootPanel()");
    return Panels.buildPanel(new Panel(), "main", client);
  }

  public byte[] getResource(String string) {
    System.out.println("getResource(" + string + ")");
    return null;
  }
}