import figura.*;
import javaIn.*;

import java.io.IOException;
import java.util.LinkedList;



public class Test {
    private static LinkedList<Prostokąt> figury = new LinkedList<Prostokąt>();

    private static int menu(){
        System.out.println();
        System.out.println("1. Wczytaj prostokat");
        System.out.println("2. wyswietl prostokat");
        System.out.println("3. Oblicz sume pol wszystkich prostokatow");
        System.out.println("4. Zakończ\n ");


        return JIn.getInt();
    }

    public static void main(String[] args) throws IOException {
        int choice = menu();

        while(choice!=4) {
            switch (choice) {
                case 1:
                    double a,b;
                    System.out.print("Podaj a: ");
                    a=JIn.getDouble();
                    System.out.print("Podaj b: ");
                    b=JIn.getDouble();
                    figury.add(new Prostokąt(a,b));
                    break;

                case 2:
                    for (int i=0;i<figury.size();i++) {
                        System.out.println((i+1)+". ("+figury.get(i).getA()+" , "+figury.get(i).getB()+")");
                    }
                    break;

                case 3:
                    double suma=0;
                    for (int i=0;i<figury.size();i++) {
                        suma+=figury.get(i).area();
                    }
                    break;
                default:{
                    System.out.print("Podaj liczbę od 1-4: ");
                    break;
                }

            }

            choice = menu();
        }

    }
}