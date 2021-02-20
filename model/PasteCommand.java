package model;

import java.util.ArrayList;

import controller.myPoint;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

public class PasteCommand implements ICommand, IUndoable {
	
	public static ShapeType shapeType;
	public static ShapeColor primaryColor;
	public static ShapeColor secondaryColor;
	public static ShapeShadingType shadingType;
	public static myPoint startPoint;
	public static myPoint endPoint;
	public static IShape shapeCopy;
	
	ArrayList<IShape> copyShapeList = new ArrayList<IShape>();
	ArrayList<IShape> newShapeList = new ArrayList<IShape>();
	
	@Override
	public void run(){
		
		copyShapeList = ShapeList.getCopy();
		
		for (IShape shape : copyShapeList) {
			
			int startX = shape.getStartX()+60;
			int startY = shape.getStartY()+60;
			int endX = shape.getEndX()+60;
			int endY = shape.getEndY()+60;
			
			startPoint = new myPoint(startX, startY);
			endPoint = new myPoint(endX, endY);
			shapeType = shape.getShapeType();
			primaryColor = shape.getPrimaryColor();
			secondaryColor = shape.getSecondaryColor();
			shadingType = shape.getshapeShadingType();
			
			shapeCopy = ShapeFactory.shapeWorks(shapeType, primaryColor, secondaryColor, shadingType, startPoint, endPoint);
			newShapeList.add(shapeCopy);
			ShapeList.addShape(shapeCopy);
		}
		CommandHistory.add(this);	
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for(IShape shape: newShapeList) {
			ShapeList.removeShape(shape);
		}	
	}
	@Override
	public void redo() {
		// TODO Auto-generated method stub
		for(IShape shape: newShapeList) {
			ShapeList.addShape(shape);
		}
	}
}