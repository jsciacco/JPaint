package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.Main;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

    public class MyMouseHandler extends MouseAdapter implements MouseListener {
    	
    	public PaintCanvasBase paintCanvas;
        public myPoint startPoint;
        public myPoint endPoint;
        public static int height;
        public static int width;
        public static int x;
        public static int y;
        
        public MyMouseHandler(PaintCanvasBase paintCanvas) {
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
            Graphics2D graphics2d = paintCanvas.getGraphics2D();
            graphics2d.fillRect(x, y, height, width);
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
