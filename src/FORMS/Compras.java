package FORMS;

import static DEV.Conexion.conexion;
import DEV.Metodos;
import static DEV.Metodos.Nueva_Compra;
import static DEV.Metodos.RefreshListCompras;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Compras extends javax.swing.JFrame {

    String hoy = null;
    public static int id_factura = getFacturaMax();
    public static ResultSetMetaData rsm;
    public static DefaultTableModel dtm;
    public static int max = 0;

    /**
     * Creates new form Compras
     */
    public Compras() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Compras");
        setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        hoy = DEV.Metodos.getHoy_format2();

//        jT_fecha.setText(hoy);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jT_factura_nro = new javax.swing.JTextField();
        jT_Proveedor = new javax.swing.JTextField();
        jT_Buscar_Productos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jL_Total = new javax.swing.JLabel();
        jLabel_factura = new javax.swing.JLabel();
        jLabel_proveedor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel_fecha = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jButton_guardar = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setText("Facturación");

        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jT_factura_nro.setEditable(false);
        jT_factura_nro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jT_factura_nro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_factura_nroActionPerformed(evt);
            }
        });
        jT_factura_nro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jT_factura_nroFocusLost(evt);
            }
        });
        jT_factura_nro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_factura_nroKeyPressed(evt);
            }
        });

        jT_Proveedor.setEditable(false);
        jT_Proveedor.setBackground(new java.awt.Color(204, 204, 255));
        jT_Proveedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jT_Proveedor.setToolTipText("Click para buscar un proveedor");
        jT_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_ProveedorMouseClicked(evt);
            }
        });
        jT_Proveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_ProveedorKeyPressed(evt);
            }
        });

        jT_Buscar_Productos.setEditable(false);
        jT_Buscar_Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_Buscar_ProductosActionPerformed(evt);
            }
        });
        jT_Buscar_Productos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jT_Buscar_ProductosKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripcion", "Unidades", "Precio Unitario", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(450);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        jL_Total.setBackground(new java.awt.Color(255, 255, 255));
        jL_Total.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jL_Total.setForeground(new java.awt.Color(0, 102, 0));
        jL_Total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_Total.setText("0");
        jL_Total.setOpaque(true);
        jL_Total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jL_TotalKeyPressed(evt);
            }
        });

        jLabel_factura.setText("Factura Nro:");

        jLabel_proveedor.setText("Proveedor:");

        jLabel6.setText("Buscar Productos");

        jLabel_fecha.setText("Fecha:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo_mini.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDateChooser.setDateFormatString("dd/MMM/yyyy");

        jButton_guardar.setBackground(new java.awt.Color(204, 204, 255));
        jButton_guardar.setText("Guardar ");
        jButton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jT_Buscar_Productos, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel_factura)
                                    .addComponent(jLabel_proveedor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jT_factura_nro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_fecha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jT_Proveedor))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(311, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jL_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jT_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_proveedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jT_factura_nro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_factura))
                            .addComponent(jLabel_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_Buscar_Productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jL_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

    private void jT_Buscar_ProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_Buscar_ProductosKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            new FORMS.buscar_productos_en_compras().setVisible(true);
            FORMS.buscar_productos_en_compras.Buscar_Productos();
        }
    }//GEN-LAST:event_jT_Buscar_ProductosKeyReleased

    private void jL_TotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jL_TotalKeyPressed

    }//GEN-LAST:event_jL_TotalKeyPressed

    public static int getFacturaMax() {
        try {
            ResultSet RS_Productos;
            try (Statement ST_Productos = conexion.createStatement()) {
                RS_Productos = ST_Productos.executeQuery("SELECT MAX(id_facturas_compra) from facturas_compra");
                if (RS_Productos.next()) {
                    max = RS_Productos.getInt(1);
                }
            }
            RS_Productos.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return max;

    }

    public static String getFacturaNumero() {
        String valor = "";
        try {
            ResultSet RS_Productos;
            try (Statement ST_Productos = conexion.createStatement()) {
                max = getFacturaMax();

                RS_Productos = ST_Productos.executeQuery("SELECT * from facturas_compra where id_facturas_compra = '" + max + "'");
                if (RS_Productos.next()) {
                    valor = RS_Productos.getString("numero");
                }
            }
            RS_Productos.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return valor;

    }

    public static void Compras_Buscar_Factura(int valor) {
        try {

            int entro = 0;

            PreparedStatement ps;
            ResultSet rs;

            ps = conexion.prepareStatement("select \n"
                    + "productos.nombre, \n"
                    + "facturas_compra_detalle.cantidad, \n"
                    + "facturas_compra_detalle.precio\n"
                    + "from facturas_compra_detalle \n"
                    + "\n"
                    + "inner join productos on productos.id_producto = facturas_compra_detalle.id_producto  \n"
                    + "\n"
                    + "where id_facturas_compra = '" + valor + "' "
                    + "and id_comercio = '" + Metodos.id_comercio + "' "
                    + "order by facturas_compra_detalle.id_facturas_compra_detalle DESC");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();

            for (int j = 0;
                    j < jTable1.getRowCount();
                    j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            int precio = 0;

            ArrayList<Object[]> data = new ArrayList<>();

            while (rs.next()) {

                precio = rs.getInt("precio") + precio;

                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                data.add(rows);
                entro = 1;
            }

            for (int i = 0;
                    i < data.size();
                    i++) {
                dtm.addRow(data.get(i));
            }
            String strLong = Long.toString(precio);
            String nuevo = DEV.Metodos.getSepararMiles(strLong);

            jL_Total.setText(nuevo);

            if (entro == 0) {

                int numero = Integer.parseInt(jT_factura_nro.getText());

                String max = String.valueOf(getFacturaMax());

                int maxi = Integer.parseInt(max);
                if (valor == 1) {
                    if (numero < maxi) {
                        numero = (numero + (valor));
                        jT_factura_nro.setText(String.valueOf(numero));
                        Compras_Buscar_Factura(valor);
                    } else {
                        jT_factura_nro.setText(max);
                        Compras_Buscar_Factura(0);
                    }
                }
                if (valor == -1) {
                    numero = (numero + (valor));
                    jT_factura_nro.setText(String.valueOf(numero));
                    Compras_Buscar_Factura(valor);
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }


    private void jT_factura_nroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_factura_nroKeyPressed

    }//GEN-LAST:event_jT_factura_nroKeyPressed

    private void jT_ProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_ProveedorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            Buscar_proveedores jFrame = new Buscar_proveedores();
            jFrame.setVisible(true);
            Buscar_proveedores.jL_Formulario_que_pide.setText("Compras");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Buscar_proveedores.formulario = 2;
            Buscar_proveedores jFrame = new Buscar_proveedores();
            jFrame.setVisible(true);
            Buscar_proveedores.jL_Formulario_que_pide.setText("Compras");
        }
    }//GEN-LAST:event_jT_ProveedorKeyPressed

    

   


    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
    }//GEN-LAST:event_formWindowGainedFocus

    public static void Buscar_Compra_menos() {
        if (id_factura > 0) {
            try {

                id_factura = id_factura - 1;
                int encontro = 0;

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT * FROM facturas_compra "
                        + "where id_facturas_compra = '" + id_factura + "' and id_comercio = '" + Metodos.id_comercio + "' ");
                if (result.next()) {

                    PreparedStatement stUpdateAuxiliar = conexion.prepareStatement("UPDATE facturas_compra "
                            + "SET activo='0' WHERE activo='1' and id_comercio = '" + Metodos.id_comercio + "' ");
                    stUpdateAuxiliar.executeUpdate();

                    PreparedStatement stUpdateAuxiliar2 = conexion.prepareStatement("UPDATE facturas_compra "
                            + "SET activo='1' WHERE id_facturas_compra = '" + id_factura + "' "
                            + "and id_comercio = '" + Metodos.id_comercio + "' ");
                    stUpdateAuxiliar2.executeUpdate();

                    RefreshListCompras();
                    encontro = 1;
//                    jTextField_id_factura_compra.setText(String.valueOf(id_factura));
                }
                if (encontro == 0) {
                    id_factura = id_factura - 1;
//                    jTextField_id_factura_compra.setText(String.valueOf(id_factura));
                    Buscar_Compra_menos();
                }

            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }

    }

    public static void Buscar_Compra_mas() {

        try {
            int max = 0;
            Statement st0 = conexion.createStatement();
            ResultSet result0 = st0.executeQuery("SELECT max(id_facturas_compra) FROM facturas_compra ");
            if (result0.next()) {
                max = result0.getInt(1);
            }

            if ((id_factura > 0) && (id_factura <= max)) {
                try {

                    id_factura = id_factura + 1;
                    int encontro = 0;

                    Statement st1 = conexion.createStatement();
                    ResultSet result = st1.executeQuery("SELECT * FROM facturas_compra "
                            + "where id_facturas_compra = '" + id_factura + "' and id_comercio = '" + Metodos.id_comercio + "' ");
                    if (result.next()) {

                        PreparedStatement stUpdateAuxiliar = conexion.prepareStatement("UPDATE facturas_compra "
                                + "SET activo='0' WHERE activo='1' and id_comercio = '" + Metodos.id_comercio + "' ");
                        stUpdateAuxiliar.executeUpdate();

                        PreparedStatement stUpdateAuxiliar2 = conexion.prepareStatement("UPDATE facturas_compra "
                                + "SET activo='1' WHERE id_facturas_compra = '" + id_factura + "' "
                                + "and id_comercio = '" + Metodos.id_comercio + "' ");
                        stUpdateAuxiliar2.executeUpdate();

//                        jTextField_id_factura_compra.setText(String.valueOf(id_factura));
                        RefreshListCompras();
                        encontro = 1;

                    }
                    if (encontro == 0) {
                        id_factura = id_factura + 1;
                        Buscar_Compra_mas();
                    }

                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened


    private void jT_factura_nroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_factura_nroFocusLost
        Metodos.Compras_Verificar_Numero_de_Factura();
        jT_Buscar_Productos.requestFocus();
    }//GEN-LAST:event_jT_factura_nroFocusLost

    private void jT_factura_nroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_factura_nroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_factura_nroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Nueva_Compra();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jT_ProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_ProveedorMouseClicked
        new FORMS.Compras_proveedor_buscar().setVisible(true);
    }//GEN-LAST:event_jT_ProveedorMouseClicked

    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed
     
        Metodos.Compras_Guardar();
        
    }//GEN-LAST:event_jButton_guardarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       new Compras_detalle_opciones().setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jT_Buscar_ProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_Buscar_ProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_Buscar_ProductosActionPerformed

    public static void getGuardarCompra() {

        int id = 1;
        try {
            int si = 0;
            Statement st12 = conexion.createStatement();;
            ResultSet result12 = st12.executeQuery("SELECT * FROM facturas_compra "
                    + "where numero = '" + jT_factura_nro.getText() + "' and id_proveedor = '" + Metodos.id_proveedor + "'");
            if (result12.next()) {
                si = 1;
                id_factura = result12.getInt("id_facturas_compra");
                PreparedStatement stUpdateAuxiliar = conexion.prepareStatement("UPDATE facturas_compra "
                        + "SET activo='0' WHERE activo='1' and id_comercio = '" + Metodos.id_comercio + "' ");
                stUpdateAuxiliar.executeUpdate();
                PreparedStatement stUpdateAuxiliar2 = conexion.prepareStatement("UPDATE facturas_compra "
                        + "SET activo='1' WHERE id_facturas_compra = '" + id_factura + "'");
                stUpdateAuxiliar2.executeUpdate();
            }
            if (si != 1) {

                Statement st1;
                st1 = conexion.createStatement();

                ResultSet result = st1.executeQuery("SELECT MAX(id_facturas_compra) FROM facturas_compra");
                if (result.next()) {
                    id = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateAuxiliar = conexion.prepareStatement("UPDATE facturas_compra "
                        + "SET activo='0' WHERE activo='1' and id_comercio = '" + Metodos.id_comercio + "' ");
                stUpdateAuxiliar.executeUpdate();

                PreparedStatement st2 = conexion.prepareStatement("INSERT INTO facturas_compra VALUES(?,?,?,?,?,?,?,?)");
                st2.setInt(1, id);
                st2.setString(2, jT_factura_nro.getText());
                st2.setString(3, "");
                st2.setInt(4, 0);
                st2.setInt(5, 0);
                st2.setInt(6, Metodos.id_proveedor);
                st2.setInt(7, 1);
                st2.setInt(8, Metodos.id_comercio);
                id_factura = id;

                st2.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        Compras.jT_Buscar_Productos.setEnabled(true);
        Compras.jT_Buscar_Productos.requestFocus();

    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton_guardar;
    public static com.toedter.calendar.JDateChooser jDateChooser;
    public static javax.swing.JLabel jL_Total;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_factura;
    private javax.swing.JLabel jLabel_fecha;
    private javax.swing.JLabel jLabel_proveedor;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField jT_Buscar_Productos;
    public static javax.swing.JTextField jT_Proveedor;
    public static javax.swing.JTextField jT_factura_nro;
    public static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
