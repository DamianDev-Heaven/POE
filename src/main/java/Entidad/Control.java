/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import db.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josue
 */
public class Control {
    
    int id_control;
    String id_factura;
    int cantP;
    String moneda;
    double efectivo;
    Conexion oCnn;

    public Control(int id_control, String id_factura, int cantP, String moneda, double efectivo, Conexion oCnn) {
        this.id_control = id_control;
        this.id_factura = id_factura;
        this.cantP = cantP;
        this.moneda = moneda;
        this.efectivo = efectivo;
        this.oCnn = oCnn;
    }
    public Control(Conexion pCon)
    {
        this.oCnn= pCon;
    }
    public void guardar()
    {
        try
        {
            String DatosF = "insert into control(id_control, codigo, cantP, moneda, efectivo)"
                           + " values (?, ?, ?, ?, ?)";
      
            PreparedStatement pst = this.oCnn.oCon.prepareStatement(DatosF);
            pst.setInt(1, this.getId_control());
            pst.setString(2, this.getId_factura());
            pst.setInt(3, this.getCantP());
            pst.setString(4, this.getMoneda());
            pst.setDouble(5, this.getEfectivo());
            pst.execute();
        }
        catch(Exception ee)
        {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ee);

        }
    }
    public ResultSet getFecha(Date fecha) {
    try {
        String datosF = "SELECT co.id_control , co.codigo, co.cantP, co.moneda, co.efectivo FROM control co JOIN factura fa ON fa.codigo = co.codigo WHERE fa.fecha = ?;";
        PreparedStatement preparedStatement = this.oCnn.oCon.prepareStatement(datosF);
        // Sustituimos el parámetro por el valor proporcionado
        preparedStatement.setDate(1, (java.sql.Date) fecha);
        return preparedStatement.executeQuery();
    } catch (Exception ee) {
        ee.printStackTrace(); // Manejo de errores, imprime la traza en la consola
        return null;
        }
    }
    
    

    public int getId_control() {
        return id_control;
    }

    public void setId_control(int id_control) {
        this.id_control = id_control;
    }

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }

    public int getCantP() {
        return cantP;
    }

    public void setCantP(int cantP) {
        this.cantP = cantP;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }
}
