package edu.ucsb.cs56.w16.drawings.rowallen.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A Coffee Cup (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.   
      
   @author Phill Conrad 
   @author Ryan Allen
   @version for CS56, W16, UCSB
   
*/
public class Flag extends GeneralPathWrapper implements Shape
{   
    /**
     * Constructor for objects of class CoffeeCup
     */
    public Flag(double x, double y, double width, double height)
    {
	
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* flag
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 200.0; 
        final double ORIG_WIDTH = 400.0; 
        
	//        GeneralPath rectangle = new GeneralPath();
	/*
	rectangle.moveTo(200,100); // Top Left of Flag
        rectangle.lineTo(200,300);
        rectangle.lineTo(600,300);
        rectangle.lineTo(600,100);
        rectangle.lineTo(200,100);
        */
	Rectangle2D.Double outerShape =
	    new Rectangle2D.Double(x, y, width, height);
	
	//        GeneralPath starBox = new GeneralPath();
	/*
	starBox.moveTo(x, y + (height/2));
	starBox.lineTo(x + width/3, height + (height/2));
	starBox.lineTo(x + width/3, y);
	*/
	Rectangle2D.Double starBox =
	    new Rectangle2D.Double(x, y, width/3, height/2);
	GeneralPath stripes = new GeneralPath();

	stripes.moveTo(x + width/3,y + (height/4));
	stripes.lineTo(x + width,y + height/4);

	stripes.moveTo(x + width/3,y + (height/2));
	stripes.lineTo(x + width,y + (height/2));

	stripes.moveTo(x,y + height - (height/4));
	stripes.lineTo(x + width,y + height - (height/4));
	
	GeneralPath wholeFlag = new GeneralPath ();
        wholeFlag.append(outerShape, false);
        wholeFlag.append(starBox, false);
        wholeFlag.append(stripes, false);

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
	//        Shape s = ShapeTransforms.translatedCopyOf(wholeFlag, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
	/*        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	*/
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	this.set(new GeneralPath(wholeFlag)); // normally pass in s
        
    }

}
