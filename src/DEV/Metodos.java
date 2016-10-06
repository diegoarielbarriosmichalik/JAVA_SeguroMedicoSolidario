package DEV;

import static DEV.Conexion.conexion;
import FORMS.Buscar_cliente;
import FORMS.Buscar_producto;
import FORMS.Buscar_proveedores;
import FORMS.Clientes;
import static FORMS.Clientes.id_cliente;
import static FORMS.Clientes.jt_direccion;
import static FORMS.Clientes.jt_email;
import static FORMS.Clientes.jt_nombre;
import static FORMS.Clientes.jt_ruc;
import static FORMS.Clientes.jt_telefono;
import FORMS.Compras;
import static FORMS.Compras.id_factura;
import static FORMS.Compras.jT_factura_nro;
import FORMS.Compras_proveedor_buscar;
import FORMS.Configuracion_impresion;
import FORMS.Configuraciones;
import FORMS.Logueo;
import static FORMS.Logueo.id_usuario;
import static FORMS.Logueo.jPasswordField1;
import static FORMS.Logueo.jTextField1;
import FORMS.Principal;
import FORMS.Productos;
import static FORMS.Productos.producto_codigo;
import static FORMS.Productos.producto_nombre;
import static FORMS.Productos.producto_precio;
import static FORMS.Productos.ubicacion;
import FORMS.Productos_Tipo_Listado;
import FORMS.Productos_tipo;
import FORMS.Proveedores;
import FORMS.Usuarios;
import FORMS.Ventas;
import static FORMS.Ventas.Jt_pesos;
import static FORMS.Ventas.entro;
import static FORMS.Ventas.jCheckBox_Contado;
import static FORMS.Ventas.jCheckBox_Libreta;
import static FORMS.Ventas.jT_Cliente;
import static FORMS.Ventas.jT_Fecha;
import static FORMS.Ventas.jT_Reales;
import static FORMS.Ventas.jT_codigo;
import static FORMS.Ventas.jT_dolares;
import static FORMS.Ventas.jT_total;
import FORMS.Ventas_Terminar;
import FORMS.Ventas_buscar_cliente;
import FORMS.buscar_productos_en_compras;
import FORMS.buscar_productos_nota_pedido_interno;
import FORMS.compras_add_producto;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Metodos {

    // -------------------------------------- Definicion de variables globales
    public static int id_cuenta = 0;
    public static int id = 0;
    public static ResultSetMetaData rsm;
    public static DefaultTableModel dtm;
    public static String comercio;
    public static String titulo;
    public static int id_comercio;
    public static String comercio_direccion;
    public static String comercio_telefono;
    public static String comercio_email;
    public static String comercio_ruc;
    public static int id_proveedor = 0;
    public static int id_facturas_compra = 0;
    public static int id_productos_tipo = 0;
    public static int id_producto = 0;
    public static boolean error;
    public static boolean error_cuenta_detalle;
    public static PreparedStatement ps;
    public static ResultSet rs;

    // -------------------------------------- Definicion de variables globales
    public static void Compras_Proveedores_cargar_datos() {

        DefaultTableModel tm = (DefaultTableModel) Compras_proveedor_buscar.jTable_proveedores.getModel();
        String id_proveedor_str = String.valueOf(tm.getValueAt(Compras_proveedor_buscar.jTable_proveedores.getSelectedRow(), 0));
        String nombre_proveedor = String.valueOf(tm.getValueAt(Compras_proveedor_buscar.jTable_proveedores.getSelectedRow(), 1));

        Compras.jT_Proveedor.setText(nombre_proveedor.trim());
        id_proveedor = Integer.parseInt(id_proveedor_str);

        Compras.jT_factura_nro.setEditable(true);
    }

    public static void Ventas_buscar_cliente_llevar_datos() {

        try {
            DefaultTableModel tm = (DefaultTableModel) Ventas_buscar_cliente.jTable_clientes.getModel();
            id_cliente = Integer.parseInt(String.valueOf(tm.getValueAt(Ventas_buscar_cliente.jTable_clientes.getSelectedRow(), 0)));
            String cliente_nombre = String.valueOf(tm.getValueAt(Ventas_buscar_cliente.jTable_clientes.getSelectedRow(), 1));

            Ventas.jT_Cliente.setText(cliente_nombre.trim());

            PreparedStatement Update2 = conexion.prepareStatement("UPDATE cuenta SET id_cliente = '" + id_cliente + "' WHERE id_cuenta ='" + id_cuenta + "'");
            Update2.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public static void Productos_delete() {
        try {
            PreparedStatement Update2 = conexion.prepareStatement(""
                    + "UPDATE productos "
                    + "SET borrado_int = '1' "
                    + "WHERE id_producto ='" + id_producto + "'");
            Update2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto eliminado.");

        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public static void Proveedores_delete() {
        try {
            PreparedStatement Update2 = conexion.prepareStatement(""
                    + "UPDATE proveedor "
                    + "SET borrado_int = '1' "
                    + "WHERE id_proveedor ='" + id_proveedor + "'");
            Update2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proveedor eliminado.");

        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public static void Productos_Proveedor_cargar_datos() {

        try {
            DefaultTableModel tm = (DefaultTableModel) Buscar_proveedores.jTable_proveedores.getModel();
            id_proveedor = Integer.parseInt(String.valueOf(tm.getValueAt(Buscar_proveedores.jTable_proveedores.getSelectedRow(), 0)));

            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM proveedor where id_proveedor = '" + id_proveedor + "'");
            if (RS.next()) {
                Proveedores.JT_Nombre.setText(RS.getString("nombre").trim());
                Proveedores.JT_Direccion.setText(RS.getString("direccion").trim());
                Proveedores.JT_Descripcion.setText(RS.getString("descripcion").trim());
                Proveedores.JT_Nombre_Vendedor.setText(RS.getString("nombre_vendedor").trim());
                Proveedores.JT_Ruc.setText(RS.getString("ruc").trim());
                Proveedores.JT_Telefono.setText(RS.getString("telefono").trim());
                Proveedores.JT_Telefono_Vendedor.setText(RS.getString("telefono_vendedor").trim());
                Proveedores.jButton_borrar.setVisible(true);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public static void Cliente_editar_cargar_datos() {

        DefaultTableModel tm = (DefaultTableModel) Buscar_cliente.jTable_clientes.getModel();
        id_cliente = Integer.parseInt(String.valueOf(tm.getValueAt(Buscar_cliente.jTable_clientes.getSelectedRow(), 0)));

        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM cliente where id_cliente = '" + id_cliente + "'");
            if (RS.next()) {
                Clientes.jt_nombre.setText(RS.getString("nombre").trim());
                Clientes.jTextField_ci.setText(RS.getString("ci").trim());
                Clientes.jt_ruc.setText(RS.getString("ruc").trim());
                Clientes.jt_direccion.setText(RS.getString("direccion").trim());
                Clientes.jt_telefono.setText(RS.getString("telefono").trim());
                Clientes.jt_email.setText(RS.getString("email").trim());
                Clientes.jDateChooser_cumpleanos.setDate(RS.getDate("cumpleanos"));
                Clientes.jt_nombre.setEditable(true);

            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public static void Buscar_proveedor_cargar_lista() {
        try {

            ps = conexion.prepareStatement(""
                    + "select * "
                    + "from proveedor "
                    + "where nombre ilike '%" + Buscar_proveedores.jT_Buscar_proveedor.getText() + "%' "
                    + " and borrado_int != '1'");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            dtm = (DefaultTableModel) Buscar_proveedores.jTable_proveedores.getModel();
            for (int j = 0; j < Buscar_proveedores.jTable_proveedores.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    if (rs.getObject(i + 1).toString().length() > 1) {
                        rows[i] = rs.getObject(i + 1).toString().trim();
                    } else {
                        rows[i] = rs.getObject(i + 1);
                    }
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) Buscar_proveedores.jTable_proveedores.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    public static void Buscar_cliente_cargar_lista() {
        try {

            ps = conexion.prepareStatement(""
                    + "select id_cliente, nombre, ci, ruc, telefono "
                    + "from cliente "
                    + "where nombre ilike '%" + Buscar_cliente.jT_Buscar.getText() + "%'");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            dtm = (DefaultTableModel) Buscar_cliente.jTable_clientes.getModel();
            for (int j = 0; j < Buscar_cliente.jTable_clientes.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    if (rs.getObject(i + 1).toString().length() > 1) {
                        rows[i] = rs.getObject(i + 1).toString().trim();
                    } else {
                        rows[i] = rs.getObject(i + 1);
                    }
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) Buscar_cliente.jTable_clientes.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    public static void Ventas_Buscar_cliente_cargar_lista() {
        try {

            ps = conexion.prepareStatement(""
                    + "select id_cliente, nombre, ci, ruc, telefono "
                    + "from cliente "
                    + "where nombre ilike '%" + Ventas_buscar_cliente.jT_Buscar.getText() + "%' and id_comercio = '" + id_comercio + "'");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            dtm = (DefaultTableModel) Ventas_buscar_cliente.jTable_clientes.getModel();
            for (int j = 0; j < Ventas_buscar_cliente.jTable_clientes.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    if (rs.getObject(i + 1).toString().length() > 1) {
                        rows[i] = rs.getObject(i + 1).toString().trim();
                    } else {
                        rows[i] = rs.getObject(i + 1);
                    }
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) Ventas_buscar_cliente.jTable_clientes.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    public static void main(String args[]) throws IOException {

        try {
            //        FileInputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream("c:/archivo.pdf");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        if (inputStream == null) {
//            return;
//        }
//
//        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
//        Doc document = new SimpleDoc(inputStream, docFormat, null);
//
//        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
//
//        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
//
//        if (defaultPrintService != null) {
//            DocPrintJob printJob = defaultPrintService.createPrintJob();
//            try {
//                printJob.print(document, attributeSet);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.err.println("No existen impresoras instaladas");
//        }
//
//        inputStream.close();
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            DocPrintJob pj = service.createPrintJob();
            String SS_Titulo = new String("pipa \n RUC: 4113625-0 Telef: 07622601222");
            byte[] bytesTitulo;
            bytesTitulo = SS_Titulo.getBytes();
            Doc IMP_Titulo = new SimpleDoc(bytesTitulo, flavor, null);
            pj.print(IMP_Titulo, null);
        } catch (PrintException ex) {
            System.err.println(ex);
        }

    }

    public static void Imprimir_ticket() {

        try {
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

            DocPrintJob pj = service.createPrintJob();
            String SS_Titulo = new String("pipa \nRUC: 4113625-0 Telef: 0761265492");
            byte[] bytesTitulo;
            bytesTitulo = SS_Titulo.getBytes();
            Doc IMP_Titulo = new SimpleDoc(bytesTitulo, flavor, null);
            pj.print(IMP_Titulo, null);

            DocPrintJob PJ_Pago = service.createPrintJob();
            String SS_Pago = new String("\nTipo de Pago: ");
            byte[] bytesPago;
            bytesPago = SS_Pago.getBytes();
            Doc IMP_Pago = new SimpleDoc(bytesPago, flavor, null);
            PJ_Pago.print(IMP_Pago, null);

            DocPrintJob PJ_Cliente = service.createPrintJob();
            String SS_Cliente = new String("\nCliente: ");
            byte[] bytesCliente;
            bytesCliente = SS_Cliente.getBytes();
            Doc IMP_cliente = new SimpleDoc(bytesCliente, flavor, null);
            PJ_Cliente.print(IMP_cliente, null);

            DocPrintJob PJ_Detalle = service.createPrintJob();
            String SS_Detalle = new String("\n ### Detalle de Venta ### - ");
            byte[] bytesDetalle;
            bytesDetalle = SS_Detalle.getBytes();
            Doc IMP_Detalle = new SimpleDoc(bytesDetalle, flavor, null);
            PJ_Detalle.print(IMP_Detalle, null);

            long total_detalle = 0;

            Statement stAuxiliar5 = conexion.createStatement();
            ResultSet rsAuxiliar5 = stAuxiliar5.executeQuery("SELECT * FROM cuenta_detalle where id_cuenta = '" + id_cuenta + "'");
            while (rsAuxiliar5.next()) {
                DocPrintJob PJ_Producto = service.createPrintJob();
                String SS_Producto = new String("\n" + rsAuxiliar5.getString("id_cuenta_detralle"));
                byte[] bytesProducto;
                bytesProducto = SS_Producto.getBytes();
                Doc IMP_Producto = new SimpleDoc(bytesProducto, flavor, null);
                PJ_Producto.print(IMP_Producto, null);
                total_detalle = (total_detalle + rsAuxiliar5.getLong("total"));
            }

            DocPrintJob PJ_Pie = service.createPrintJob();
            String SS_Pie = new String("\nTotal: " + total_detalle + " Gs.\n");
            byte[] bytesPie;
            bytesPie = SS_Pie.getBytes();
            Doc IMP_Pie = new SimpleDoc(bytesPie, flavor, null);
            PJ_Pie.print(IMP_Pie, null);

            DocPrintJob PJ_Dinero = service.createPrintJob();
            String SS_Dinero = new String("\nDinero:  Gs. Vuelto:  Gs. \nGracias por su preferencia\n\n\n\n\n\n\n'");
            byte[] bytesDinero;
            bytesDinero = SS_Dinero.getBytes();
            Doc IMP_Dinero = new SimpleDoc(bytesDinero, flavor, null);
            PJ_Dinero.print(IMP_Dinero, null);
        } catch (PrintException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Configuracion_impresion_traer_datos() {
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM configuracion where id_comercio = '" + id_comercio + "'");
            if (RS.next()) {
                Configuracion_impresion.jTextField_ultimo_numero_factura.setText(RS.getString("factura"));
                Configuracion_impresion.jTextField_timbrado.setText(RS.getString("timbrado"));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Stock_bajo() {

        String ubicacion_proyecto = new File("").getAbsolutePath();
        String path = ubicacion_proyecto + "\\reportes\\stock_bajo.jasper";

        JasperReport jr = null;

        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conexion);

            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException e) {
            System.out.println(e);
        }
    }

    public static void Cuenta_imprimir() {
        try {

            int factura = 0;

            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT max(factura) FROM configuracion where id_comercio = '" + id_comercio + "'");
            if (RS.next()) {
                factura = RS.getInt(1) + 1;
                PreparedStatement Update2 = conexion.prepareStatement(""
                        + "UPDATE configuracion "
                        + "SET factura = '" + factura + "' "
                        + "where id_comercio = '" + id_comercio + "'");
                Update2.executeUpdate();
            }

            PreparedStatement Update2 = conexion.prepareStatement("UPDATE cuenta SET print = '0' WHERE print ='1'");
            Update2.executeUpdate();

            PreparedStatement Update3 = conexion.prepareStatement(""
                    + "UPDATE cuenta "
                    + "SET print = '1', "
                    + "factura = '" + factura + "', "
                    + "dinero = '" + Ventas_Terminar.dinero + "', "
                    + "vuelto = '" + Ventas_Terminar.vuelto + "' "
                    + "WHERE id_cuenta='" + id_cuenta + "'");
            Update3.executeUpdate();

//            String ubicacion_proyecto = new File("").getAbsolutePath();
//            String path = ubicacion_proyecto + "\\reportes\\factura_con_logo.jasper";
            String path = "C:\\Sistema\\Pipas_Bar\\factura_con_logo.jasper";

            JasperReport jr = null;

            try {
                jr = (JasperReport) JRLoader.loadObjectFromFile(path);
                JasperPrint jp = JasperFillManager.fillReport(jr, null, conexion);

                JasperViewer jv = new JasperViewer(jp, false);
                jv.setVisible(true);

            } catch (JRException e) {
                System.out.println(e);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Listado_de_Productos() {

        String ubicacion_proyecto = new File("").getAbsolutePath();
        String path = ubicacion_proyecto + "\\reportes\\listado_de_productos.jasper";

        JasperReport jr = null;

        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conexion);

            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException e) {
            System.out.println(e);
        }
    }

    public static void Cuenta_actualizar_total(long total, int control) {
        try {
            long total_actual = 0;
            long total_actualizado = 0;
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM cuenta where id_cuenta = '" + id_cuenta + "'");
            if (RS.next()) {
                total_actual = RS.getLong("total");
            }

            if (control > 0) {
                total_actualizado = total_actual + total;
            }
            if (control < 0) {
                total_actualizado = total_actual - total;
            }

            String dinero_en_letras = Numero_a_String(total_actualizado);

            PreparedStatement Update2 = conexion.prepareStatement(""
                    + "UPDATE cuenta "
                    + "SET total = '" + total_actualizado + "', "
                    + "obs = '" + dinero_en_letras + "' "
                    + "WHERE id_cuenta='" + id_cuenta + "'");
            Update2.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }

    public static String Numero_a_String(long numeroINT) throws ClassNotFoundException, SQLException {

        Numero_a_Letra NumLetra = new Numero_a_Letra();
        String cantidad_string = Long.toString(numeroINT);
        String aRemplazar = NumLetra.Convertir(cantidad_string, true);
        String remplazado = aRemplazar.replace("0", "");
        return remplazado;

    }

    public static class Numero_a_Letra {

        private final String[] UNIDADES = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
        private final String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
            "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
            "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
        private final String[] CENTENAS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
            "setecientos ", "ochocientos ", "novecientos "};

        public Numero_a_Letra() {
        }

        public String Convertir(String numero, boolean mayusculas) {
            String literal = "";
            String parte_decimal;
            //si el numero utiliza (.) en lugar de (,) -> se reemplaza
            numero = numero.replace(".", ",");
            //si el numero no tiene parte decimal, se le agrega ,00
            if (numero.indexOf(",") == -1) {
                numero = numero + ",0";
            }
            //se valida formato de entrada -> 0,00 y 999 999 999,00
            if (Pattern.matches("\\d{1,9},\\d{1,2}", numero)) {
                //se divide el numero 0000000,00 -> entero y decimal
                String Num[] = numero.split(",");
                //de da formato al numero decimal
                parte_decimal = Num[1] + "";
                //se convierte el numero a literal
                if (Integer.parseInt(Num[0]) == 0) {//si el valor es cero
                    literal = "cero ";
                } else if (Integer.parseInt(Num[0]) > 999999) {//si es millon
                    literal = getMillones(Num[0]);
                } else if (Integer.parseInt(Num[0]) > 999) {//si es miles
                    literal = getMiles(Num[0]);
                } else if (Integer.parseInt(Num[0]) > 99) {//si es centena
                    literal = getCentenas(Num[0]);
                } else if (Integer.parseInt(Num[0]) > 9) {//si es decena
                    literal = getDecenas(Num[0]);
                } else {//sino unidades -> 9
                    literal = getUnidades(Num[0]);
                }
                //devuelve el resultado en mayusculas o minusculas
                if (mayusculas) {
                    return (literal + parte_decimal).toUpperCase();
                } else {
                    return (literal + parte_decimal);
                }
            } else {//error, no se puede convertir
                return literal = null;
            }
        }

        /* funciones para convertir los numeros a literales */
        private String getUnidades(String numero) {// 1 - 9
            //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
            String num = numero.substring(numero.length() - 1);
            return UNIDADES[Integer.parseInt(num)];
        }

        private String getDecenas(String num) {// 99                        
            int n = Integer.parseInt(num);
            if (n < 10) {//para casos como -> 01 - 09
                return getUnidades(num);
            } else if (n > 19) {//para 20...99
                String u = getUnidades(num);
                if (u.equals("")) { //para 20,30,40,50,60,70,80,90
                    return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
                } else {
                    return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
                }
            } else {//numeros entre 11 y 19
                return DECENAS[n - 10];
            }
        }

        private String getCentenas(String num) {// 999 o 099
            if (Integer.parseInt(num) > 99) {//es centena
                if (Integer.parseInt(num) == 100) {//caso especial
                    return " cien ";
                } else {
                    return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
                }
            } else {//por Ej. 099 
                //se quita el 0 antes de convertir a decenas
                return getDecenas(Integer.parseInt(num) + "");
            }
        }

        private String getMiles(String numero) {// 999 999
            //obtiene las centenas
            String c = numero.substring(numero.length() - 3);
            //obtiene los miles
            String m = numero.substring(0, numero.length() - 3);
            String n = "";
            //se comprueba que miles tenga valor entero
            if (Integer.parseInt(m) > 0) {
                n = getCentenas(m);
                return n + "mil " + getCentenas(c);
            } else {
                return "" + getCentenas(c);
            }

        }

        private String getMillones(String numero) { //000 000 000        
            //se obtiene los miles
            String miles = numero.substring(numero.length() - 6);
            //se obtiene los millones
            String millon = numero.substring(0, numero.length() - 6);
            String n = "";

            int mill = Integer.parseInt(millon);

            if (millon.length() > 1) {
                n = getCentenas(millon) + "millones ";
            } else {
                if (mill == 1) {
                    n = getCentenas(millon) + "millon ";
                }
                if (mill > 1) {
                    n = getCentenas(millon) + "millones ";
                }
            }

            return n + getMiles(miles);
        }
    }

    public static void Add_producto() {
        new FORMS.compras_add_producto().setVisible(true);
        DefaultTableModel tm = (DefaultTableModel) buscar_productos_en_compras.jTable_productos.getModel();
        String id = String.valueOf(tm.getValueAt(buscar_productos_en_compras.jTable_productos.getSelectedRow(), 0));
        FORMS.compras_add_producto.id_producto = Integer.parseInt(id);
        String nombre = DEV.Metodos.Producto_nombre_x_id(id);
        compras_add_producto.jTextField_Descripcion.setText(nombre);
    }

    public static void Productos_cargar_producto_en_editar() {

        try {
            DefaultTableModel tm = (DefaultTableModel) Buscar_producto.jTable1.getModel();
            id_producto = Integer.parseInt(String.valueOf(tm.getValueAt(Buscar_producto.jTable1.getSelectedRow(), 0)));

            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM productos where id_producto = '" + id_producto + "'");
            while (RS.next()) {
                Productos.producto_nombre.setText(RS.getString("nombre").trim());
                Productos.ubicacion.setText(RS.getString("ubicacion").trim());
                Productos.producto_stock_bajo.setText(RS.getString("stock_bajo"));
                Productos.producto_precio.setText(RS.getString("precio"));
                id_productos_tipo = RS.getInt("id_productos_tipo");

                Statement ST2 = conexion.createStatement();
                ResultSet RS2 = ST2.executeQuery("SELECT * FROM productos_tipo where id_productos_tipo = '" + id_productos_tipo + "'");
                while (RS2.next()) {
                    Productos.jTextField_Tipo.setText(RS2.getString("productos_tipo"));
                }
                Productos.producto_codigo.setText(RS.getString("codigo").trim());

                String proveedor_nombre = Proveedor_nombre_x_id(RS.getString("id_proveedor"));
                Productos.producto_proveedor.setText(proveedor_nombre);

                String productos_tipo = Tipo_de_producto_tipo_x_id(RS.getString("id_productos_tipo"));
                Productos.jTextField_Tipo.setText(productos_tipo);

                String iva = Productos_iva_x_id_iva(RS.getString("id_iva"));
                Productos.jTextField_iva.setText(iva);

                Productos.jDateChooser_vencimiento.setDate(RS.getDate("vencimiento_date"));

                Productos.producto_nombre.setEditable(true);

            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public synchronized static void Compras_detalle_delete() {

        try {
            DefaultTableModel tm = (DefaultTableModel) Compras.jTable1.getModel();
            String id_factura_compra_detalle = String.valueOf(tm.getValueAt(Compras.jTable1.getSelectedRow(), 0));
            String unidades = String.valueOf(tm.getValueAt(Compras.jTable1.getSelectedRow(), 2));

            long total_detalle = 0;
            long total_compra = 0;

            ResultSet RS_Productos;

            try (Statement ST_Productos = conexion.createStatement()) {
                RS_Productos = ST_Productos.executeQuery(""
                        + "SELECT * from facturas_compra_detalle "
                        + "where id_facturas_compra_detalle =  '" + id_factura_compra_detalle + "'");
                if (RS_Productos.next()) {
                    id_producto = RS_Productos.getInt("id_producto");
                    total_detalle = RS_Productos.getLong("total");
                    id_facturas_compra = RS_Productos.getInt("id_facturas_compra");
                }
            }
            try (Statement ST_Productos = conexion.createStatement()) {
                RS_Productos = ST_Productos.executeQuery(""
                        + "SELECT * from facturas_compra "
                        + "where id_facturas_compra =  '" + id_facturas_compra + "'");
                if (RS_Productos.next()) {
                    total_compra = RS_Productos.getLong("total");
                }
            }

            total_compra = total_compra - total_detalle;

            double unidades_double = Double.parseDouble(unidades);

            Productos_Update(unidades_double, id_producto, -1);

            PreparedStatement stUpdateAuxiliar2 = conexion.prepareStatement(""
                    + "delete from facturas_compra_detalle "
                    + "WHERE id_facturas_compra_detalle ='" + id_factura_compra_detalle + "'");
            stUpdateAuxiliar2.executeUpdate();

            PreparedStatement stUpdateAuxiliar4 = conexion.prepareStatement("UPDATE facturas_compra "
                    + "SET total = '" + total_compra + "' where id_facturas_compra = '" + id_facturas_compra + "'");
            stUpdateAuxiliar4.executeUpdate();

            RefreshListCompras();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static int getFacturaMax() {
        int max = 0;
        try {
            ResultSet RS_Productos;
            try (Statement ST_Productos = conexion.createStatement()) {
                RS_Productos = ST_Productos.executeQuery("SELECT MAX(id_cuenta) from cuenta where id_comercio = '" + id_comercio + "'");
                if (RS_Productos.next()) {
                    id_cuenta = RS_Productos.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
        return max;
    }

    public static void Productos_tipo_cargar_datos() {
        DefaultTableModel tm = (DefaultTableModel) Productos_Tipo_Listado.jTable_tipos.getModel();
        String id_productos_tipo_str = String.valueOf(tm.getValueAt(Productos_Tipo_Listado.jTable_tipos.getSelectedRow(), 0));
        String productos_tipo = String.valueOf(tm.getValueAt(Productos_Tipo_Listado.jTable_tipos.getSelectedRow(), 1));
        Productos.jTextField_Tipo.setText(productos_tipo.trim());
        id_productos_tipo = Integer.parseInt(id_productos_tipo_str);
    }

    public static void BuscarFactura(int valor) {
        try {

            long precio = 0;
            String nuevo = "";
            double peso;
            double real;
            double dolar;
            String peso_string = "";
            String dolar_String = "";
            String real_String = "";

            ResultSetMetaData rsm;
            DefaultTableModel dtm;

            PreparedStatement ps;
            ResultSet rs;

            error = true;

            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM cuenta_detalle where id_cuenta = '" + id_cuenta + "'");
            if (RS.next()) {
                error = false;
            }

            dtm = (DefaultTableModel) Ventas.jT_Venta_Detalle.getModel();
            for (int j = 0; j < Ventas.jT_Venta_Detalle.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }

            if (error != true) {

                ps = conexion.prepareStatement("select cuenta_detalle.id_cuenta_detalle,  "
                        + " productos.nombre, cuenta_detalle.cantidad, cuenta_detalle.precio, "
                        + "cuenta_detalle.exentas, cuenta_detalle.cinco, cuenta_detalle.diez, "
                        + "cuenta_detalle.id_producto  from cuenta_detalle inner join productos on "
                        + "productos.id_producto = cuenta_detalle.id_producto  "
                        + "where id_cuenta = '" + Metodos.id_cuenta + "' "
                        + "order by cuenta_detalle.id_cuenta_detalle DESC");
                rs = ps.executeQuery();
                rsm = rs.getMetaData();

                ArrayList<Object[]> data = new ArrayList<>();

                while (rs.next()) {

                    precio = rs.getInt("cinco") + rs.getInt("diez") + rs.getInt("exentas") + precio;

                    Object[] rows = new Object[rsm.getColumnCount()];
                    for (int i = 0; i < rows.length; i++) {
                        rows[i] = rs.getObject(i + 1);
                    }
                    data.add(rows);
                    entro = 1;
                }

                dtm = (DefaultTableModel) Ventas.jT_Venta_Detalle.getModel();
                for (int i = 0; i < data.size(); i++) {
                    dtm.addRow(data.get(i));
                }
                String strLong = Long.toString(precio);
                nuevo = DEV.Metodos.getSepararMiles(strLong);

                Ventas.total = precio;

                Statement ST_Productos = conexion.createStatement();
                ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM configuracion where id_comercio = '" + Metodos.id_comercio + "'");

                if (RS_Productos.next()) {

                    peso = precio / RS_Productos.getDouble("peso");
                    peso = Math.round(peso * 100);
                    peso = peso / 100;
                    peso_string = String.valueOf(peso);

                    dolar = precio / RS_Productos.getDouble("dolar");
                    dolar = Math.round(dolar * 100);
                    dolar = dolar / 100;
                    dolar_String = String.valueOf(dolar);

                    real = precio / RS_Productos.getDouble("real");
                    real = Math.round(real * 100);
                    real = real / 100;
                    real_String = String.valueOf(real);

                }

            }

            if (entro == 0) {

//                int numero = Integer.parseInt(jT_Factura_nro.getText());
                int numero = Metodos.id_cuenta;

                String max = String.valueOf(getFacturaMax());

                int maxi = Integer.parseInt(max);
                if (valor == 1) {
                    if (numero < maxi) {
                        numero = (numero + (valor));
//                        jT_Factura_nro.setText(String.valueOf(numero));
                        Metodos.id_cuenta = valor;
                        BuscarFactura(valor);
                    } else {
//                        jT_Factura_nro.setText(max);
                        Metodos.id_cuenta = valor;
                        BuscarFactura(0);
                    }
                }
                if (valor == -1) {
                    numero = (numero + (valor));
//                    jT_Factura_nro.setText(String.valueOf(numero));
                    Metodos.id_cuenta = valor;
                    BuscarFactura(valor);
                }
            }

            Date fecha = null;

            Statement ST_Factura = conexion.createStatement();
            ResultSet RS_Factura = ST_Factura.executeQuery("SELECT * FROM cuenta where id_cuenta = '" + Metodos.id_cuenta + "'"
                    + " and id_comercio = '" + Metodos.id_comercio + "'");
            String tipo = "";
            while (RS_Factura.next()) {
                fecha = RS_Factura.getDate("fecha_date");
                jT_Cliente.setText(DEV.Metodos.getCliente_Nombre_Q_id_cliente(RS_Factura.getInt("id_cliente")));

                Ventas.jTextField_factura.setText(RS_Factura.getString("factura"));

                if (RS_Factura.getInt("tipo") == 1) {
                    jCheckBox_Contado.setSelected(true);
                } else {
                    jCheckBox_Contado.setSelected(false);
                }

                if (RS_Factura.getInt("tipo") == 2) {
                    //  jCheckBox_Libreta.setSelected(true);
                } else {
                    //  jCheckBox_Libreta.setSelected(false);
                }
            }
            if (fecha != null) {
                jT_Fecha.setText(fecha.toString());
            }
            jT_codigo.requestFocus();

//            String total = DEV.Metodos.Ventas_Del_Dia(fecha);
//            total = DEV.Metodos.getSepararMiles(total);
//            jTextField_total_dia.setText(total);
            jT_total.setText(nuevo);
            Jt_pesos.setText(peso_string);
            jT_dolares.setText(dolar_String);
            jT_Reales.setText(real_String);

        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    public static void Tipo_de_productos_guardar() {
        error = false;
        if (Productos_tipo.jTextField_productos_tipo.getText().length() < 1) {
            JOptionPane.showMessageDialog(null, "ERROR: Ingrese el tipo de producto");
            error = true;
        }
        if (error != true) {
            try {
                int id = 0;
                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_productos_tipo) FROM productos_tipo");
                if (result.next()) {
                    id = result.getInt(1) + 1;
                }
                PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO productos_tipo VALUES(?,?,?)");
                stUpdateProducto.setInt(1, id);
                stUpdateProducto.setString(2, Productos_tipo.jTextField_productos_tipo.getText());
                stUpdateProducto.setInt(3, id_comercio);
                stUpdateProducto.executeUpdate();
                JOptionPane.showMessageDialog(producto_codigo, "Agregado correctamente");
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    public static void Usuario_guardar() {

        try {
            int id_usuario = 0;
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_usuario) FROM usuario");
            if (result.next()) {
                id_usuario = result.getInt(1) + 1;
            }

            char[] arrayC = Usuarios.jPasswordField1.getPassword();
            String pass = new String(arrayC);

            PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?,?,?)");
            stUpdateProducto.setInt(1, id_usuario);
            stUpdateProducto.setString(2, Usuarios.jTextField_usuario.getText());
            stUpdateProducto.setString(3, pass);
            stUpdateProducto.setInt(4, 1);
            stUpdateProducto.setInt(5, 1);
            stUpdateProducto.setString(6, Usuarios.jTextField_nombre_real.getText());
            stUpdateProducto.executeUpdate();
            JOptionPane.showMessageDialog(null, "Agregado correctamente");
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public static void Tipo_de_productos_cargar_lista() {
        try {
            ResultSetMetaData rsm;
            DefaultTableModel dtm;
            PreparedStatement ps;
            ResultSet rs;
            ps = DEV.Conexion.conexion.prepareStatement("SELECT id_productos_tipo, productos_tipo "
                    + "FROM productos_tipo where id_comercio = '" + id_comercio + "' order by productos_tipo");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            dtm = (DefaultTableModel) Productos_Tipo_Listado.jTable_tipos.getModel();
            for (int j = 0; j < Productos_Tipo_Listado.jTable_tipos.getRowCount(); j++) {
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
            dtm = (DefaultTableModel) Productos_Tipo_Listado.jTable_tipos.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Compras_buscar_productos_cargar_lista() {
        try {

            ps = DEV.Conexion.conexion.prepareStatement(""
                    + "SELECT id_producto, nombre "
                    + "FROM productos "
                    + "where id_comercio = '" + id_comercio + "' "
                    + "and nombre ilike '%" + Compras.jT_Buscar_Productos.getText() + "%' "
                    + "order by nombre");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            dtm = (DefaultTableModel) buscar_productos_en_compras.jTable_productos.getModel();
            for (int j = 0; j < buscar_productos_en_compras.jTable_productos.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    if (rs.getObject(i + 1).toString().length() > 0) {
                        rows[i] = rs.getObject(i + 1).toString().trim();
                    } else {
                        rows[i] = rs.getObject(i + 1);
                    }
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) buscar_productos_en_compras.jTable_productos.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Productos_buscar_productos_cargar_lista() {
        try {

            ps = DEV.Conexion.conexion.prepareStatement(""
                    + "SELECT id_producto, productos.nombre as producto_nombre, proveedor.nombre as proveedor_nombre, stock, stock_bajo, ubicacion "
                    + "FROM productos inner join proveedor on proveedor.id_proveedor = productos.id_proveedor "
                    + "where productos.id_comercio = '" + id_comercio + "' "
                    + "and productos.nombre ilike '%" + Buscar_producto.jTextField_buscar.getText() + "%' and (borrado_int != '1' or borrado_int is null) "
                    + "order by productos.nombre");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            dtm = (DefaultTableModel) Buscar_producto.jTable1.getModel();
            for (int j = 0; j < Buscar_producto.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    if (rs.getObject(i + 1).toString().length() > 0) {
                        rows[i] = rs.getObject(i + 1).toString().trim();
                    } else {
                        rows[i] = rs.getObject(i + 1);
                    }
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) Buscar_producto.jTable1.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Pedidos_buscar_productos_cargar_lista() {
        try {

            ps = DEV.Conexion.conexion.prepareStatement(""
                    + "SELECT id_producto, productos.nombre as producto_nombre, proveedor.nombre as proveedor_nombre, stock, ubicacion "
                    + "FROM productos inner join proveedor on proveedor.id_proveedor = productos.id_proveedor "
                    + "where productos.id_comercio = '" + id_comercio + "' "
                    + "and productos.nombre ilike '%" + buscar_productos_nota_pedido_interno.jTextField_buscar.getText() + "%' and (borrado_int != '1' or borrado_int is null) "
                    + "order by productos.nombre");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            dtm = (DefaultTableModel) buscar_productos_nota_pedido_interno.jTable1.getModel();
            for (int j = 0; j < buscar_productos_nota_pedido_interno.jTable1.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    if (rs.getObject(i + 1).toString().length() > 0) {
                        rows[i] = rs.getObject(i + 1).toString().trim();
                    } else {
                        rows[i] = rs.getObject(i + 1);
                    }
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) buscar_productos_nota_pedido_interno.jTable1.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Producto_Guardar() {
        if (id_producto == 0) {
            error = false;
            if (producto_nombre.getText().length() < 1) {
                JOptionPane.showMessageDialog(null, "ERROR: Ingrese un nombre");
                error = true;
            }

            if (producto_precio.getText().length() < 1) {
                JOptionPane.showMessageDialog(producto_codigo, "ERROR: Ingrese un precio");
                error = true;
            }

            if (error != true) {

                try {

                    int iva = 1;

                    int iva_str = Integer.parseInt(Productos.jTextField_iva.getText());

                    if (iva_str == 5) {
                        iva = 2;
                    }
                    if (iva_str == 0) {
                        iva = 3;
                    }

                    String precio_str = producto_precio.getText();
                    precio_str = precio_str.replace(".", "");
                    precio_str = precio_str.replace(",", "");

                    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                    String strFecha = "2007-12-25";
                    Date fecha = null;

                    fecha = formatoDelTexto.parse(strFecha);
                    boolean entro = false;
                    java.sql.Date fecha_sql_date = null;
                    if (Productos.jDateChooser_vencimiento.getDate() != null) {
                        fecha_sql_date = util_Date_to_sql_date(Productos.jDateChooser_vencimiento.getDate());
                        entro = true;
                    }

                    int stock_bajo = 0;

                    if (Productos.producto_stock_bajo.getText().length() > 1) {
                        stock_bajo = Integer.parseInt(Productos.producto_stock_bajo.getText());
                    }

                    if (Productos.jTextField_Tipo.getText().length() < 1) {
                        error = true;
                    }

                    if (Productos.producto_proveedor.getText().length() < 1) {
                        error = true;
                    }
                    if (error == false) {

                        Statement st1 = conexion.createStatement();
                        ResultSet result = st1.executeQuery("SELECT MAX(id_producto) FROM productos");
                        if (result.next()) {
                            id_producto = result.getInt(1) + 1;
                        }

                        PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                                + "INSERT INTO productos VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        stUpdateProducto.setInt(1, id_producto);
                        stUpdateProducto.setInt(2, id_proveedor);
                        stUpdateProducto.setString(3, producto_nombre.getText());
                        stUpdateProducto.setString(4, producto_codigo.getText());
                        stUpdateProducto.setInt(5, Integer.parseInt(precio_str));
                        stUpdateProducto.setInt(6, iva);
                        stUpdateProducto.setInt(7, 0);
                        stUpdateProducto.setInt(8, 0);
                        stUpdateProducto.setInt(9, stock_bajo);
                        stUpdateProducto.setString(10, ubicacion.getText());
                        stUpdateProducto.setString(11, "");
                        stUpdateProducto.setString(12, null);
                        stUpdateProducto.setInt(13, id_comercio);
                        stUpdateProducto.setString(14, null);
                        stUpdateProducto.setString(15, "---- -- --");
                        stUpdateProducto.setInt(16, 0);
                        stUpdateProducto.setInt(17, id_productos_tipo);

                        if (entro == true) {
                            stUpdateProducto.setDate(18, fecha_sql_date);
                        } else {
                            stUpdateProducto.setDate(18, null);
                        }

                        stUpdateProducto.executeUpdate();
                        Productos.producto_nombre.setEditable(false);
                        JOptionPane.showMessageDialog(null, "Producto Agregado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Complete todos los campos");
                    }

                } catch (SQLException ex) {
                    System.err.println(ex);
                } catch (ParseException ex) {
                    System.err.println(ex);
                }

            }

        } else {
            try {
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                String strFecha = "1990-01-01";
                Date fecha = null;

                fecha = formatoDelTexto.parse(strFecha);
                boolean entro = false;
                java.sql.Date fecha_sql_date = null;
                if (Productos.jDateChooser_vencimiento.getDate() != null) {
                    fecha_sql_date = util_Date_to_sql_date(Productos.jDateChooser_vencimiento.getDate());
                    entro = true;
                }

                if (entro == false) {
                    fecha_sql_date = util_Date_to_sql_date(fecha);
                }

                int iva = 1;

                int iva_str = Integer.parseInt(Productos.jTextField_iva.getText());

                if (iva_str == 5) {
                    iva = 2;
                }
                if (iva_str == 0) {
                    iva = 3;
                }

                String producto_codigo = Productos.producto_codigo.getText().trim();

                int stock_bajo = 0;

                if (Productos.producto_stock_bajo.getText().length() > 1) {
                    stock_bajo = Integer.parseInt(Productos.producto_stock_bajo.getText());
                }

                PreparedStatement stUpdateProducto;
                stUpdateProducto = conexion.prepareStatement(""
                        + "UPDATE productos SET nombre='" + Productos.producto_nombre.getText() + "', "
                        + "precio = '" + Productos.producto_precio.getText() + "', "
                        + "stock_bajo = '" + stock_bajo + "', "
                        + "codigo = '" + producto_codigo + "', "
                        + "id_iva = '" + iva + "', "
                        + "vencimiento_date = '" + fecha_sql_date + "', "
                        + "id_productos_tipo = '" + id_productos_tipo + "', "
                        + "ubicacion = '" + Productos.ubicacion.getText() + "' "
                        + "WHERE id_producto='" + id_producto + "'");
                stUpdateProducto.executeUpdate();
                JOptionPane.showMessageDialog(null, "Actualizado correctamente");

                Productos_cargar_producto_en_editar();
            } catch (SQLException | ParseException ex) {
                System.err.println(ex);
            }
        }

    }

    public static java.sql.Date util_Date_to_sql_date(Date fecha) {
        java.util.Date utilDate = fecha;
        java.sql.Date fecha_sql_date = new java.sql.Date(utilDate.getTime());
        return fecha_sql_date;
    }

    public static void RefreshListCompras() {
        DefaultTableModel modelo = (DefaultTableModel) Compras.jTable1.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        try {
            PreparedStatement ps = conexion.prepareStatement(""
                    + "select id_facturas_compra_detalle, nombre, cantidad, facturas_compra_detalle.precio, facturas_compra_detalle.total  "
                    + "from facturas_compra_detalle "
                    + "inner join productos "
                    + "on productos.id_producto = facturas_compra_detalle.id_producto "
                    + "where id_facturas_compra = '" + id_facturas_compra + "'");
            ResultSet rs = ps.executeQuery();
            rsm = rs.getMetaData();

            long total = 0;

            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                total = rs.getInt("total") + total;
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    if (rs.getObject(i + 1).toString().length() > 1) {
                        rows[i] = rs.getObject(i + 1).toString().trim();
                    } else {
                        rows[i] = rs.getObject(i + 1);
                    }
                }
                data.add(rows);
            }
            DefaultTableModel dtm = (DefaultTableModel) Compras.jTable1.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }
            String strLong = Long.toString(total);
            String nuevo = DEV.Metodos.getSepararMiles(strLong);

            // -------------- SETEAR VALORES EN FORM
            Compras.jL_Total.setText(nuevo);

        } catch (SQLException ex) {
            System.err.println("Error RefreshListCompras() " + ex);
        }
    }

    public static void Compras_Guardar() {
        try {
            Compras.jT_Buscar_Productos.setEditable(false);
            error = false;
            Statement st1 = conexion.createStatement();
            int id = 0;
            ResultSet result = st1.executeQuery("SELECT MAX(id_facturas_compra) FROM facturas_compra");
            if (result.next()) {
                id = result.getInt(1) + 1;
            }

            java.sql.Date fecha = null;
            if (Compras.jDateChooser.getDate() != null) {
                java.util.Date utilDate = Compras.jDateChooser.getDate();
                fecha = new java.sql.Date(utilDate.getTime());
            } else {
                JOptionPane.showMessageDialog(null, "ERROR: Debe ingresar una fecha");
                error = true;
            }

            if (id_proveedor == 0) {
                JOptionPane.showMessageDialog(null, "ERROR: Debe ingresar un proveedor");
                error = true;
            }

            if (Compras.jT_factura_nro.getText().length() < 1) {
                JOptionPane.showMessageDialog(null, "ERROR: Debe ingresar una factura");
                error = true;
            }

            if (error != true) {
                PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO facturas_compra VALUES(?,?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id);
                stUpdateProducto.setString(2, Compras.jT_factura_nro.getText());
                stUpdateProducto.setString(3, null);
                stUpdateProducto.setInt(4, 1);
                stUpdateProducto.setInt(5, 0);
                stUpdateProducto.setInt(6, id_proveedor);
                stUpdateProducto.setInt(7, 1);
                stUpdateProducto.setInt(8, id_comercio);
                stUpdateProducto.setDate(9, fecha);
                stUpdateProducto.executeUpdate();

                id_facturas_compra = id;

                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                Compras.jT_Buscar_Productos.setEditable(true);
                Compras.jButton_guardar.setVisible(false);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Compras_Verificar_Numero_de_Factura() {
        try {

            String numero = null;
            Compras.jT_Buscar_Productos.setEditable(false);
            Compras.jDateChooser.setDate(null);
            Compras.jButton_guardar.setVisible(true);
            id_facturas_compra = 0;

            if (jT_factura_nro.getText().length() > 1) {

                String numero_de_factura_ingresado = jT_factura_nro.getText().trim();
                numero_de_factura_ingresado = numero_de_factura_ingresado.replace("-", "");

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery(""
                        + "SELECT * FROM facturas_compra "
                        + "where id_comercio = '" + Metodos.id_comercio + "' and id_proveedor = '" + Metodos.id_proveedor + "'"
                );
                while (result.next()) {
                    numero = result.getString("numero").trim();
                    numero = numero.replace("-", "");
                    if (numero.equals(numero_de_factura_ingresado)) {
                        id_facturas_compra = result.getInt("id_facturas_compra");
                        Compras.jButton_guardar.setVisible(false);
                        Compras.jT_Buscar_Productos.setEditable(true);
                        Compras.jDateChooser.setDate(result.getDate("fecha_date"));
                        RefreshListCompras();
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Configuracion_Guardar() {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE comercio SET nombre ='" + Configuraciones.jTextField_comercio.getText() + "', "
                    + "direccion ='" + Configuraciones.jTextField_direccion.getText() + "', "
                    + "telefono ='" + Configuraciones.jTextField_telefono.getText() + "', "
                    + "ruc ='" + Configuraciones.jTextField_ruc.getText() + "', "
                    + "email ='" + Configuraciones.jTextField_email.getText() + "' "
                    + "WHERE id_comercio = '" + id_comercio + "'");
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Configuracion_impresora_guardar() {
        try {

            // convertir date
            java.sql.Date inicio = null;
            java.sql.Date vencimiento = null;

            java.util.Date utilDate = Configuracion_impresion.jDateChooser_inicio.getDate();
            inicio = new java.sql.Date(utilDate.getTime());

            java.util.Date utilDate_hasta = Configuracion_impresion.jDateChooser_vencimiento.getDate();
            vencimiento = new java.sql.Date(utilDate_hasta.getTime());

            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE configuracion SET "
                    + "timbrado ='" + Configuracion_impresion.jTextField_timbrado.getText() + "', "
                    + "timbrado_vencimiento ='" + inicio + "', "
                    + "timbrado_inicio_vigencia ='" + vencimiento + "' "
                    + "WHERE id_configuracion = '1'");
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static boolean getIngresar() {

        String nombre = jTextField1.getText();
        char[] arrayC = jPasswordField1.getPassword();
        String pass = new String(arrayC);

        boolean entro = false;

        try {

            PreparedStatement ps = conexion.prepareStatement("select * from usuario where nombre ='" + nombre + "' and contrasenha = '" + pass + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                nombre = rs.getString("nombre_real").trim();

                id_usuario = rs.getInt("id_usuario");
                id_comercio = rs.getInt("id_comercio");

                PreparedStatement ps3 = conexion.prepareStatement("select * from comercio where id_comercio = '" + id_comercio + "'");
                ResultSet rs3 = ps3.executeQuery();
                while (rs3.next()) {
                    titulo = rs3.getString("nombre").trim() + " - Usuario: " + nombre;
                    comercio = rs3.getString("nombre").trim();
                    comercio_ruc = rs3.getString("ruc").trim();
                    comercio_direccion = rs3.getString("direccion").trim();
                    comercio_telefono = rs3.getString("telefono").trim();
                    comercio_email = rs3.getString("email").trim();
                }

                new Principal().setVisible(true);
                entro = true;
                String hoy = DEV.Metodos.getHoy_format3();
                Principal.jTextField_info.setText(hoy);

            }
            if (entro == false) {
                //new Logueo().setVisible(true);
                JOptionPane.showMessageDialog(jTextField1, "Error de usuario y/o contraseña.");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return entro;
    }

    public static void Cliente_Guardar() {
        try {

            if (id_cliente == 0) {

                if (("".equals(jt_nombre.getText())) || (" ".equals(jt_nombre.getText())) || (jt_nombre.getText() == null)) {
                    JOptionPane.showMessageDialog(jt_direccion, "Ingresar el Nombre");
                } else {

                    Statement st1 = conexion.createStatement();

                    ResultSet result = st1.executeQuery("SELECT MAX(id_cliente) FROM cliente");
                    if (result.next()) {
                        id_cliente = result.getInt(1) + 1;
                    }
                    java.sql.Date cumple = null;
                    if (Clientes.jDateChooser_cumpleanos.getDate() != null) {
                        java.util.Date utilDate = Clientes.jDateChooser_cumpleanos.getDate();
                        cumple = new java.sql.Date(utilDate.getTime());
                    }
                    long ci = 0;
                    if (Clientes.jTextField_ci.getText().length() < 1) {
                        ci = 0;
                    } else {
                        ci = Long.parseLong(Clientes.jTextField_ci.getText());
                    }

                    PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO cliente VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
                    stUpdateProducto.setInt(1, id_cliente);
                    stUpdateProducto.setString(2, jt_nombre.getText());
                    stUpdateProducto.setString(3, jt_direccion.getText());
                    stUpdateProducto.setString(4, jt_telefono.getText());
                    stUpdateProducto.setString(5, "");
                    stUpdateProducto.setInt(6, 0);
                    stUpdateProducto.setString(7, jt_ruc.getText());
                    stUpdateProducto.setInt(8, id_comercio);
                    stUpdateProducto.setString(9, jt_email.getText());
                    stUpdateProducto.setInt(10, 0);
                    stUpdateProducto.setDate(11, cumple);
                    stUpdateProducto.setLong(12, ci);
                    stUpdateProducto.executeUpdate();
                    Clientes.jt_nombre.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Cliente guardado correctamente");
                }
            } else {

                if (Clientes.jDateChooser_cumpleanos.getDate() != null) {
                    java.util.Date utilDate = Clientes.jDateChooser_cumpleanos.getDate();
                    java.sql.Date cumple = new java.sql.Date(utilDate.getTime());
                    PreparedStatement st = conexion.prepareStatement(""
                            + "UPDATE cliente "
                            + "SET nombre ='" + jt_nombre.getText() + "', "
                            + "direccion ='" + jt_direccion.getText() + "', "
                            + "telefono ='" + jt_telefono.getText() + "', "
                            + "ruc ='" + jt_ruc.getText() + "', "
                            + "email = '" + jt_email.getText() + "', "
                            + "cumpleanos = '" + cumple + "', "
                            + "ci = '" + Integer.parseInt(Clientes.jTextField_ci.getText()) + "' "
                            + "WHERE id_cliente = '" + id_cliente + "'");
                    st.executeUpdate();
                    Clientes.jt_nombre.setEditable(false);
                    JOptionPane.showMessageDialog(jt_direccion, "Cliente actualizado correctamente");

                } else {

                    PreparedStatement st = conexion.prepareStatement(""
                            + "UPDATE cliente "
                            + "SET nombre ='" + jt_nombre.getText() + "', "
                            + "direccion ='" + jt_direccion.getText() + "', "
                            + "telefono ='" + jt_telefono.getText() + "', "
                            + "ruc ='" + jt_ruc.getText() + "', "
                            + "email = '" + jt_email.getText() + "', "
                            + "ci = '" + Integer.parseInt(Clientes.jTextField_ci.getText()) + "' "
                            + "WHERE id_cliente = '" + id_cliente + "'");
                    st.executeUpdate();
                    Clientes.jt_nombre.setEditable(false);
                    JOptionPane.showMessageDialog(jt_direccion, "Cliente actualizado correctamente");
                }

            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void Productos_Tipo_Cargar_Jtable() {

        try {

            ResultSetMetaData rsm;
            DefaultTableModel dtm;
            PreparedStatement ps;
            ResultSet rs;
            ps = DEV.Conexion.conexion.prepareStatement("SELECT id_productos_tipo, productos_tipo FROM productos_tipo where id_comercio = '" + id_comercio + "' and productos_tipo ilike '%" + Productos.jTextField_Tipo.getText() + "%'");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            dtm = (DefaultTableModel) Productos_Tipo_Listado.jTable_tipos.getModel();
            for (int j = 0; j < Productos_Tipo_Listado.jTable_tipos.getRowCount(); j++) {
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
            dtm = (DefaultTableModel) Productos_Tipo_Listado.jTable_tipos.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public synchronized static void Productos_Tipo_Guardar() {

        try {
            Statement st1 = conexion.createStatement();

            ResultSet result = st1.executeQuery("SELECT MAX(id_productos_tipo) FROM productos_tipo");
            if (result.next()) {
                id = result.getInt(1) + 1;
            }

            PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO productos_tipo VALUES(?,?,?)");
            stUpdateProducto.setInt(1, id);
            // stUpdateProducto.setString(2, Productos_tipo.jTextField_productos_tipo.getText());
            stUpdateProducto.setInt(3, id_comercio);
            stUpdateProducto.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    public synchronized static void Buscar_Factura_Siguiente() {
        try {

            long precio = 0;
            String nuevo = "";
            double peso = 0.0;
            double real = 0.0;
            double dolar = 0.0;
            String peso_string = "0";
            String dolar_String = "0";
            String real_String = "0";

            boolean encontrado = false;
            int max = 0;
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT MAX(id_cuenta) from cuenta where id_comercio = '" + id_comercio + "'");
            if (RS.next()) {
                max = RS.getInt("MAX");
            }

            if (id_cuenta >= max) {
                id_cuenta = max;
            }

            error = true;
            error_cuenta_detalle = true;

            Statement ST2 = conexion.createStatement();
            ResultSet RS2 = ST2.executeQuery("SELECT * FROM cuenta_detalle where id_cuenta = '" + id_cuenta + "'");
            if (RS2.next()) {
                error_cuenta_detalle = false;
            }

            DefaultTableModel dtm = (DefaultTableModel) Ventas.jT_Venta_Detalle.getModel();
            for (int j = 0; j < Ventas.jT_Venta_Detalle.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }

            if (error_cuenta_detalle == false) {

                PreparedStatement ps = conexion.prepareStatement("select cuenta_detalle.id_cuenta_detalle,   "
                        + "productos.nombre, cuenta_detalle.cantidad, cuenta_detalle.precio, cuenta_detalle.exentas, cuenta_detalle.cinco, "
                        + "cuenta_detalle.diez, cuenta_detalle.id_producto  from cuenta_detalle inner join productos "
                        + "on productos.id_producto = cuenta_detalle.id_producto  where id_cuenta = '" + id_cuenta + "' "
                        + "order by cuenta_detalle.id_cuenta_detalle DESC");
                ResultSet rs = ps.executeQuery();
                ResultSetMetaData rsm = rs.getMetaData();

                ArrayList<Object[]> data = new ArrayList<>();
                while (rs.next()) {
                    precio = rs.getInt("cinco") + rs.getInt("diez") + rs.getInt("exentas") + precio;
                    Object[] rows = new Object[rsm.getColumnCount()];
                    for (int i = 0; i < rows.length; i++) {
                        rows[i] = rs.getObject(i + 1);
                    }
                    data.add(rows);
                    encontrado = true;
                }

                if (encontrado == false) {
                    if (max > id_cuenta) {
                        id_cuenta++;
                        Buscar_Factura_Siguiente();
                    } else {
                        id_cuenta--;
                        Buscar_Factura_Siguiente();
                    }
                }

                dtm = (DefaultTableModel) Ventas.jT_Venta_Detalle.getModel();
                for (int i = 0; i < data.size(); i++) {
                    dtm.addRow(data.get(i));
                }
                String strLong = Long.toString(precio);
                nuevo = DEV.Metodos.getSepararMiles(strLong);

                Statement ST_Productos = conexion.createStatement();
                ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM configuracion where id_comercio = '" + id_comercio + "'");

                if (RS_Productos.next()) {

                    peso = precio / RS_Productos.getDouble("peso");
                    peso = Math.round(peso * 100);
                    peso = peso / 100;
                    peso_string = String.valueOf(peso);

                    dolar = precio / RS_Productos.getDouble("dolar");
                    dolar = Math.round(dolar * 100);
                    dolar = dolar / 100;
                    dolar_String = String.valueOf(dolar);

                    real = precio / RS_Productos.getDouble("real");
                    real = Math.round(real * 100);
                    real = real / 100;
                    real_String = String.valueOf(real);

                }

            }

            Date fecha = null;

            Statement ST_Factura = conexion.createStatement();
            ResultSet RS_Factura = ST_Factura.executeQuery("SELECT * FROM cuenta where id_cuenta = '" + id_cuenta + "' "
                    + "and id_comercio = '" + id_comercio + "'");
            String tipo = "";
            while (RS_Factura.next()) {
                Ventas.jTextField_factura.setText(RS_Factura.getString("factura"));
                fecha = RS_Factura.getDate("fecha_date");
                jT_Cliente.setText(DEV.Metodos.getCliente_Nombre_Q_id_cliente(RS_Factura.getInt("id_cliente")));

                if (RS_Factura.getInt("tipo") == 1) {
                    jCheckBox_Contado.setSelected(true);
                } else {
                    jCheckBox_Contado.setSelected(false);
                }

                if (RS_Factura.getInt("tipo") == 2) {
                    //  jCheckBox_Libreta.setSelected(true);
                } else {
                    // jCheckBox_Libreta.setSelected(false);
                }
            }
            if (fecha != null) {
                jT_Fecha.setText(fecha.toString());
            }
            jT_codigo.requestFocus();

//            String total = DEV.Metodos.Ventas_Del_Dia(fecha);
//            total = DEV.Metodos.getSepararMiles(total);
//            jTextField_total_dia.setText(total);
            Jt_pesos.setText(peso_string);
            jT_dolares.setText(dolar_String);
            jT_Reales.setText(real_String);
            jT_total.setText(nuevo);

//            if (id_cuenta >= max) {
//                id_cuenta--;
//                BuscarFactura(id_cuenta);
//            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    public static void Buscar_Factura_Anterior() {
        try {

            long precio = 0;
            String nuevo = "";
            double peso;
            double real;
            double dolar;
            String peso_string = "";
            String dolar_String = "";
            String real_String = "";

            boolean encontrado = false;
            error = true;
            error_cuenta_detalle = true;
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM cuenta where id_cuenta = '" + id_cuenta + "'");
            if (RS.next()) {
                error = false;
            }

            Statement ST2 = conexion.createStatement();
            ResultSet RS2 = ST2.executeQuery("SELECT * FROM cuenta_detalle where id_cuenta = '" + id_cuenta + "'");
            if (RS2.next()) {
                error_cuenta_detalle = false;
            }
            if (id_cuenta < 1) {
                id_cuenta++;
            }

            if ((error == false) || (error_cuenta_detalle == false)) {

                DefaultTableModel dtm = (DefaultTableModel) Ventas.jT_Venta_Detalle.getModel();
                for (int j = 0; j < Ventas.jT_Venta_Detalle.getRowCount(); j++) {
                    dtm.removeRow(j);
                    j -= 1;
                }
                PreparedStatement ps = conexion.prepareStatement("select cuenta_detalle.id_cuenta_detalle,  "
                        + "productos.nombre,  cuenta_detalle.cantidad, cuenta_detalle.precio, cuenta_detalle.exentas, cuenta_detalle.cinco, "
                        + "cuenta_detalle.diez, cuenta_detalle.id_producto  from cuenta_detalle inner join productos "
                        + "on productos.id_producto = cuenta_detalle.id_producto  where id_cuenta = '" + id_cuenta + "' "
                        + "and id_comercio = '" + id_comercio + "' order by cuenta_detalle.id_cuenta_detalle DESC");
                ResultSet rs = ps.executeQuery();
                ResultSetMetaData rsm = rs.getMetaData();

                ArrayList<Object[]> data = new ArrayList<>();
                while (rs.next()) {
                    precio = rs.getInt("cinco") + rs.getInt("diez") + rs.getInt("exentas") + precio;
                    Object[] rows = new Object[rsm.getColumnCount()];
                    for (int i = 0; i < rows.length; i++) {
                        rows[i] = rs.getObject(i + 1);
                    }
                    data.add(rows);
                }

                dtm = (DefaultTableModel) Ventas.jT_Venta_Detalle.getModel();
                for (int i = 0; i < data.size(); i++) {
                    dtm.addRow(data.get(i));
                }
                String strLong = Long.toString(precio);
                nuevo = DEV.Metodos.getSepararMiles(strLong);

                Statement ST_Productos = conexion.createStatement();
                ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM configuracion where id_comercio = '" + id_comercio + "'");

                if (RS_Productos.next()) {

                    peso = precio / RS_Productos.getDouble("peso");
                    peso = Math.round(peso * 100);
                    peso = peso / 100;
                    peso_string = String.valueOf(peso);

                    dolar = precio / RS_Productos.getDouble("dolar");
                    dolar = Math.round(dolar * 100);
                    dolar = dolar / 100;
                    dolar_String = String.valueOf(dolar);

                    real = precio / RS_Productos.getDouble("real");
                    real = Math.round(real * 100);
                    real = real / 100;
                    real_String = String.valueOf(real);

                }
                Date fecha = null;

                Statement ST_Factura = conexion.createStatement();
                ResultSet RS_Factura = ST_Factura.executeQuery("SELECT * FROM cuenta where id_cuenta = '" + id_cuenta + "' "
                        + "and id_comercio = '" + id_comercio + "'");
                while (RS_Factura.next()) {
                    Ventas.jTextField_factura.setText(RS_Factura.getString("factura"));
                    fecha = RS_Factura.getDate("fecha_date");
                    jT_Cliente.setText(DEV.Metodos.getCliente_Nombre_Q_id_cliente(RS_Factura.getInt("id_cliente")));

                    if (RS_Factura.getInt("tipo") == 1) {
                        jCheckBox_Contado.setSelected(true);
                    } else {
                        jCheckBox_Contado.setSelected(false);
                    }

                    if (RS_Factura.getInt("tipo") == 2) {
                        // jCheckBox_Libreta.setSelected(true);
                    } else {
                        //  jCheckBox_Libreta.setSelected(false);
                    }
                }
                if (fecha != null) {
                    jT_Fecha.setText(fecha.toString());
                }
                jT_codigo.requestFocus();

//                String total = DEV.Metodos.Ventas_Del_Dia(fecha);
//                total = DEV.Metodos.getSepararMiles(total);
//                jTextField_total_dia.setText(total);
                jT_total.setText(nuevo);
                Jt_pesos.setText(peso_string);
                jT_dolares.setText(dolar_String);
                jT_Reales.setText(real_String);

            }

        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    public static String getHoy_format2() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String hoy = ft.format(dNow);
        return hoy;
    }

    public static String Compras_MAX() {

        String dato = "";
        try {
            Statement ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT max(id_facturas_compra)"
                    + " FROM facturas_compra where id_comercio = '" + id_comercio + "'");
            while (RS_Productos.next()) {
                dato = RS_Productos.getString("max");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return dato;
    }

    public static void Nueva_Compra() {
        try {
            Statement st1;
            st1 = conexion.createStatement();
            int id = 0;
            ResultSet result = st1.executeQuery("SELECT MAX(id_facturas_compra) FROM facturas_compra");
            if (result.next()) {
                id = result.getInt(1) + 1;
            }

            String fecha = DEV.Metodos.getHoy_format1();

            PreparedStatement stUpdateAuxiliar = conexion.prepareStatement("UPDATE facturas_compra SET activo='0' WHERE activo='1' and id_comercio = '" + Metodos.id_comercio + "' ");
            stUpdateAuxiliar.executeUpdate();

            PreparedStatement st2 = conexion.prepareStatement("INSERT INTO facturas_compra VALUES(?,?,?,?,?,?,?,?)");
            st2.setInt(1, id);
            st2.setString(2, "");
            st2.setString(3, fecha);
            st2.setInt(4, 0);
            st2.setInt(5, 0);
            st2.setInt(6, 1);
            st2.setInt(7, 1);
            st2.setInt(8, Metodos.id_comercio);
            id_factura = id;

            st2.executeUpdate();

            RefreshListCompras();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Proveedor_Buscar() {
        try {
            ResultSetMetaData rsm;
            DefaultTableModel dtm;
            PreparedStatement ps;
            ResultSet rs;
            ps = DEV.Conexion.conexion.prepareStatement("select id_proveedor, nombre "
                    + "from proveedor where nombre ilike '%" + Compras_proveedor_buscar.jTextField_Buscar_proveedor.getText() + "%'");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            dtm = (DefaultTableModel) Compras_proveedor_buscar.jTable_proveedores.getModel();
            for (int j = 0; j < Compras_proveedor_buscar.jTable_proveedores.getRowCount(); j++) {
                dtm.removeRow(j);
                j -= 1;
            }
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    if (rs.getObject(i + 1) != null) {
                        rows[i] = rs.getObject(i + 1).toString().trim();
                    } else {
                        rows[i] = rs.getObject(i + 1);
                    }
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) Compras_proveedor_buscar.jTable_proveedores.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    public static String getHoy_format3() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String hoy = ft.format(dNow);
        return hoy;
    }

    public static String getHoy_format1() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String hoy = ft.format(dNow);
        return hoy;
    }
//    public static Date getHoy_format_date() {
//        Date dNow = new Date();
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//        String hoy = ft.format(dNow);
//        return hoy;
//    }

    public static String Ventas_Del_Dia(String dia) {
        long total_long = 0;
        dia = dia.substring(0, 10);
        try {

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cuenta where fecha >= '" + dia + " "
                    + "00:00:00' and fecha <= '" + dia + " 24:59:59' and id_comercio = '" + id_comercio + "'");
            while (rs.next()) {

                Statement st2 = conexion.createStatement();
                ResultSet rs2 = st2.executeQuery("SELECT * FROM cuenta_detalle where id_cuenta = '" + rs.getInt("id_cuenta") + "' ");
                while (rs2.next()) {
                    total_long = rs2.getLong("diez") + rs2.getLong("cinco") + rs2.getLong("exentas") + total_long;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return String.valueOf(total_long);
    }

    public static int getLibreta() {

        int lib = 0;
        Statement stAuxiliar5;
        try {

            stAuxiliar5 = conexion.createStatement();
            ResultSet rsAuxiliar5 = stAuxiliar5.executeQuery("SELECT * FROM configuracion where id_comercio = '" + id_comercio + "'");
            while (rsAuxiliar5.next()) {
                lib = rsAuxiliar5.getInt("libreta");
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return lib;
    }

    public static String getCliente_Nombre_Q_id_cliente(int id_cliente) {

        String nombre = "";
        Statement stAuxiliar5;
        try {
            stAuxiliar5 = conexion.createStatement();
            ResultSet rsAuxiliar5 = stAuxiliar5.executeQuery("SELECT * FROM cliente where id_cliente = '" + id_cliente + "'");
            while (rsAuxiliar5.next()) {
                nombre = rsAuxiliar5.getString("nombre").trim();
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return nombre;
    }

    public static String getSepararMiles(String txtprec) {
        String valor = txtprec;

        int largo = valor.length();
        if (largo > 8) {
            valor = valor.substring(largo - 9, largo - 6) + "." + valor.substring(largo - 6, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 7) {
            valor = valor.substring(largo - 8, largo - 6) + "." + valor.substring(largo - 6, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 6) {
            valor = valor.substring(largo - 7, largo - 6) + "." + valor.substring(largo - 6, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 5) {
            valor = valor.substring(largo - 6, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 4) {
            valor = valor.substring(largo - 5, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 3) {
            valor = valor.substring(largo - 4, largo - 3) + "." + valor.substring(largo - 3, largo);
        }
        txtprec = valor;
        return valor;
    }

    public synchronized static void ventaNuevo() {
        try {
            Statement stCuenta = conexion.createStatement();
            ResultSet rsCuentaSelectId = stCuenta.executeQuery("SELECT MAX(id_cuenta) FROM cuenta");
            if (rsCuentaSelectId.next()) {
                id_cuenta = rsCuentaSelectId.getInt(1) + 1;
            }

//            String hoy = getHoy_format1();
            Date hoy = new Date();
            java.sql.Date fecha_sql_date = util_Date_to_sql_date(hoy);

            PreparedStatement stCuentaGuardar = conexion.prepareStatement("INSERT INTO cuenta VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stCuentaGuardar.setInt(1, id_cuenta);
            stCuentaGuardar.setInt(2, 1);
            stCuentaGuardar.setInt(3, 1);
            stCuentaGuardar.setDouble(4, 0);
            stCuentaGuardar.setString(5, "---- -- --");
            stCuentaGuardar.setString(6, "ninguna");
            stCuentaGuardar.setLong(7, 0);
            stCuentaGuardar.setLong(8, 0);
            stCuentaGuardar.setLong(9, 0);
            stCuentaGuardar.setLong(10, 0);
            stCuentaGuardar.setString(11, "");
            stCuentaGuardar.setString(12, "");
            stCuentaGuardar.setInt(13, Logueo.id_usuario);
            stCuentaGuardar.setInt(14, 0);
            stCuentaGuardar.setInt(15, id_comercio);
            stCuentaGuardar.setInt(16, 1);
            stCuentaGuardar.setDate(17, fecha_sql_date);
            stCuentaGuardar.executeUpdate();

            Metodos.BuscarFactura(0);

        } catch (NumberFormatException | SQLException e) {
            System.err.println("Error en JavaConnection -> VentaNuevo() -> " + e);
        }

        Ventas.jT_codigo.setText("");
        Ventas.jT_codigo.requestFocus();
    }

    public static String Producto_nombre_x_id(String id) {
        String nombre = null;
        try {
            Statement ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM productos where id_producto = '" + id + "'");
            while (RS_Productos.next()) {
                nombre = RS_Productos.getString("nombre").trim();
            }

        } catch (SQLException ex) {
            System.err.println("Error en: Producto_nombre_x_id() " + ex);
        }
        return nombre;
    }

    public static String Producto_nombre_x_id_venta_detalle(String id_venta_detalle) {
        String nombre = null;
        try {

            Statement ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM cuenta_detalle where id_cuenta_detalle = '" + id_venta_detalle + "'");
            while (RS_Productos.next()) {

                Statement ST_Productos2 = conexion.createStatement();
                ResultSet RS_Productos2 = ST_Productos2.executeQuery("SELECT * FROM productos where id_producto = '" + RS_Productos.getInt("id_producto") + "'");
                while (RS_Productos2.next()) {
                    nombre = RS_Productos2.getString("nombre").trim();
                }
            }

        } catch (SQLException ex) {
            System.err.println("Error en: Producto_nombre_x_id() " + ex);
        }
        return nombre;
    }

    public static String Producto_id_producto_x_id_venta_detalle(String id_venta_detalle) {
        String dato = null;
        try {

            Statement ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM cuenta_detalle where id_cuenta_detalle = '" + id_venta_detalle + "'");
            while (RS_Productos.next()) {

                dato = RS_Productos.getString("id_producto");
            }

        } catch (SQLException ex) {
            System.err.println("Error en: Producto_nombre_x_id() " + ex);
        }
        return dato;
    }

    public static String Producto_precio_x_id_venta_detalle(String id_venta_detalle) {
        String dato = null;
        try {

            Statement ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM cuenta_detalle where id_cuenta_detalle = '" + id_venta_detalle + "'");
            while (RS_Productos.next()) {
                dato = RS_Productos.getString("precio");
            }

        } catch (SQLException ex) {
            System.err.println("Error en: Producto_nombre_x_id() " + ex);
        }
        return dato;
    }

    public static String Proveedor_nombre_x_id(String id) {
        String nombre = null;
        try {
            Statement ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM proveedor where id_proveedor = '" + id + "'");
            while (RS_Productos.next()) {
                nombre = RS_Productos.getString("nombre").trim();
            }

        } catch (SQLException ex) {
            System.err.println("Error en: Proveedor_nombre_x_id() " + ex);
        }
        return nombre;
    }

    public static String Tipo_de_producto_tipo_x_id(String id_productos_tipo) {
        String nombre = null;
        try {
            Statement ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM productos_tipo where id_productos_tipo = '" + id_productos_tipo + "'");
            while (RS_Productos.next()) {
                nombre = RS_Productos.getString("productos_tipo").trim();
            }
        } catch (SQLException ex) {
            System.err.println("Error en: Tipo_de_producto_tipo_x_id() " + ex);
        }
        return nombre;
    }

    public static String Productos_iva_x_id_iva(String id_iva) {
        String nombre = null;
        try {
            Statement ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM iva where id_iva = '" + id_iva + "'");
            while (RS_Productos.next()) {
                nombre = RS_Productos.getString("int").trim();
            }
        } catch (SQLException ex) {
            System.err.println("Error en: Tipo_de_producto_tipo_x_id() " + ex);
        }
        return nombre;
    }

    public static void Productos_Update(double unidades, int id_producto, int mas_menos) {
        try {
            Statement ST_Productos;
            ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM productos where id_producto = '" + id_producto + "'");
            while (RS_Productos.next()) {
                if (mas_menos < 0) {
                    unidades = RS_Productos.getDouble("stock") - unidades;
                }
                if (mas_menos > 0) {
                    unidades = RS_Productos.getDouble("stock") + unidades;
                }
            }
            PreparedStatement stUpdateAuxiliar = conexion.prepareStatement("UPDATE productos SET stock = '" + unidades + "' where id_producto = '" + id_producto + "'");
            stUpdateAuxiliar.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error en productos update: " + ex);
        }
    }

    public static int Obtener_id_producto_desde_id_cuenta_detalle(int id_cuenta_detalle) {
        int id = 0;
        try {
            Statement ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM cuenta_detalle where id_cuenta_detalle = '" + id_cuenta_detalle + "'");
            while (RS_Productos.next()) {
                id = RS_Productos.getInt("id_producto");
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
        return id;
    }

    public static int Obtener_unidades_desde_id_cuenta_detalle(int id_cuenta_detalle) {
        int id = 0;
        try {
            Statement ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("SELECT * FROM cuenta_detalle where id_cuenta_detalle = '" + id_cuenta_detalle + "'");
            while (RS_Productos.next()) {
                id = RS_Productos.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
        return id;
    }

    public static String Fecha_yyyymmdd_to_ddmmyyyy(Date fecha) {
        SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd-MM-YYYY");
        String fecha_string = ddMMyyyy.format(fecha);
        return fecha_string;
    }

}
