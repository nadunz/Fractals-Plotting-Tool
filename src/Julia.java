/**
 *
 * @author E14010
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Julia extends Fractal{
    
    private final static int SCALE=400;
    private static Picture picture= null;

    public Julia() {
        
        picture=new Picture(Fractal.JULIA); // create a panel and frame for JULIA
    }

    
    public static void juliaSet(Graphics g){
        
      for(int x=0;x<=WIDTH;x++){
            for(int y=0;y<=HEIGHT;y++){
                // convert to a argand plane real=(-1 to 1) img=(-1 to 1)
                Complex z = new Complex((x-WIDTH/2d)/SCALE,(-y+HEIGHT/2d)/SCALE); 
                Color color = calculateColor(z); // calculate the color relevent to the point
                picture.printPoint((Graphics2D) g, color, new Point(x, y)); // draw a point
           
            }
        } 
    }
    
    
    
     public static Color calculateColor(Complex z){
        
        Complex Zc = zc;
        boolean juliaSet = true;
        Color color;
        int i=0;

        for(;i<iteration;i++){
            
            if(z.abs2() > 4.0){ // check weather |Z|^2 > 4.0
                juliaSet = false;
                break;
            }
            z = z.pow2().plus(Zc); //Z=Z^2 + Zc
            
            
        }
        // decide the color of the points
        if(juliaSet) return  Color.WHITE;
       
        double hue = (double) (0.06 + (((double)i)/1000));
        return Color.getHSBColor((float)hue ,1f,(float) (0.1+(((float)i)/100)));
    }

}
