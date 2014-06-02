package control;

import modelo.Graph;
import modelo.Floyd_Warshall;

/**
 * @author Juan Manuel Reyes <juan.reyes@correounivalle.edu.co>
 */
public class HiloFloydWarshall extends Thread {

    private Floyd_Warshall floyd;
    private Graph grafo;

    public HiloFloydWarshall(Graph gafo) {
        this.grafo = grafo;
    }

    public void run() {
        String[][] caminos = floyd.GenerarMatrizCaminos(grafo);
        Integer[][] adyacencia = floyd.generarMatrizAdyacencia(grafo);
        floyd.algoritmoFloydWarshall(adyacencia, caminos);
        System.out.println("");
    }
}
