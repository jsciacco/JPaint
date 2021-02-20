package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class ShapeDraw {

	PaintCanvasBase paintCanvas;

	public ShapeDraw(PaintCanvasBase paintCanvas) {
		this.paintCanvas = paintCanvas;
	}

	public void blankCanvas(PaintCanvasBase paintCanvas) {
		Graphics2D blankCanvas = paintCanvas.getGraphics2D();
		blankCanvas.setColor(Color.WHITE);
		blankCanvas.fillRect(0,0,paintCanvas.getWidth(),paintCanvas.getHeight());
	}

	public void reDraw(ArrayList<IShape>shapeList) {

		int listCount = shapeList.size();

		System.out.println(listCount);

		blankCanvas(paintCanvas);

		for (IShape shape: shapeList) {

			int startX = shape.getStartX();
			int startY = shape.getStartY();
			int endX = shape.getEndX();
			int endY = shape.getEndY();
			int height = shape.getHeight();
			int width = shape.getWidth();

			shape.draw(paintCanvas, startX, startY, endX, endY, height, width);
		}
	}
	
	public void drawBorder(ArrayList<IShape>shapeList, ArrayList<IShape>selectShapeList) {

		int selectListCount = selectShapeList.size();

		System.out.println(selectListCount);
		
		blankCanvas(paintCanvas);

		for (IShape shape: shapeList) {

			int startX = shape.getStartX();
			int startY = shape.getStartY();
			int endX = shape.getEndX();
			int endY = shape.getEndY();
			int height = shape.getHeight();
			int width = shape.getWidth();

			shape.draw(paintCanvas, startX, startY, endX, endY, height, width);
		}

		for (IShape shape: selectShapeList) {

			int startX = shape.getStartX()-5;
			int startY = shape.getStartY()-5;
			int endX = shape.getEndX()+5;
			int endY = shape.getEndY()+5;
			int height = shape.getHeight()+10;
			int width = shape.getWidth()+10;

			shape.drawOutline(paintCanvas, startX, startY, endX, endY, height, width);
		}
	}
}
