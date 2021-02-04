package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.Main;
import model.CreateShapeCommand;
import model.MouseMode;
import model.MoveShapeCommand;
import model.SelectShapeCommand;
import model.ShapeDraw;
import model.ShapeList;
import model.interfaces.IApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

public class MyMouseHandler implements MouseListener {

	public myPoint startPoint;
	public myPoint endPoint;
	public static int height;
	public static int width;
	public static int x;
	public static int y;
	public PaintCanvasBase paintCanvas;
	public IApplicationState appState;
	public CreateShapeCommand createShapeCommand;
	public ShapeList shapeList; 
	public ShapeDraw shapeDraw;
	public MouseMode mouseMode;
	public SelectShapeCommand selectShapeCommand;
	public MoveShapeCommand moveShapeCommand;

	public MyMouseHandler(PaintCanvasBase paintCanvas, IApplicationState appState) {
		this.appState = appState;
		this.paintCanvas = paintCanvas;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		startPoint = new myPoint(e.getX(), e.getY());
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		endPoint = new myPoint(e.getX(), e.getY());
		height = (endPoint.getY()-startPoint.getY());
		width = (endPoint.getX()-startPoint.getX());
		System.out.println(x);
		System.out.println(y);
		System.out.println(height);
		System.out.println(width);

		mouseMode = appState.getActiveMouseMode();

		switch(mouseMode)
		{
		case DRAW:
			createShapeCommand = new CreateShapeCommand(paintCanvas, appState, startPoint, endPoint);
			createShapeCommand.run();
			break;
		case SELECT:
			selectShapeCommand = new SelectShapeCommand(paintCanvas, appState, startPoint, endPoint);
			selectShapeCommand.run();
			break;
		case MOVE:
			moveShapeCommand = new MoveShapeCommand(paintCanvas, appState, startPoint, endPoint);
			moveShapeCommand.run();
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
