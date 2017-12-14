package com.duval.components;

import com.duval.utils.Coordinates;

public abstract class Fault {

	Coordinates points[];

	int xorigin;
	int yorigin;
	int scale;
	String faultName;

	public Fault(int xorigin, int yorigin, int scale, String faultName) {
		super();
		this.xorigin = xorigin;
		this.yorigin = yorigin;
		this.scale = scale;
		this.faultName = faultName;
	}

	public abstract void initPoints();

	public abstract int len();

	public int[] getX() {
		int res[] = new int[len()];

		for (int i = 0; i < len(); i++) {
			res[i] = (int) (xorigin + points[i].getX()*scale);
		}

		return res;
	}

	public int[] getY() {
		int res[] = new int[len()];

		for (int i = 0; i < len(); i++) {
			res[i] = (int) (yorigin - points[i].getY()*scale);
		}

		return res;
	}
	
	public Coordinates[] getPoints() {
		return this.points;
	}
	
	public String getFaultName() {
		return faultName;
	}
	
	public boolean isFault(Coordinates p) {
		return Coordinates.isInside(points, len(), p);
	}
	public boolean isFault(double x, double y) {
		Coordinates p = new Coordinates(x, y);
		return Coordinates.isInside(points, len(), p);
	}

}
