package model;

import controller.myPoint;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;

public class ShapeFactory {
	
	public static IApplicationState appState;
	public static ShapeType shapeType;
	public static IShape shape;
	
	public static IShape shapeWorks(IApplicationState appState, myPoint startPoint, myPoint endPoint) {
		
		shapeType = appState.getActiveShapeType();
		
		switch(shapeType)
		{
		case RECTANGLE:
			shape = new Rectangle(appState, startPoint, endPoint);
			return shape;
		case TRIANGLE:
			break;
		case ELLIPSE:
			break;
		}
		return shape;
	}
}
