import java.awt.*;
import javaIn.*;

public class Shapeprogram{
    private static int menu(){
        System.out.println();
        System.out.println("1. Dodaj kwadrat");
        System.out.println("2. Dodaj prostokat");
        System.out.println("3. Dodaj koło");
        System.out.println("4. Dodaj trójkąt");
        System.out.println("5. Rysuj wszystko");
        System.out.println("6. Wyjdz");

        return JIn.getInt();
    }

    public static void main(String [] argv){
        int choice = menu();
        while(choice!=6) {
            switch (choice) {
                case 1:
                    MyPanel.addSquare();
                    System.out.println("Dodałeś kwadrat");
                    break;

                case 2:
                    MyPanel.addRectangle();
                    System.out.println("Dodałeś prostokat");
                    break;
                case 3:
                    MyPanel.addCircle();
                    System.out.println("Dodałeś koło");
                    break;

                case 4:
                    MyPanel.addTriangle();
                    System.out.println("Dodałeś trójkąt");
                    break;
                case 5:
                    EventQueue.invokeLater(MyFrame::new);
                    break;
                default: {
                    System.out.print("Podaj liczbę od 1 do 5: ");
                    break;
                }
            }

            choice = menu();
        }
    }

}

