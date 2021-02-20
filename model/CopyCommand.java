package model;

import java.util.ArrayList;

import model.interfaces.ICommand;
import model.interfaces.IShape;

public class CopyCommand implements ICommand {
	
	ArrayList<IShape> copyShapeList = new ArrayList<IShape>();
	@Override
	public void run(){
		copyShapeList = ShapeList.getSelect();
		ShapeList.copyList(copyShapeList);
	}
}