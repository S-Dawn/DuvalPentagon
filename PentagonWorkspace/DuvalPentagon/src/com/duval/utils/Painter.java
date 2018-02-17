package com.duval.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.duval.components.D1Fault;
import com.duval.components.D2Fault;
import com.duval.components.Fault;
import com.duval.components.PDFault;
import com.duval.components.SFault;
import com.duval.components.T1Fault;
import com.duval.components.T2Fault;
import com.duval.components.T3Fault;

public class Painter {

	JLabel view;
	BufferedImage surface;
	Random random = new Random();
	int height, width;
	int xorigin, yorigin, scale;
	JFrame frame;
	JButton resetCanvas, plotpoints, plotfaultpoints, plotokpoints, plotpentagon, countfaultpoints;
	Controller cont;

	public Painter(int height, int width, int scale) throws Exception {
		this.height = height;
		this.width = width;
		xorigin = height / 2;
		yorigin = width / 2;
		this.scale = scale;
		frame = new JFrame();

		createCanvas();
		initButtons();
	}

	public void createCanvas() {
		surface = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
		view = new JLabel(new ImageIcon(surface));
		Graphics g = surface.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 600);
		g.setColor(Color.BLACK);

		Polygon p = new Polygon();

		// Creation of the Extreme Points
		p.addPoint(xorigin + 0 * scale, yorigin - 100 * scale);
		p.addPoint(xorigin - 95 * scale, yorigin - 31 * scale);
		p.addPoint(xorigin - 59 * scale, yorigin + 81 * scale);
		p.addPoint(xorigin + 59 * scale, yorigin + 81 * scale);
		p.addPoint(xorigin + 95 * scale, yorigin - 31 * scale);

		g.drawPolygon(p);

		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(xorigin, yorigin, xorigin + 0 * scale, yorigin - 100 * scale);
		g.drawLine(xorigin, yorigin, xorigin - 95 * scale, yorigin - 31 * scale);
		g.drawLine(xorigin, yorigin, xorigin - 59 * scale, yorigin + 81 * scale);
		g.drawLine(xorigin, yorigin, xorigin + 59 * scale, yorigin + 81 * scale);
		g.drawLine(xorigin, yorigin, xorigin + 95 * scale, yorigin - 31 * scale);

		// Creation of the Boundaries

		g.setColor(Color.BLACK);
		Fault pd = new PDFault(xorigin, yorigin, scale);
		g.drawPolygon(pd.getX(), pd.getY(), pd.len());
		Fault d1 = new D1Fault(xorigin, yorigin, scale);
		g.drawPolygon(d1.getX(), d1.getY(), d1.len());
		Fault d2 = new D2Fault(xorigin, yorigin, scale);
		g.drawPolygon(d2.getX(), d2.getY(), d2.len());
		Fault t3 = new T3Fault(xorigin, yorigin, scale);
		g.drawPolygon(t3.getX(), t3.getY(), t3.len());
		Fault t2 = new T2Fault(xorigin, yorigin, scale);
		g.drawPolygon(t2.getX(), t2.getY(), t2.len());
		Fault t1 = new T1Fault(xorigin, yorigin, scale);
		g.drawPolygon(t1.getX(), t1.getY(), t1.len());
		Fault s = new SFault(xorigin, yorigin, scale);
		g.drawPolygon(s.getX(), s.getY(), s.len());

		g.dispose();

	}

	public void addNewElement(Coordinates p, boolean match) {
		Graphics g = surface.getGraphics();
		if (match) {
			g.setColor(Color.BLUE);
			drawNode(p, g);
		} else {
			g.setColor(Color.RED);
			drawNode(p, g);
		}
		g.dispose();
		view.repaint();
	}

	public void addNewElement(Coordinates p, String fault) {
		Graphics g = surface.getGraphics();
		if (fault.equals("PD")) {
			g.setColor(Color.YELLOW);
			drawNode(p, g);
		} else if (fault.equals("D1")) {
			g.setColor(Color.BLUE);
			drawNode(p, g);
		} else if (fault.equals("D2")) {
			g.setColor(Color.RED);
			drawNode(p, g);
		} else if (fault.equals("T3")) {
			g.setColor(Color.GREEN);
			drawNode(p, g);
		} else if (fault.equals("T2")) {
			g.setColor(Color.PINK);
			drawNode(p, g);
		} else if (fault.equals("T1")) {
			g.setColor(Color.PINK);
			drawNode(p, g);
		} else if (fault.equals("T1/T2") || fault.equals("T2/T1")) {
			g.setColor(Color.PINK);
			drawNode(p, g);
		} else if (fault.equals("S")) {
			g.setColor(Color.ORANGE);
			drawNode(p, g);
		} else {
			g.setColor(Color.BLACK);
			drawNode(p, g);
		}
		g.dispose();
		view.repaint();
	}

	public void addNewElementDirect(Coordinates p, String fault) {
		Graphics g = surface.getGraphics();
		if (fault.equals("PD")) {
			g.setColor(Color.YELLOW);
			drawDirectNode(p, g);
		} else if (fault.equals("D1")) {
			g.setColor(Color.BLUE);
			drawDirectNode(p, g);
		} else if (fault.equals("D2")) {
			g.setColor(Color.RED);
			drawDirectNode(p, g);
		} else if (fault.equals("T3")) {
			g.setColor(Color.GREEN);
			drawDirectNode(p, g);
		} else if (fault.equals("T2")) {
			g.setColor(Color.PINK);
			drawDirectNode(p, g);
		} else if (fault.equals("T1")) {
			g.setColor(Color.PINK);
			drawDirectNode(p, g);
		} else if (fault.equals("T1/T2") || fault.equals("T2/T1")) {
			g.setColor(Color.PINK);
			drawDirectNode(p, g);
		} else if (fault.equals("S")) {
			g.setColor(Color.ORANGE);
			drawDirectNode(p, g);
		} else {
			g.setColor(Color.BLACK);
			drawDirectNode(p, g);
		}
		g.dispose();
		view.repaint();
	}

	public void initButtons() {
		resetCanvas = new JButton("Reset Canvas");
		plotpoints = new JButton("Plot Points");
		plotfaultpoints = new JButton("Plot Fault Points");
		plotokpoints = new JButton("Plot Ok Points");
		plotpentagon = new JButton("Plot Pentagon");
		countfaultpoints = new JButton("Count Fault Points");

		resetCanvas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				createCanvas();
			}
		});

		plotpoints.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

	}

	public void show() {

		int vertexes = 0;
		vertexes = 10;
		int canvasSize = vertexes * vertexes;
		frame.setSize(canvasSize, canvasSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this.view);
		frame.add(resetCanvas);
		frame.add(plotpoints);
		frame.add(plotfaultpoints);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public void drawNode(Coordinates p, Graphics g) {
		int xLoc = (int) (xorigin + (p.getX() * scale) - 5);
		int yLoc = (int) (yorigin - (p.getY() * scale) - 5);
		g.fillOval(xLoc, yLoc, scale, scale);
		g.drawOval(xLoc, yLoc, scale, scale);
	}

	public void drawDirectNode(Coordinates p, Graphics g) {
		int xLoc = (int) (p.getX());
		int yLoc = (int) (p.getY());
		g.fillOval(xLoc, yLoc, scale, scale);
		g.drawOval(xLoc, yLoc, scale, scale);
	}

	public void drawpentagon(Coordinates coor[], Color col) {
		Polygon p = new Polygon();
		Graphics g = surface.getGraphics();
		g.setColor(col);
		p.addPoint((int) (xorigin + coor[0].getX() * scale), (int) (yorigin - coor[0].getY() * scale));
		p.addPoint((int) (xorigin + coor[1].getX() * scale), (int) (yorigin - coor[1].getY() * scale));
		p.addPoint((int) (xorigin + coor[2].getX() * scale), (int) (yorigin - coor[2].getY() * scale));
		p.addPoint((int) (xorigin + coor[3].getX() * scale), (int) (yorigin - coor[3].getY() * scale));
		p.addPoint((int) (xorigin + coor[4].getX() * scale), (int) (yorigin - coor[4].getY() * scale));
		g.drawPolygon(p);
	}

	public void drawpolygon(ArrayList<Point> list, Color col) {
		Polygon p = new Polygon();
		Graphics g = surface.getGraphics();
		g.setColor(col);
		for(java.awt.Point pd:list)
			System.out.println(pd.toString());
		System.out.println();
		for (Point point : list) {
			p.addPoint((int) (xorigin + point.getX() * scale), (int) (yorigin - point.getY() * scale));
		}
		g.drawPolygon(p);
	}
}
