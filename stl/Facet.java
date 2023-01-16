package stl;
/**
 * The purpose of this class is to represent a single facet
 * (a triangle with the three vertices and a unit normal that is perpendicular to the triangle)
 * @author Tyler King 0409797598
 * @version 2
 **/
public class Facet {
    private Vertex v1;private Vertex v2;private Vertex v3;private Vertex normal;
    /**
     * inital constructor, creates facet from 3 vertexes
     * @param a vertex a
     * @param b vertex b
     * @param c vertex c
     */
    public Facet(Vertex a, Vertex b, Vertex c){
        v1 =a;
        v2 =b;
        v3 =c;
        normal = Vertex.calcNormal(v1,v2,v3);
    }

    /**
     * outputs facet information in stl format (stl format complete when combined with solid toString
     * @return string builder output
     **/
    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        a.append("facet normal").append(normal.toString()).append("\n");
        a.append("  outer loop"+"\n");
        a.append("    vertex").append(v1.toString()).append("\n").append("    vertex").append(v2.toString()).append("\n").append("    vertex").append(v3.toString()).append("\n");
        a.append("  endloop"+"\n");
        a.append("endfacet"+"\n");
        return a.toString();
    }
}
