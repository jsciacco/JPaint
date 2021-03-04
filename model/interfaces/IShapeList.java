package model.interfaces;

public interface IShapeList {
	static void addShape(IShape shape) {
	}
	static void removeShape(IShape shape) {
	}
	void undoMove();
	void redoMove();
	
}
