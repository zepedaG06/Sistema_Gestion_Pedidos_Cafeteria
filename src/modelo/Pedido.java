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

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public void cambiarEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}