package ifs;
/**Creates ifs data from affine classes
 * @author Tyler King 040979598
 * @version 2*/
public class ifsCreator {
    private int A=0;private int B=1;private int C=2;private int D=3;private int E=4;private int F=5;
    private int PROB=6;
    /**
     * This method generates a ifs from an affine transform
     * @param affineifs
     *        The specified affine transform
     * @return returns a resulting 2d array
     **/
    public int[][] generateifs(AffineTransform affineifs){
        int row=0;
        double u;
        double v;
        double x=0;
        double y=0;
        int xDisp;
        int yDisp;
        int[][] output = new int[affineifs.getWidth()][affineifs.getHeight()];
        double[][] matrix = affineifs.getAffine();
        int loop = affineifs.getWidth()*affineifs.getHeight();

        for(int i =0;i<=loop;i++){//for 1
            double rand_Num = Math.random();
            double sumProb = 0;
            for(int f=0; f<matrix.length; f++){//for2
                if(sumProb < rand_Num && rand_Num <= matrix[f][PROB]+sumProb) row = f;
                sumProb+=matrix[f][PROB];
            }//for2

            u = matrix[row][A]*x + matrix[row][B]*y + matrix[row][E];
            v = matrix[row][C]*x + matrix[row][D]*y + matrix[row][F];
            x=u;
            y=v;
            xDisp = (int) (x*affineifs.getScale()+affineifs.getXoffset());
            yDisp = (int) (y*affineifs.getScale()+affineifs.getYoffset());
            output[yDisp][xDisp]++;
        }//for 1
        return output;
    }

    /**This method creates a affine transform array used in IfsStlfile for user selection
     * @return returns affine transform array
     **/
    public AffineTransform[] getTransforms(){
        AffineTransform[] images = new AffineTransform[4];
        BarnsleyFernIfs b = new BarnsleyFernIfs();
        MapleIfs m = new MapleIfs();
        SierpinskiIfs s = new SierpinskiIfs();
        FileIfs f = new FileIfs("GoldenDragon.ifs");
        images[0]=b;
        images[1]=s;
        images[2]=m;
        images[3]=f;
        return images;
    }
}
