/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;
import Entidad.Control;
import db.Conexion;
import Entidad.GestorProdDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josue
 */
public class ControlCaja extends javax.swing.JInternalFrame {
    Conexion oCnx;
    private GestorProdDAO gestor;
    private Connection con;
    DefaultTableModel model;
    private Factura fac;
    ResultSet rs;
    private double saldoAntesCerrar;
    private double saldoInicialOriginal;
    /**
     * Creates new form ControlCaja
     */
    public ControlCaja() {
        initComponents();
        oCnx = new Conexion("admin", "RBK");
         model = (DefaultTableModel) this.tableControl.getModel();
        fac = new Factura();
    }
    public ControlCaja(double saldoAntesCerrar, double saldoInicialOriginal) {
        initComponents();
        oCnx = new Conexion("admin", "RBK");
        model = (DefaultTableModel) this.tableControl.getModel();
        fac = new Factura();
        this.saldoAntesCerrar = saldoAntesCerrar;  // Set saldoAntesCerrar
        this.saldoInicialOriginal = saldoInicialOriginal;  // Set saldoInicialOriginal

        // Update your UI components to display these values
        setSaldoAntesCerrarLabel(saldoAntesCerrar);
        setSaldoInicialOriginalLabel(saldoInicialOriginal);
    }
    public void setSaldoAntesCerrarLabel(double saldoAntesCerrar) {
        jLabel7.setText(String.valueOf(saldoAntesCerrar));
    }

    public void setSaldoInicialOriginalLabel(double saldoInicialOriginal) {
        jLabel5.setText(String.valueOf(saldoInicialOriginal));
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableControl = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtReporte = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Control de caja");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Control de caja");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 118, -1));

        jLabel2.setText("Ingrese la fecha:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 90, -1));

        txtFecha.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 160, -1));

        tableControl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Total", "Recibido", "Cambio"
            }
        ));
        jScrollPane1.setViewportView(tableControl);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 640, 260));

        jLabel3.setText("Reporte total efectivo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 420, 130, -1));

        txtReporte.setEditable(false);
        txtReporte.setText("0.00");
        getContentPane().add(txtReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 412, 130, 30));

        btnReporte.setText("Buscar");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        getContentPane().add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 120, -1));

        jLabel4.setText("Saldo inicial");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 70, -1));

        jLabel6.setText("Saldo Final");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        jLabel7.setText("jLabel5");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        double saldoAntesCerrar = fac.getSaldoAntesCerrar();
        double saldoInicial = fac.getSaldoInicial();
        jLabel5.setText(String.valueOf(saldoInicial));
        jLabel7.setText(String.valueOf(saldoAntesCerrar));
        
        String fecha = ((JTextField)this.txtFecha.getDateEditor().getUiComponent()).getText();
        
        //Instancio Producto y le mando la conexion
        Control oHerra = new Control(this.oCnx);
        //A la funcion getTodo2 le mando el numero extraido
        this.rs= oHerra.getFecha(java.sql.Date. valueOf(fecha));
        //Aqui hago la consulta de lo necesitado
        try
        {
            double reporte = 0;
            model.setRowCount(0);
            while (rs.next())
            {
              String Datos[]= {rs.getObject(1).toString(),
                                rs.getObject(2).toString(),
                                rs.getObject(3).toString(),
                                rs.getObject(4).toString(),
                                //rs.getObject(5).toString()
                                };
              model.addRow(Datos);
              reporte = reporte + Double.parseDouble(rs.getObject(4).toString());
            }
            this.txtReporte.setText(String.format("%.2f",reporte));
           this.tableControl.setModel(model);
        }
        catch(Exception ee) {}
    }//GEN-LAST:event_btnReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableControl;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtReporte;
    // End of variables declaration//GEN-END:variables
}
