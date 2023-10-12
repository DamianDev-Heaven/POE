/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import db.Conexion;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josue
 */
public class Comprobante {
    int id;
    String co;
    Date fecha;
    Double total;
    Conexion oCnn;
        public Comprobante(String co, Date fecha, Double total, Conexion oCnn) {
        this.co = co;
        this.fecha = fecha;
        this.total = total;
        this.oCnn = oCnn;
    }
    public void guardar()
    {
        try
        {
            String DatosF = "insert into factura(codigo, fecha, total)"
                           + " values (?, ?, ?)";
      
            PreparedStatement pst = this.oCnn.oCon.prepareStatement(DatosF);
            pst.setString(1, this.getCo());
            pst.setDate(2, (java.sql.Date) this.getFecha());
            pst.setDouble(3, this.getTotal());
            pst.execute();
        }
        catch(Exception ee)
        {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, null, ee);

        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
