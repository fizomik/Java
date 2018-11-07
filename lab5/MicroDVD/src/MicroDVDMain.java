import java.io.IOException;

public class MicroDVDMain {


    public static void main(String[] args) {
        try { MicroDVDDelayer.microDVDDelayer(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } catch (IndexOutOfBoundsException a) {
            System.out.println("Wrong number of program arguments (should be 4): " + a.getMessage());
        } catch (NumberFormatException a) {
            System.out.println("Check 3rd and 4th arg: " + a.getMessage());
        } catch (IOException a) {
            System.out.println("Problem with open file: " + a.getMessage());
        } catch (ImproperDataException a) {
            System.out.println("Wrong file with subtitles: " + a.getMessage());
        }

    }

}