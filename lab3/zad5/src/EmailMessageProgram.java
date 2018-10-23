import javax.mail.*;
import java.util.LinkedList;

public class EmailMessageProgram {
    public static void main(String[] argv) throws MessagingException {

        try{ ;
            //do: to,cc,bcc mozna przekazac lista lub stringiem
            //LinkedList<String> toList = new LinkedList<>();
            //LinkedList<String> ccList = new LinkedList<>();
            //LinkedList<String> bccList = new LinkedList<>();
            EmailMessage email =new EmailMessage.Builder()
                    .from("Nadawca")
                    .to("Odbiorca")
                    //.cc("Adresat kopii")
                    //.bcc("Adresat ukrytej kopii")
                    .subject("test")
                    .content("Witam, to test")
                    .mimeType("text/html")
                    .build();

            email.send();
            System.out.println("\n\n $Your Java Program has just sent an Email successfully. Check your email...");
        }

        catch(MessagingException w)
        {
            System.out.println(w.getMessage());
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

    }



}