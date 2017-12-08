package com.duval.components;

import com.duval.utils.Coordinates;

public class T3Fault extends Fault{
	
	public T3Fault(int xorigin, int yorigin, int scale) {
		super(xorigin, yorigin, scale, "T3");
		initPoints();
	}

	public int len() {
		return 5;
	}
	
	@Override
	public void initPoints() {
		Coordinates p[] = new Coordinates[len()];
		p[0] = new Coordinates(24,-30);
		p[1] = new Coordinates(-1,-2);
		p[2] = new Coordinates(-6,-4);
		p[3] = new Coordinates(1,-32);
		p[4] = new Coordinates(23, -32);
		
		super.points = p;
	}
	
	
}
