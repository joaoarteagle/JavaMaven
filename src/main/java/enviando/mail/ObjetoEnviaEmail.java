package enviando.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {
	private String username = "javawebtreinamento@gmail.com";
	private String password = "dbdn tsuo fhyc bobw";
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assunto = "";
	private String textoEmail = "";
	public ObjetoEnviaEmail(String listaDestinatario,
							String nomeRemetente, 
							String assunto, 
							String textoEmail) {
		
		this.listaDestinatarios = listaDestinatario;
		this.nomeRemetente = nomeRemetente;
		this.assunto = assunto;
		this.textoEmail = textoEmail;
		
	}
	
	public void enviarEmail(boolean envioHtml) throws Exception {
		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.trust", "*");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, password);
			}
		});

		Address[] toUser = InternetAddress.parse(listaDestinatarios);

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username,nomeRemetente));
		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject(assunto);
		
		if(envioHtml) {
			message.setContent(textoEmail, "text/html; charset=utf-8");
		}else {
		message.setText(textoEmail);
		}
		Transport.send(message);
	}
}
