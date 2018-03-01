/**
 *
 * @author E14010
 */

public class Complex {
    private final double x,y; 

    public Complex(double x0,double y0) {
        this.x=x0;
        this.y=y0;
    }

    public double getX() { 
        return x;
    }

    public double getY() {
        return y;
    }
    
    
    // for get the (x^2 + y^2)=|z|^2 value for any z=x + yi
    public double abs2(){
        double abs2 = 0d;
        abs2= x*x + y*y ;
        return abs2;
    }    
    // To take the 2 to the power of this complex
    public Complex pow2(){
        Complex ztimes=null;
        double zx=x*x - y*y;
        double zy=2*x*y;
        ztimes = new Complex(zx, zy);
        
        return ztimes;
    }   
    
    // for adding the complex z 
    public Complex plus(Complex z){
        Complex zans=null;
        double zx=this.x + z.getX();
        double zy=this.y + z.getY();
        zans = new Complex(zx, zy);
        return zans;
    }
}
