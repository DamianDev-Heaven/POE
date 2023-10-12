
package Entidad;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Josue
 */
public class Producto {
    
    int id_producto;
    String nombre;
    Double precio;
    int obtidS;
    int seccion;
    private Conexion oCnn;
    int cantidad;
    double subtotal;

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    public int getObtidS() {
        return obtidS;
    }

    public void setObtidS(int obtidS) {
        this.obtidS = obtidS;
    }

    public Producto(int obtidS) {
        this.obtidS = obtidS;
    }

    public Producto(int id_producto, String nombre, Double precio ,int cantidad, double subtotal) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    
    public Producto(){};
    
    public Producto(String nombre, Conexion oCnn){
       this.nombre = nombre; 
       this.oCnn = oCnn;
    }

    public Producto(int id_producto, String nombre, Double precio, int seccion, Conexion oCnn) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.seccion = seccion;
        this.oCnn = oCnn;
    }
     public Producto(Conexion pCon)
    {
    
        this.oCnn= pCon;
    }
      public void guardar()
    {
        try
        {
            String DatosF = "insert into producto (id_producto, nombre, precio, id_seccion)"
                           + " values (?, ?, ?, ?)";
      
            PreparedStatement pst = this.oCnn.oCon.prepareStatement(DatosF);
            pst.setInt(1, this.getId_producto());
            pst.setString(2, this.getNombre());
            pst.setDouble(3, this.getPrecio());
            pst.setInt(4, this.getSeccion());
            pst.execute();
        }
        catch(Exception ee)
        {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ee);

        }
    }
    public ResultSet getTodo()
    {
        try
        {
            String DatosF= "SELECT * FROM producto;";
            Statement stm = this.oCnn.oCon.createStatement();
            return stm.executeQuery(DatosF);
            
        }
        catch(Exception ee) 
        {
            return null;
        }
    }
    public ResultSet getTodo2(int idsec) {
    try {
        String datosF = "SELECT id_producto, nombre, precio FROM producto WHERE id_seccion = ?;";
        PreparedStatement preparedStatement = this.oCnn.oCon.prepareStatement(datosF);
        // Sustituimos el parámetro por el valor proporcionado
        preparedStatement.setInt(1, idsec);

        return preparedStatement.executeQuery();
    } catch (Exception ee) {
        ee.printStackTrace(); // Manejo de errores, imprime la traza en la consola
        return null;
    }
}


    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
        public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public Conexion getoCnn() {
        return oCnn;
    }

    public void setoCnn(Conexion oCnn) {
        this.oCnn = oCnn;
    }
    public void llenarCMB(JComboBox<String> comboBox){
        try{
          String query = "SELECT DISTINCT nombre FROM seccion";
          Statement st = this.oCnn.oCon.createStatement();
          ResultSet rs = st.executeQuery(query);
           while (rs.next()) {
            String nombreSeccion = rs.getString("nombre");
            comboBox.addItem(nombreSeccion);
        }
         rs.close();
         st.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    
}
