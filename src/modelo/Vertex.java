package modelo;

import control.IVertex;

/**
 * @author Juan Manuel Reyes <juan.reyes@correounivalle.edu.co>
 */
public class Vertex implements IVertex{
    private String label;

    public Vertex(String lab){
        label = lab;
    }

    public String getLabel(){
        return label;
    }
    /*
    public boolean equals(Object other){
        return ((Vertex)other).getLabel().equals(label);
    }*/
}
