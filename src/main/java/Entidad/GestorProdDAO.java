package Entidad;

/**
 *
 * @author Administrador
 */

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class GestorProdDAO {
    private Connection conexion;
    private double saldoActual;
    private boolean cajaAbierta;
    private int idTurno;
    public GestorProdDAO(Connection conexion) {
        this.saldoActual = 0.0;
        this.cajaAbierta = false;
        this.conexion = conexion;
        this.idTurno = -1;
    }
    
   
   public boolean verificarCaja() {
         try {
        String consulta = "SELECT id_turno, caja_abierta, saldo_final FROM turno_caja WHERE fecha_cierre IS NULL ORDER BY id_turno DESC LIMIT 1";
        PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
             this.idTurno = resultSet.getInt("id_turno");
            int idTurno = resultSet.getInt("id_turno");
            boolean cajaAbiertaEnBD = resultSet.getBoolean("caja_abierta");
            double saldoFinalEnBD = resultSet.getDouble("saldo_final");

            if (cajaAbiertaEnBD) {
                this.saldoActual = saldoFinalEnBD;
                this.cajaAbierta = true;
                JOptionPane.showMessageDialog(null, "Caja abierta. Saldo actual de la caja: " + saldoActual);
                return true;
            }
        } else {
            String saldoInicialStr = JOptionPane.showInputDialog(null, "Ingrese el saldo inicial de la caja:", "Saldo Inicial", JOptionPane.QUESTION_MESSAGE);

            if (saldoInicialStr == null || saldoInicialStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un saldo inicial válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            double saldoInicial = Double.parseDouble(saldoInicialStr);

            String insertQuery = "INSERT INTO turno_caja (fecha_apertura, saldo_inicial, saldo_final, caja_abierta) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = conexion.prepareStatement(insertQuery);
            insertStatement.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
            insertStatement.setDouble(2, saldoInicial);
            insertStatement.setDouble(3, saldoInicial);
            insertStatement.setBoolean(4, true);
            insertStatement.executeUpdate();

            this.saldoActual = saldoInicial;
            this.cajaAbierta = true;
            JOptionPane.showMessageDialog(null, "Caja abierta. Saldo inicial de la caja: " + saldoInicial);
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al consultar/actualizar la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
    }

    public Connection getConexion() {
    return this.conexion;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void actualizarSaldo(double nuevoSaldo) {
        this.saldoActual = nuevoSaldo;
    }
    public int getIdTurno() {
        return idTurno;
    }
    public void guardarProducto(Producto producto) {
        verificarCaja();

        double saldoActual = getSaldoActual();

        JOptionPane.showMessageDialog(null, "Producto guardado. Saldo actual de la caja: " + saldoActual);
    }

    public void cerrarCaja() {
    try {
        // Actualiza la fecha de cierre y marca la caja como cerrada en la base de datos
        String updateQuery = "UPDATE turno_caja SET fecha_cierre = ?, caja_abierta = ?, saldo_final = ? WHERE id_turno = ?";
        PreparedStatement updateStatement = conexion.prepareStatement(updateQuery);
        updateStatement.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));  // Fecha actual como fecha de cierre
        updateStatement.setBoolean(2, false);  // Marcar la caja como cerrada
        updateStatement.setDouble(3, this.saldoActual);  // Actualizar el saldo final
        updateStatement.setInt(4, idTurno);  // Suponiendo que idTurno es el ID del turno actual
        updateStatement.executeUpdate();

        // Reinicializa el saldo actual y el ID del turno
        this.saldoActual = 0.0;
        this.cajaAbierta = false;
        this.idTurno = -1;

        JOptionPane.showMessageDialog(null, "Caja cerrada. Gracias por su trabajo.");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cerrar la caja en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
}
