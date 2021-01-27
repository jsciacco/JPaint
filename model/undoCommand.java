package model;

import model.interfaces.ICommand;

public class undoCommand implements ICommand {
    @Override
    public void run(){
        CommandHistory.undo();
    }
}
