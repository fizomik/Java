import java.io.File;
import java.io.IOException;
import javaIn.*;


public class CryptographerMain {

    public static void main(String[] argv) {
        try{

            File in = new File(argv[0]);
            File out = new File(argv[1]);
            System.out.println("1. Szyfruj");
            System.out.println("2. Odszyfruj");
            int choice = JIn.getInt();


            switch (choice) {
                case 1:
                    System.out.println("1. ROT11");
                    System.out.println("2. Polibiusz");
                    int choice1 = JIn.getInt();
                    switch (choice1) {
                        case 1:

                            ROT11 r = new ROT11();
                            Cryptographer.cryptfile(in, out, r);
                            break;


                        case 2:

                            Polibiusz r1 = new Polibiusz();
                            Cryptographer.cryptfile(in, out, r1);
                            break;
                    }
                    break;

                case 2:
                    System.out.println("1. ROT11");
                    System.out.println("2. Polibiusz");
                    int choice2 = JIn.getInt();
                    switch (choice2) {
                        case 1:

                            ROT11 r = new ROT11();
                            Cryptographer.decryptfile(in, out, r);
                            break;


                        case 2:

                            Polibiusz r1 = new Polibiusz();
                            Cryptographer.decryptfile(in, out, r1);
                            break;
                    }
                    break;


                default: {
                    System.out.print("Podaj liczbę od 1 lub 2: ");
                    break;
                }

            }


        } catch (IOException e) {
            System.out.println("Brak plików");
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("Brak argumentów ");
        }


    }
}



