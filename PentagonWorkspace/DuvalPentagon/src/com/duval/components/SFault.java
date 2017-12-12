package com.duval.components;

import com.duval.utils.Coordinates;

public class SFault extends Fault {
	
	public SFault(int xorigin, int yorigin, int scale) {
		super(xorigin, yorigin, scale, "S");
		initPoints();
	}

	public int len() {
		return 8;
	}
	
	@Override
	public void initPoints() {
		Coordinates p[] = new Coordinates[len()];
		p[0] = new Coordinates(-35,3);
		p[1] = new Coordinates(0,1.5);
		p[2] = new Coordinates(0,24.5);
		p[3] = new Coordinates(0,33);
		p[4] = new Coordinates(-1,24.5);
		p[5] = new Coordinates(-1,33);
		p[6] = new Coordinates(0,40);
		p[7] = new Coordinates(-38, 12.4);
		super.points = p;
	}

}
