package ifs;
import stl.Solid;
import stl.StlImage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The purpose of this class is to allow a user to select a affine to turn into an stl file
 * @author Tyler King 040979598
 * @version 2
 **/
public class IfsStlfile {

    /**Combines all classes in ifs and stl packages to write a stl file
     * @param args args declaration
     **/
    public static void main(String[] args) {
        ifsCreator ifs = new ifsCreator();
        Scanner input = new Scanner(System.in);
        AffineTransform[] hold = ifs.getTransforms();
        ArrayList<AffineTransform> images = new ArrayList<>();
        for (int i=0;i <hold.length;i++){
            images.add(hold[i]);
        }
        int selection= 0;
        System.out.println("Available fractal images are:");
        for (int i=0; i< images.size();i++){
            System.out.println(i+1 +" "+images.get(i).getName());
        }
        System.out.print("What image number do you want: ");
        selection = input.nextInt();
        if(selection <= 0 || selection > hold.length){
            do{
                System.out.println("Please select a value from 1 to 4: ");
                selection = input.nextInt();
            }
            while(selection <= 0 || selection > hold.length);
        }

        //lab 4 starts here
        StlImage affine = new StlImage(0.8,0.4);
        Solid output = new Solid("Tetrahedron");
        String name = output.getName();
        output = affine.createSolid(ifs.generateifs(images.get(selection-1)));
        String location = "src\\Output.stl";
        try(PrintWriter writer = new PrintWriter(new FileWriter(location){})){output.print(writer,name);}
        catch (IOException e){System.out.println("Write failed "+e);}
        System.out.println("done");
    }
}
