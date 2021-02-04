package model;

import java.awt.Graphics2D;

import controller.myPoint;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;

public class MoveShapeCommand implements ICommand, IUndoable, IShape{

	public ShapeType shapeType;
	public myPoint startPoint, endPoint;
	public int startX,startY,endX,endY,height,width;
	public ShapeList shapeList;
	public IApplicationState appState;
	public PaintCanvasBase paintCanvas;
	public static IShape shape;
	public ShapeDraw shapeDraw;

	public MoveShapeCommand(PaintCanvasBase paintCanvas, IApplicationState appState, myPoint startPoint, myPoint endPoint) {	
		this.paintCanvas = paintCanvas;
		this.appState = appState;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public void run(){
		// TODO Auto-generated method stub
		startX = startPoint.getX();
		startY = startPoint.getY();
		endX = endPoint.getX();
		endY = endPoint.getY();
		height = (endPoint.getY()-startPoint.getY());
		width = (endPoint.getX()-startPoint.getX());
		shapeDraw = new ShapeDraw(paintCanvas);
		shapeList = new ShapeList(shapeDraw);
		shapeList.moveList(startPoint, endPoint);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		shapeList.undoMove();
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		shapeList.redoMove();
	}

	@Override
	public int getStartX() {
		return startX;
	}

	@Override
	public int getStartY() {
		return startY;
	}

	@Override
	public int getEndX() {
		// TODO Auto-generated method stub
		return endX;
	}

	@Override
	public int getEndY() {
		// TODO Auto-generated method stub
		return endY;
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

	@Override
	public void setStartX(int deltaX) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStartY(int deltaY) {
		// TODO Auto-generated method stub

	}



}
