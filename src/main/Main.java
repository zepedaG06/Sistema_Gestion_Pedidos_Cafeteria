package main;

import modelo.*;
import servicios.*;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog("Ingrese nombre del cliente:");
        Cliente cliente = new Cliente(nombre);

        Cajero cajero = new Cajero();
        Cocina cocina = new Cocina();

        Pedido pedido = new Pedido();

        int opcion;

        do {
            try {
                String menu = """
                        --- MENÚ CAFETERÍA ---
                        1. Agregar producto
                        2. Ver productos
                        3. Eliminar producto
                        4. Ordenar pedido
                        5. Salir
                        """;

                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcion) {

                    case 1:
                        String nombreProd = JOptionPane.showInputDialog("Nombre del producto:");

                        double precio;
                        while (true) {
                            try {
                                precio = Double.parseDouble(
                                        JOptionPane.showInputDialog("Precio:")
                                );
                                break;
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Precio inválido");
                            }
                        }

                        int cantidad;
                        while (true) {
                            try {
                                cantidad = Integer.parseInt(
                                        JOptionPane.showInputDialog("Cantidad:")
                                );
                                break;
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Cantidad inválida");
                            }
                        }

                        pedido.agregarProducto(new Producto(nombreProd, precio, cantidad));
                        JOptionPane.showMessageDialog(null, "Producto agregado");
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, pedido.mostrarProductos());
                        break;

                    case 3:
                        if (pedido.estaVacio()) {
                            JOptionPane.showMessageDialog(null, "No hay productos");
                            break;
                        }

                        JOptionPane.showMessageDialog(null, pedido.mostrarProductos());

                        try {
                            int index = Integer.parseInt(
                                    JOptionPane.showInputDialog("Número de producto a eliminar:")
                            ) - 1;

                            pedido.eliminarProducto(index);
                            JOptionPane.showMessageDialog(null, "Producto eliminado");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Entrada inválida");
                        }
                        break;

                    case 4:
                        if (pedido.estaVacio()) {
                            JOptionPane.showMessageDialog(null, "Pedido vacío");
                            break;
                        }

                        cajero.registrarPedido(pedido);
                        cajero.enviarPedidoACocina(pedido, cocina);
                        cajero.notificarCliente(cliente, pedido);

                        JOptionPane.showMessageDialog(null,
                                pedido.mostrarProductos() +
                                        "\nTOTAL: $" + pedido.calcularTotal());

                        int continuar = JOptionPane.showConfirmDialog(null,
                                "¿Desea hacer otro pedido?",
                                "Confirmación",
                                JOptionPane.YES_NO_OPTION);

                        if (continuar == JOptionPane.YES_OPTION) {
                            pedido.limpiarPedido();
                        } else {
                            JOptionPane.showMessageDialog(null, "Gracias por su compra");
                            System.exit(0);
                        }
                        break;

                    case 5:
                        int salir = JOptionPane.showConfirmDialog(null,
                                "¿Seguro que desea salir?",
                                "Salir",
                                JOptionPane.YES_NO_OPTION);

                        if (salir == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Saliendo...");
                            System.exit(0);
                        }
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido");
            }

        } while (true);
    }
}