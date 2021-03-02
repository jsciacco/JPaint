package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.EnumMap;

import controller.myPoint;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class Triangle implements IShape {

	public myPoint startPoint,endPoint;
	public IApplicationState appState;
	public ShapeList shapeList;
	public ShapeColor primaryColor;
	public ShapeColor secondaryColor;
	public ShapeShadingType shadingType;
	public int startX, startY, endX, endY;

	public Triangle(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType, myPoint startPoint, myPoint endPoint) {
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.shadingType = shadingType;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		startX = startPoint.getX();
		startY = startPoint.getY();	
		endX = endPoint.getX();
		endY = endPoint.getY();
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
		return (endPoint.getX()-startPoint.getX());
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return (endPoint.getY()-startPoint.getY());
	}
	
	@Override
	public void setWidth(int deltaW) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setHeight(int deltaH) {
		// TODO Auto-generated method stub
		
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
		return ShapeType.TRIANGLE;
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
	public void draw(PaintCanvasBase paintCanvas, int xStart, int yStart, int xEnd, int yEnd, int height, int width) {
		// TODO Auto-generated method stub
		Color firstColor = primaryColor.getColor();
		Color secondColor = secondaryColor.getColor();
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		int xArray[] = {xStart,xEnd,xStart};
		System.out.println(xArray[0]);
		System.out.println(xArray[1]);
		System.out.println(xArray[2]);
		int yArray[] = {yStart,yEnd,yEnd};
		System.out.println(yArray[0]);
		System.out.println(yArray[1]);
		System.out.println(yArray[2]);

		switch(shadingType) {

		case FILLED_IN:
			graphics2d.setColor(firstColor);
			graphics2d.fillPolygon(xArray, yArray, 3);
			break;
		case OUTLINE:
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(firstColor);
			graphics2d.drawPolygon(xArray, yArray, 3);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(secondColor);
			graphics2d.drawPolygon(xArray, yArray, 3);
			graphics2d.setColor(firstColor);
			graphics2d.fillPolygon(xArray, yArray, 3);
			break;
		}
	}
	@Override
	public void drawOutline(PaintCanvasBase paintCanvas, int xStart, int yStart, int xEnd, int yEnd, int height, int width) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		int xArray[] = {xStart,xEnd,xStart};
		System.out.println(xArray[0]);
		System.out.println(xArray[1]);
		System.out.println(xArray[2]);
		int yArray[] = {yStart,yEnd,yEnd};
		System.out.println(yArray[0]);
		System.out.println(yArray[1]);
		System.out.println(yArray[2]);
		
		graphics2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0));
		graphics2d.setColor(Color.BLACK);
		graphics2d.drawPolygon(xArray, yArray, 3);
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

//recommendation right triangle

//three parameters : x array y array number of points (3)
//xarray[3] = 10(startpointx),40(endpoint x),10(startpoint x)
//yarray[3] = 30(startpoint y),50(endpoint y),50(endpoint y)
//drawpolygon(x,y,3)
//startpoint x, endpoint y = 3rd point in array

//mapping colors, 1st way public static switch statements, 2nd way enum map
//EnumMap<ShapeColor, java.awt.Color> map = new EnumMap<ShapeColor, Color>(ShapeColor.class);
//Can put in main, then pass around -> map.put(ShapeColor.BLUE, Color.Blue);
