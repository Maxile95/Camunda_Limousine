package loanapproval;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import com.sun.mail.smtp.SMTPTransport;


public class Kunde_absagen implements JavaDelegate{
	private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");
	
	
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Kunden-Absage fuer:'" + execution.getVariable("Customer") + "' wird vorbereitet...");
		//E-Mail senden
		Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        msg.setFrom(new
        InternetAddress("limousinenvermietung@gmail.com"));;
        msg.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse("joel.ranzer@gmail.com", false));
        msg.setSubject("Absage");
        msg.setText("Leider haben wir für Sie keine Limousine gefunden!");
        msg.setHeader("X-Mailer", "Tov Are's program");
        msg.setSentDate(new Date());
        SMTPTransport t =(SMTPTransport)session.getTransport("smtps");
        t.connect("smtp.gmail.com", "limousinenvermietung@gmail.com", "Passwort12!");
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Response: " + t.getLastServerResponse());
        t.close();
		LOGGER.info("Kunden-Absage wurde versendet!");
	}
	
	
}


