import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class MicroDVDDelayer {


    public static void microDVDDelayer(String inputFilePath, String outputFilePath, int delay, int fps) throws IOException, ImproperDataException {
        BufferedReader input = null;
        FileWriter output = null;
        try (BufferedReader input1 = new BufferedReader(new FileReader(
                new File(inputFilePath)));
             FileWriter output1 = new FileWriter(new File(
                     outputFilePath))) {
            input = input1;
            output = output1;
            String temp;
            while ((temp = input.readLine()) != null) {
                output.write(delay(temp, delay, fps));
            }
        } finally {
            if (input != null)
                input.close();
            if (output != null)
                output.close();
        }
    }


    public static String delay(String in, int delay, int fps) throws ImproperDataException {
        String[] parts = in.split("\\}");
        Integer begin, end;
        if ((Pattern.matches("\\{[[0-9]]*", parts[0])) && (Pattern.matches("\\{[[0-9]]*", parts[1]))) {
            begin = Integer.parseInt(parts[0].split("\\{")[1]);
            end = Integer.parseInt(parts[1].split("\\{")[1]);
            if (begin > end) {
                throw new ImproperDataException("Begining time of subtitles is further than the end");
            }
            begin += (fps * delay / 1000);
            end += (fps * delay / 1000);
            return "{" + begin.toString() + "}{" + end.toString() + "}"
                    +parts[2] + "\n";
        } else {
            throw new ImproperDataException("Wrong format of subtitles");
        }
    }
}







