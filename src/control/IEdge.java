package control;

/**
 * @author Juan Manuel Reyes <juan.reyes@correounivalle.edu.co>
 */
public interface IEdge {
    public IVertex getInitialVertex();
    public IVertex getTerminalVertex();
    public double getWeight();
}
