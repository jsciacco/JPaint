package model;

import controller.myPoint;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class ShapeFactory {

	public IApplicationState appState;
	public static ShapeType shapeType;
	public static IShape shape;
	public static ShapeColor primaryColor, secondaryColor;
	public static ShapeShadingType shadingType;
	public static myPoint startPoint;
	public static myPoint endPoint;
	
	
	public static IShape shapeWorks(ShapeType shapeType, ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType, myPoint startPoint, myPoint endPoint) {
		
		System.out.println(shapeType);

		switch(shapeType)
		{
		case RECTANGLE:
			shape = new Rectangle(primaryColor, secondaryColor, shadingType, startPoint, endPoint);
			return shape;
		case TRIANGLE:
			shape = new Triangle(primaryColor, secondaryColor, shadingType, startPoint, endPoint);
			return shape;
		case ELLIPSE:
			shape = new Ellipse(primaryColor, secondaryColor, shadingType, startPoint, endPoint);
			return shape;
		}
		return shape;
	}
}
