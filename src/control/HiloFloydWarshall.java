package control;

import modelo.Graph;
import modelo.Floyd_Warshall;

/**
 * @author Juan Manuel Reyes <juan.reyes@correounivalle.edu.co>
 */
public class HiloFloydWarshall extends Thread {

    private Floyd_Warshall floyd = new Floyd_Warshall();
    private Graph grafo = new Graph();
    private String reporte = "";

    public HiloFloydWarshall(Graph gafo) {
        this.grafo = grafo;
    }

    public void run() {
        this.reporte = floyd.reporte(grafo);
    }

    public String getReporte() {
        return reporte;
    }

    
    
}
