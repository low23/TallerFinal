/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Torres
 */
public class retornarGrafos {

    public Graph obtenerGrafo1() {
        Graph myGraph = new Graph(false,true);
        
        Vertex a = new Vertex("Cali");
        Vertex b = new Vertex("Bogota");
        Vertex c = new Vertex("Manizales");
        Vertex d = new Vertex("Medellin");
        
        myGraph.addEdge(a, b, 6);
        myGraph.addEdge(b, c, 3);
        myGraph.addEdge(c, d, 2);
        myGraph.addEdge(d, b, 4);
        return  myGraph;
    }
    
    public Graph obtenerGrafo2() {
        
        Graph myGraph = new Graph(false,true);
        
       Vertex a = new Vertex("Cali");
        Vertex b = new Vertex("Bogota");
        Vertex c = new Vertex("Manizales");
        Vertex d = new Vertex("Medellin");

        myGraph.addEdge(a, b, 6);
        myGraph.addEdge(b, c, 3);
        myGraph.addEdge(a, d, 7);
        
        return  myGraph;
    }
    
    public Graph obtenerGrafo3() {
        
        Graph myGraph = new Graph(false,true);
        
       Vertex a = new Vertex("Cali");
        Vertex b = new Vertex("Bogota");
        Vertex c = new Vertex("Manizales");
        Vertex d = new Vertex("Medellin");

        myGraph.addEdge(a, b, 6);
        myGraph.addEdge(b, c, 3);
        myGraph.addEdge(a, d, 7);
        
        return  myGraph;
    }
    
    public Graph obtenerGrafo4() {
        
        Graph myGraph = new Graph(false,true);
        
       Vertex a = new Vertex("Cali");
        Vertex b = new Vertex("Bogota");
        Vertex c = new Vertex("Manizales");
        Vertex d = new Vertex("Medellin");

        myGraph.addEdge(a, b, 6);
        myGraph.addEdge(b, c, 3);
        myGraph.addEdge(a, d, 7);
        
        return  myGraph;
    }
    
    public Graph obtenerGrafo5() {
        
        Graph myGraph = new Graph(false,true);
        
       Vertex a = new Vertex("Cali");
        Vertex b = new Vertex("Bogota");
        Vertex c = new Vertex("Manizales");
        Vertex d = new Vertex("Medellin");

        myGraph.addEdge(a, b, 6);
        myGraph.addEdge(b, c, 3);
        myGraph.addEdge(a, d, 7);
        
        return  myGraph;
    }

}
