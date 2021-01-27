	package model.interfaces;

	import controller.myPoint;
	import model.ShapeColor;
	import model.ShapeShadingType;
	import model.ShapeType;
	import view.interfaces.PaintCanvasBase;

	public interface IShape {
		int getX();
		int getY();
		int getWidth();
		int getHeight();
		
		ShapeColor getPrimaryColor();
		ShapeColor getSecondaryColor();
		ShapeShadingType getshapeShadingType();
		ShapeType getShapeType();
		
		void addShape(IShape shape);
		void removeShape(IShape shape);
		void draw(PaintCanvasBase paintcanvas, int x, int y, int height, int width);
	}
