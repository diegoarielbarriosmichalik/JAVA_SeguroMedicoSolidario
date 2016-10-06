package FORMS;

import DEV.Metodos;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Ventas_Terminar extends javax.swing.JFrame {

    public static long total;
    public static int id_cliente;

    public Ventas_Terminar() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Terminar Venta");
        setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
    }
    
    public static long dinero = 0;
    public static long vuelto = 0;
        
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField_ingresar_dinero = new javax.swing.JTextField();
        jTextField_vuelto = new javax.swing.JTextField();
        jt_Total = new javax.swing.JTextField();
        jLabel_Total = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField_ingresar_dinero.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jTextField_ingresar_dinero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_ingresar_dinero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_ingresar_dineroFocusLost(evt);
            }
        });
        jTextField_ingresar_dinero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_ingresar_dineroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_ingresar_dineroKeyReleased(evt);
            }
        });

        jTextField_vuelto.setEditable(false);
        jTextField_vuelto.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jTextField_vuelto.setForeground(new java.awt.Color(204, 0, 0));
        jTextField_vuelto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_vuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_vueltoActionPerformed(evt);
            }
        });
        jTextField_vuelto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_vueltoKeyPressed(evt);
            }
        });

        jt_Total.setEditable(false);
        jt_Total.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jt_Total.setForeground(new java.awt.Color(0, 102, 0));
        jt_Total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel_Total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/impresora_mini.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_ingresar_dinero, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_vuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(54, 54, 54)
                .addComponent(jLabel_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_ingresar_dinero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_vuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.setVisible(false);

    }//GEN-LAST:event_formWindowClosed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        String enteroString = Long.toString(total);

        String strLong = Long.toString(total);
        String nuevo = DEV.Metodos.getSepararMiles(strLong);

//            jT_total.setText(nuevo);
        jt_Total.setText(nuevo);
        jTextField_ingresar_dinero.requestFocus();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened


    }//GEN-LAST:event_formWindowOpened

    private void jTextField_vueltoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_vueltoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_vueltoKeyPressed

    private void jTextField_vueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_vueltoActionPerformed

    }//GEN-LAST:event_jTextField_vueltoActionPerformed

    private void jTextField_ingresar_dineroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ingresar_dineroKeyReleased

        if ((evt.getKeyCode() == KeyEvent.VK_ESCAPE)) {
            this.setVisible(false);
        }
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            getTerinarVenta();
            this.setVisible(false);
            DEV.Metodos.ventaNuevo();
        }

        if (jTextField_ingresar_dinero.getText().length() > 1) {

            String strDinero = jTextField_ingresar_dinero.getText();
            strDinero = strDinero.replace(".", "");

            dinero = Integer.parseInt(strDinero);

            System.err.println("Dinero: " + strDinero);

            vuelto = dinero - total;

            String strLong = Long.toString(vuelto);
            String nuevo = DEV.Metodos.getSepararMiles(strLong);
            String nuevo_dinero = DEV.Metodos.getSepararMiles(strDinero);

            jTextField_vuelto.setText(nuevo);

            jTextField_ingresar_dinero.setText(nuevo_dinero);
        }


    }//GEN-LAST:event_jTextField_ingresar_dineroKeyReleased

    private void jTextField_ingresar_dineroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ingresar_dineroKeyPressed

    }//GEN-LAST:event_jTextField_ingresar_dineroKeyPressed

    private void jTextField_ingresar_dineroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_ingresar_dineroFocusLost

        int dinero = Integer.parseInt(jTextField_ingresar_dinero.getText());
        int total = Integer.parseInt(jt_Total.getText());
        int vuelto = dinero - total;

        String strLong = Long.toString(vuelto);
        String nuevo = DEV.Metodos.getSepararMiles(strLong);

        jTextField_vuelto.setText(String.valueOf(nuevo));
    }//GEN-LAST:event_jTextField_ingresar_dineroFocusLost

    public static void getTerinarVenta() {

//        if (jComboBox1.getSelectedItem().equals("Presupuesto")) {
//
//            try {
//
//                int id_cuenta = Metodos.id_cuenta;
//                // 9  es presupuesto
//                PreparedStatement stUpdateAuxiliar = conexion.prepareStatement("UPDATE cuenta SET tipo = '9', id_cliente = '" + id_cliente + "' WHERE id_cuenta = '" + id_cuenta + "'");
//                stUpdateAuxiliar.executeUpdate();
//
//                String path = "C:/Sistema/presupuesto_venta.jasper";
//                JasperReport jr = null;
//                try {
//                    jr = (JasperReport) JRLoader.loadObjectFromFile(path);
//                    JasperPrint jp = JasperFillManager.fillReport(jr, null, conexion);
//                    JasperViewer jv = new JasperViewer(jp, false);
//                    jv.setVisible(true);
//                    jv.setLocationByPlatform(true);
//                } catch (JRException e) {
//                    System.err.println(e);
//                }
//            } catch (SQLException ex) {
//                System.err.println(ex);
//            }
//        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.setVisible(false);
        Metodos.Cuenta_imprimir();
//        Metodos.Imprimir_ticket();

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas_Terminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas_Terminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas_Terminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas_Terminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas_Terminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JLabel jLabel_Total;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField jTextField_ingresar_dinero;
    private javax.swing.JTextField jTextField_vuelto;
    public static javax.swing.JTextField jt_Total;
    // End of variables declaration//GEN-END:variables
}
