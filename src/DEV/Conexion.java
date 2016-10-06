package DEV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import FORMS.Logueo;

public class Conexion {

    public static Connection conexion = null;

    public static void Iniciar_Conexion() {
        try {
            try {
//                String db = "pipas_bar";
//                String db = "comercios";
//                String db = "mca"; // 4k; del campo
                String db = "seguro_medico_solidario"; // 4k; del campo
//                String db = "mca_novedades";
                String host = "localhost"; // host en el servidor del cliente
//                String host = "190.104.167.162"; // Host 4k

                Class.forName("org.postgresql.Driver");
                conexion = DriverManager.getConnection("jdbc:postgresql://" + host + ":5432/" + db + "", "postgres", "postgres");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al iniciar la conexion con la base de datos.");
                System.exit(-1);
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(Logueo.jTextField1, ex);
            System.exit(-1);
        }
    }

    public static void Cerrar_Conexion() {
        try {
            conexion.close();
            System.err.println("Conexion finalizada");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    static PreparedStatement prepareStatement(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
