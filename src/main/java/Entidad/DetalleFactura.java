package Entidad;

/**
 *
 * @author Administrador
 */
public class DetalleFactura {
    private int detalleId;
    private int productoId;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public int getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(int detalleId) {
        this.detalleId = detalleId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public DetalleFactura(int detalleId, int productoId, int cantidad, double precioUnitario, double subtotal) {
        this.detalleId = detalleId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }
    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }
    

}
