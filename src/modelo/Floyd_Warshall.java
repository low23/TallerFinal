/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.IEdge;
import control.IGraph;
import control.IVertex;
import java.util.ArrayList;

/**
 *
 * @author Torres
 */
public class Floyd_Warshall {

    public Integer[][] generarMatrizAdyacencia(Graph grafo) {

        ArrayList<IEdge> edges = new ArrayList<>(grafo.getEdges());

        ArrayList<IVertex> vertices = new ArrayList<>(grafo.getVertices());

        Integer[][] MatrizAdyacencia = new Integer[vertices.size()][vertices.size()];
        for (IEdge aristas : edges) {
            MatrizAdyacencia[vertices.indexOf(aristas.getInitialVertex())][vertices.indexOf(aristas.getTerminalVertex())] = (int) aristas.getWeight();
            MatrizAdyacencia[vertices.indexOf(aristas.getTerminalVertex())][vertices.indexOf(aristas.getInitialVertex())] = (int) aristas.getWeight();
        }
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                if (i == j) {
                    MatrizAdyacencia[i][j] = 0;
                }
                if (MatrizAdyacencia[i][j] == null) {
//                    MatrizAdyacencia[i][j] = Integer.MAX_VALUE/2;
                    MatrizAdyacencia[i][j] = 9999;
                }
            }
        }
        return MatrizAdyacencia;
    }

    public String[][] GenerarMatrizCaminos(Graph grafo) {
        ArrayList<IEdge> edges = new ArrayList<>(grafo.getEdges());

        ArrayList<IVertex> vertices = new ArrayList<>(grafo.getVertices());

        String[][] MatrizRutas = new String[vertices.size()][vertices.size()];

        for (IEdge arista : edges) {
            int i = vertices.indexOf(arista.getInitialVertex());
            int j = vertices.indexOf(arista.getTerminalVertex());
            //Por Strings
            MatrizRutas[i][j] = vertices.get(i).getLabel() + "-" + vertices.get(j).getLabel();
            MatrizRutas[j][i] = vertices.get(i).getLabel() + "-" + vertices.get(j).getLabel();

//                    Por aristas            
//            MatrizRutas[vertices.indexOf(arista.getTerminalVertex())]
//                    [vertices.indexOf(arista.getInitialVertex())] = 
//                    arista;
        }

        for (int i = 0; i < MatrizRutas.length; i++) {
            for (int j = 0; j < MatrizRutas.length; j++) {
                if (i == j) {
                    MatrizRutas[i][j] = vertices.get(i).getLabel();
                }
                if (MatrizRutas[i][j] == null) {
                    MatrizRutas[i][j] = "Ø";
                }
            }
        }
        return MatrizRutas;
    }

    public void algoritmoFloydWarshall(Integer[][] MatrizPesos, String[][] Caminos) {
//    public void algoritmoFloydWarshall(Integer[][] adyacencia, String[][] Caminos) {

        for (int i = 0; i < MatrizPesos.length ; i++) {
            for (int j = 0; j < MatrizPesos.length ; j++) {
                for (int k = 0; k < MatrizPesos.length ; k++) {
                    int suma = MatrizPesos[i][k] + MatrizPesos[j][i];
                    String ruta = Caminos[i][k] + "_" + Caminos[j][i];
                    if(MatrizPesos[j][k] > suma){
                        MatrizPesos[j][k] = suma;
                        MatrizPesos[k][j] = suma;
                        
                        Caminos[j][k] = ruta;
                        Caminos[k][j] = ruta;
                    }
                }
            }

        }

    }

    public static void main(String args[]) {
        Floyd_Warshall app = new Floyd_Warshall();
        Graph myGraph = new Graph(false, true);
//      Grafo grande de prueba
        Vertex a = new Vertex("Cali");
        Vertex b = new Vertex("Bogota");
        Vertex c = new Vertex("Manizales");
        Vertex d = new Vertex("Medellin");
        Vertex e = new Vertex("Pereira"); 

        myGraph.addEdge(a, b, 6);
        myGraph.addEdge(b, c, 3);
        myGraph.addEdge(c, d, 2);
        myGraph.addEdge(d, b, 4);

//        myGraph.addVertex(e);
//        JFrame gw = CLDGraph.draw(myGraph);
//        JOptionPane.showMessageDialog(null, "Ahora agregaremos mas aristas y nodos.");
        Vertex f = new Vertex("Barranquilla");
        Vertex g = new Vertex("Cartagena");

        myGraph.addEdge(f, e, 9);
        myGraph.addEdge(g, a, 11);
        myGraph.addEdge(e, c, 1);
        myGraph.addEdge(g, d, 6);
        myGraph.addEdge(a, e, 3);
//        //Grafo pequeño de prueba
//        Vertex a = new Vertex("Cali");
//        Vertex b = new Vertex("Bogota");
//        Vertex c = new Vertex("Manizales");
//        Vertex d = new Vertex("Medellin");
//        
//        myGraph.addEdge(a, b, 6);
//        myGraph.addEdge(b, c, 3);
//        myGraph.addEdge(a, d, 7);

        Integer[][] ab = app.generarMatrizAdyacencia(myGraph);
        String[][] bc = app.GenerarMatrizCaminos(myGraph);
        for (int i = 0; i < ab.length; i++) {
            for (int j = 0; j < ab.length; j++) {
                System.out.print(ab[i][j] + ", ");
            }
            System.out.println("");
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < bc.length; i++) {
            for (int j = 0; j < bc.length; j++) {
                System.out.print(bc[i][j] + "||");
            }
            System.out.println("");
        }
        
        app.algoritmoFloydWarshall(ab, bc);
        
       
        for (int i = 0; i < ab.length; i++) {
            for (int j = 0; j < ab.length; j++) {
                System.out.print(ab[i][j] + ", ");
            }
            System.out.println("");
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < bc.length; i++) {
            for (int j = 0; j < bc.length; j++) {
                System.out.print(bc[i][j] + "||");
            }
            System.out.println("");
        }
    }
}
