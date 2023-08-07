package domain.entities.notificaciones;


import domain.entities.actores.miembros.Miembro;
import net.kyori.adventure.text.minimessage.MiniMessage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class notificacionEmial {

    private static String email;
    private static String contrasenia;

    private Properties props;
    private Session session;
    private MimeMessage message;

    private Miembro miembro;

    public void enviarNotificacion(){
            props = new Properties();
    }

    public void crearEmail(){
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        session = Session.getDefaultInstance(props);


        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(miembro.getEmail()));
            String asunto = "Incidentes reportados en las ultimas 24 hs";
            message.setSubject(asunto,"UTF-8");
            String contenido = "Estos fueron los incidentes reportados:";
            message.setText(contenido,"UTF-8");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void enviarEmial(){
        try {
            Transport transport = session.getTransport("smtp");
            transport.connect(email,contrasenia);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Email enviado correctamente!");
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}



