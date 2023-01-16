package stl;
/**
 * The purpose of this class is to create a lithophane from a 2d array of integers
 * @author Tyler King 040979598
 * @version 1
 **/
public class StlImage { double minThick;double thickScale;double scale =0.1;double maxValue;

     /**
     * initial constructor with set min and max thickness of lithophane
     * @param max maximum value
     * @param min minimum value
     **/
    public StlImage(double min, double max){
        thickScale = max-min;
        minThick=min;
    }

    /**
     * create a solid from a 2d int array
     * @param array 2d int array from chosen ifs
     * @return solid from 2d array
     **/
    public Solid createSolid(int[][] array){
        for (int i=0;i <array.length-1;i++){//max value
            for (int j=0;j< array[0].length-1;j++){
                if (maxValue < array[i][j]){
                    maxValue = array[i][j];
                }
            }
        }
        double width = array.length;
        double length = array[0].length;
        Solid a = new Solid();
        //top
        for(int x=0;x <array.length-1;x++){
            for (int y=0;y<array[0].length-1;y++){
                Vertex one = createIfsVertex(y,x,array[x][y]);
                Vertex two = createIfsVertex(y,x+1,array[x+1][y]);
                Vertex three = createIfsVertex(y+1,x+1,array[x+1][y+1]);
                Vertex four = createIfsVertex(y+1,x,array[x][y+1]);
                a.addFacet(one,two,three,four);
            }
        }
        //side1
        Vertex one = new Vertex(0,0,0);
        Vertex two = new Vertex(width*scale,0,0);
        Vertex three = new Vertex(width*scale,0,minThick);
        Vertex four = new Vertex(0,0,minThick);
        a.addFacet(one,two,three,four);

        //side2
        one = new Vertex(0,length*scale,0);
        two = new Vertex(0,0,0);
        three = new Vertex(0,0,minThick);
        four = new Vertex(0,length*scale,minThick);
        a.addFacet(one,two,three,four);

        //side3
        one = new Vertex(width*scale,0,0);
        two = new Vertex(width*scale,length*scale,0);
        three = new Vertex(width*scale,length*scale,minThick);
        four = new Vertex(width*scale,0,minThick);
        a.addFacet(one,two,three,four);

        //side4
        one = new Vertex(width*scale,length*scale,0);
        two = new Vertex(0,length*scale,0);
        three = new Vertex(0,length*scale,minThick);
        four = new Vertex(width*scale,length*scale,minThick);
        a.addFacet(one,two,three,four);

        //bottom
        one = new Vertex(0,0,0);
        two = new Vertex(0,length*scale,0);
        three = new Vertex(width*scale,length*scale,0);
        four = new Vertex(width*scale,0,0);
        a.addFacet(one,two,three,four);
        return a;
    }

    /**
     * creates vertex adjusted by class variables and given x, y, z
     * @param x x value of vertex
     * @param y y value of vertex
     * @param z  values of vertex
     * @return vertex from x, y, z
     **/
    public Vertex createIfsVertex(double x, double y, double z){
        double thickness = minThick+thickScale*(Math.sqrt((z/maxValue)));
        return new Vertex(y*scale,x*scale,thickness);
    }
}
