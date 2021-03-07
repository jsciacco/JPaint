package model;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

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
	
	public static ArrayList<IShape> deletedGroupList = new ArrayList<IShape>();
	
	public static ArrayList<ArrayList<IShape>> groupShapeListArray = new ArrayList<ArrayList<IShape>>();
	
	static int listCount = shapeList.size();
	int selectListCount = selectShapeList.size();

	public static ShapeDraw shapeDraw;

	public ShapeList(ShapeDraw shapeDraw) {
		ShapeList.shapeDraw = shapeDraw;
	}

	public void checkList(myPoint startPoint, myPoint endPoint) {
		
		selectShapeList.clear();
		deletedGroupList.clear();
		
		ArrayList<Integer>startXList = new ArrayList<Integer>();
		ArrayList<Integer>startYList = new ArrayList<Integer>();
		ArrayList<Integer>endXList = new ArrayList<Integer>();
		ArrayList<Integer>endYList = new ArrayList<Integer>();
		ArrayList<IShape>groupList = new ArrayList<IShape>();
		
		for (IShape shape: shapeList) {
			
			if (startPoint.getX() < shape.getEndX() && endPoint.getX() > shape.getStartX() &&
					startPoint.getY() < shape.getEndY() && endPoint.getY() > shape.getStartY()) {
				selectShapeList.add(shape);
			}
			
			for (ArrayList<IShape> groupArray: groupShapeListArray) {
				
				for (IShape groupShape: groupArray){
					startXList.add(groupShape.getStartX());
					startYList.add(groupShape.getStartY());
					endXList.add(groupShape.getEndX());
					endYList.add(groupShape.getEndY());
				}
				
				int xStart = Collections.min(startXList)-5;
				int yStart = Collections.min(startYList)-5;
				int xEnd = Collections.max(endXList)+5;
				int yEnd = Collections.max(endYList)+5;
					
				startXList.clear();
				startYList.clear();
				endXList.clear();
				endYList.clear();
				
				if (groupArray.contains(shape) && startPoint.getX() < xEnd && endPoint.getX() > xStart &&
					startPoint.getY() < yEnd && endPoint.getY() > yStart) {
					selectShapeList.add(shape);
				}
				
				//if (groupArray.contains(shape) && selectShapeList.contains(shape)) {
				//	for (IShape newShape: groupArray){
				//		if (!selectShapeList.contains(newShape)) {
				//			selectShapeList.add(newShape);
				//		}
				//	}
				//}
			}					
		}
		
		if (!groupShapeListArray.isEmpty()) {
			shapeDraw.drawGroupBorder(shapeList, selectShapeList, groupShapeListArray);
		}
		else {
			shapeDraw.drawBorder(shapeList, selectShapeList);
		}
		System.out.println(selectListCount);	
	}

	public void moveList(myPoint startPoint, myPoint endPoint) {
		moveShapeList.clear();
		deltaX = endPoint.getX() - startPoint.getX();
		deltaY = endPoint.getY() - startPoint.getY();
		for (IShape shape: shapeList){
			for (ArrayList<IShape> groupArray: groupShapeListArray) {
				if (groupArray.contains(shape) && selectShapeList.contains(shape)) {
					for (IShape groupShape: groupArray){
						selectShapeList.add(groupShape);
					}
				}
			}
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
		if (!groupShapeListArray.isEmpty()) {
			//if (!deletedGroupList.isEmpty()) {
			//	shapeDraw.drawGroupBorderDelete(shapeList, selectShapeList, groupShapeListArray);
			//}
			//else {
			shapeDraw.drawGroupBorder(shapeList, selectShapeList, groupShapeListArray);
			//}
		}
		else {
		shapeDraw.drawBorder(shapeList, selectShapeList);
		}
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
		deletedGroupList.clear();
		ArrayList<IShape>deleteList = new ArrayList<IShape>();
		for (IShape shape: deleteCopy){
			shapeList.remove(shape);
			deleteShapeList.add(shape);
			System.out.println(listCount);
			for (ArrayList<IShape> groupArray: groupShapeListArray) {
				if (groupArray.contains(shape)) {
					for (IShape groupShape: groupArray){
						deleteList.add(groupShape);
						deletedGroupList.add(groupShape);
					}
				}
			}
			groupShapeListArray.remove(deleteList);
		}
		//if (!groupShapeListArray.isEmpty()) {
		//	shapeDraw.drawGroupBorderDelete(shapeList, selectShapeList, groupShapeListArray);
		//}
		//else {
			shapeDraw.reDraw(shapeList);
		//}
	}
	
	public static void undoDelete(ArrayList<IShape> deleteCopy) {
		ArrayList<IShape>deleteList = new ArrayList<IShape>();
		for (IShape shape : deleteCopy) {
			shapeList.add(shape);
			deleteShapeList.remove(shape);
			if (deletedGroupList.contains(shape)) {
				deleteList.add(shape);
			}
		}
		if (!deleteList.isEmpty()) {
			groupShapeListArray.add(deleteList);
		}
		System.out.println(listCount);
		if (!groupShapeListArray.isEmpty()) {
			shapeDraw.drawGroupBorder(shapeList, selectShapeList, groupShapeListArray);
		}
		else {
			shapeDraw.drawBorder(shapeList, selectShapeList);
		}
	}
	
	public static void groupList(ArrayList<IShape>groupList) {
		
		ArrayList<IShape> groupShapeList = new ArrayList<IShape>();
		
		for (IShape shape: groupList) {
			groupShapeList.add(shape);
		}
		groupShapeListArray.add(groupShapeList);
		shapeDraw.drawGroupBorder(shapeList, selectShapeList, groupShapeListArray);
		System.out.println(groupShapeListArray.size());
		
	}
	
	public static void unGroupList(ArrayList<IShape>groupList) {
		ArrayList<IShape> groupShapeList = new ArrayList<IShape>();
		
		for (IShape shape: groupList) {
			groupShapeList.add(shape);
		}
		if (groupShapeListArray.contains(groupShapeList)) {
			System.out.println("contains selected shapes");	
			groupShapeListArray.remove(groupShapeList);
		}
		
		System.out.println(groupShapeListArray.size());
		
		if (!groupShapeListArray.isEmpty()) {
			shapeDraw.drawGroupBorder(shapeList, selectShapeList, groupShapeListArray);
		}
		else {
			shapeDraw.drawBorder(shapeList, selectShapeList);
		}
	}
	
	public static void addShape(IShape shape) {
		shapeList.add(shape);
		System.out.println(listCount);
		if (selectShapeList.isEmpty() && groupShapeListArray.isEmpty()) {
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
			if (!groupShapeListArray.isEmpty()) {
				shapeDraw.drawGroupBorder(shapeList, selectShapeList, groupShapeListArray);
			}
			else {
				shapeDraw.drawBorder(shapeList, selectShapeList);
			}
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
		else if (!groupShapeListArray.isEmpty()) {
				shapeDraw.drawGroupBorder(shapeList, selectShapeList, groupShapeListArray);
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
		else if (!groupShapeListArray.isEmpty()) {
			shapeDraw.drawGroupBorder(shapeList, selectShapeList, groupShapeListArray);
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
		else if (!groupShapeListArray.isEmpty()) {
			shapeDraw.drawGroupBorder(shapeList, selectShapeList, groupShapeListArray);
		}
		else {
			shapeDraw.drawBorder(shapeList, selectShapeList);
		}
	}
}
