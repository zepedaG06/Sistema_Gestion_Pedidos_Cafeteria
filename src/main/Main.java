package main;

import modelo.Cliente;
import modelo.Pedido;
import servicios.Cajero;
import servicios.Cocina;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog("Ingrese nombre del cliente:");
        Cliente cliente = new Cliente(nombre);

        Cajero cajero = new Cajero();
        Cocina cocina = new Cocina();

        Pedido pedido = cliente.realizarPedido();
        cajero.registrarPedido(pedido);
        cajero.enviarPedidoACocina(pedido, cocina);
        cajero.notificarCliente(cliente, pedido);

        JOptionPane.showMessageDialog(null,
                "Total a pagar: $" + pedido.calcularTotal());
    }
}