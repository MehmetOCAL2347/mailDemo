package maildemo;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailDemo {
        
    public static void main(String[] args) {
        
        Properties properties;
        Message mesaj;
        Session session;
        
        String mailAdresim = "kendiMailAdresiniz@gmail.com";
        String mailSifrem = "mailŞifreniz";
        String mailAtılacakAdres = "mailAtılacakAdres@gmail.com";
        String mailBaslıgı = "Java İle Mail";
        String mailIcerigi = "Java İle İlk Mail Denemesi";
        
        properties = System.getProperties();        
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        session = Session.getInstance(properties, new Authenticator() {            
            
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                
                return new PasswordAuthentication(mailAdresim, mailSifrem);
                
            }
        }); 
        
        mesaj = new MimeMessage(session);
        
        try {
            
            mesaj.setFrom(new InternetAddress(mailAdresim));
            
            mesaj.setRecipient(
                    Message.RecipientType.TO, 
                    new InternetAddress(mailAtılacakAdres)
            );
            
            mesaj.setText(mailIcerigi);
            mesaj.setSubject(mailBaslıgı);
            
            Transport.send(mesaj);  
            
        } catch (AddressException ex) {
            System.out.println(ex);
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
    }        
}





