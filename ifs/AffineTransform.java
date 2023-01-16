package ifs;
import java.io.*;
import java.util.Scanner;
/**
 * Stores all affine transforms, defines what all transform must contain
 * @author Tyler King 040979598
 * @version 2
 **/
public interface AffineTransform {
    /**Returns name *
     * @return returns name as string*/
    String getName();
    /**Returns values from 2d array
     * @return returns affine as 2d double array*/
    double[][] getAffine();
    /**Returns scale value
     * @return returns scale as double*/
    double getScale();
    /**Returns Height value
     * @return returns height as integer*/
    int getHeight();
    /**Returns Width value
     * @return returns width as integer*/
    int getWidth();
    /**Returns xOffset
     * @return returns xOffset as integer*/
    int getXoffset();
    /**Returns yOffset
     * @return returns yOffset as integer*/
    int getYoffset();
}

class FileIfs implements AffineTransform{
    private double[][] affine;
    private double scale;
    private int height;
    private int width;
    private int xOffset;
    private int yOffset;
    private String name;
    /**
     * Loads values into all class specific variables for FileIfs
     * @param place
     *      The location of the file (relative or absolute)
     **/
    public FileIfs(String place){
        File file = new File(place);
        try(Scanner input = new Scanner(file)) {
            String hold = "";
            int n =0;
            int length=0;
            while (input.hasNextLine()){
                hold = input.nextLine();
                // removes scale from line
                if (hold.startsWith("affine")) {
                    length = Integer.parseInt(hold.substring(6).trim());
                    //System.out.println("Length: " + length);
                    affine = new double[length][7];
                }
                else if (hold.startsWith("scale")) {
                    scale = Integer.parseInt(hold.substring(5).trim());
                    //System.out.println("Scale: " + scale);
                }
                // removes height from line
                else if (hold.startsWith("height")) {
                    height = Integer.parseInt(hold.substring(6).trim());
                    //System.out.println("Height: " + height);
                }
                // removes width from line
                else if (hold.startsWith("width")) {
                    width = Integer.parseInt(hold.substring(5).trim());
                    //System.out.println("Width: " + width);
                }
                // removes xOffset from line
                else if (hold.startsWith("xOffset")) {
                    xOffset = Integer.parseInt(hold.substring(7).trim());
                    //System.out.println("Scale: " + xOffset);
                }
                // removes yOffset from line
                else if (hold.startsWith("yOffset")) {
                    yOffset = Integer.parseInt(hold.substring(7).trim());
                    //System.out.println("yOffset: " + yOffset);
                }
                else if (hold.startsWith("name")) {
                    String[] parts = hold.split(" ");
                    name = parts[1]+" "+parts[2];
                }
                else{
                    String[] parts = hold.split(" ");
                    for (int i = 0; i < 7; i++) {
                        affine[n][i] = Double.parseDouble(parts[i]);
                        //System.out.println(affine[n][i]+" "+(i+1));
                    }
                    n++;
                }//else end
            }//while ends
           for (int i=0;i<affine.length;i++){
                for (int j=0;j<affine[0].length;j++){
                    System.out.println(affine[i][j]+" "+(j+1));
                }
            }
        }//try ends
        catch (FileNotFoundException e){System.out.println("No such file "+e.getMessage());}
    }//constructor ends

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double[][] getAffine(){
        return affine;
    }

    @Override
    public double getScale() {
        return scale;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getXoffset() {
        return xOffset;
    }

    @Override
    public int getYoffset() {
        return yOffset;
    }
}

class BarnsleyFernIfs implements AffineTransform {
    private double[][] affine = {
            {0.00, 0.00, 0.00, 0.16, 0.00, 0.00, 0.01},
            {0.85, 0.04, -0.04, 0.85, 0.00, 1.60, 0.85},
            {0.20,-0.26,0.23,0.22,0.00,1.60,0.07},
            {-0.15,0.28,0.26,0.24,0.00,0.44,0.07}};
    private double scale = 100;
    private int height = 503;
    private int width = 1019;
    private int xOffset = 228;
    private int yOffset = 10;

    @Override
    public String getName() {
        return "Barnsley Fern";
    }

    @Override
    public double[][] getAffine(){
        return affine;
    }

    @Override
    public double getScale() {
        return scale;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getXoffset() {
        return xOffset;
    }

    @Override
    public int getYoffset() {
        return yOffset;
    }
}

class SierpinskiIfs implements AffineTransform {
    private double[][] affine = {
            {0.50, 0.00, 0.00, 0.50, 0.00, 0.00, 0.33},
            {0.50, 0.00, 0.00, 0.50, 0.00, -0.50, 0.35},
            {0.50,0.00,0.00,0.50,-0.43,-0.25,0.34}};
    private double scale = 500;
    private int height = 449;
    private int width = 519;
    private int xOffset = 439;
    private int yOffset = 509;

    @Override
    public String getName() {
        return "Sierpinski Ifs";
    }

    @Override
    public double[][] getAffine(){
        return affine;
    }

    @Override
    public double getScale() {
        return scale;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getXoffset() {
        return xOffset;
    }

    @Override
    public int getYoffset() {
        return yOffset;
    }
}

class MapleIfs implements AffineTransform {
    private double[][] affine = {
            {0.51, 0.00, 0.01, 0.14, 1.31, 0.08, 0.10},
            {0.50, -0.45, 0.52, 0.43, 0.75, -1.49, 0.35},
            {0.47,0.47,-0.49,0.45,0.74,1.62,0.35},
            {0.51,0.00,0.00,0.49,-1.62,-0.02,0.20}};
    private double scale = 100;
    private int height = 702;
    private int width = 885;
    private int xOffset = 340;
    private int yOffset = 445;

    @Override
    public String getName() {
        return "Maple Leaf";
    }

    @Override
    public double[][] getAffine(){
        return affine;
    }

    @Override
    public double getScale() {
        return scale;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getXoffset() {
        return xOffset;
    }

    @Override
    public int getYoffset() {
        return yOffset;
    }
}