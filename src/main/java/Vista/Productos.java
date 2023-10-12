package Vista;

import Entidad.GestorProdDAO;
import Entidad.Producto;
import static Vista.Factura.tableF;
import db.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Productos extends javax.swing.JInternalFrame {
    
    ResultSet rs;
    DefaultTableModel model;
    Conexion oCnx;
    ArrayList<Producto> arrayProducto;
    public double sal;

    
    public Productos() {
        initComponents();      
        oCnx= new Conexion("admin","RBK");
        model = (DefaultTableModel) this.tableP.getModel();
        Producto producto = new Producto(oCnx);
        producto.llenarCMB(cmbCompra);
        producto.llenarCMB(cmbSeccion);
        arrayProducto = new ArrayList<>();
    }
    public Productos(double saldoInicial){
        initComponents();
        this.sal = saldoInicial;
        //saldo = String.valueOf(sal);
        //inicial.setText(this.saldo);
        oCnx= new Conexion("admin","RBK");
        model = (DefaultTableModel) this.tableP.getModel();
        Producto producto = new Producto(oCnx);
        producto.llenarCMB(cmbCompra);
        producto.llenarCMB(cmbSeccion);
        arrayProducto = new ArrayList<>();
    }

//ahorita esta de mas
    public void consultar(){
    {
        Producto oHerra = new Producto(this.oCnx);
        this.rs= oHerra.getTodo();
        
        try
        {
            model.setRowCount(0);
            while (rs.next())
            {
              String Datos[]= {rs.getObject(1).toString(),
                                rs.getObject(2).toString()};
              model.addRow(Datos);
            }
           this.tableP.setModel(model);
        }
        catch(Exception ee) {}   
        
        }    
    }
    public void LimpiarTabla() 
    {
        for (int i = 0; i<model.getRowCount(); i++) {
            model.removeRow(i);
            i = i -1;
        }
    }
    public void limpiar(){
        //this.txtId.setText("");
        this.txtProducto.setText("");
        this.spnPrecio.setValue(0);
        this.cmbSeccion.setSelectedIndex(0);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableP = new javax.swing.JTable();
        cmbSeccion = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        spnPrecio = new javax.swing.JSpinner();
        cmbCompra = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Productos y compra");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nombre", "Precio P/U"
            }
        ));
        tableP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableP);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 590, 160));

        cmbSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        getContentPane().add(cmbSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 140, 20));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Seleccione la sección:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 170, 20));

        btnComprar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        getContentPane().add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 472, 130, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Ingrese el producto: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 170, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Ingrese el precio unitario: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 170, -1));
        getContentPane().add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 140, -1));

        btnAgregar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 100, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Compra de productos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 170, -1));

        spnPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.05d));
        getContentPane().add(spnPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 140, 20));

        cmbCompra.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        cmbCompra.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCompraItemStateChanged(evt);
            }
        });
        cmbCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCompraActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 140, 20));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Seleccione la sección:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 150, 20));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Ingreso de productos");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 170, -1));

        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        getContentPane().add(spnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 110, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Ingrese la cantidad:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 140, -1));

        jLabel8.setText("ID");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 496, 20, 10));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 50, 20));

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 472, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCompraActionPerformed
        // TODO add your handling code here:
        //Cada vez que se selecciona algo en el combobox extraigo su numero
        int sec = this.cmbCompra.getSelectedIndex();
        //Instancio Producto y le mando la conexion
        Producto oHerra = new Producto(this.oCnx);
        //A la funcion getTodo2 le mando el numero extraido
        this.rs= oHerra.getTodo2(sec);
        //Aqui hago la consulta de lo necesitado
        try
        {
            model.setRowCount(0);
            while (rs.next())
            {
              String Datos[]= {rs.getObject(1).toString(),
                                rs.getObject(2).toString(),
                                rs.getObject(3).toString()};
              model.addRow(Datos);
            }
           this.tableP.setModel(model);
        }
        catch(Exception ee) {}   
        //
    }//GEN-LAST:event_cmbCompraActionPerformed

    private void cmbCompraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCompraItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbCompraItemStateChanged

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       String nombre = this.txtProducto.getText().trim();
    Object precioObj = this.spnPrecio.getValue();

    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Error: Ingrese el nombre del producto.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (precioObj == null || !(precioObj instanceof Double)) {
        JOptionPane.showMessageDialog(this, "Error: Ingrese un precio válido para el producto.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    double precio = (Double) precioObj;

    // Resto del código ejecutado si las validaciones pasan
    JOptionPane.showMessageDialog(this, "Producto añadido Correctamente");
    int id = 0;
    int seccion = this.cmbSeccion.getSelectedIndex();
    Producto objP = new Producto(id, nombre, precio, seccion, this.oCnx);
    objP.guardar();
    JOptionPane.showMessageDialog(this, "Producto añadido: ");
    this.limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
       String nombre = this.txtProducto.getText().trim();
        Object precioObj = this.spnPrecio.getValue();

    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el nombre del producto.");
        return;
    }

    if (precioObj == null || !(precioObj instanceof Double)) {
        JOptionPane.showMessageDialog(this, "Ingrese un precio válido para el producto.");
        return;
    }
    int id = Integer.parseInt(this.txtId.getText().trim());
    double precio = (Double) precioObj;
    int cantidad = Integer.parseInt(this.spnCantidad.getValue().toString());
    double subtotal = precio * cantidad;

    // Buscar el producto en la lista
    boolean productoEncontrado = false;
    for (Producto producto : arrayProducto) {
        if (producto.getNombre().equalsIgnoreCase(nombre) && producto.getPrecio() == precio) {
            // Si encontramos el producto, actualizamos la cantidad y subtotal
            producto.setCantidad(producto.getCantidad() + cantidad);
            producto.setSubtotal(producto.getSubtotal() + subtotal);
            productoEncontrado = true;
            break;
        }
    }

    if (!productoEncontrado) {
        // Si no encontramos el producto en la lista, lo agregamos
        Producto objP = new Producto(id, nombre, precio, cantidad, subtotal);
        arrayProducto.add(objP);
    }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void tablePMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePMouseClicked

        int i = this.tableP.getSelectedRow();
        this.txtId.setText(this.tableP.getModel().getValueAt(i,0).toString());
        this.txtProducto.setText(this.tableP.getModel().getValueAt(i,1).toString());
        this.spnPrecio.setValue(Double.parseDouble(this.tableP.getModel().getValueAt(i,2).toString()));
        
    }//GEN-LAST:event_tablePMouseClicked

        private double calcularTotal() {
        double total = 0.0;
        for (Producto producto : arrayProducto) {
            total += producto.getSubtotal();
        }
        return total;
        
    }
        /*private double calcularTotal1() {
        double total = 0.0;
        for (Producto producto : arrayProducto) {
            total += producto.getSubtotal();
        }
        return total;
        }
*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
     DefaultTableModel modelF = (DefaultTableModel) Factura.tableF.getModel();
       Object[] obj = new Object[8];
       int cantidadTotal = 0;
       for (int i = 0; i < arrayProducto.size(); i++) 
        {
            double subtotal = arrayProducto.get(i).getSubtotal();
            obj[0] = arrayProducto.get(i).getId_producto();
            obj[1] = arrayProducto.get(i).getNombre();
            obj[2] = arrayProducto.get(i).getPrecio();
            obj[3] = arrayProducto.get(i).getCantidad();
            obj[4] = String.format("%.2f", subtotal);
            modelF.addRow(obj);
            
            cantidadTotal += arrayProducto.get(i).getCantidad();
        }
        Factura.txtCant.setText(String.valueOf(cantidadTotal));
        //tableF.setModel(modelF);
        double total = calcularTotal();
        Factura.txtTotal.setText(String.format("%.2f", total)); 
        
       DefaultTableModel modelC = (DefaultTableModel) Caja.tableC.getModel();
       Object[] obj1 = new Object[8];
       //int cantidadTotal = 0;
       for (int i = 0; i < arrayProducto.size(); i++) 
        {
            double subtotal = arrayProducto.get(i).getSubtotal();
            obj1[0] = arrayProducto.get(i).getId_producto();
            obj1[1] = arrayProducto.get(i).getNombre();
            obj1[2] = arrayProducto.get(i).getPrecio();
            obj1[3] = arrayProducto.get(i).getCantidad();
            obj1[4] = String.format("%.2f", subtotal);
            modelC.addRow(obj1);
            
            //cantidadTotal += arrayProducto.get(i).getCantidad();
        }
        //Factura.txtCant.setText(String.valueOf(cantidadTotal));
        //tableF.setModel(modelF);
        double total1 = calcularTotal();
        Caja.txtTot.setText(String.format("%.2f", total1)); 
        
        
        this.arrayProducto.clear();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JComboBox<String> cmbCompra;
    private javax.swing.JComboBox<String> cmbSeccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JSpinner spnPrecio;
    private javax.swing.JTable tableP;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
