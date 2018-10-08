import java.io.*;
/**
 *
 * @author Damian
 */
public class LoginProgram {
    public static void main(String[] argv){
        Login log = new Login ("ala", "makota");
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            System.out.println("Podaj login:");
            String login = bfr.readLine();
            System.out.println("Podaj haslo:");
            String haslo = bfr.readLine();


        if(log.check(login, haslo))
            System.out.println("OK");
        else
            System.out.println("Bledny login lub haslo");


        }catch(IOException e){e.printStackTrace();}

    }
}