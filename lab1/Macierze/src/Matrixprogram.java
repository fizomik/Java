/**
 * @author Damian
 */
import javaIn.*;
public class Matrixprogram {
    public static void main(String[] argv)
    {

        System.out.println("Podaj rozmiar macierzy: ");
        int n=JIn.getInt();
        if(n>0){
            int[] tab = new int[n*n];
            int[] tab1 = new int[n*n];
            System.out.println("Podaj wartosci dla pierwszej macierzy: ");
            for (int i = 0; i < n*n; i++) {
                tab[i] = JIn.getInt();
            }
            System.out.println("Podaj wartosci dla drugiej macierzy:: ");
            for (int i = 0; i < n*n; i++) {
                tab1[i] = JIn.getInt();
            }
            Matrix o1 = new Matrix(tab,n);
            Matrix o2 = new Matrix(tab1,n);

            System.out.println("Pierwsza macierz:");
            o1.show();
            System.out.println("\nDruga macierz:");
            o2.show();

            System.out.println("\nSuma:");
            Matrix o3 = o1.add(o2);
            o3.show();

            System.out.println("\nRóżnica:");
            Matrix o4 = o1.sub(o2);
            o4.show();

            System.out.println("\nIloczyn:");
            Matrix o5 = o1.mul(o2);
            o5.show();

        }
        else {
            System.out.println("Wielkosc <1 ");

        }






    }
}