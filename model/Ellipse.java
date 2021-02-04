package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.EnumMap;

import controller.myPoint;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class Ellipse implements IShape {

	public myPoint startPoint,endPoint;
	public IApplicationState appState;
	public ShapeList shapeList;
	public ShapeColor primaryColor;
	public ShapeColor secondaryColor;
	public ShapeShadingType shadingType;
	public int startX, startY;


	public Ellipse(IApplicationState appState, myPoint startPoint, myPoint endPoint) {
		this.appState = appState;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		startX = startPoint.getX();
		startY = startPoint.getY();
		primaryColor = appState.getActivePrimaryColor();
		System.out.println(primaryColor);
		secondaryColor = appState.getActiveSecondaryColor();
		System.out.println(secondaryColor);
		shadingType = appState.getActiveShapeShadingType();
		System.out.println(shadingType);
	}
	@Override
	public int getStartX() {
		return startX;
	}

	@Override
	public int getStartY() {
		// TODO Auto-generated method stub
		return startY;
	}

	@Override
	public void setStartX(int deltaX) {
		// TODO Auto-generated method stub
		this.startX = deltaX;
	}
	@Override
	public void setStartY(int deltaY) {
		// TODO Auto-generated method stub
		this.startY = deltaY;
	}
	@Override
	public int getEndX() {
		// TODO Auto-generated method stub
		return endPoint.getX();
	}
	@Override
	public int getEndY() {
		// TODO Auto-generated method stub
		return endPoint.getY();
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
		Color firstColor = primaryColor.getColor();
		Color secondColor = secondaryColor.getColor();
		Graphics2D graphics2d = paintCanvas.getGraphics2D();

		switch(shadingType) {

		case FILLED_IN:
			graphics2d.setColor(firstColor);
			graphics2d.fillOval(x, y, width, height);
			break;
		case OUTLINE:
			graphics2d.setStroke(new BasicStroke(9));
			graphics2d.setColor(firstColor);
			graphics2d.drawOval(x, y, width, height);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2d.setStroke(new BasicStroke(9));
			graphics2d.setColor(secondColor);
			graphics2d.drawOval(x, y, width, height);
			graphics2d.setColor(firstColor);
			graphics2d.fillOval(x, y, width, height);
			break;
		}
	}

	// Filled in rectangle
	//Graphics2D graphics2d = paintCanvas.getGraphics2D();
	//graphics2d.setColor(Color.GREEN);
	//graphics2d.fillRect(12, 13, 200, 400);

	// Outlined rectangle
	//graphics2d.setStroke(new BasicStroke(5));
	//graphics2d.setColor(Color.BLUE);
	//graphics2d.drawRect(12, 13, 200, 400);

	// Selected Shape
	//Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
	//graphics2d.setStroke(stroke);
	//graphics2d.setColor(Color.BLACK);
	//graphics2d.drawRect(7, 8, 210, 410);

	// if outline only, graphics2d.draw, if filled in, graphics2d.draw
}
