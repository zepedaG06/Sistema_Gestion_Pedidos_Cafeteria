package servicios;

import modelo.Cliente;
import modelo.Pedido;
import javax.swing.JOptionPane;

public class Cajero {

    public void registrarPedido(Pedido pedido) {
        JOptionPane.showMessageDialog(null, "Cajero: Registrando pedido...");
    }

    public void enviarPedidoACocina(Pedido pedido, Cocina cocina) {
        JOptionPane.showMessageDialog(null, "Cajero: Enviando pedido a cocina...");
        cocina.procesarPedido(pedido);
    }

    public void notificarCliente(Cliente cliente, Pedido pedido) {
        JOptionPane.showMessageDialog(null,
                "Cajero: " + cliente.getNombre() +
                        ", tu pedido está " + pedido.getEstado());
    }
}