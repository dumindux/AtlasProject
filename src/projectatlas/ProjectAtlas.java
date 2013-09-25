/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author Dumindu
 */
public class ProjectAtlas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchAlgorithmException {
        // TODO code application logic here
        //new MySqlPassword();
        //MySqlPassword.createConnection();
        //System.out.println(MySqlPassword.compareData("dumindux","dextor"));
        byte[] b=hash("atlas");
        System.out.println(Arrays.toString(b));
       // MySqlPassword.shutdown();
    }
    public static byte[] hash(String password)throws NoSuchAlgorithmException
    {
        MessageDigest sha256=MessageDigest.getInstance("SHA-256");
        byte[] passBytes=password.getBytes();
        byte[] passHash=sha256.digest(passBytes);
       // String x=new String(passHash);
        return passHash;
    }
}
