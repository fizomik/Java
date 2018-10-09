import java.io.*;
/**
 * @author Damian Kozyra
 */
public class Peselprogram {
    public static void main(String[] argv){
        System.out.print("Podaj numer pesel: ");
        String text = null;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);
            text = bfr.readLine();
            if(Pesel.check(text))
                System.out.print("Poprawny numer pesel! ");
            else
                System.out.print("Niepoprawny numer pesel! ");
        }catch(IOException e){e.printStackTrace();}
    }
}

