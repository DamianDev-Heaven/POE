package Vista;

import Entidad.Producto;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Caja extends javax.swing.JInternalFrame {
    private JLabel lblFactura;
    private JLabel lblCantidad;
    private JLabel lblMoneda;
    private JLabel lblEfectivo;
    DefaultTableModel modelC;
    public ArrayList<Producto> caja;
    public Caja() {
        initComponents();
        //this.toFront();
       // modelC = (DefaultTableModel) this.tableC.getModel();
       

    }
    public Caja(String codigo, int cantidad, String moneda, double efectivo) {
        initComponents();
        inicializarLabels();
        mostrarDatos(codigo, cantidad, moneda, efectivo);
    }

    public Caja(ArrayList<Producto> productos) {
        initComponents();
        inicializarLabels();
        //modelC = (DefaultTableModel) tableC.getModel();
        //this.caja = productos;
        //this.listar();

        
    }
    public void listar() {
      
       Object[] obj = new Object[8];
       int cantidadTotal = 0;
       for (int i = 0; i < caja.size(); i++) 
        {
            double subtotal = caja.get(i).getSubtotal();
            obj[0] = caja.get(i).getId_producto();
            obj[1] = caja.get(i).getNombre();
            obj[2] = caja.get(i).getPrecio();
            obj[3] = caja.get(i).getCantidad();
            obj[4] = String.format("%.2f", subtotal);
            modelC.addRow(obj);
            
            cantidadTotal += caja.get(i).getCantidad();
        }
        //txtCant.setText(String.valueOf(cantidadTotal));
        //tableC.setModel(modelC);
        //double total = calcularTotal();
        //txtTotal.setText(String.format("%.2f", total));
            
        //factura.mostrarCodigo();
    }
    private void inicializarLabels() {
        lblFactura = new JLabel("Código: ");
        lblCantidad = new JLabel("Cantidad total productos: ");
        lblMoneda = new JLabel("Moneda: ");
        lblEfectivo = new JLabel("Efectivo: ");

    }
    private void mostrarDatos(String codigo, int cantidad, String moneda, double efectivo) {
        lblFactura.setText("Código: " + codigo);
        lblCantidad.setText("Cantidad total productos: " + cantidad);
        lblMoneda.setText("Moneda: " + moneda);
        lblEfectivo.setText("Efectivo: " + efectivo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableC = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTot = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Factura");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setText("Comprobante de pago");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Caja:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("000000");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Ref:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("000000");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Fecha:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("##/##/##");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("0000000");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Nro. Ticket:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        tableC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "Descripcion", "Precio", "Cantidad", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableC);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 280, 310));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("TOTAL A PAGAR:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel14.setText("¡GRACIAS POR PREFERIRNOS!");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, 20));

        txtTot.setText("0.00");
        getContentPane().add(txtTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 30, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        //for (int i = 0; i < this.tableC.getRowCount(); i++) {
          //  modelC.removeRow(i);
           // i-=1;
        
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tableC;
    public static javax.swing.JLabel txtTot;
    // End of variables declaration//GEN-END:variables
}
