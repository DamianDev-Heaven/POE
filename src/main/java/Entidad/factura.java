
package Entidad;

import com.toedter.calendar.JDateChooser;
import db.Conexion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Administrador
 */

public class factura {
    private int codigoFactura;
    private Date fecha;
    private double total;
    private Conexion conexion;
    private JLabel lblFact;
    private ArrayList<DetalleFactura> detallesFactura;

    public int getCodigoFactura() {
        return codigoFactura;
    }
    public Date getFecha() {
        return fecha;
    }
    public double getTotal() {
        return total;
    }  
    
    public factura(JDateChooser fecha, Conexion conexion, JLabel lblFactura) {
        
        this.fecha = fecha.getDate();
        this.codigoFactura = generarCodigo();
        this.total = 0.0;
        this.conexion = conexion;
        this.lblFact = lblFactura;
        this.detallesFactura = new ArrayList<>();
    }
    private int generarCodigo(){
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(1000) + 3000;
        
        return numeroAleatorio;
    }
    private String generarCodigoFort(){
        return String.format("31DC - " + codigoFactura);
    }
    public void calcularTotal(double subtotalProducto) {
        this.total += subtotalProducto;
    }
    
    public void mostrarCodigo(){
        lblFact.setText(generarCodigoFort());
    }
    public void agregarDetalle(DetalleFactura detalle){
        detallesFactura.add(detalle);
    }
}
