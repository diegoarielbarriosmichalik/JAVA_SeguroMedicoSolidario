package FORMS;

import static DEV.Conexion.conexion;
import DEV.Metodos;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventas extends javax.swing.JFrame {

    public Ventas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Ventas");
        setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        jCheckBox_Libreta.setVisible(false);
    }

    public static long total = 0;
    public static int form_cant = 0;
    public static int form_cotizacion = 0;
    public static int form_precio = 0;
    public static int form_cliente = 0;
    public static int entro = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jT_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_Venta_Detalle = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jT_Cliente = new javax.swing.JTextField();
        jT_total = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton_anterior = new javax.swing.JButton();
        jButton_siguiente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jT_Reales = new javax.swing.JTextField();
        jT_dolares = new javax.swing.JTextField();
        Jt_pesos = new javax.swing.JTextField();
        jT_Fecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox_Contado = new javax.swing.JCheckBox();
        jCheckBox_Libreta = new javax.swing.JCheckBox();
        jTextField_Buscar_producto_por_nombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField_factura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jT_codigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jT_codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jT_codigoFocusLost(evt);
            }
        });
        jT_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jT_codigoKeyReleased(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_codigoKeyPressed(evt);
            }
        });

        jLabel2.setText("Código de barras:");

        jT_Venta_Detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Unidades", "Precio Unitario", "Exentas", "5%", "10%"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_Venta_Detalle.getTableHeader().setReorderingAllowed(false);
        jT_Venta_Detalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_Venta_DetalleMouseClicked(evt);
            }
        });
        jT_Venta_Detalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_Venta_DetalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jT_Venta_Detalle);
        if (jT_Venta_Detalle.getColumnModel().getColumnCount() > 0) {
            jT_Venta_Detalle.getColumnModel().getColumn(0).setResizable(false);
            jT_Venta_Detalle.getColumnModel().getColumn(0).setPreferredWidth(2);
            jT_Venta_Detalle.getColumnModel().getColumn(1).setResizable(false);
            jT_Venta_Detalle.getColumnModel().getColumn(1).setPreferredWidth(500);
            jT_Venta_Detalle.getColumnModel().getColumn(2).setResizable(false);
            jT_Venta_Detalle.getColumnModel().getColumn(2).setPreferredWidth(2);
            jT_Venta_Detalle.getColumnModel().getColumn(3).setResizable(false);
            jT_Venta_Detalle.getColumnModel().getColumn(3).setPreferredWidth(7);
            jT_Venta_Detalle.getColumnModel().getColumn(4).setResizable(false);
            jT_Venta_Detalle.getColumnModel().getColumn(4).setPreferredWidth(7);
            jT_Venta_Detalle.getColumnModel().getColumn(5).setResizable(false);
            jT_Venta_Detalle.getColumnModel().getColumn(5).setPreferredWidth(7);
            jT_Venta_Detalle.getColumnModel().getColumn(6).setResizable(false);
            jT_Venta_Detalle.getColumnModel().getColumn(6).setPreferredWidth(7);
        }

        jLabel4.setText("Cliente:");

        jT_Cliente.setEditable(false);
        jT_Cliente.setBackground(new java.awt.Color(204, 204, 255));
        jT_Cliente.setText("Cliente no registrado");
        jT_Cliente.setToolTipText("Haga click aqui para cambiar el cliente");
        jT_Cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jT_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_ClienteMouseClicked(evt);
            }
        });
        jT_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_ClienteActionPerformed(evt);
            }
        });

        jT_total.setEditable(false);
        jT_total.setBackground(new java.awt.Color(255, 255, 255));
        jT_total.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        jT_total.setForeground(new java.awt.Color(0, 153, 0));
        jT_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jT_total.setBorder(null);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/terminar_mini.jpg"))); // NOI18N
        jButton3.setMnemonic('T');
        jButton3.setToolTipText("Presione las teclas Alt + T para terminar la venta");
        jButton3.setBorderPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setIconTextGap(-4);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton_anterior.setText("Anterior");
        jButton_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_anteriorActionPerformed(evt);
            }
        });

        jButton_siguiente.setText("Siguiente");
        jButton_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_siguienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Pesos");

        jLabel6.setText("Dolares");

        jLabel7.setText("Reales");

        jT_Reales.setEditable(false);
        jT_Reales.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jT_dolares.setEditable(false);
        jT_dolares.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        Jt_pesos.setEditable(false);
        Jt_pesos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jT_Fecha.setEditable(false);
        jT_Fecha.setBackground(new java.awt.Color(255, 255, 255));
        jT_Fecha.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel8.setText("Tipo de Venta:");

        jCheckBox_Contado.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox_Contado.setText("Contado");
        jCheckBox_Contado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_ContadoMouseClicked(evt);
            }
        });
        jCheckBox_Contado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_ContadoActionPerformed(evt);
            }
        });

        jCheckBox_Libreta.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox_Libreta.setText("Libreta");
        jCheckBox_Libreta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_LibretaMouseClicked(evt);
            }
        });

        jTextField_Buscar_producto_por_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_Buscar_producto_por_nombreKeyReleased(evt);
            }
        });

        jLabel9.setText("Buscar producto:");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo_mini.png"))); // NOI18N
        jButton2.setMnemonic('N');
        jButton2.setToolTipText("Presione la tecla Alt + N para iniciar una nueva venta");
        jButton2.setBorder(null);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setIconTextGap(-4);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField_factura.setEditable(false);
        jTextField_factura.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Factura:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jT_codigo)
                            .addComponent(jT_Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_Buscar_producto_por_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox_Contado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox_Libreta, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jT_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_anterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 199, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jT_Reales, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jT_dolares, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jt_pesos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jT_total, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jT_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_anterior)
                    .addComponent(jButton_siguiente)
                    .addComponent(jTextField_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField_Buscar_producto_por_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jCheckBox_Contado)
                    .addComponent(jCheckBox_Libreta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jt_pesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jT_dolares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jT_Reales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jT_total, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        Metodos.getFacturaMax();
        Metodos.BuscarFactura(Metodos.id_cuenta);

    //    jT_codigo.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void jButton_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_siguienteActionPerformed
        DEV.Metodos.id_cuenta++;
        DEV.Metodos.Buscar_Factura_Siguiente();
        jT_codigo.requestFocus();

    }//GEN-LAST:event_jButton_siguienteActionPerformed

    private void jButton_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_anteriorActionPerformed
        DEV.Metodos.id_cuenta--;
        DEV.Metodos.Buscar_Factura_Anterior();
        jT_codigo.requestFocus();
    }//GEN-LAST:event_jButton_anteriorActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Ventas_Terminar.total = total;

        new Ventas_Terminar().setVisible(true);
        Ventas_Terminar.jTextField_ingresar_dinero.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jT_codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_codigoKeyReleased

    }//GEN-LAST:event_jT_codigoKeyReleased

    private void jT_codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_codigoKeyPressed
    }//GEN-LAST:event_jT_codigoKeyPressed

    private void jCheckBox_LibretaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_LibretaMouseClicked

        try {
            PreparedStatement Update = conexion.prepareStatement("UPDATE cuenta SET tipo='2' WHERE id_cuenta ='" + Metodos.id_cuenta + "'");
            Update.executeUpdate();
            jCheckBox_Contado.setSelected(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el tipo de venta: " + ex);
        }

    }//GEN-LAST:event_jCheckBox_LibretaMouseClicked

    private void jCheckBox_ContadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_ContadoMouseClicked
        try {
            PreparedStatement Update = conexion.prepareStatement("UPDATE cuenta SET tipo='1' WHERE id_cuenta ='" + Metodos.id_cuenta + "'");
            Update.executeUpdate();
            jCheckBox_Libreta.setSelected(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el tipo de venta: " + ex);
        }
    }//GEN-LAST:event_jCheckBox_ContadoMouseClicked

    private void jTextField_Buscar_producto_por_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Buscar_producto_por_nombreKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            new Ventas_Buscar_Productos().setVisible(true);
            Ventas_Buscar_Productos.Buscar_Productos();
        }
    }//GEN-LAST:event_jTextField_Buscar_producto_por_nombreKeyReleased

    private void jT_codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_codigoFocusLost

        if ((form_cant == 0) && (form_precio == 0) && (form_cliente == 0) && (form_cotizacion == 0)) {
            int ok = guardar();

            if (ok == 1) {
                Metodos.BuscarFactura(Metodos.id_cuenta);
                jT_codigo.setText("");
                jT_codigo.requestFocus();
            }
            if (ok == 0) {
                jT_codigo.setText("");
                jT_codigo.requestFocus();
            }
            if (ok == 2) {
                jT_codigo.setText("");
                jTextField_Buscar_producto_por_nombre.requestFocus();
            }
            if (ok == 3) {
                JOptionPane.showMessageDialog(jT_Cliente, "Error en la lectura del codigo.", "Atencion", WIDTH);
                jT_codigo.setText("");
                jT_codigo.requestFocus();
            }
        }
    }//GEN-LAST:event_jT_codigoFocusLost

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
//        jT_codigo.requestFocus();
    }//GEN-LAST:event_formWindowActivated

    private void jT_Venta_DetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_Venta_DetalleKeyPressed
        new FORMS.compras_add_producto().setVisible(true);

        DefaultTableModel tm = (DefaultTableModel) jT_Venta_Detalle.getModel();

        String id = String.valueOf(tm.getValueAt(jT_Venta_Detalle.getSelectedRow(), 0));
        String nombre = DEV.Metodos.Producto_nombre_x_id(id);

        System.out.println(nombre);
//        Agregar_Forms.compras_add_producto.jTextField_Descripcion.setText(nombre);
    }//GEN-LAST:event_jT_Venta_DetalleKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DEV.Metodos.ventaNuevo();
        jT_codigo.setText("");
        jT_codigo.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jT_Venta_DetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_Venta_DetalleMouseClicked
        new venta_modificar_precio_cantidad().setVisible(true);

        DefaultTableModel tm = (DefaultTableModel) jT_Venta_Detalle.getModel();
        String id = String.valueOf(tm.getValueAt(jT_Venta_Detalle.getSelectedRow(), 0));
        String unidades = String.valueOf(tm.getValueAt(jT_Venta_Detalle.getSelectedRow(), 2));
        String nombre = DEV.Metodos.Producto_nombre_x_id_venta_detalle(id);
        String id_producto = DEV.Metodos.Producto_id_producto_x_id_venta_detalle(id);
        String precio = DEV.Metodos.Producto_precio_x_id_venta_detalle(id);

        venta_modificar_precio_cantidad.id_producto = id_producto;
        venta_modificar_precio_cantidad.id_cuenta_detalle = id;
        venta_modificar_precio_cantidad.jTextField_Producto.setText(nombre);
        venta_modificar_precio_cantidad.jTextField_Precio_Unitario.setText(precio);
        venta_modificar_precio_cantidad.jTextField_Unidades.setText(unidades);
        venta_modificar_precio_cantidad.jTextField_Unidades.select(0, 10);

    }//GEN-LAST:event_jT_Venta_DetalleMouseClicked

    private void jCheckBox_ContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_ContadoActionPerformed

    }//GEN-LAST:event_jCheckBox_ContadoActionPerformed

    private void jT_ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_ClienteMouseClicked
        
        new Ventas_buscar_cliente().setVisible(true);
    }//GEN-LAST:event_jT_ClienteMouseClicked

    private void jT_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_ClienteActionPerformed

    public static int guardar() {

        int ret = 0;
        String StringThatCouldBeANumberOrNot = jT_codigo.getText();
        long codigo = 0;
        String vacio = "";
        try {

            if ((StringThatCouldBeANumberOrNot.equals(vacio)) || (StringThatCouldBeANumberOrNot == null)) {
            } else {
                codigo = Long.parseLong(StringThatCouldBeANumberOrNot);
            }
        } catch (NumberFormatException e) {
            ret = 3;
        }

        int producto_no_encontrado = 0;

        int producto_cargado = 0;
        if (codigo > 0) {
            try {

                String hoy = DEV.Metodos.getHoy_format2();

                Statement ST_Productos = conexion.createStatement();
                ResultSet RS_Productos = ST_Productos.executeQuery("select id_producto, precio, codigo, id_comercio,"
                        + " id_iva from productos where codigo ='" + codigo + "' and id_comercio = '" + Metodos.id_comercio + "'");
                while (RS_Productos.next()) {

                    Statement ST_Productos3 = conexion.createStatement();
                    ResultSet RS_Productos3 = ST_Productos3.executeQuery("select id_producto, id_cuenta_detalle, cantidad from cuenta_detalle where id_producto ='" + RS_Productos.getInt("id_producto") + "' and id_cuenta = '" + Metodos.id_cuenta + "'");
                    while (RS_Productos3.next()) {
                        producto_cargado = 1;
                        int id = RS_Productos3.getInt("id_cuenta_detalle");
                        int cantidad = RS_Productos3.getInt("cantidad");

                        double diez = 0;
                        double cinco = 0;
                        double cero = 0;

                        if (RS_Productos.getInt("id_iva") == 1) {
                            diez = (cantidad + 1) * RS_Productos.getInt("precio");
                        }
                        if (RS_Productos.getInt("id_iva") == 2) {
                            cinco = (cantidad + 1) * RS_Productos.getInt("precio");
                        }
                        if (RS_Productos.getInt("id_iva") == 3) {
                            cero = (cantidad + 1) * RS_Productos.getInt("precio");
                        }

                        long diez_long = (long) diez;
                        long cinco_long = (long) cinco;
                        long cero_long = (long) cero;

                        long total = cero_long + cinco_long + diez_long;

                        PreparedStatement Update;

//                        System.out.println("Cantidad: " + cantidad + " Exentas: " + cero + " Cinco: " + cinco + " Diez: " + diez);
                        Update = conexion.prepareStatement("UPDATE cuenta_detalle SET cantidad='" + (cantidad + 1) + "', exentas = '" + cero_long + "', cinco = '" + cinco_long + "', diez = '" + diez_long + "' WHERE id_cuenta_detalle='" + id + "'");
                        Update.executeUpdate();

                        Metodos.Cuenta_actualizar_total(total, 1);

                        producto_no_encontrado = 1;
                        ret = 1;
                    }

                    if (producto_cargado == 0) {

                        producto_no_encontrado = 1;
                        int id = 0;
                        Statement ST_Auxiliar_2 = conexion.createStatement();
                        ResultSet RS_Auxiliar_2 = ST_Auxiliar_2.executeQuery("SELECT MAX(id_cuenta_detalle) FROM cuenta_detalle");
                        if (RS_Auxiliar_2.next()) {
                            id = RS_Auxiliar_2.getInt(1) + 1;
                        }

                        PreparedStatement st2 = conexion.prepareStatement("INSERT INTO cuenta_detalle VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        st2.setInt(1, id);
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
                        st2.setInt(15, 0);
                        st2.executeUpdate();

                        Metodos.Cuenta_actualizar_total(total, 1);

                        // restar stock
                        DEV.Metodos.Productos_Update(1, RS_Productos.getInt("id_producto"), 1);

                        ret = 1;
                    }
                }
                if (producto_no_encontrado == 0) {
                    JOptionPane.showMessageDialog(jT_Cliente, "No se encuentra el producto.", "Atencion", WIDTH);
                    ret = 0;
                }
            } catch (SQLException ex) {
                System.err.println("Error: " + ex);
                ret = 0;
            }
        } else if (ret == 3) {
        } else {
            ret = 2;
        }
        return ret;
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Jt_pesos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton_anterior;
    public static javax.swing.JButton jButton_siguiente;
    public static javax.swing.JCheckBox jCheckBox_Contado;
    public static javax.swing.JCheckBox jCheckBox_Libreta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField jT_Cliente;
    public static javax.swing.JTextField jT_Fecha;
    public static javax.swing.JTextField jT_Reales;
    public static javax.swing.JTable jT_Venta_Detalle;
    public static javax.swing.JTextField jT_codigo;
    public static javax.swing.JTextField jT_dolares;
    public static javax.swing.JTextField jT_total;
    public static javax.swing.JTextField jTextField_Buscar_producto_por_nombre;
    public static javax.swing.JTextField jTextField_factura;
    // End of variables declaration//GEN-END:variables
}
