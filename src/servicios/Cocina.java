package servicios;

import modelo.Pedido;
import javax.swing.JOptionPane;

public class Cocina {

    public void procesarPedido(Pedido pedido) {
        JOptionPane.showMessageDialog(null, "Cocina: Procesando pedido...");
        pedido.cambiarEstado("En proceso");

        JOptionPane.showMessageDialog(null, "Cocina: Preparando productos...");

        pedido.cambiarEstado("Listo");
        JOptionPane.showMessageDialog(null, "Cocina: Pedido listo");
    }
}