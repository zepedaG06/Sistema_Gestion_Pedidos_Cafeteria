package modelo;

import javax.swing.JOptionPane;

public class Cliente {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Pedido realizarPedido() {
        JOptionPane.showMessageDialog(null, nombre + " está realizando un pedido");

        Pedido pedido = new Pedido();

        String opcion;
        do {
            String producto = JOptionPane.showInputDialog("Ingrese producto:");
            double precio = Double.parseDouble(
                    JOptionPane.showInputDialog("Ingrese precio:")
            );

            pedido.agregarProducto(new Producto(producto, precio));

            opcion = JOptionPane.showInputDialog("¿Agregar otro producto? (si/no)");
        } while (opcion.equalsIgnoreCase("si"));

        return pedido;
    }

    public String getNombre() {
        return nombre;
    }
}