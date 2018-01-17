package com.duval.datasource;

import com.duval.utils.Coordinates;

public class DSData implements GenData{

	double H2, C2H6, CH4, C2H4, C2H2;
	
	String Fault, PredictedFault;
	Coordinates faultcoordinates;
	boolean match;

	public DSData(double h2, double c2h6, double cH4, double c2h4, double c2h2, String fault) {
		super();
		H2 = h2;
		C2H6 = c2h6;
		CH4 = cH4;
		C2H4 = c2h4;
		C2H2 = c2h2;
		Fault = fault;
		this.match = false;
		this.faultcoordinates = null;
	}

	public DSData() {
		super();
	}

	public double getH2() {
		return H2;
	}

	public void setH2(double h2) {
		H2 = h2;
	}

	public double getC2H6() {
		return C2H6;
	}

	public void setC2H6(double c2h6) {
		C2H6 = c2h6;
	}

	public double getCH4() {
		return CH4;
	}

	public void setCH4(double cH4) {
		CH4 = cH4;
	}

	public double getC2H4() {
		return C2H4;
	}

	public void setC2H4(double c2h4) {
		C2H4 = c2h4;
	}

	public double getC2H2() {
		return C2H2;
	}

	public void setC2H2(double c2h2) {
		C2H2 = c2h2;
	}

	public String getFault() {
		return Fault;
	}

	public void setFault(String fault) {
		Fault = fault;
		String [] faultarr = Fault.split("/");
		match = false;
		for(int i=0; i<faultarr.length;i++) {
			if(faultarr[i].equals(PredictedFault))
				match = true;
		}
	}

	public String getPredictedFault() {
		return PredictedFault;
	}

	public void setPredictedFault(String predictedFault) {
		PredictedFault = predictedFault;
		String [] faultarr = Fault.split("/");
		match = false;
		for(int i=0; i<faultarr.length;i++) {
			if(faultarr[i].equals(PredictedFault))
				match = true;
		}
	}
	
	public boolean isAmbiguous() {
		return !match;
	}
	
	public Coordinates getFaultcoordinates() {
		return faultcoordinates;
	}

	public void setFaultcoordinates(Coordinates faultcoordinates) {
		this.faultcoordinates = faultcoordinates;
	}


	@Override
	public String toString() {
		return "DSData [H2=" + H2 + ", C2H6=" + C2H6 + ", CH4=" + CH4 + ", C2H4=" + C2H4 + ", C2H2=" + C2H2 + ", Fault="
				+ Fault + "]";
	}

	@Override
	public Coordinates getCoordinates() {
		return getFaultcoordinates();
	}

	@Override
	public void setCoordinates(Coordinates coor) {
		setFaultcoordinates(coor);		
	}
	
}
