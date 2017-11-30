package com.duval.helper;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.duval.components.D1Fault;
import com.duval.components.D2Fault;
import com.duval.components.PDFault;
import com.duval.components.T1Fault;
import com.duval.components.T2Fault;
import com.duval.components.T3Fault;

public class Helper extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Polygon p = new Polygon();

		int xorigin = 400;
		int yorigin = 200;

		// Creation of the Extreme Points
		p.addPoint(xorigin + 0, yorigin - 100);
		p.addPoint(xorigin - 95, yorigin - 31);
		p.addPoint(xorigin - 59, yorigin + 81);
		p.addPoint(xorigin + 59, yorigin + 81);
		p.addPoint(xorigin + 95, yorigin - 31);

		g.drawPolygon(p);

		// Creation of the Boundaries

		
		g.setColor(Color.CYAN);
		PDFault pd = new PDFault(xorigin, yorigin);
		g.fillPolygon(pd.getPDx(),pd.getPDy(),pd.len());
		g.setColor(Color.PINK);
		D1Fault d1 = new D1Fault(xorigin, yorigin);
		g.fillPolygon(d1.getD1x(xorigin),d1.getD1y(yorigin), d1.len());
		g.setColor(Color.GREEN);
		D2Fault d2 = new D2Fault(xorigin, yorigin);
		g.fillPolygon(d2.getD2x(xorigin), d2.getD2y(yorigin), d2.len());
		g.setColor(Color.ORANGE);
		T3Fault t3 = new T3Fault(xorigin, yorigin);
		g.fillPolygon(t3.getT3x(xorigin), t3.getT3y(yorigin), t3.len());
		g.setColor(Color.PINK);
		T2Fault t2 = new T2Fault(xorigin, yorigin);
		g.fillPolygon(t2.getT2x(xorigin), t2.getT2y(yorigin), t2.len());
		g.setColor(Color.YELLOW);
		T1Fault t1 = new T1Fault(xorigin, yorigin);
		g.fillPolygon(t1.getT1x(xorigin), t1.getT1y(yorigin), t1.len());
		

	}

	public static void showFrame() {
		JFrame frame = new JFrame();
		frame.setTitle("MarkI");
		frame.setSize(800, 600);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Container contentPane = frame.getContentPane();
		contentPane.add(new Helper());

		frame.show();
		
	}
	

	
	
	
	
}
