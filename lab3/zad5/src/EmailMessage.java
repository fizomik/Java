import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.Properties;

public class EmailMessage {
    private String from; //required (must be gmail e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional
    private static Properties mailServerProperties;
    private static Session getMailSession;
    private static MimeMessage generateMailMessage;

    private EmailMessage(Builder builder){
        this.from=builder.from;
        this.to=builder.to;
        this.subject=builder.subject;
        this.content=builder.content;
        this.mimeType=builder.mimeType;
        this.cc=builder.cc;
        this.bcc=builder.bcc;

    }

    public static class Builder{
        private String from; //required (must be e-mail)
        private LinkedList<String> to; //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType;  // optional
        private LinkedList<String> cc; //optional
        private LinkedList<String> bcc; // optional

        public Builder(){
            to = new LinkedList<String>();
            cc = new LinkedList<String>();
            bcc = new LinkedList<String>();
        }

        public Builder from(String from){
            this.from = from;
            return this;
        }

        public Builder to(LinkedList<String> to){
            this.to.addAll(to);
            return this;
        }

        public Builder to(String to){
            this.to.add(to);
            return this;
        }

        public Builder subject(String subject){
            this.subject=subject;
            return this;
        }

        public Builder content(String content){
            this.content=content;
            return this;
        }

        public Builder mimeType(String mimeType){
            this.mimeType=mimeType;
            return this;
        }

        public Builder cc(LinkedList<String> cc){
            this.cc.addAll(cc);
            return this;
        }

        public Builder cc(String cc){
            this.cc.add(cc);
            return this;
        }

        public Builder bcc(LinkedList<String> bcc){
            this.bcc.addAll(bcc);
            return this;
        }

        public Builder bcc(String bcc){
            this.bcc.add(bcc);
            return this;
        }

        public EmailMessage build(){
            if(from == null || from.isEmpty()){
                throw new IllegalArgumentException("e-mail must be non-empty value");
            }

            if(to.size()<1 && cc.size()<1 && bcc.size()<1){
                throw new IllegalArgumentException("you have to add at least one adress to: To or Cc or Bcc");
            }

            if(subject==null){
                subject="";
            }

            if(content==null){
                content="";
            }

            if(mimeType==null){
                mimeType="";
            }


            return new EmailMessage(this);
        }

    }





    public void send() throws AddressException, MessagingException {



        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");


        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        for(String i:to){
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(i));
        }
        for(String i:cc){
            generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(i));
        }
        for(String i:bcc){
            generateMailMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress(i));
        }
        generateMailMessage.setSubject(subject);
        generateMailMessage.setContent(content, mimeType);


        Transport transport = getMailSession.getTransport("smtp");


        transport.connect("smtp.gmail.com", from, "haslo");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }


}
