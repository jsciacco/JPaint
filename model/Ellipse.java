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
	public int startX, startY, endX, endY, width, height;

	public Ellipse(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType, myPoint startPoint, myPoint endPoint) {
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.shadingType = shadingType;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		startX = startPoint.getX();
		startY = startPoint.getY();	
		endX = endPoint.getX();
		endY = endPoint.getY();
		width = endPoint.getX()-startPoint.getX();
		height = endPoint.getY()-startPoint.getY();
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
		return endX;
	}
	@Override
	public int getEndY() {
		// TODO Auto-generated method stub
		return endY;
	}
	
	@Override
	public void setEndX(int deltaX) {
		// TODO Auto-generated method stub
		this.endX = deltaX;
	}
	@Override
	public void setEndY(int deltaY) {
		// TODO Auto-generated method stub
		this.endY = deltaY;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	
	public void setWidth(int deltaW) {
		// TODO Auto-generated method stub
		this.width = deltaW;
	}
	@Override
	public void setHeight(int deltaH) {
		// TODO Auto-generated method stub
		this.height = deltaH;
	}
	@Override
	public ShapeColor getPrimaryColor() {
		// TODO Auto-generated method stub
		return primaryColor;
	}

	@Override
	public ShapeColor getSecondaryColor() {
		// TODO Auto-generated method stub
		return secondaryColor;
	}

	@Override
	public ShapeShadingType getshapeShadingType() {
		// TODO Auto-generated method stub
		return shadingType;
	}

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return ShapeType.ELLIPSE;
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
	public void draw(PaintCanvasBase paintCanvas, int xStart, int yStart, int xEnd, int yEnd, int h, int w) {
		// TODO Auto-generated method stub
		Color firstColor = primaryColor.getColor();
		Color secondColor = secondaryColor.getColor();
		Graphics2D graphics2d = paintCanvas.getGraphics2D();

		switch(shadingType) {

		case FILLED_IN:
			graphics2d.setColor(firstColor);
			graphics2d.fillOval(xStart, yStart, w, h);
			break;
		case OUTLINE:
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(firstColor);
			graphics2d.drawOval(xStart, yStart, w, h);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(secondColor);
			graphics2d.drawOval(xStart, yStart, w, h);
			graphics2d.setColor(firstColor);
			graphics2d.fillOval(xStart, yStart, w, h);
			break;
		}
	}
	@Override
	public void drawOutline(PaintCanvasBase paintCanvas, int xStart, int yStart, int xEnd, int yEnd, int h, int w) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		
		graphics2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0));
		graphics2d.setColor(Color.BLACK);
		graphics2d.drawOval(xStart, yStart, w, h);
	}
}
