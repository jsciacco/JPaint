package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;

public class redoCommand implements ICommand, IUndoable {
    @Override
    public void run() {
        CommandHistory.redo();
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
