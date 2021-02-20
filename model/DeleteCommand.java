package model;

import java.util.ArrayList;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

public class DeleteCommand implements ICommand, IUndoable {
	
	ArrayList<IShape> deleteShapeList = new ArrayList<IShape>();
	@Override
	public void run(){
		deleteShapeList = ShapeList.getSelect();
		ShapeList.deleteList(deleteShapeList);
		CommandHistory.add(this);
	}
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		ShapeList.undoDelete(deleteShapeList);
	}
	@Override
	public void redo() {
		// TODO Auto-generated method stub
		deleteShapeList = ShapeList.getSelect();
		ShapeList.deleteList(deleteShapeList);
		CommandHistory.add(this);
	}
}