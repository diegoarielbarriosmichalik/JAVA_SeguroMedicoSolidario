package FORMS;

import static DEV.Conexion.conexion;
import DEV.Metodos;
import static DEV.Metodos.RefreshListCompras;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;

public class compras_add_producto extends javax.swing.JFrame {

    public compras_add_producto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Detalle de compra");
            setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
    }

    public static int id_producto = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField_Unidades = new javax.swing.JTextField();
        jTextField_Precio_Unitario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Total = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Descripcion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField_Unidades.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Unidades.setForeground(new java.awt.Color(0, 102, 0));
        jTextField_Unidades.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField_Precio_Unitario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Precio_Unitario.setForeground(new java.awt.Color(0, 102, 0));
        jTextField_Precio_Unitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Precio_Unitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Precio_UnitarioKeyReleased(evt);
            }
        });

        jLabel1.setText("Unidades");

        jLabel2.setText("Precio Unitario");

        jTextField_Total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Total.setForeground(new java.awt.Color(0, 102, 0));
        jTextField_Total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_Total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_TotalKeyReleased(evt);
            }
        });

        jLabel3.setText("Total");

        jTextField_Descripcion.setEditable(false);
        jTextField_Descripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Descripcion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setText("Descripcion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Total)
                    .addComponent(jTextField_Precio_Unitario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_Descripcion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_Unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Precio_Unitario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        jTextField_Unidades.requestFocus();
    }//GEN-LAST:event_formWindowActivated

    private void jTextField_Precio_UnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Precio_UnitarioKeyReleased
        double precio_unitario = Integer.parseInt(jTextField_Precio_Unitario.getText());
        double unidades = Double.parseDouble(jTextField_Unidades.getText().replace(",", "."));

        double total = precio_unitario * unidades;
        long total_long = Math.round(total);
        String totalString = String.valueOf(total_long);

        totalString = DEV.Metodos.getSepararMiles(totalString);
        jTextField_Total.setText(totalString);

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            producto_add();
            FORMS.Compras.jT_Buscar_Productos.setText("");
            FORMS.Compras.jT_Buscar_Productos.requestFocus();
            this.setVisible(false);
            RefreshListCompras();
        }
    }//GEN-LAST:event_jTextField_Precio_UnitarioKeyReleased

    public static void producto_add() {
        try {
            int id = 1;

            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_facturas_compra_detalle) FROM facturas_compra_detalle");
            if (result.next()) {
                id = result.getInt(1) + 1;
            }
            long total = 0;
            Statement st22 = conexion.createStatement();
            ResultSet result23 = st22.executeQuery("SELECT id_facturas_compra, total FROM facturas_compra "
                    + "where id_facturas_compra = '" + Metodos.id_facturas_compra + "'");
            if (result23.next()) {
                total = result23.getLong("total");
            }

            String totalString = jTextField_Total.getText().replace(".", "");
            String unidades = jTextField_Unidades.getText().replace(",", ".");
            double unidades_double = Double.parseDouble(unidades);
            String precio_unitario = jTextField_Precio_Unitario.getText().replace(",", "");
            precio_unitario = precio_unitario.replace(".", "");
            PreparedStatement st2 = conexion.prepareStatement("INSERT INTO facturas_compra_detalle VALUES(?,?,?,?,?,?,?)");
            st2.setInt(1, id);
            st2.setDouble(2, unidades_double);
            st2.setInt(3, Integer.parseInt(precio_unitario));
            st2.setInt(4, 0);
            st2.setInt(5, Metodos.id_facturas_compra);
            st2.setInt(6, id_producto);
            st2.setInt(7, Integer.parseInt(totalString));
            st2.executeUpdate();

            total = total + Long.parseLong(totalString);

            double cantidad = 0;
            Statement st8 = conexion.createStatement();
            ResultSet result8 = st8.executeQuery("SELECT * FROM productos where id_producto = '" + id_producto + "'");
            if (result8.next()) {
                cantidad = result8.getDouble("stock") + unidades_double;
            }

            PreparedStatement stUpdateAuxiliar = conexion.prepareStatement("UPDATE productos SET stock = '" + cantidad + "' where id_producto = '" + id_producto + "'");
            stUpdateAuxiliar.executeUpdate();

            PreparedStatement stUpdateAuxiliar2 = conexion.prepareStatement("UPDATE facturas_compra "
                    + "SET total = '" + total + "' where id_facturas_compra = '" + Metodos.id_facturas_compra + "'");
            stUpdateAuxiliar2.executeUpdate();

            RefreshListCompras();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }


    private void jTextField_TotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TotalKeyReleased
        String totalString = jTextField_Total.getText();
        totalString = totalString.replace(".", "");
        totalString = DEV.Metodos.getSepararMiles(totalString);
        jTextField_Total.setText(totalString);

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            producto_add();
            this.setVisible(false);
        }

    }//GEN-LAST:event_jTextField_TotalKeyReleased

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
            java.util.logging.Logger.getLogger(compras_add_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(compras_add_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(compras_add_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(compras_add_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new compras_add_producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField jTextField_Descripcion;
    public static javax.swing.JTextField jTextField_Precio_Unitario;
    public static javax.swing.JTextField jTextField_Total;
    public static javax.swing.JTextField jTextField_Unidades;
    // End of variables declaration//GEN-END:variables
}
