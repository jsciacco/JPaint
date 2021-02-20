package model.interfaces;

import controller.myPoint;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public interface IShape {
	int getStartX();
	int getStartY();
	int getEndX();
	int getEndY();
	int getWidth();
	int getHeight();

	ShapeColor getPrimaryColor();
	ShapeColor getSecondaryColor();
	ShapeShadingType getshapeShadingType();
	ShapeType getShapeType();

	void setStartX(int deltaX);
	void setStartY(int deltaY);
	void addShape(IShape shape);
	void removeShape(IShape shape);
	void draw(PaintCanvasBase paintcanvas, int startX, int startY, int endX, int endY, int height, int width);
	void drawOutline(PaintCanvasBase paintCanvas, int startX, int startY, int endX, int endY, int height, int width);
	void setEndX(int deltaX);
	void setEndY(int deltaY);
	void setWidth(int deltaW);
	void setHeight(int deltaH);
}
