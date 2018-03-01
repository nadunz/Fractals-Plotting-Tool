/**
 *
 * @author E14010
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;

class Picture extends JPanel { // inherit JPanel 

    private String title = ""; // title for the frame
    private int whatPic;       // picture type Julia or Mandelbrot (Fractal.MANDELBROT=0,Fractal.JULIA=1)
   
    public Picture(int whatPicture) {

        this.whatPic = whatPicture; // set the picture type

        // decide the title for the frame
        if (whatPicture==Fractal.MANDELBROT){
            title = "Mandelbrot Set";
        }else if (whatPicture==Fractal.JULIA){
            title = "Julia Set";
        }
        
        JFrame frame = new JFrame(title); //  create new frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setContentPane(this);
        setPreferredSize(new Dimension(Fractal.WIDTH, Fractal.HEIGHT)); //set the size for the frame 
        frame.pack(); 
		frame.setLocationRelativeTo(null); // take the fame to center
		frame.setVisible(true);  // show the frame
        

    }

    
     @Override
    public void paintComponent(Graphics g) { 
	// call paintComponent from parent class 
	super.paintComponent(g);
        
	
        if (whatPic==Fractal.MANDELBROT){
            Mandelbrot.mandelbrotSet(g);
        }else if (whatPic==Fractal.JULIA){
            Julia.juliaSet(g);
        }
       
      

    }
   
    public static void printPoint(Graphics2D frame, Color c, Point p) {

	frame.setColor(c); 
	frame.draw(new Line2D.Double(p.getX(), p.getY(), 
				     p.getX(), p.getY())); 
    } 

}


