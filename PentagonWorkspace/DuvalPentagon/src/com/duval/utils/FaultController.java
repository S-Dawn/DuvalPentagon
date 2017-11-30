package com.duval.utils;

import com.duval.datasource.DSData;

public class FaultController {

	double a, b, c, d, e;
	double ar, br, cr, dr, er;
	double sum;
	
	Coordinates coor[];
	
	Coordinates centroid;
	
	public Coordinates getFaultPoints(double a, double b, double c, double d, double e){
		init(a, b, c, d, e);
		return getCentroid();
	}
	
	public Coordinates getFaultPoints(DSData obj){
		this.a = obj.getH2();
		this.b = obj.getC2H6();
		this.c = obj.getCH4();
		this.d = obj.getC2H4();
		this.e = obj.getC2H2();
		init(a, b, c, d, e);
		return getCentroid();
	}

	void init (double a, double b, double c, double d, double e) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		
		sum = a + b + c + d + e;
		
		processRelativeConc();		
		processCoordinates();
		processCentroid();
	}
	
	public Coordinates getCentroid() {
		return centroid;
	}

	private void processRelativeConc() {
		ar = a*100/sum;
		br = b*100/sum;
		cr = c*100/sum;
		dr = d*100/sum;
		er = e*100/sum;	
	}
	
	private void processCoordinates () {
		
		double adeg = 90;
		double bdeg = 180-18;
		double cdeg = 180+54;
		double ddeg = 360-54;
		double edeg = 18;
		
		int x, y;
		
		coor = new Coordinates[5];
		
		x = (int) (ar*Math.cos(Math.toRadians(adeg)));
		y = (int) (ar*Math.sin(Math.toRadians(adeg)));
		coor[0] = new Coordinates(x, y);
		
		x = (int) (br*Math.cos(Math.toRadians(bdeg)));
		y = (int) (br*Math.sin(Math.toRadians(bdeg)));
		coor[1] = new Coordinates(x, y);
		
		x = (int) (cr*Math.cos(Math.toRadians(cdeg)));
		y = (int) (cr*Math.sin(Math.toRadians(cdeg)));
		coor[2] = new Coordinates(x, y);
		
		x = (int) (dr*Math.cos(Math.toRadians(ddeg)));
		y = (int) (dr*Math.sin(Math.toRadians(ddeg)));
		coor[3] = new Coordinates(x, y);
		
		x = (int) (er*Math.cos(Math.toRadians(edeg)));
		y = (int) (er*Math.sin(Math.toRadians(edeg)));
		coor[4] = new Coordinates(x, y);
		
	}
	
	private void processCentroid() {
		double A = 0;
		
		for(int i=0; i<coor.length-1; i++) {
			A += coor[i].getX()*coor[i+1].getY() - coor[i+1].getX()*coor[i].getY();
		}
		
		A = A / 2;
		
		double Cx = 0, Cy = 0;
		
		for(int i=0; i<coor.length-1; i++) {
			
			Cx += (coor[i].getX() + coor[i+1].getX())*((coor[i].getX()*coor[i+1].getY())-(coor[i+1].getX()*coor[i].getY()));
			
			Cy += (coor[i].getY() + coor[i+1].getY())*((coor[i].getX()*coor[i+1].getY())-(coor[i+1].getX()*coor[i].getY()));
		}
		
		Cx = Cx/(6*A);
		Cy = Cy/(6*A);
		
		centroid = new Coordinates((int)Cx, (int)Cy);
	}
	
	
}
