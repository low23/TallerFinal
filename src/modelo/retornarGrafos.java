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
        
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        
        myGraph.addEdge(a, b, 3);
        myGraph.addEdge(b, c, 5);
        myGraph.addEdge(c, d, 1);
        myGraph.addEdge(d, b, 7);
        
        myGraph.addVertex(e);
        
//        JFrame gw = CLDGraph.draw(myGraph);
//        JOptionPane.showMessageDialog(null, "Ahora agregaremos mas aristas y nodos.");
        
        Vertex f = new Vertex("f");
        Vertex g = new Vertex("g");
        
        myGraph.addEdge(f, c, 9);
        myGraph.addEdge(g, a, 2);
        
//        gw.revalidate();
//        JOptionPane.showMessageDialog(null, "Y ahora algunos mas!");
        
        Vertex h = new Vertex("h");
        Vertex i = new Vertex("i");
        
        myGraph.addVertex(h);
        
        myGraph.addEdge(i, f, 6);
        myGraph.addEdge(i, b, 4);
        
//        gw.revalidate();
        
        return  myGraph;
    }

}
