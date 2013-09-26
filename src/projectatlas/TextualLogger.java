/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

/**
 *
 * @author Dumindu
 */
import java.io.IOException;
import java.sql.SQLException;
import org.apache.log4j.Logger;
public class TextualLogger {
  private static Logger log = Logger.getLogger(TextualLogger.class.getName());

  public static void main(String[] args){

      try{
        log.debug("Debug");
        log.info("Info");
        System.out.println("sdf");
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
     
  }
}
