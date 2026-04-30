package servicios;

import modelo.Pedido;
import javax.swing.JOptionPane;

public class Cocina {

    public void procesarPedido(Pedido pedido) {
        pedido.cambiarEstado("En proceso");
        JOptionPane.showMessageDialog(null, "Cocina: Preparando pedido...");

        pedido.cambiarEstado("Listo");
        JOptionPane.showMessageDialog(null, "Cocina: Pedido listo");
    }
}