

import com.sun.mail.pop3.POP3SSLStore;


import java.io.File;
import java.io.PrintWriter;
import java.security.Security;
import java.util.Properties;
import java.util.Properties;
import javax.mail.URLName;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;

class testing {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();

        String host = "pop.mail.ru";
        String provider = "pop3";
        final String PORT = "995";
        String username = "goleshov@list.ru";
        String pass = "holeshov";
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        props.setProperty("mail.pop3.ssl.trust", "*");
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.pop3.socketFactory.fallback", "false");
        props.setProperty("mail.pop3.port", PORT);
        props.setProperty("mail.pop3.socketFactory.port", PORT);

        URLName urln = new URLName(provider, host, Integer.parseInt(PORT), null, username, pass);

        Session session = Session.getInstance(props,  new MailAuthenticator());


        POP3SSLStore store = new POP3SSLStore(session, urln);
       // Store store = session.getStore(urln);
        store.connect();



        Folder inbox = store.getFolder("INBOX");
        if (inbox == null) {
           System.out.println("No INBOX");
            System.exit(1);
        }
       inbox.open(Folder.READ_ONLY);



      javax.mail.Message[] messages = inbox.getMessages();
     //  for (int i = 0; i < 1; i++) {
        int i=906;
            System.out.println("Message " + (i + 1));
           File newFile=new File("F:\\test\\"+i+".txt");
           PrintWriter printWriter=new PrintWriter(newFile);
         //  printWriter.write(

         //
           System.out.println(messages[i].);

          //  messages[i].writeTo(System.out);
     //  }
       inbox.close(false);
        store.close();
    }
}

class MailAuthenticator extends Authenticator {

    public MailAuthenticator() {
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("Psix47@mail.ru", "******");
    }
}
