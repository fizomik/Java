public class Pesel {
    /**
     * @param n - numer pesel
     * @author Damian Kozyra
     */
    public static boolean check(String n) {
        if (n.length() != 11)
            return false;

        int kontrolna = Character.getNumericValue(n.charAt(10));
        int suma = 9 * Character.getNumericValue(n.charAt(0))+
                7 * Character.getNumericValue(n.charAt(1)) +
                3 * Character.getNumericValue(n.charAt(2)) +
                1 *Character.getNumericValue(n.charAt(3)) +
                9 * Character.getNumericValue(n.charAt(4)) +
                7 * Character.getNumericValue(n.charAt(5)) +
                3 * Character.getNumericValue(n.charAt(6)) +
                1 *Character.getNumericValue(n.charAt(7)) +
                9 * Character.getNumericValue(n.charAt(8)) +
                7 * Character.getNumericValue(n.charAt(9));
        int modulo = suma % 10;
        return kontrolna == modulo;
    }
}