public class PrimeNumbers{
    /**
     * @author Damian
     * @param n liczba od ktorej ma wyszukac liczby pierwsze
     */
    public static void search(int n) {
        boolean[] tab = new boolean[n];
        /**
         * @param m - wykreslanie kolejnych wielokrotnosci liczb od 2 do n
         */
        for (int i = 2; i < n; i++)
            tab[i] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (tab[i]) {
                int m = i * i;
                while (m < n) {
                    tab[m] = false;
                    m += i;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (tab[i])
                System.out.println(i);
        }
    }
}
