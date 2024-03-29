package Vista;
import db.*;
import Entidad.*;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josue
 */
public class Factura extends javax.swing.JInternalFrame {

    /**
     * Creates new form Factura
     */
    Conexion oCnx;
    public ArrayList<Producto> productos;
    DefaultTableModel modelF;
    private factura factura;
    private JLabel lblFactura;
    private String saldoInicial;
    private Venta[] ventas;
    private boolean productosVacios;
    public String saldo;
    public double sal;
    private double saldoAntesCerrar;
    private double saldoInicialOriginal;
    private ControlCaja objCaja;
    private double cambioUSD = 1.0;
    private double cambioHNL = 24.0; //LEMPIRAS
    private double cambioNIO = 35.0; //CORDOBAS
    private double cambioEUR = 0.85; //EUROS
    private double cambioGTQ = 7.8; //QUETZALES
   
    public Factura() {
        initComponents();
        oCnx= new Conexion("admin","RBK");
        modelF = (DefaultTableModel) this.tableF.getModel();    
    }
    public Factura(double saldoInicial){
        initComponents();
        this.sal = saldoInicial;
        this.saldoInicialOriginal = saldoInicial;
        
        mostrarCodigoAleatorio();
        oCnx= new Conexion("admin","RBK");
        modelF = (DefaultTableModel) this.tableF.getModel();
    }
    
    public Factura(ArrayList<Producto> produ, double saldoInicial)
    {       
        initComponents();
        this.productos = produ;
        this.listar();
        oCnx= new Conexion("admin","RBK");
        mostrarCodigoAleatorio();
        //this.saldoInicial = String.valueOf(saldoInicial);
        //inicial.setText(this.saldoInicial);
        this.productosVacios = produ.isEmpty();
        
        GestorProdDAO ges = new GestorProdDAO(oCnx.oCon);
        ges.actualizarSaldo(saldoInicial);
        this.ventas = new Venta[produ.size()];
        for (int i = 0; i < produ.size(); i++) {
            Producto producto = produ.get(i);
            ventas[i] = new Venta(producto.getCantidad(), producto.getNombre(), producto.getPrecio(), producto.getSubtotal());

        }
    }   
    private String generarCodigoAleatorio() {
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(1000) + 10000;
        return String.format("31DC-%04d", numeroAleatorio);
    }

    public void mostrarCodigoAleatorio() {
        String codigoAleatorio = generarCodigoAleatorio();
        txtCodigo.setText(codigoAleatorio);
    }
    
    private void actualizarDatosComprobante() {
    String codigo = this.txtCodigo.getText().trim();
    int cantidad = Integer.parseInt(this.txtCant.getText().trim());
    String moneda = this.cmbMoneda.getSelectedItem().toString();
    double efectivo = Double.parseDouble(this.spnEfectivo.getValue().toString());

    // Crea una instancia de ComprobanteForm y pásale los datos del comprobante
    Caja comprobanteForm = new Caja(codigo, cantidad, moneda, efectivo);

    // Muestra el formulario del comprobante
    comprobanteForm.setVisible(true);
    comprobanteForm.pack();
}
    public void listar() {
       
       modelF = (DefaultTableModel) tableF.getModel();
       Object[] obj = new Object[8];
       int cantidadTotal = 0;
       for (int i = 0; i < productos.size(); i++) 
        {
            double subtotal = productos.get(i).getSubtotal();
            obj[0] = productos.get(i).getId_producto();
            obj[1] = productos.get(i).getNombre();
            obj[2] = productos.get(i).getPrecio();
            obj[3] = productos.get(i).getCantidad();
            obj[4] = String.format("%.2f", subtotal);
            modelF.addRow(obj);
            
            cantidadTotal += productos.get(i).getCantidad();
        }
        txtCant.setText(String.valueOf(cantidadTotal));
        //tableF.setModel(modelF);
        double total = calcularTotal();
        txtTotal.setText(String.format("%.2f", total));
            
        //factura.mostrarCodigo();
    }
    private double calcularTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getSubtotal();
        }
        return total;
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableF = new javax.swing.JTable();
        txtFecha = new com.toedter.calendar.JDateChooser();
        Total = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbMoneda = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        spnEfectivo = new javax.swing.JSpinner();
        simbolo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inicial = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnComprob = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setMaximizable(true);
        setTitle("Caja");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
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

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Caja");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Codigo:");

        txtCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCodigo.setText("000003");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Fecha");

        tableF.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tableF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nombre", "P/U", "Cantidad", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(tableF);

        txtFecha.setDateFormatString("yyyy-MM-dd");

        Total.setText("Total:");

        txtTotal.setEditable(false);

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setText("Cobrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar"));

        btnEditar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Formas de pago"));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Ingrese su Moneda:");

        cmbMoneda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una moneda", "Dolar", "Lempira", "Cordoba", "Euro", "Quetzal" }));
        cmbMoneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMonedaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Efectivo:");

        spnEfectivo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        spnEfectivo.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simbolo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbMoneda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spnEfectivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spnEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simbolo))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Saldo en caja:");

        inicial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        inicial.setText("0.00");

        jButton2.setText("Cerra Caja");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnComprob.setText("Comprobante");
        btnComprob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobActionPerformed(evt);
            }
        });

        jLabel7.setText("Cantidad total productos");

        txtCant.setEditable(false);

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(269, 269, 269)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnComprob, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 23, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(232, 232, 232)
                                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addGap(17, 17, 17)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inicial))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo)))
                        .addGap(1, 1, 1)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inicial))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnComprob)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(Total))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int filaSeleccionada = tableF.getSelectedRow();
    if (filaSeleccionada >= 0) {
       
        Producto producto = productos.get(filaSeleccionada);
        int cantidadActual = producto.getCantidad();

        
        String nuevaCantidadStr = JOptionPane.showInputDialog(this, "Ingrese la nueva cantidad:", String.valueOf(cantidadActual));

        if (nuevaCantidadStr != null && !nuevaCantidadStr.isEmpty()) {
            try {
                int nuevaCantidad = Integer.parseInt(nuevaCantidadStr);

                
                producto.setCantidad(nuevaCantidad);
                producto.setSubtotal(nuevaCantidad * producto.getPrecio());

                
                modelF.setValueAt(nuevaCantidad, filaSeleccionada, 3);
                modelF.setValueAt(producto.getSubtotal(), filaSeleccionada, 4);

                
                double total = calcularTotal();
                txtTotal.setText(String.valueOf(total));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "La cantidad ingresada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un producto para editar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tableF.getSelectedRow();

    if (filaSeleccionada >= 0) {       
        Producto producto = productos.get(filaSeleccionada);        
        ((DefaultTableModel) tableF.getModel()).removeRow(filaSeleccionada);
        productos.remove(filaSeleccionada);
        double total = calcularTotal();
        txtTotal.setText(String.valueOf(total));
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.oCnx= new Conexion("admin","RBK");
    double montoCliente = (double) spnEfectivo.getValue();
    mostrarCodigoAleatorio();
    String codigo = this.txtCodigo.getText().trim();
    String fecha = ((JTextField)this.txtFecha.getDateEditor().getUiComponent()).getText();  // Obtén la fecha directamente desde el componente JDateChooser
    double total = Double.parseDouble(this.txtTotal.getText().trim());
    String moneda = this.cmbMoneda.getSelectedItem().toString();
    double totalFactura = Double.parseDouble(txtTotal.getText());
    
    if (moneda == null || moneda.equals("Seleccione una moneda")) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una moneda.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (montoCliente < totalFactura) {
        JOptionPane.showMessageDialog(this, "El monto proporcionado es insuficiente. Faltan fondos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (fecha == null || fecha.isEmpty()){
        JOptionPane.showMessageDialog(this, "Por favor ", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    saldoAntesCerrar = Double.parseDouble(inicial.getText());
    double mA = 0;
    if( moneda.equals("Lempira")){
        mA = montoCliente / 24.0;
    }

    
    GestorProdDAO ges = new GestorProdDAO(oCnx.oCon);
    

       
    calcularCambio(mA, total);
            Comprobante objf = new Comprobante(codigo,java.sql.Date.
                    valueOf(fecha), total, this.oCnx);
        objf.guardar(); 
    Control crtl = new Control(oCnx);
    crtl.setTotal(total);
    crtl.setEfectivo_recibido(montoCliente);
    crtl.setCambio(cambioEnDolares);
    crtl.setCodigo(txtCodigo.getText());
    
    crtl.guardar();
        //dispose();
      this.limpiartabla();
        
    }//GEN-LAST:event_jButton1ActionPerformed
    double cambioEnDolares;
    private void calcularCambio(double montoCliente, double total) {
    GestorProdDAO gestor = new GestorProdDAO(oCnx.oCon);

    cambioEnDolares = montoCliente - total;
    double saldoAntesCompra = Double.parseDouble(inicial.getText());

    double saldoDespuesCompra = saldoAntesCompra + cambioEnDolares;
    //saldoDespuesCompra -= cambioEnDolares;
    inicial.setText(String.valueOf(saldoDespuesCompra));

    //double tasaDeCambio = obtenerTasaDeCambio(moneda);
    //double cambioEnMoneda = cambioEnDolares * tasaDeCambio;

    String mensaje = "Cambio a dar al cliente:\n" +
          "- En Dólares: " + String.format("%.2f", cambioEnDolares);
    //        "- En " + moneda + ": " + String.format("%.2f", cambioEnMoneda);

    JOptionPane.showMessageDialog(this, mensaje);
}
    public void limpiartabla(){
        for (int i = 0; i < tableF.getRowCount(); i++) {
            modelF.removeRow(i);
            i-=1;
        }
    }

    private void cmbMonedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonedaActionPerformed
        actLBL();
    }//GEN-LAST:event_cmbMonedaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //GestorProdDAO gestor = new GestorProdDAO(oCnx.oCon);
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea cerrar la caja?", "Confirmar cierre de caja", JOptionPane.YES_NO_OPTION);
            saldoInicialOriginal = sal;
            
            //objCaja = new ControlCaja(saldoInicialOriginal, saldoAntesCerrar);
            //objCaja.setSaldoAntesCerrarLabel(saldoAntesCerrar);
            //objCaja.setSaldoInicialOriginalLabel(saldoInicialOriginal);
        if (confirmacion == JOptionPane.YES_OPTION) {
            //Manda el saldo inicial y como se quedo el saldo a directamente y de un solo a control de caja (MAL HECHO)
            objCaja = new ControlCaja(saldoInicialOriginal, saldoAntesCerrar);
            objCaja.setSaldoAntesCerrarLabel(saldoAntesCerrar);
            objCaja.setSaldoInicialOriginalLabel(saldoInicialOriginal);
            getParent().add(objCaja);
            objCaja.setVisible(true);
            objCaja.toFront();
            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnComprobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobActionPerformed
        // TODO add your handling code here:
        
        this.oCnx= new Conexion("root","cruzpolanco32");
        int id = 0;
        String codigo = this.txtCodigo.getText().trim();
        int can = Integer.parseInt(this.txtCant.getText().trim());
        String mone = this.cmbMoneda.getSelectedItem().toString();
        double efec = Double.parseDouble(this.spnEfectivo.getValue().toString());
        
        //Control objC = new Control(id, codigo, can, mone, efec, this.oCnx);
        //objC.guardar();
        
        //Caja caja = new Caja();
       // MDI.desktopPane.add(caja);
        //this.productos.clear();
        //this.limpiartabla();
        //caja.toFront();
        //caja.setVisible(true);
        //caja.listar();
        //actualizarDatosComprobante();


        // String fecha = ((JTextField)this.txtFecha.getDateEditor().getUiComponent()).getText();
    }//GEN-LAST:event_btnComprobActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        saldo = String.valueOf(sal);
        inicial.setText(this.saldo);
        
    }//GEN-LAST:event_formInternalFrameOpened
    
    public double getSaldoAntesCerrar() {
        return saldoAntesCerrar;
    }
    public double getSaldoInicial(){
        return saldoInicialOriginal;
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            Caja fm = new Caja();
            MDI.desktopPane.add(fm);
            fm.toBack();
            fm.setVisible(true);
           this.toFront();
         Productos frm1 = new Productos();
            MDI.desktopPane.add(frm1);
            frm1.toFront();
            frm1.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
    public void actLBL(){
        String seleccion = (String) cmbMoneda.getSelectedItem();
        String simbolo = "";
        
        switch (seleccion) {
            case "Dólar":
                simbolo = "$";
                break;
            case "Lempira":
                simbolo = "L";
                break;
            case "Cordoba":
                simbolo = "C$";
                break;
            case "Euro":
                simbolo = "€ ";
                break;
            default:
                simbolo = "$";
                break;
        }
        
        this.simbolo.setText(simbolo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Total;
    private javax.swing.JButton btnComprob;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cmbMoneda;
    private javax.swing.JLabel inicial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel simbolo;
    private javax.swing.JSpinner spnEfectivo;
    public static javax.swing.JTable tableF;
    public static javax.swing.JTextField txtCant;
    private javax.swing.JLabel txtCodigo;
    private com.toedter.calendar.JDateChooser txtFecha;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
