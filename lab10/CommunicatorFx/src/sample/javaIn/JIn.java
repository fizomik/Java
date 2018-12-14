/**
 * @author Damian
 */
package sample.javaIn;

import java.io.*;

public class JIn {
    public static String getString() {
        String text = null;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            text = bfr.readLine();
        }catch(IOException e){e.printStackTrace();}
        return text;
    }

    public static double getDouble() {
        String text = null;
        double number = 0;
        try {
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            text = bfr.readLine();
            number = Double.parseDouble(text);
        } catch (IOException e) {e.printStackTrace();}
        return number;
    }

    public static int getInt() {
        String text = null;
        int asnumeric = 0;
        try {
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            text = bfr.readLine();
            asnumeric = Integer.parseInt(text);
        }catch (IOException e) {e.printStackTrace();}
        return asnumeric;


    }
}