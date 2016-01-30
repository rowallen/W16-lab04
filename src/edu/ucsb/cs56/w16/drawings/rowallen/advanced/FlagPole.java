package edu.ucsb.cs56.w16.drawings.rowallen.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   A Flag Pole
      
   @author Phill Conrad 
   @author Ryan Allen
   @version for CS56, W16, UCSB
   
*/
public class FlagPole extends Flag implements Shape
{
    /**
     * Constructor for objects of class FlagPole
     */
    public FlagPole(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	double poleLength = 3 * height;
	
	GeneralPath pole = new GeneralPath();

	pole.moveTo(x,y);
	pole.lineTo(x,y + poleLength);

        GeneralPath wholeFlag = this.get();
        wholeFlag.append(pole, false);

    }    
}
