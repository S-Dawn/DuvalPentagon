package com.duval.utils;

import java.awt.Color;

import com.duval.components.D1Fault;
import com.duval.components.D2Fault;
import com.duval.components.Fault;
import com.duval.components.PDFault;
import com.duval.components.SFault;
import com.duval.components.T1Fault;
import com.duval.components.T2Fault;
import com.duval.components.T3Fault;

public class Detector {
	int xorigin;
	int yorigin;
	int scale;
	
	public Detector(int xorigin, int yorigin) {
		super();
		this.xorigin = xorigin;
		this.yorigin = yorigin;
		this.scale = 1;
	}
	
	public String FaultType(Coordinates p) {
		
		Fault pd = new PDFault(xorigin, yorigin, scale);
		Fault d1 = new D1Fault(xorigin, yorigin, scale);
		Fault d2 = new D2Fault(xorigin, yorigin, scale);
		Fault t3 = new T3Fault(xorigin, yorigin, scale);
		Fault t2 = new T2Fault(xorigin, yorigin, scale);
		Fault t1 = new T1Fault(xorigin, yorigin, scale);
		Fault s = new SFault(xorigin, yorigin, scale);
		
		if(pd.isFault(p))
			return pd.getFaultName();
		else if(d1.isFault(p))
			return d1.getFaultName();
		else if(d2.isFault(p))
			return d2.getFaultName();
		else if(t3.isFault(p))
			return t3.getFaultName();
		else if(t2.isFault(p))
			return t2.getFaultName();
		else if(t1.isFault(p))
			return t1.getFaultName();
		else if(s.isFault(p))
			return s.getFaultName();
		else
			return "Invalid Coordinate";
		
	}

}
