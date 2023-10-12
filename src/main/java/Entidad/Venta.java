/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Administrador
 */
public class Venta {
    private int cantidad;
    private String nombreProducto;
    private double precioUnitario;
    private double subtotal;
    private double cambio;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Venta(int cantidad, String nombreProducto, double precioUnitario, double subtotal) {
        this.cantidad = cantidad;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }
}
