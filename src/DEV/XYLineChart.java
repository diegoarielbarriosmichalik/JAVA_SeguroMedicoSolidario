package DEV;

import static DEV.Conexion.conexion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Dell
 */
public class XYLineChart extends ImageIcon {

    public XYLineChart(Dimension d) {

        //se declara el grafico XY Lineal
        XYDataset xydataset = xyDataset();
        JFreeChart jfreechart = ChartFactory.createXYLineChart(
                "", "2016", "",
                xydataset, PlotOrientation.VERTICAL, true, true, false);

        //personalización del grafico
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.white);
        xyplot.setDomainGridlinePaint(Color.BLACK);
        xyplot.setRangeGridlinePaint(Color.BLACK);
        // -> Pinta Shapes en los puntos dados por el XYDataset
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();
        xylineandshaperenderer.setBaseShapesVisible(true);
        //--> muestra los valores de cada punto XY
        XYItemLabelGenerator xy = new StandardXYItemLabelGenerator();
        xylineandshaperenderer.setBaseItemLabelGenerator(xy);
        xylineandshaperenderer.setBaseItemLabelsVisible(true);
        xylineandshaperenderer.setBaseLinesVisible(true);
        xylineandshaperenderer.setBaseItemLabelsVisible(true);
        //fin de personalización

        //se crea la imagen y se asigna a la clase ImageIcon
        BufferedImage bufferedImage = jfreechart.createBufferedImage(d.width, d.height);
        this.setImage(bufferedImage);
    }

    public static long enero_ventas = 0;
    public static long febrero_ventas = 0;
    public static long marzo_ventas = 0;
    public static long agosto_ventas = 0;
    public static long setiembre_ventas = 0;
    public static long octubre_ventas = 0;
    public static long noviembre_ventas = 0;
    public static long diciembre_ventas = 0;
    
    public static String mes_desde = "";
    public static String mes_hasta = "";

    public static void Enero_ventas() {
        try {
            mes_desde = "2016-01-01";
            mes_hasta = "2016-01-31";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(total) FROM cuenta where fecha_date >= '" + mes_desde + " "
                    + "' and fecha_date <= '" + mes_hasta + "' and id_comercio = '" + Metodos.id_comercio + "'");
            while (rs.next()) {
                enero_ventas = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Febrero_ventas() {
        try {
            mes_desde = "2016-02-01";
            mes_hasta = "2016-02-28";

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(total) FROM cuenta where fecha_date >= '" + mes_desde + " "
                    + "' and fecha_date <= '" + mes_hasta + "' and id_comercio = '" + Metodos.id_comercio + "'");
            while (rs.next()) {
                febrero_ventas = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    public static void Marzo_ventas() {
        try {
            mes_desde = "2016-03-01";
            mes_hasta = "2016-03-31";

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(total) FROM cuenta where fecha_date >= '" + mes_desde + " "
                    + "' and fecha_date <= '" + mes_hasta + "' and id_comercio = '" + Metodos.id_comercio + "'");
            while (rs.next()) {
                marzo_ventas = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    public static void Agosto_ventas() {
        try {
            mes_desde = "2016-08-01";
            mes_hasta = "2016-08-31";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(total) FROM cuenta where fecha_date >= '" + mes_desde + " "
                    + "' and fecha_date <= '" + mes_hasta + "' and id_comercio = '" + Metodos.id_comercio + "'");
            while (rs.next()) {
                agosto_ventas = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    public static void Setiembre_ventas() {
        try {
            mes_desde = "2016-09-01";
            mes_hasta = "2016-09-30";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(total) FROM cuenta where fecha_date >= '" + mes_desde + " "
                    + "' and fecha_date <= '" + mes_hasta + "' and id_comercio = '" + Metodos.id_comercio + "'");
            while (rs.next()) {
                setiembre_ventas = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Datos
     */
    private XYDataset xyDataset() {

        Enero_ventas();
        Febrero_ventas();
        Marzo_ventas();
        Agosto_ventas();
        Setiembre_ventas();

        //se declaran las series y se llenan los datos
        XYSeries sIngresos = new XYSeries("Compras");
        XYSeries sEgresos = new XYSeries("Ventas");
        //serie #1
        sIngresos.add(1, 0);
        sIngresos.add(2, 0);
        sIngresos.add(3, 0);
        sIngresos.add(4, 0);
        sIngresos.add(5, 0);
        sIngresos.add(6, 0);
        sIngresos.add(7, 0);
        sIngresos.add(8, 0);
        sIngresos.add(9, 0);
        sIngresos.add(10, 0);
        sIngresos.add(11, 0);
        sIngresos.add(12, 0);

        //serie #2
        sEgresos.add(1, enero_ventas);
        sEgresos.add(2, febrero_ventas);
        sEgresos.add(3, marzo_ventas);
        sEgresos.add(4, 0);
        sEgresos.add(5, 0);
        sEgresos.add(6, 0);
        sEgresos.add(7, 0);
        sEgresos.add(8, agosto_ventas);
        sEgresos.add(9, setiembre_ventas);
        sEgresos.add(10, 0);
        sEgresos.add(11, 0);
        sEgresos.add(12, 0);

        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(sIngresos);
        xyseriescollection.addSeries(sEgresos);

        return xyseriescollection;
    }

}
