/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEV;

import java.awt.*;

/**
 *
 * @author user
 */
public class Impresora {

    Font fuente = new Font("Dialog", Font.PLAIN, 10);
    PrintJob pj;
    Graphics pagina;

    public Impresora() {
        pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
    }

    public void imprimir(String Cadena) {

        try {
            pagina = pj.getGraphics();
            pagina.setFont(fuente);
            pagina.setColor(Color.black);

            pagina.drawString(Cadena, 60, 60);

            pagina.dispose();
            pj.end();
        } catch (Exception e) {
            System.out.println("LA IMPRESION HA SIDO CANCELADA...");
        }
    }

}
