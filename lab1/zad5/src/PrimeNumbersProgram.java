import java.io.*;
import javaIn.*;
/**
 *
 * @author Damian
 */
public class PrimeNumbersProgram {
    public static void main(String[] argv){
        System.out.print("Podaj liczbę do ktorej chcesz znalezc wszystkie liczby pierwsze: ");
        int n=JIn.getInt();
        PrimeNumbers.search(n);
    }
}