/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import vista.ventana;

/**
 *
 * @author Portatil1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        vista.ventana app = new ventana();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }
}
