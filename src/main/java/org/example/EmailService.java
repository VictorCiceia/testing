package org.example;

public class EmailService {

    private EmailClient emailClient;

    public EmailService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public void enviarCorreo(String destinatario, String mensaje) {
        // Lógica para enviar correo
        emailClient.enviar(destinatario, mensaje);
    }
}
