package model;

import java.awt.List;
import java.util.ArrayList;

import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import view.interfaces.PaintCanvasBase;

public class ShapeList implements IShapeList{
	
	public static ArrayList<IShape> shapeList = new ArrayList<IShape>();
	
	int listCount = shapeList.size();
	
	public ShapeDraw shapeDraw;
	
	public ShapeList(ShapeDraw shapeDraw) {
		this.shapeDraw = shapeDraw;
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
}
