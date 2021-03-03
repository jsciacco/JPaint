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
	
	public static ArrayList<IShape> copyShapeList = new ArrayList<IShape>();
	
	public static ArrayList<IShape> deleteShapeList = new ArrayList<IShape>();
	
	public static ArrayList<ArrayList<IShape>> groupShapeListArray = new ArrayList<ArrayList<IShape>>();
	
	public static ArrayList<IShape> groupShapeList = new ArrayList<IShape>();

	static int listCount = shapeList.size();
	int selectListCount = selectShapeList.size();

	public static ShapeDraw shapeDraw;

	public ShapeList(ShapeDraw shapeDraw) {
		ShapeList.shapeDraw = shapeDraw;
	}

	public void checkList(myPoint startPoint, myPoint endPoint) {
		selectShapeList.clear();
		for (IShape shape: shapeList) {
			if (startPoint.getX() < shape.getEndX() && endPoint.getX() > shape.getStartX() &&
					startPoint.getY() < shape.getEndY() && endPoint.getY() > shape.getStartY()) {
				selectShapeList.add(shape);
			}
			shapeDraw.drawBorder(shapeList, selectShapeList);
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
				shape.setEndX(shape.getEndX() + deltaX);
				shape.setEndY(shape.getEndY() + deltaY);
				shape.setWidth((shape.getEndX() + deltaX) - (shape.getStartX() + deltaX));
				shape.setHeight((shape.getEndY() + deltaY) - (shape.getStartY() + deltaY));
				moveShapeList.add(shape);
			}
		}
		shapeDraw.drawBorder(shapeList, selectShapeList);
	}
	
	public static ArrayList<IShape> getSelect() {
		return selectShapeList;
	}
	
	public static ArrayList<IShape> getCopy() {
		return copyShapeList;
	}
	public static void copyList(ArrayList<IShape>shapeCopy) {
		copyShapeList = shapeCopy;
	}
	
	public static void deleteList(ArrayList<IShape>deleteCopy) {
		for (IShape shape: deleteCopy){
			shapeList.remove(shape);
			deleteShapeList.add(shape);
			System.out.println(listCount);
		}
		shapeDraw.reDraw(shapeList);
	}
	
	public static void undoDelete(ArrayList<IShape> deleteCopy) {
		for (IShape shape : deleteCopy) {
			shapeList.add(shape);
			deleteShapeList.remove(shape);
			System.out.println(listCount);
		}
		shapeDraw.drawBorder(shapeList, selectShapeList);
	}
	
	public static void groupList(ArrayList<IShape>groupList) {
		groupShapeList.clear();
		for (IShape shape: groupList) {
			groupShapeList.add(shape);
		}
		groupShapeListArray.add(groupShapeList);
		selectShapeList.clear();
		shapeDraw.drawGroupBorder(shapeList, selectShapeList, groupShapeListArray);
		System.out.println(groupShapeListArray.size());
		
	}
	public static void addShape(IShape shape) {
		shapeList.add(shape);
		System.out.println(listCount);
		if (selectShapeList.isEmpty()) {
			shapeDraw.reDraw(shapeList);
		}
		else {
			if (!deleteShapeList.isEmpty()){
				for (IShape s: deleteShapeList){
					if (selectShapeList.contains(s)){
						selectShapeList.remove(s);
					}
				}
			}
			shapeDraw.drawBorder(shapeList, selectShapeList);
		}
		// TODO Auto-generated method stub
	}
	public static void removeShape(IShape shape) {
		// TODO Auto-generated method stub
		shapeList.remove(shape);
		if (selectShapeList.contains(shape)) {
		selectShapeList.remove(shape);
		}
		System.out.println(listCount);
		if (selectShapeList.isEmpty()) {
			shapeDraw.reDraw(shapeList);
		}
		else {
			shapeDraw.drawBorder(shapeList, selectShapeList);
		}
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
		if (selectShapeList.isEmpty()) {
			shapeDraw.reDraw(shapeList);
		}
		else {
			shapeDraw.drawBorder(shapeList, selectShapeList);
		}
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
		if (selectShapeList.isEmpty()) {
			shapeDraw.reDraw(shapeList);
		}
		else {
			shapeDraw.drawBorder(shapeList, selectShapeList);
		}
	}
}
