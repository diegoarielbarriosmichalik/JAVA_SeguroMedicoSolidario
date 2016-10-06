package FORMS;

import DEV.Metodos;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Buscar_cliente extends javax.swing.JFrame {

    public static int formulario;

    public Buscar_cliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Buscar cliente");
        setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jT_Buscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jL_Formulario_que_pide = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_clientes = new javax.swing.JTable();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jT_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_BuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jT_BuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar por nombre");

        jTable_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "CI", "RUC", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_clientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_clientes);
        if (jTable_clientes.getColumnModel().getColumnCount() > 0) {
            jTable_clientes.getColumnModel().getColumn(0).setResizable(false);
            jTable_clientes.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable_clientes.getColumnModel().getColumn(1).setResizable(false);
            jTable_clientes.getColumnModel().getColumn(1).setPreferredWidth(230);
            jTable_clientes.getColumnModel().getColumn(2).setResizable(false);
            jTable_clientes.getColumnModel().getColumn(3).setResizable(false);
            jTable_clientes.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_Formulario_que_pide)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jT_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(jL_Formulario_que_pide))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jT_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jT_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_BuscarKeyReleased
        Metodos.Buscar_cliente_cargar_lista();
        if ((evt.getKeyCode() == KeyEvent.VK_ESCAPE)) {
            this.setVisible(false);
        }
//        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
//            Metodos.Buscar_cliente_cargar_lista();
//        }
//        if ((evt.getKeyCode() == KeyEvent.VK_TAB)) {
//            Metodos.Buscar_cliente_cargar_lista();
//        }
//
//        try {
//
//            if (!"".equals(jT_Buscar.getText())) {
//                DefaultListModel modelo = new DefaultListModel();
//                Statement ST_Productos = conexion.createStatement();
//                ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM cliente where nombre ilike '%" + jT_Buscar.getText() + "%'"
//                        + " and id_comercio = '" + Metodos.id_comercio + "'");
//                while (RS_Productos.next()) {
//                    this.jList1.setModel(modelo);
//                    modelo.addElement(RS_Productos.getString("nombre").trim() + "");
//                }
//                this.jList1.setModel(modelo);
//            }
//        } catch (SQLException e) {
//            System.err.println(e);
//
//        }

    }//GEN-LAST:event_jT_BuscarKeyReleased

    public static void getLlevarNombre() {
//        Object dato = jList1.getSelectedValue();
//
//        try {
//            Statement ST;
//            ST = conexion.createStatement();
//            ResultSet RS_Productos = ST.executeQuery("SELECT * FROM cliente where nombre = '" + dato + "' and id_comercio = '" + Metodos.id_comercio + "' and (borrado <> 'SI' OR borrado is null)");
//            while (RS_Productos.next()) {
//
//                if (formulario == 1) {
//                    Clientes.jt_nombre.setText(RS_Productos.getString("nombre").trim());
//                    Clientes.jt_direccion.setText(RS_Productos.getString("direccion").trim());
//                    Clientes.jt_ruc.setText(RS_Productos.getString("ruc").trim());
//                    Clientes.jt_telefono.setText(RS_Productos.getString("telefono").trim());
//                    Clientes.id_cliente = RS_Productos.getInt("id_cliente");
//                    Clientes.jDateChooser_cumpleanos.setDate(RS_Productos.getDate("cumpleanos"));
//                    
//
//                } 
//                if (Ventas.form_cliente == 1) {
//
//                    int id_cliente = RS_Productos.getInt("id_cliente");
//                    int id_cuenta = Metodos.id_cuenta;
//
//                    PreparedStatement st = conexion.prepareStatement("UPDATE cuenta SET id_cliente='" + id_cliente + "' WHERE id_cuenta='" + id_cuenta + "'");
//                    st.executeUpdate();
//
//                    Ventas_Terminar.id_cliente = RS_Productos.getInt("id_cliente");
//                  
//
//                    Metodos.BuscarFactura(id_cuenta);
//                    Ventas.form_cliente = 0;
//                }
//            }
//
//        } catch (SQLException e) {
//            System.err.println("ERROR: " + e);
//        }
//        Ventas.form_cliente = 0;
    }

    private void jT_BuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_BuscarKeyPressed

        if ((evt.getKeyCode() == KeyEvent.VK_ESCAPE)) {
            Ventas.form_cliente = 0;
            this.setVisible(false);
        }

    }//GEN-LAST:event_jT_BuscarKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        jL_Formulario_que_pide.setVisible(false);
    }//GEN-LAST:event_formWindowActivated

    private void jTable_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_clientesMouseClicked
        Metodos.Cliente_editar_cargar_datos();
        this.setVisible(false);
    }//GEN-LAST:event_jTable_clientesMouseClicked

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
            java.util.logging.Logger.getLogger(Buscar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jL_Formulario_que_pide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField jT_Buscar;
    public static javax.swing.JTable jTable_clientes;
    // End of variables declaration//GEN-END:variables
}
