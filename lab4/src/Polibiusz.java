public class Polibiusz implements Algorithm {


    private final char[][] alph =       { { 'A', 'B', 'C', 'D', 'E' },
                                        { 'F', 'G', 'H', 'J', 'K' },
                                        { 'L', 'M', 'N', 'O', 'P' },
                                        { 'Q', 'R', 'S', 'T', 'U' },
                                        { 'V', 'W', 'X', 'Y', 'Z' } };




    @Override
    public String crypt(String linia) {
        String result = new String();

        boolean flaga;

        linia = linia.toUpperCase();

        linia.replace('I', 'J');


        for (Character i : linia.toCharArray()) {
            flaga = false;

            for (int j = 0; j < alph.length && !flaga; j++) {
                for (int k = 0; k < alph[0].length && !flaga; k++) {
                    if (i.equals(alph[j][k])) {
                        result += j + 1;
                        result += k + 1;
                        result += ' ';
                        flaga = true;
                    }
                }
            }
            if (!flaga) {
                result += i;
                if (i != ' ')
                    result += ' ';
            }
        }
        return result;
    }



    @Override
    public String decrypt(String linia) {
        char[] decryptArray = linia.toCharArray();
        String result = "";
        int step = 1;
        for (int i = 0; i < decryptArray.length; i += step) {
            step = 1;
            if (decryptArray[i] - '0' >= 0 && decryptArray[i] - '0' < alph.length) {
                step = 2;
                if ((decryptArray[i + 1] - 1 - '0' >= 0 && decryptArray[i + 1] - 1 - '0' < alph[0].length) && i + 1 < decryptArray.length) {
                    result = result + alph[decryptArray[i] - 1 - '0'][decryptArray[i + 1] - 1 - '0'];
                } else {
                    result = result + decryptArray[i];
                    if (i + 1 < linia.length())
                        if (linia.charAt(i + 1) != ' ')
                            result = result + decryptArray[i + 1];
                        else {
                            if (i + 2 < linia.length()) {
                                if (linia.charAt(i + 2) == ' ')
                                    result = result + decryptArray[i + 1];
                            }
                        }
                }
            } else {

                if (i + 1 < linia.length())
                    if (linia.charAt(i + 1) == ' ')
                        result = result + decryptArray[i];
            }
        }
        return result;
    }

}