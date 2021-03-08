package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MyMouseHandler;
import controller.myPoint;
import model.ShapeColor;
import model.ShapeDraw;
import model.ShapeList;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;
import java.util.EnumMap;

public class Main {

	public static void main(String[] args){
		PaintCanvasBase paintCanvas = new PaintCanvas();
		IGuiWindow guiWindow = new GuiWindow(paintCanvas);
		IUiModule uiModule = new Gui(guiWindow);
		ApplicationState appState = new ApplicationState(uiModule);
		IJPaintController controller = new JPaintController(uiModule, appState);
		controller.setup();

		paintCanvas.addMouseListener(new MyMouseHandler(paintCanvas, appState));

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
