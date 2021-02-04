package model;

import java.awt.List;
import java.util.ArrayList;

import controller.myPoint;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import view.interfaces.PaintCanvasBase;

public class ShapeList implements IShapeList{

	public int deltaX, deltaY;

	public static ArrayList<IShape> shapeList = new ArrayList<IShape>();

	public static ArrayList<IShape> selectShapeList = new ArrayList<IShape>();

	public static ArrayList<IShape> moveShapeList = new ArrayList<IShape>();

	int listCount = shapeList.size();
	int selectListCount = selectShapeList.size();

	public ShapeDraw shapeDraw;

	public ShapeList(ShapeDraw shapeDraw) {
		this.shapeDraw = shapeDraw;
	}

	public void checkList(myPoint startPoint, myPoint endPoint) {
		selectShapeList.clear();
		for (IShape shape: shapeList) {
			if (startPoint.getX() < shape.getEndX() && endPoint.getX() > shape.getStartX() &&
					startPoint.getY() < shape.getEndY() && endPoint.getY() > shape.getStartY()) {
				selectShapeList.add(shape);
			}
			System.out.println(selectListCount);	
		}
	}

	public void moveList(myPoint startPoint, myPoint endPoint) {
		moveShapeList.clear();
		deltaX = endPoint.getX() - startPoint.getX();
		deltaY = endPoint.getY() - startPoint.getY();
		for (IShape shape: shapeList){
			if (selectShapeList.contains(shape)) {
				shape.setStartX(shape.getStartX() + deltaX);
				shape.setStartY(shape.getStartY() + deltaY);
				moveShapeList.add(shape);
			}
		}
		shapeDraw.reDraw(shapeList);
	}
	@Override
	public void addShape(IShape shape) {
		shapeList.add(shape);
		System.out.println(listCount);
		shapeDraw.reDraw(shapeList);

		// TODO Auto-generated method stub
	}
	@Override
	public void removeShape(IShape shape) {
		// TODO Auto-generated method stub
		shapeList.remove(shape);
		System.out.println(listCount);
		shapeDraw.reDraw(shapeList);

	}

	@Override
	public void undoMove() {
		// TODO Auto-generated method stub
		for (IShape shape: shapeList) {
			if (moveShapeList.contains(shape)) {
				shape.setStartX(shape.getStartX() - deltaX);
				shape.setStartY(shape.getStartY() - deltaY);
			}
		}
		shapeDraw.reDraw(shapeList);
	}

	@Override
	public void redoMove() {
		// TODO Auto-generated method stub
		for (IShape shape: shapeList) {
			if (moveShapeList.contains(shape)) {
				shape.setStartX(shape.getStartX() + deltaX);
				shape.setStartY(shape.getStartY() + deltaY);
			}
		}
		shapeDraw.reDraw(shapeList);
	}
}
