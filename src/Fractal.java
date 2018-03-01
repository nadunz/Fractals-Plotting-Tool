/**
 *
 * @author E14010
 */

public class Fractal {
    
   	public static final int MANDELBROT = 0,JULIA = 1;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static int iteration = 1000;
    public static Complex zc = new Complex(-0.4,0.6);
    public static double xMin = -1.0;
    public static double xMax = 1.0;
    public static double yMin = -1.0;
    public static double yMax = 1.0;

    public Fractal(double xMin, double xMax, double yMin, double yMax, int iteration) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        this.iteration = iteration;
        Mandelbrot mandelbrot = new Mandelbrot();
    }
    public Fractal(Complex zc, int iteration) {
        this.iteration = iteration;
        this.zc = zc;
        Julia julia = new Julia();
    }

    public Fractal() {
        
    }
// for printing a message
    public static void printUsageMessage(){
    	System.out.println("Usage: Fractal Mandelbrot <Xmin> <Xmax> <Ymin> <Ymax> <iteration>");
    	System.out.println("Usage: Fractal Julia <ZcReal> <ZcImg> <iteration>");
        System.out.println("where possible figure include:");
        System.out.println("   Mandelbrot\n   Julia");

    }
    
    
    public static void main(String[] args)  {
        String picture="";
        boolean exception=false; // if there is any exception this is true
        try{
            picture = args[0];
        }catch(ArrayIndexOutOfBoundsException ex){
            printUsageMessage();
            exception=true;
        }
        
        if(picture.equals("Mandelbrot")){
            
            int argcount=args.length; // take the # of given arguments
            double realMin = -1.0;
            double realMax = 1.0;
            double imgMin = -1.0;
            double imgMax = 1.0;
            int iter = 1000;
            
            
            if(argcount==5 || argcount==6){
                
                try{
                	realMin = Double.parseDouble(args[1]);
                	realMax = Double.parseDouble(args[2]);
                	imgMin = Double.parseDouble(args[3]);
                	imgMax = Double.parseDouble(args[4]);
            
            	}catch(NumberFormatException ex){
            		System.out.println("Interest region should be given in DOUBLE");
            		exception=true;
            	}
                
            }


            if(argcount==6){

            	try{
                	iter = Integer.parseInt(args[5]);
            	
                }catch(NumberFormatException ex){
            		System.out.println("Iteration should be given in DOUBLE");
            		exception=true;
            	}
            }


            if((argcount==1 || argcount==5 || argcount==6) && exception==false){
            	Fractal fractal = new Fractal(realMin, realMax, imgMin, imgMax, iter); // doing the plot of mandelbrot
            }else if(!exception){
            	printUsageMessage();
            }
            
        }else if(picture.equals("Julia")){ 
            
            int argcount=args.length;
            double realC = -0.4 ;
            double imgC =0.6;
            int iter = 1000;
             
            
            if(argcount==3 || argcount==4){
                try{
                	realC = Double.parseDouble(args[1]);
                	imgC = Double.parseDouble(args[2]);
                }catch(NumberFormatException ex){
            		System.out.println("Real & imaganary parts of Zc should be given in DOUBLE");
            		exception=true;
            	}
                
            }
            if(argcount==4){

            	try{
                	iter = Integer.parseInt(args[3]);
            	
                }catch(NumberFormatException ex){
            		System.out.println("Iteration should be given in DOUBLE");
            		exception=true;
            	}
            }
            if((argcount==1 || argcount==3 || argcount==4) && exception==false){
            	Fractal fractal = new Fractal(new Complex(realC,imgC), iter); // doing the plot of Julia
            }else if(!exception){
            	printUsageMessage();
            }
        }else if(!exception){ // if user asked any invalid picture
        	System.out.println("Invalid Picture");
        	System.out.println("where possible figure include:");
            System.out.println("   Mandelbrot\n   Julia");
        }
    
    
    
      
    }
    
    
    
}
