package stl;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/**
 * The purpose of this class is to represent a StL ASCII Format solid. A 3D object that is composed of multiple Facets
 * @author Tyler King 040979598
 * @version 3
 **/
public class Solid {
    private String name;
    private List<Facet> facets = new ArrayList<Facet>();

    /**constructor to only create solid*/
    public Solid(){

    }

    /**
     * constructor to create solid with a name
     * @param text name given to solid
     **/
    public Solid(String text){
        name = text;
    }

    /**
     *gets solid name
     * @return returns name as string
     */
    public String getName(){
        return name;
    }

    /**
     * adds a facet to an array list
     * @param facet facet to be added to facets arraylist
     * @return true when facet is contained in the arraylist
     **/
    public boolean addFacet(Facet facet){
        facets.add(facet);
        return facets.contains(facet);
    }

    /**creates and adds facets to facets arraylist
     * @param vertices vertexes used for facet creation and addition to arraylist
     *                  n # of vertices can be used in method call
     * @return true when facet is contained in the arraylist
     **/
    public boolean addFacet(Vertex ...vertices){
        List<Facet> hold = new ArrayList<Facet>();
        if (vertices.length < 3) {
            return false;
        }
        for (int i = 0; i < vertices.length - 2; i++) {
            Facet one = new Facet(vertices[0], vertices[1 + i], vertices[2 + i]);
            facets.add(one);
            hold.add(one);
        }
        return facets.equals(hold);
    }

    /**
     * prints a facet
     * @param name name of solid
     * @param printWriter PrintWriter to be used
     **/
    public void print(PrintWriter printWriter, String name){
        printWriter.println("solid "+name);
        printWriter.println(facets.toString().replace("[", "").replace("]", "").replace(",","" )+"endsolid " +name);
        printWriter.flush();
        printWriter.close();
    }

    /**
     * outputs all facets in facets arraylist in stl format (continued in facet toString
     * @return stringbuilder output
     **/
    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        String delim ="";
        a.append("solid ").append(name).append("\n");
        for (Facet facet: facets){

            a.append(String.join(delim,facet.toString()+"\n"));
        }
        a.append("endfacet"+"\n");
        return a.toString();
    }
}
