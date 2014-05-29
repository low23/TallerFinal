package control;

import java.util.Collection;

/**
 * @author Juan Manuel Reyes <juan.reyes@correounivalle.edu.co>
 */
public interface IGraph {
    public Collection<IVertex> getVertices();
    public Collection<IEdge> getEdges();
    public int countVertex();
    public int countEdges();
    public boolean isWeighted();
    public boolean isDirected();
}
