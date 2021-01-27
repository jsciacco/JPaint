package model;

import java.awt.Graphics2D;

import controller.myPoint;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;

public class CreateShapeCommand implements ICommand, IUndoable, IShape{
	
	public ShapeType shapeType;
	public myPoint startPoint, endPoint;
	public int x,y,height,width;
	public ShapeList shapeList;
	public IApplicationState appState;
	public PaintCanvasBase paintCanvas;
	public static IShape shape;
	
	public CreateShapeCommand(ShapeList shapeList, IApplicationState appState, myPoint startPoint, myPoint endPoint) {
		this.shapeList = shapeList;
		this.appState = appState;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public void run(){
		// TODO Auto-generated method stub
		x = startPoint.getX();
		y = startPoint.getY();
		height = (endPoint.getY()-startPoint.getY());
		width = (endPoint.getX()-startPoint.getX());
		shape = ShapeFactory.shapeWorks(appState, startPoint, endPoint);
		shapeList.addShape(shape);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		shapeList.removeShape(shape);
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		shapeList.addShape(shape);
	}

	@Override
	public int getX() {
		return x;
	}
	
	@Override
	public int getY() {
		return y;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public ShapeColor getPrimaryColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeColor getSecondaryColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeShadingType getshapeShadingType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addShape(IShape shape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeShape(IShape shape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(PaintCanvasBase paintcanvas, int x, int y, int height, int width) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.fillRect(x, y, width, height);
	}

}
