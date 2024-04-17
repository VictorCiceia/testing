package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NotificadorEmailTest {

    @Mock
    private EmailCliente emailClienteMock;

    @Test
    public void testNotificar() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "Hola Mundo");

        // Verificar que emailClienteMock.enviarCorreo se llamó con los argumentos correctos
        verify(emailClienteMock).enviarCorreo("ejemplo@test.com", "Hola Mundo");
    }
    // Test para verificar que no se envía correo con dirección vacía

    @Test
    public void testNotificarConDireccionVacia() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("", "Mensaje");

        // Verificar que no se realiza el envío si la dirección es vacía
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }
    // Test para verificar el comportamiento con mensaje nulo

    @Test
    public void testNotificarConMensajeNulo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", null);

        // Verificar que se maneja adecuadamente un mensaje nulo
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    @Test
    public void testNotificarConDireccionNoValida() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplotest.com", "Mensaje");

        // Verificar que no se realiza el envío si la dirección no es valida
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }
    // Test para verificar el comportamiento con direccion no valido

    @Test
    public void testNotificarDosSeguidas() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "Mensaje");
        notificador.notificar("ejemplo@test.com", "Mensaje");

        // Verificar que se realize el envio de dos email
        verify(emailClienteMock, times(2)).enviarCorreo(anyString(), anyString());
    }
    // Test para verificar el comportamiento con envio de dos email seguidos

    @Test
    public void testNotificarMensajeLargo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        // Verificar que lance una excepcion cuando el mensaje es muy largo
        assertThrows(EmailException.class, () -> {
            notificador.notificar("ejemplo@test.com", "123456789012345678901234567890123456789012345678901234567890");
        });
    }
    // Test para verificar el comportamiento con mensaje muy largo


}
