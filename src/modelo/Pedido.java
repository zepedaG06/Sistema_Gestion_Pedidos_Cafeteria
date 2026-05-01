package modelo;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<Producto> productos;
    private String estado;

    public Pedido() {
        productos = new ArrayList<>();
        estado = "Pendiente";
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void eliminarProducto(int index) {
        if (index >= 0 && index < productos.size()) {
            productos.remove(index);
        }
    }

    public String mostrarProductos() {
        if (productos.isEmpty()) return "No hay productos";

        String lista = "";
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            lista += (i + 1) + ". " +
                    p.getNombre() +
                    " | $" + p.getPrecio() +
                    " | Cantidad: " + p.getCantidad() +
                    " | Subtotal: $" + p.getSubtotal() + "\n";
        }
        return lista;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getSubtotal();
        }
        return total;
    }

    public void cambiarEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public boolean estaVacio() {
        return productos.isEmpty();
    }

    public void limpiarPedido() {
        productos.clear();
        estado = "Pendiente";
    }
}