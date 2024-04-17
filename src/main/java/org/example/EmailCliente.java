package org.example;

public class EmailCliente implements EmailClient{
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("Enviado Email a " + destinatario);
        System.out.println(mensaje);
    }

    public void enviarCorreo(String destinatario, String mensaje) {
        System.out.println("Enviado Correo a " + destinatario);
        System.out.println(mensaje);
    }
}
