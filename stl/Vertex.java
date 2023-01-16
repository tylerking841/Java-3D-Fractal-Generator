package stl;
import java.text.DecimalFormat;
/**Creates vertex using double values as x, y, z
 * @author Tyler King 040979958
 * @version 2*/
public class Vertex {
    private double x;private double y;private double z;
    static DecimalFormat decimalFormat = new DecimalFormat("#0.##");
    /**
     * initial constructor, creates vertex from x, y, z
     * @param a x value for vertex
     * @param b y value for vertex
     * @param c z value for vertex
     **/
    public Vertex(double a,double b, double c){
        x=a;
        y=b;
        z=c;
    }

    /**
     * returns x, y, and z values rounded to 2 decimals
     * @return x, y ,z values as string
     **/
    @Override
    public String toString() { return " "+decimalFormat.format(x)+" "+decimalFormat.format(y)+" "+decimalFormat.format(z); }

    /**
     * calculate vertex normal from 3 vertexes
     * @param one first vertex
     * @param two second vertex
     * @param three third vertex
     * vertexes should be given to method in order required on method call
     * @return vertex normal from 2 vertexes
     **/
    public static Vertex calcNormal(Vertex one, Vertex two, Vertex three) {
        float a1 = (float) (two.x - one.x);
        float b1 = (float) (two.y - one.y);
        float c1 = (float) (two.z - one.z);
        float a2 = (float) (three.x - one.x);
        float b2 = (float) (three.y - one.y);
        float c2 = (float) (three.z - one.z);
        float a = b1 * c2 - b2 * c1;
        float b = a2 * c1 - a1 * c2;
        float c = a1 * b2 - b1 * a2;
        float d = (float) (- a * one.x - b * one.y - c * one.z);
        double ans = Math.sqrt((a*a) +(b*b) +(c*c));
        a/=ans;
        b/=ans;
        c/=ans;
        Vertex output = new Vertex(a,b,c);
        return output;
    }
}
