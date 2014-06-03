/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Dijkstra;
import modelo.Graph;

/**
 *
 * @author Portatil1
 */
public class HiloDijkstra extends Thread{
    private Dijkstra dijks = new Dijkstra();
    private Graph grafo = new Graph();;
    private String reporte = "";
    
    public HiloDijkstra(Graph grafo) {
        
        this.grafo = grafo;
    }
    
    public void run() {
        this.reporte += dijks.reporte(grafo);
        System.out.println(grafo.getVertices());
        System.out.println("hola");
        System.out.println(reporte);
    }

    public String getReporte() {
        return reporte;
    }

    
    
}
