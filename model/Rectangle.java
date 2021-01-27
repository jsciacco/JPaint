package model;

import java.awt.Color;
import java.awt.Graphics2D;

import controller.myPoint;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class Rectangle implements IShape {

		public myPoint startPoint,endPoint;
		public IApplicationState appState;
		public ShapeList shapeList;
		
		public Rectangle(IApplicationState appState, myPoint startPoint, myPoint endPoint) {
			this.appState = appState;
			this.startPoint = startPoint;
			this.endPoint = endPoint;
		}
	@Override
	public int getX() {
		return startPoint.getX();
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return startPoint.getY();
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return (endPoint.getX()-startPoint.getX());
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return (endPoint.getY()-startPoint.getY());
	}

	@Override
	public ShapeColor getPrimaryColor() {
		// TODO Auto-generated method stub
		return appState.getActivePrimaryColor();
	}

	@Override
	public ShapeColor getSecondaryColor() {
		// TODO Auto-generated method stub
		return appState.getActiveSecondaryColor();
	}

	@Override
	public ShapeShadingType getshapeShadingType() {
		// TODO Auto-generated method stub
		return appState.getActiveShapeShadingType();
	}

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return appState.getActiveShapeType();
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
	public void draw(PaintCanvasBase paintCanvas, int x, int y, int height, int width) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		graphics2d.setColor(Color.green);
        graphics2d.fillRect(x, y, width, height);
	}
}
