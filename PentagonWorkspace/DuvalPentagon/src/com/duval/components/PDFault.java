package com.duval.components;

import com.duval.utils.Coordinates;

public class PDFault extends Fault{

	public PDFault(int xorigin, int yorigin, int scale) {
		super(xorigin, yorigin, scale, "PD");
		initPoints();
	}

	public int len() {
		return 4;
	}
	
	@Override
	public void initPoints() {
		Coordinates p[] = new Coordinates[len()];
		p[0] = new Coordinates(0,24.5);
		p[1] = new Coordinates(0,33);
		p[2] = new Coordinates(-1,24.5);
		p[3] = new Coordinates(-1,33);
		
		super.points = p;
	}
	
}
