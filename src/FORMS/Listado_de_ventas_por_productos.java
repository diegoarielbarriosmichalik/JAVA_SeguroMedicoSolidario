package FORMS;

import static DEV.Conexion.conexion;
import DEV.Metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Listado_de_ventas_por_productos extends javax.swing.JFrame {

    public Listado_de_ventas_por_productos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Listado de ventas por productos");
        setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());

        Date dnow = new Date();
        jd_desde.setDate(dnow);
        jd_hasta.setDate(dnow);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id_producto = new javax.swing.JLabel();
        jd_desde = new com.toedter.calendar.JDateChooser();
        jd_hasta = new com.toedter.calendar.JDateChooser();
        jComboBox_productos = new javax.swing.JComboBox();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/impresora_mini.png"))); // NOI18N
        jButton1.setToolTipText("Ver listado");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Desde:");

        jLabel3.setText("Hasta:");

        jLabel4.setText("Producto:");

        jComboBox_productos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos los productos" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(id_producto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jd_desde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jd_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(198, 198, 198))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jd_desde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jd_hasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id_producto))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");

            Date desde_date = jd_desde.getDate();
            Date hasta_date = jd_hasta.getDate();

            String desde = yyyyMMdd.format(desde_date);
            String hasta = yyyyMMdd.format(hasta_date);

            String desde_formatdmy = DEV.Metodos.Fecha_yyyymmdd_to_ddmmyyyy(desde_date);
            String hasta_formatdmy = DEV.Metodos.Fecha_yyyymmdd_to_ddmmyyyy(hasta_date);

            Statement stAuxiliar = conexion.createStatement();
            stAuxiliar.executeUpdate("truncate table reporte_ventas_productos");

            double cantidad = 0;
            long total = 0;

            int entro = 0;
            Statement ST_Productos;
            ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM productos where "
                    + "id_comercio = '" + Metodos.id_comercio + "' and (borrado <> 'SI' OR borrado is null)");
            while (RS_Productos.next()) {

                Statement ST_Cuenta_detalle;
                ST_Cuenta_detalle = conexion.createStatement();
                ResultSet RS_Cuenta_detalle = ST_Cuenta_detalle.executeQuery("SELECT * FROM cuenta_detalle "
                        + "where id_producto = '" + RS_Productos.getInt("id_producto") + "' and (borrado <> 'SI' OR borrado is null) "
                        + "and fecha >= '" + desde + " 00:00:00' and fecha <= '" + hasta + " 24:59:59' and tipo_venta != '9'");
                while (RS_Cuenta_detalle.next()) {
                    cantidad = cantidad + RS_Cuenta_detalle.getDouble("cantidad");
                    total = RS_Cuenta_detalle.getLong("diez") + RS_Cuenta_detalle.getLong("cinco") + RS_Cuenta_detalle.getLong("exentas") + total;
                }
                if (cantidad > 0) {
                    int id = 0;
                    Statement st1 = conexion.createStatement();
                    ResultSet result = st1.executeQuery("SELECT MAX(id) FROM reporte_ventas_productos");
                    if (result.next()) {
                        id = result.getInt(1) + 1;
                    }
                    PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO reporte_ventas_productos VALUES(?,?,?,?,?,?,?)");
                    stUpdateProducto.setInt(1, id);
                    stUpdateProducto.setString(2, RS_Productos.getString("nombre"));
                    stUpdateProducto.setDouble(3, cantidad);
                    stUpdateProducto.setString(4, desde_formatdmy);
                    stUpdateProducto.setString(5, hasta_formatdmy);
                    stUpdateProducto.setLong(6, 0);
                    stUpdateProducto.setDouble(7, total);
                    total = 0;
                    stUpdateProducto.executeUpdate();
                    cantidad = 0;
                    entro = 1;
                }
            }
            if (entro == 0) {
                PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO reporte_ventas_productos VALUES(?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, 1);
                stUpdateProducto.setString(2, "");
                stUpdateProducto.setDouble(3, 0);
                stUpdateProducto.setString(4, desde_formatdmy);
                stUpdateProducto.setString(5, hasta_formatdmy);
                stUpdateProducto.setLong(6, 0);
                stUpdateProducto.setDouble(7, total);
                total = 0;
                stUpdateProducto.executeUpdate();
            }

            String path = "C:\\Sistema\\venta_de_productos_por_fecha.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException | SQLException e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        jd_desde.requestFocus();

    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Listado_de_ventas_por_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado_de_ventas_por_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado_de_ventas_por_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado_de_ventas_por_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listado_de_ventas_por_productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel id_producto;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox_productos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public static com.toedter.calendar.JDateChooser jd_desde;
    private com.toedter.calendar.JDateChooser jd_hasta;
    // End of variables declaration//GEN-END:variables
}
