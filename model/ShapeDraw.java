package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

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

	public void drawGroupBorder(ArrayList<IShape>shapeList, ArrayList<IShape>selectShapeList, ArrayList<ArrayList<IShape>> groupShapeListArray) {

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

		ArrayList<Integer>startXList = new ArrayList<Integer>();
		ArrayList<Integer>startYList = new ArrayList<Integer>();
		ArrayList<Integer>endXList = new ArrayList<Integer>();
		ArrayList<Integer>endYList = new ArrayList<Integer>();
		ArrayList<IShape>groupList = new ArrayList<IShape>();

		for (ArrayList<IShape> groupArray: groupShapeListArray) {

			for (IShape shape: groupArray) {
				startXList.add(shape.getStartX());
				startYList.add(shape.getStartY());
				endXList.add(shape.getEndX());
				endYList.add(shape.getEndY());
			}	
			int xStart = Collections.min(startXList)-5;
			int yStart = Collections.min(startYList)-5;
			int xEnd = Collections.max(endXList)+5;
			int yEnd = Collections.max(endYList)+5;
			int groupWidth = xEnd-xStart;
			int groupHeight = yEnd-yStart;

			startXList.clear();
			startYList.clear();
			endXList.clear();
			endYList.clear();

			Graphics2D graphics2d = paintCanvas.getGraphics2D();

			if (selectShapeList.containsAll(groupArray)) {

				graphics2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0));
				graphics2d.setColor(Color.BLACK);
				graphics2d.drawRect(xStart, yStart, groupWidth, groupHeight);
				
				for (IShape shape: groupArray) {
					groupList.add(shape);
				}
			}
			else {
				graphics2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0));
				graphics2d.setColor(Color.ORANGE);
				graphics2d.drawRect(xStart, yStart, groupWidth, groupHeight);
			}
		}
		for (IShape shape: selectShapeList) {
			
			if (!groupList.contains(shape)) {
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
		
	public void drawGroupBorderDelete(ArrayList<IShape>shapeList, ArrayList<IShape>selectShapeList, ArrayList<ArrayList<IShape>> groupShapeListArray) {

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

		ArrayList<Integer>startXList = new ArrayList<Integer>();
		ArrayList<Integer>startYList = new ArrayList<Integer>();
		ArrayList<Integer>endXList = new ArrayList<Integer>();
		ArrayList<Integer>endYList = new ArrayList<Integer>();

		for (ArrayList<IShape> groupArray: groupShapeListArray) {

			for (IShape shape: groupArray) {
				startXList.add(shape.getStartX());
				startYList.add(shape.getStartY());
				endXList.add(shape.getEndX());
				endYList.add(shape.getEndY());
			}	
			int xStart = Collections.min(startXList)-5;
			int yStart = Collections.min(startYList)-5;
			int xEnd = Collections.max(endXList)+5;
			int yEnd = Collections.max(endYList)+5;
			int groupWidth = xEnd-xStart;
			int groupHeight = yEnd-yStart;

			startXList.clear();
			startYList.clear();
			endXList.clear();
			endYList.clear();

			Graphics2D graphics2d = paintCanvas.getGraphics2D();
			
			graphics2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0));
			graphics2d.setColor(Color.ORANGE);
			graphics2d.drawRect(xStart, yStart, groupWidth, groupHeight);
			}
		}
}

