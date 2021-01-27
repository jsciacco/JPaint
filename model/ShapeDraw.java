package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.interfaces.IShape;
import model.interfaces.IShapeDraw;
import view.interfaces.PaintCanvasBase;

public class ShapeDraw implements IShapeDraw {
	
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
			
			int x = shape.getX();
			int y = shape.getY();
			int height = shape.getHeight();
			int width = shape.getWidth();
			
			shape.draw(paintCanvas, x, y, height, width);
		}
	}
}
