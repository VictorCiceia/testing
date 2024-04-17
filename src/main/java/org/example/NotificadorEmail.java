package org.example;

public class NotificadorEmail {
    private EmailCliente emailCliente;

    public NotificadorEmail(EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void notificar(String direccion, String mensaje) {
        if(direccion == null || direccion.isBlank() || !direccion.contains("@")){
            return;
        }
        if(mensaje == null || mensaje.isBlank() ){
            return;
        }
        if(mensaje.length() > 50){
            throw new EmailException("Mensaje muy largo, se permite 255 caracteres");
        }
        emailCliente.enviarCorreo(direccion, mensaje);
    }
}
