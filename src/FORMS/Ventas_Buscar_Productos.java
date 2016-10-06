package FORMS;

import static DEV.Conexion.conexion;
import DEV.Metodos;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import static FORMS.Logueo.hoy;
import javax.swing.ImageIcon;

public class Ventas_Buscar_Productos extends javax.swing.JFrame {

    public Ventas_Buscar_Productos() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle("Buscar producto");
        setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Precio", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(350);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

    public static void Buscar_Productos() {
        try {
            ResultSetMetaData rsm;
            DefaultTableModel dtm;
            PreparedStatement ps;
            ResultSet rs;
            ps = conexion.prepareStatement("select id_producto, nombre, precio, stock "
                    + "from productos where id_comercio = '" + Metodos.id_comercio + "' "
                    + "and (borrado_int != '1' or borrado_int is null) "
                    + "and nombre ilike '%" + Ventas.jTextField_Buscar_producto_por_nombre.getText() + "%'");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            dtm = (DefaultTableModel) jTable1.getModel();
            for (int j = 0; j < jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) jTable1.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }

        Ventas.jTextField_Buscar_producto_por_nombre.setText("");
    }

    public static void GuardarDesdeLista() {

        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        String dato = String.valueOf(tm.getValueAt(jTable1.getSelectedRow(), 0));
        int id = 0;
        Statement ST_Productos;
        try {
            ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM productos where nombre = '" + dato + "' and id_comercio = '" + index.id_comercio + "' and (borrado <> 'SI' OR borrado is null)");
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM productos where id_producto = '" + dato + "'");
            while (RS_Productos.next()) {

                try (Statement ST_Auxiliar_2 = conexion.createStatement(); ResultSet RS_Auxiliar_2 = ST_Auxiliar_2.executeQuery("SELECT MAX(id_cuenta_detalle) FROM cuenta_detalle")) {
                    if (RS_Auxiliar_2.next()) {
                        id = RS_Auxiliar_2.getInt(1) + 1;
                    }
                }

                PreparedStatement st2 = conexion.prepareStatement("INSERT INTO cuenta_detalle VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                st2.setInt(1, id);
//                st2.setInt(2, Integer.parseInt(Ventas.jT_Factura_nro.getText()));
                st2.setInt(2, Metodos.id_cuenta);
                st2.setInt(3, RS_Productos.getInt("id_producto"));
                st2.setInt(4, RS_Productos.getInt("precio"));
                st2.setInt(5, 1);
                st2.setInt(6, RS_Productos.getInt("precio"));
                st2.setString(7, hoy);
                st2.setString(8, "--");

                double diez = 0;
                double cinco = 0;
                double cero = 0;

                if (RS_Productos.getInt("id_iva") == 1) {
                    diez = RS_Productos.getInt("precio");
                }
                if (RS_Productos.getInt("id_iva") == 2) {
                    cinco = RS_Productos.getInt("precio");
                }
                if (RS_Productos.getInt("id_iva") == 3) {
                    cero = RS_Productos.getInt("precio");
                }

                st2.setDouble(9, cero); // exentas
                st2.setDouble(10, cinco);// cinco
                st2.setDouble(11, diez);// diez

                st2.setInt(12, 0);
                st2.setInt(13, 0);
                st2.setInt(14, 1);
                st2.setInt(15, 1);
                st2.executeUpdate();

                long diez_long = (long) diez;
                long cinco_long = (long) cinco;
                long cero_long = (long) cero;

                long total = cero_long + cinco_long + diez_long;

                Metodos.Cuenta_actualizar_total(total, 1);

                // resta en stock
                DEV.Metodos.Productos_Update(1, RS_Productos.getInt("id_producto"), -1);

                Metodos.BuscarFactura(0);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jTable1.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        GuardarDesdeLista();
        Ventas.jT_codigo.requestFocus();
        Ventas.jT_codigo.setText("");
        this.setVisible(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased

    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            GuardarDesdeLista();
            Ventas.jT_codigo.requestFocus();
            Ventas.jT_codigo.setText("");
            this.setVisible(false);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_jTable1KeyPressed

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
            java.util.logging.Logger.getLogger(Ventas_Buscar_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas_Buscar_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas_Buscar_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas_Buscar_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas_Buscar_Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
