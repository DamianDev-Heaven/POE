package Vista;
/**
 *
 * @author Josue
 */
public class MDI extends javax.swing.JFrame {

    public MDI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        abrirCaja = new javax.swing.JMenuItem();
        Productos = new javax.swing.JMenuItem();
        Factura = new javax.swing.JMenuItem();
        Caja = new javax.swing.JMenuItem();
        Control = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Pastelito");

        abrirCaja.setMnemonic('x');
        abrirCaja.setText("Abrir Caja");
        abrirCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCajaActionPerformed(evt);
            }
        });
        fileMenu.add(abrirCaja);

        Productos.setMnemonic('o');
        Productos.setText("Productos");
        Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductosActionPerformed(evt);
            }
        });
        fileMenu.add(Productos);

        Factura.setMnemonic('s');
        Factura.setText("Factura");
        Factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacturaActionPerformed(evt);
            }
        });
        fileMenu.add(Factura);

        Caja.setMnemonic('a');
        Caja.setText("Caja");
        Caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CajaActionPerformed(evt);
            }
        });
        fileMenu.add(Caja);

        Control.setText("Control caja");
        Control.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControlActionPerformed(evt);
            }
        });
        fileMenu.add(Control);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Cerrar Caja");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void ProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductosActionPerformed
        // TODO add your handling code here:
        Productos objProd = new Productos();
        this.desktopPane.add(objProd);
        objProd.show();
        
    }//GEN-LAST:event_ProductosActionPerformed

    private void FacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacturaActionPerformed
        // TODO add your handling code here:
        Factura objFac = new Factura();
        this.desktopPane.add(objFac);
        objFac.show();
        
    }//GEN-LAST:event_FacturaActionPerformed

    private void CajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CajaActionPerformed
        // TODO add your handling code here:
        Caja objC = new Caja();
        this.desktopPane.add(objC);
        objC.show();
    }//GEN-LAST:event_CajaActionPerformed

    private void ControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControlActionPerformed
        // TODO add your handling code here:
        ControlCaja objControl = new ControlCaja();
        this.desktopPane.add(objControl);
        objControl.show();
    }//GEN-LAST:event_ControlActionPerformed

    private void abrirCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCajaActionPerformed
       AbrirCaja ac = new AbrirCaja();
       this.desktopPane.add(ac);
       ac.show();
    }//GEN-LAST:event_abrirCajaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Caja;
    private javax.swing.JMenuItem Control;
    private javax.swing.JMenuItem Factura;
    private javax.swing.JMenuItem Productos;
    private javax.swing.JMenuItem abrirCaja;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
