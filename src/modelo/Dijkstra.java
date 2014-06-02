/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.IEdge;
import control.IVertex;
import java.util.ArrayList;

/**
 *
 * @author Torres
 */
public class Dijkstra {

    public String[][] caminos;
    public Integer[][] matrizPesos;

//    public Dijkstra(Graph grafo) {
//        this.caminos = GenerarMatrizCaminos(grafo);
//        this.matrizPesos = generarMatrizAdyacencia(grafo);
//    }
    public String[][] getCaminos() {
        return caminos;
    }

    public Integer[][] getMatrizAdyacencia() {
        return matrizPesos;
    }

    public void DijkstraParaTodos(Graph grafo) {

        ArrayList<IVertex> vertices = new ArrayList<>(grafo.getVertices());

        if (vertices.size() > 0) {

            for (IVertex vertice : vertices) {

                algoritmoDijkstra(grafo, vertice);
            }
        }
    }

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
                    MatrizAdyacencia[i][j] = Integer.MAX_VALUE;
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
            MatrizRutas[i][j] = vertices.get(i).getLabel() + "<->" + vertices.get(j).getLabel();
            MatrizRutas[j][i] = vertices.get(i).getLabel() + "<->" + vertices.get(j).getLabel();

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

    public void algoritmoDijkstra(Graph Grafo, IVertex vertice) {

        ArrayList<IEdge> edges = new ArrayList<>(Grafo.getEdges());

        ArrayList<IVertex> vertices = new ArrayList<>(Grafo.getVertices());

        Integer a = vertices.indexOf(vertice);

        matrizPesos[a][a] = 0;
        caminos[a][a] = vertices.get(a).getLabel();
        ArrayList<IVertex> S = new ArrayList<>(vertices.size());

        while (S.size() != vertices.size()) {

            int u = 0;
            int menor = Integer.MAX_VALUE;
            for (int i = 0; i < vertices.size(); i++) {
                if (!S.contains(vertices.get(i)) && menor > matrizPesos[a][i]) {
                    menor = matrizPesos[a][i];
                    u = i;
                }
            }
            S.add(vertices.get(u));
            for (int v = 0; v < vertices.size(); v++) {
//                int v = j;
                if (!S.contains(vertices.get(v))) {
                    IEdge w = new Edge(new Vertex(""), new Vertex(""), Integer.MAX_VALUE);

                    for (IEdge aristActual : edges) {
                        if (aristActual.getInitialVertex() == vertices.get(u)
                                && aristActual.getTerminalVertex() == vertices.get(v)
                                || aristActual.getInitialVertex() == vertices.get(v)
                                && aristActual.getTerminalVertex() == vertices.get(u)) {
                            w = aristActual;
                        }
                    }

                    if (matrizPesos[a][u] + w.getWeight() < matrizPesos[a][v]) {

                        matrizPesos[a][v] = (int) (matrizPesos[a][u] + w.getWeight());
                        caminos[a][v] = caminos[a][u] + " _ " + vertices.get(v).getLabel();
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        Dijkstra app = new Dijkstra();
        Graph myGraph = new Graph(false, true);
//      Grafo grande de prueba
//        Vertex a = new Vertex("Cali");
//        Vertex b = new Vertex("Bogota");
//        Vertex c = new Vertex("Manizales");
//        Vertex d = new Vertex("Medellin");
//        Vertex e = new Vertex("Pereira"); 
//
//        myGraph.addEdge(a, b, 6);
//        myGraph.addEdge(b, c, 3);
//        myGraph.addEdge(c, d, 2);
//        myGraph.addEdge(d, b, 4);
//
////        myGraph.addVertex(e);
////        JFrame gw = CLDGraph.draw(myGraph);
////        JOptionPane.showMessageDialog(null, "Ahora agregaremos mas aristas y nodos.");
//        Vertex f = new Vertex("Barranquilla");
//        Vertex g = new Vertex("Cartagena");
//
//        myGraph.addEdge(f, e, 9);
//        myGraph.addEdge(g, a, 11);
//        myGraph.addEdge(e, c, 1);
//        myGraph.addEdge(g, d, 6);
//        myGraph.addEdge(a, e, 3);
//        //Grafo pequeño de prueba
        Vertex a = new Vertex("Cali");
        Vertex b = new Vertex("Bogota");
        Vertex c = new Vertex("Manizales");
        Vertex d = new Vertex("Medellin");

        myGraph.addEdge(a, b, 6);
        myGraph.addEdge(b, c, 3);
        myGraph.addEdge(a, d, 7);

        app.matrizPesos = app.generarMatrizAdyacencia(myGraph);
        app.caminos = app.GenerarMatrizCaminos(myGraph);
        for (int i = 0; i < app.matrizPesos.length; i++) {
            for (int j = 0; j < app.matrizPesos.length; j++) {
                System.out.print(app.matrizPesos[i][j] + ", ");
            }
            System.out.println("");
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < app.caminos.length; i++) {
            for (int j = 0; j < app.caminos.length; j++) {
                System.out.print(app.caminos[i][j] + "||");
            }
            System.out.println("");
        }
        System.out.println("Pokemon!");
//        System.out.println("Hola");
//        app.algoritmoDijkstra(myGraph, a);
//        app.algoritmoDijkstra(myGraph, b);
//        app.algoritmoDijkstra(myGraph, c);
//        app.algoritmoDijkstra(myGraph, d);
        app.DijkstraParaTodos(myGraph);

//        app.algoritmoDijkstra(myGraph, a);
//        app.algoritmoDijkstra(myGraph, b);
//        app.algoritmoDijkstra(myGraph, c);
//        app.algoritmoDijkstra(myGraph, d);
//        app.algoritmoDijkstra(myGraph, e);
//        app.algoritmoDijkstra(myGraph, f);
//        app.algoritmoDijkstra(myGraph, g);
        System.out.println("Acabo:");

        for (int i = 0; i < app.matrizPesos.length; i++) {
            for (int j = 0; j < app.matrizPesos.length; j++) {
                System.out.print(app.matrizPesos[i][j] + ", ");
            }
            System.out.println("");
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < app.caminos.length; i++) {
            for (int j = 0; j < app.caminos.length; j++) {
                System.out.print(app.caminos[i][j] + "||");
            }
            System.out.println("");
        }

    }
}
