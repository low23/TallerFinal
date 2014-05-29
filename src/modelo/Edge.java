package modelo;

import control.IEdge;
import control.IVertex;

public class Edge implements IEdge{
	private Vertex initialVertex;
	private Vertex terminalVertex;
	private double weight;
	private final static double DEFAULT_WEIGHT=1; 
	
	public Edge(Vertex iv, Vertex tv){
		initEdge(iv, tv, DEFAULT_WEIGHT);
	}
	
	public Edge(Vertex iv, Vertex tv, double w){
		initEdge(iv, tv, w);
	}
	
	private void initEdge(Vertex iv, Vertex tv, double w){
		initialVertex  = iv;
		terminalVertex = tv;
		weight = w;
	}
	
	public IVertex getInitialVertex() {
		return initialVertex;
	}

	public IVertex getTerminalVertex() {
		return terminalVertex;
	}

	public double getWeight() {
		return weight;
	}
}
