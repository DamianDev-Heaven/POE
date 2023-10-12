/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import db.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josue
 */
public class Control {
    private String codigo;
    private double total;
    private double efectivo_recibido;
    private double cambio;
    private Conexion oCnn;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getEfectivo_recibido() {
        return efectivo_recibido;
    }

    public void setEfectivo_recibido(double efectivo_recibido) {
        this.efectivo_recibido = efectivo_recibido;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    public Control(Conexion oCnn) {
        this.oCnn = oCnn;
    }

    public Control(String codigo, double total, double efectivo_recibido, double cambio, Conexion oCnn) {
        this.codigo = codigo;
        this.total = total;
        this.efectivo_recibido = efectivo_recibido;
        this.cambio = cambio;
        this.oCnn = oCnn;
    }

    public void guardar() {
        try {
            String query = "INSERT INTO control (codigo, total, efectivo_recibido, cambio) VALUES (?, ?, ?, ?)";

            PreparedStatement pst = this.oCnn.oCon.prepareStatement(query);
            pst.setString(1, codigo);
            pst.setDouble(2, total);
            pst.setDouble(3, efectivo_recibido);
            pst.setDouble(4, cambio);

            pst.execute();
        } catch (SQLException e) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ResultSet getFecha(Date fecha) {
    try {
        String datosF = "SELECT c.codigo, c.total, c.efectivo_recibido, c.cambio, f.fecha FROM control c JOIN factura f ON c.codigo = f.codigo WHERE f.fecha = ?";
        PreparedStatement preparedStatement = this.oCnn.oCon.prepareStatement(datosF);
        // Sustituimos el parámetro por el valor proporcionado
        preparedStatement.setDate(1, (java.sql.Date) fecha);
        return preparedStatement.executeQuery();
    } catch (Exception ee) {
        ee.printStackTrace(); // Manejo de errores, imprime la traza en la consola
        return null;
        }
    }
}
