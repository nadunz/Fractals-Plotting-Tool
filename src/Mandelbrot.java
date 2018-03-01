/**
 *
 * @author E14010
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


class Mandelbrot extends Fractal{
    
    private static Picture picture= null;

    public Mandelbrot() {
        new Picture(Fractal.MANDELBROT); // create a panel to Mandelbrot
        
    } 
    
   
    public static void mandelbrotSet(Graphics g){
        
      
       for(int x=0;x<=WIDTH;x++){
            for(int y=0;y<=HEIGHT;y++){
                
            // convert to an argand plane with the interest region
                Complex zc = new Complex(xMin + (xMax-xMin)*1d*x/WIDTH,yMax - (yMax-yMin)*1d*y/HEIGHT); 
                Color color = calculateColor(zc); // calculate the color regarding this point
                Picture.printPoint((Graphics2D) g, color, new Point(x, y)); // print that point
               
            }
        } 
    }
    
    
     private static Color calculateColor(Complex z){
        
        Complex zc = z;
        boolean mandelbrotSet = true;
        int i=0;
        for(;i<iteration;i++){
            
            
            if(z.abs2() > 4.0){ // check weather |Z|^2 > 4.0
                mandelbrotSet = false;
                break;
            }
            z = z.pow2().plus(zc); //Z=Z^2 + Zc
        }
        // decide the color of the points
        if(mandelbrotSet) return Color.BLACK;

        int a = (int) (255 * ((double) i) / (250));
        int rgb=( (0) | (2*a<<16) | (a<<8) | ((a*2)<<0) );
        
        return new Color(rgb);      
		    	
		    	
        
     }
    


}
