package servicios;

import modelo.Cliente;
import modelo.Pedido;
import javax.swing.JOptionPane;

public class Cajero {

    public void registrarPedido(Pedido pedido) {
        JOptionPane.showMessageDialog(null, "Cajero: Pedido registrado");
    }

    public void enviarPedidoACocina(Pedido pedido, Cocina cocina) {
        cocina.procesarPedido(pedido);
    }

    public void notificarCliente(Cliente cliente, Pedido pedido) {
        JOptionPane.showMessageDialog(null,
                cliente.getNombre() + ", tu pedido está: " + pedido.getEstado());
    }
}