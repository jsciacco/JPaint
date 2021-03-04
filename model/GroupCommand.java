package model;

import java.io.IOException;
import java.util.ArrayList;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

public class GroupCommand implements ICommand, IUndoable{
	
	ArrayList<IShape> groupShapeList = new ArrayList<IShape>();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		groupShapeList = ShapeList.getSelect();
		ShapeList.groupList(groupShapeList);
		CommandHistory.add(this);	
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		groupShapeList = ShapeList.getSelect();
		ShapeList.unGroupList(groupShapeList);
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		groupShapeList = ShapeList.getSelect();
		ShapeList.groupList(groupShapeList);
		CommandHistory.add(this);
	}

	

}
