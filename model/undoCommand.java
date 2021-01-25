package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;

public class undoCommand implements ICommand, IUndoable {
    @Override
    public void run(){
        CommandHistory.undo();
    }

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}
}
