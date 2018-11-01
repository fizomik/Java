public class ROT11 implements Algorithm {


    private final int shift = 11;

    @Override
    public String crypt(String linia) {
        StringBuilder sb = new StringBuilder(linia);
        for (int i = 0; i < linia.length(); i++) {
            if (linia.charAt(i) != ' ' && linia.charAt(i) != '\n') {
                int c = (int) sb.charAt(i);
                if ((int) c >= 97 && (int) (c) <= 122) {
                    if ((int) c + shift > 122)
                        c = 97 + c + shift - 122 -1;
                    else
                        c += shift;
                } else if ((int) c >= 65 && (int) (c) <= 90) {
                    if ((int) c + shift > 90)
                        c = 65 + c + shift - 90 -1;
                    else
                        c += shift;
                }

                sb.setCharAt(i, (char) c);
            }


        }


        return sb.toString();
    }

    @Override
    public String decrypt(String linia) {

        StringBuilder sb = new StringBuilder(linia);
        for (int i = 0; i < linia.length(); i++) {
            if (linia.charAt(i) != ' ' && linia.charAt(i) != '\n') {
                int c = (int) sb.charAt(i);
                if ((int) c >= 97 && (int) (c) <= 122) {
                    if ((int) c - shift < 97)
                        c = 122 - (97 - (c - shift))+1;
                    else
                        c -= shift;
                }
                else if ((int) c >= 65 && (int) (c) <= 90) {
                    if ((int) c - shift < 65)
                        c = 90 - (65 - (c - shift))+1;
                    else
                        c -= shift;
                }

                sb.setCharAt(i, (char) c);
            }

        }
        return sb.toString();
    }
}
