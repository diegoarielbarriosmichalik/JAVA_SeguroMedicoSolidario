package FORMS;

import DEV.Metodos;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;

public class venta_modificar_precio_cantidad extends javax.swing.JFrame {

    public venta_modificar_precio_cantidad() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Opciones");
        setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
    }

    public static String id_producto;
    public static String id_cuenta_detalle;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField_Unidades = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Precio_Unitario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField_Producto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField_Unidades.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField_Unidades.setForeground(new java.awt.Color(0, 102, 0));
        jTextField_Unidades.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Unidades.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_UnidadesFocusGained(evt);
            }
        });
        jTextField_Unidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_UnidadesKeyReleased(evt);
            }
        });

        jLabel1.setText("Unidades:");

        jLabel2.setText("Precio Unitario:");

        jTextField_Precio_Unitario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField_Precio_Unitario.setForeground(new java.awt.Color(0, 102, 0));
        jTextField_Precio_Unitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Precio_Unitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Precio_UnitarioKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/del_mini.png"))); // NOI18N
        jButton1.setMnemonic('b');
        jButton1.setToolTipText("Quitar producto de esta venta");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField_Producto.setEditable(false);
        jTextField_Producto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Producto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("Descripcion:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_Precio_Unitario, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addComponent(jTextField_Unidades)
                            .addComponent(jTextField_Producto))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Precio_Unitario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_Precio_UnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Precio_UnitarioKeyReleased

        String strDinero = jTextField_Precio_Unitario.getText();
        strDinero = strDinero.replace(".", "");
        String nuevo = DEV.Metodos.getSepararMiles(strDinero);
        String nuevo_dinero = DEV.Metodos.getSepararMiles(strDinero);

        jTextField_Precio_Unitario.setText(nuevo_dinero);

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Guardar_Cambios();
            this.setVisible(false);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.setVisible(false);
        }

    }//GEN-LAST:event_jTextField_Precio_UnitarioKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jTextField_Unidades.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            int id_producto = 0;
            double cantidad = 0;
            long total = 0;
            long exentas = 0;
            long cinco = 0;
            long diez = 0;
            double stock_actualizado = 0;
            Statement ST_Productos = DEV.Conexion.conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM cuenta_detalle "
                    + "where id_cuenta_detalle = '" + id_cuenta_detalle + "'");
            if (RS_Productos.next()) {
                id_producto = RS_Productos.getInt("id_producto");
                cantidad = RS_Productos.getDouble("cantidad");
                exentas = RS_Productos.getLong("exentas");
                cinco = RS_Productos.getLong("cinco");
                diez = RS_Productos.getLong("diez");
                total = exentas + cinco + diez;
            }

            Statement ST = DEV.Conexion.conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM productos "
                    + "where id_producto = '" + id_producto + "'");
            if (RS.next()) {
                stock_actualizado = RS.getDouble("stock") + cantidad;
            }

            //---- actualizo el stock
            PreparedStatement stUpdateStock = DEV.Conexion.conexion.prepareStatement(""
                    + "UPDATE productos "
                    + "SET stock ='" + stock_actualizado + "' "
                    + "WHERE id_producto='" + id_producto + "'");
            stUpdateStock.executeUpdate();
            //---- actualizo el stock
            
            Metodos.Cuenta_actualizar_total(total, -1);
            

            PreparedStatement stUpdateAuxiliar = DEV.Conexion.conexion.prepareStatement("delete from cuenta_detalle WHERE id_cuenta_detalle='" + id_cuenta_detalle + "'");
            stUpdateAuxiliar.executeUpdate();

            Metodos.BuscarFactura(0);
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    public static void Guardar_Cambios() {
        double total = 0;
        String strDinero = jTextField_Precio_Unitario.getText().replace(".", "");
        String unidades = jTextField_Unidades.getText().replace(",", ".");

        double cantidad = Double.parseDouble(unidades);

        double precio = Double.parseDouble(strDinero);
        long precio_int = (new Double(precio)).longValue();
        double stock_real = 0;
        double stock_actualizado = 0;
        try {
            Statement ST_Productos = DEV.Conexion.conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM cuenta_detalle "
                    + "where id_cuenta_detalle = '" + id_cuenta_detalle + "'");
            if (RS_Productos.next()) {
                
                
                long exentas_cuenta_detalle = RS_Productos.getLong("exentas");
                long cinco_cuenta_detalle = RS_Productos.getLong("cinco");
                long diez_cuenta_detalle = RS_Productos.getLong("diez");
                
                long total_cuenta_detalle = exentas_cuenta_detalle + cinco_cuenta_detalle + diez_cuenta_detalle;
                
                Double cuenta_detalle_cantidad = RS_Productos.getDouble("cantidad");

                total = cantidad * precio;
                Statement ST = DEV.Conexion.conexion.createStatement();
                ResultSet RS = ST.executeQuery("SELECT * FROM productos "
                        + "where id_producto = '" + RS_Productos.getInt("id_producto") + "'");
                if (RS.next()) {

                    long diez = 0;
                    long cinco = 0;
                    long exentas = 0;
                    double stock = RS.getDouble("stock");

                    stock_real = stock + cuenta_detalle_cantidad;
                    stock_actualizado = stock_real - cantidad;

                    if (RS.getInt("id_iva") == 1) {
                        diez = (new Double(total)).longValue();
                    }
                    if (RS.getInt("id_iva") == 2) {
                        cinco = (new Double(total)).longValue();
                    }
                    if (RS.getInt("id_iva") == 3) {
                        exentas = (new Double(total)).longValue();
                    }

                    PreparedStatement stUpdateAuxiliar = DEV.Conexion.conexion.prepareStatement(""
                            + "UPDATE cuenta_detalle "
                            + "SET cantidad='" + cantidad + "', "
                            + "diez = '" + diez + "', "
                            + "cinco = '" + cinco + "', "
                            + "exentas = '" + exentas + "', "
                            + "precio = '" + precio_int + "'  "
                            + "WHERE id_cuenta_detalle='" + id_cuenta_detalle + "'");
                    stUpdateAuxiliar.executeUpdate();

                    //---- actualizo el stock
                    PreparedStatement stUpdateStock = DEV.Conexion.conexion.prepareStatement(""
                            + "UPDATE productos "
                            + "SET stock ='" + stock_actualizado + "' "
                            + "WHERE id_producto='" + RS_Productos.getInt("id_producto") + "'");
                    stUpdateStock.executeUpdate();
                    //---- actualizo el stock

                    long diez_long = (long) diez;
                    long cinco_long = (long) cinco;
                    long cero_long = (long) exentas;

                    long total_long = cero_long + cinco_long + diez_long - total_cuenta_detalle;

                    Metodos.Cuenta_actualizar_total(total_long, 1);

                    Metodos.BuscarFactura(0);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }


    private void jTextField_UnidadesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_UnidadesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Guardar_Cambios();
            this.setVisible(false);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_jTextField_UnidadesKeyReleased

    private void jTextField_UnidadesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_UnidadesFocusGained
        jTextField_Precio_Unitario.select(0, 10);
    }//GEN-LAST:event_jTextField_UnidadesFocusGained

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
            java.util.logging.Logger.getLogger(venta_modificar_precio_cantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(venta_modificar_precio_cantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(venta_modificar_precio_cantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(venta_modificar_precio_cantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new venta_modificar_precio_cantidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField jTextField_Precio_Unitario;
    public static javax.swing.JTextField jTextField_Producto;
    public static javax.swing.JTextField jTextField_Unidades;
    // End of variables declaration//GEN-END:variables
}
