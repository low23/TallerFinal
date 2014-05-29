package modelo;

import control.IEdge;
import control.IGraph;
import control.IVertex;
import java.util.ArrayList;

import java.util.Collection;

public class Graph implements IGraph{
    private Collection<IVertex> vertices;
    private Collection<IEdge> edges;
	private boolean directed;
	private boolean weighted;

    public Graph(){
    	initGraph(false, false);
    }
    
    public Graph(boolean d, boolean we){
    	initGraph(d, we);
    }
    
    private void initGraph(boolean d, boolean we){
        vertices = new ArrayList<>();
        edges    = new ArrayList<>();
        
		directed = d;
		weighted = we;    	
    }

    public void addVertex(Vertex v){
        vertices.add(v);
    }

    public void addEdge(Vertex iv, Vertex tv, double w){
        addVertexFromEdge(iv, tv);
        edges.add(new Edge(iv, tv, w));
    }
    
    private void addVertexFromEdge(Vertex iv, Vertex tv){
        if(!vertices.contains(iv)) vertices.add(iv); //add only if isn't present
        if(!vertices.contains(tv)) vertices.add(tv); //add only if isn't present
    }
    
    public void addEdge(Vertex iv, Vertex tv){
        addVertexFromEdge(iv, tv);
        edges.add(new Edge(iv, tv));
    }
    
    public Collection<IVertex> getVertices() {
        return vertices;
    }

    public Collection<IEdge> getEdges() {
        return edges;
    }

    public int countVertex() {
        return vertices.size();
    }

    public int countEdges() {
        return edges.size();
    }

	public boolean isWeighted() {
		return weighted;
	}

	public boolean isDirected() {
		return directed;
	}
}
