package FORMS;

import static DEV.Conexion.conexion;
import DEV.Metodos;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Arqueo_Caja extends javax.swing.JFrame {

    public Arqueo_Caja() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Arqueo de Caja");
        setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());

        Date hoy = new Date();
        
        jDateChooser2.setDate(hoy);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Fecha");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/impresora_mini.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDateChooser2.setDateFormatString("dd/MMM/yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
            String dia = yyyyMMdd.format(jDateChooser2.getDate());

            Statement stAuxiliar = conexion.createStatement();
            stAuxiliar.executeUpdate("truncate table reportecaja");
            Statement stRC = conexion.createStatement();
            int id = 0;
            int entro = 0;

            String sqlArqueo = ""
                    + "select * from cuenta \n"
                    + "inner join cliente on cliente.id_cliente = cuenta.id_cliente \n"
                    + "where cuenta.fecha_date >= '" + dia + "' and cuenta.fecha_date <= '" + dia + "' and (cuenta.obs <> 'SI' OR cuenta.obs is null) and cuenta.id_comercio = '1' and cuenta.id_estado != '9'";
            Statement stArqueo = conexion.createStatement();
            ResultSet rsArqueo = stArqueo.executeQuery(sqlArqueo);
            while (rsArqueo.next()) {

                ResultSet resultRC = stRC.executeQuery("SELECT MAX(id_reporte_caja) FROM reportecaja");
                if (resultRC.next()) {
                    id = resultRC.getInt(1) + 1;
                }

                PreparedStatement stReporteCaja = conexion.prepareStatement("INSERT INTO reportecaja VALUES(?,?,?,?,?,?,?)");
                stReporteCaja.setInt(1, id);
                stReporteCaja.setInt(2, 0);
                stReporteCaja.setLong(3, 0);
                stReporteCaja.setString(4, rsArqueo.getString("nombre"));
                stReporteCaja.setString(5, rsArqueo.getDate("fecha_date").toString());
                stReporteCaja.setLong(6, rsArqueo.getLong("total"));
                stReporteCaja.setInt(7, Metodos.id_comercio);
                stReporteCaja.executeUpdate();

                entro = 1;

            }

            if (entro == 0) {
                ResultSet resultRC = stRC.executeQuery("SELECT MAX(id_reporte_caja) FROM reportecaja");
                if (resultRC.next()) {
                    id = resultRC.getInt(1) + 1;
                }
                PreparedStatement stReporteCaja = conexion.prepareStatement("INSERT INTO reportecaja VALUES(?,?,?,?,?,?,?)");
                stReporteCaja.setInt(1, 1);
                stReporteCaja.setInt(2, 0);
                stReporteCaja.setLong(3, 0);
                stReporteCaja.setString(4, "");
                stReporteCaja.setString(5, "");
                stReporteCaja.setInt(6, 0);
                stReporteCaja.setInt(7, Metodos.id_comercio);
                stReporteCaja.executeUpdate();

                entro = 1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Arqueo_Caja.class.getName()).log(Level.SEVERE, null, ex);
        }

         String ubicacion_proyecto = new File("").getAbsolutePath();
        String path = ubicacion_proyecto + "\\reportes\\caja.jasper";
        
//        String path = "C:\\Sistema\\Reportes\\caja.jasper";
        JasperReport jr = null;

        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conexion);

            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Arqueo_Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arqueo_Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arqueo_Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arqueo_Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Arqueo_Caja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
