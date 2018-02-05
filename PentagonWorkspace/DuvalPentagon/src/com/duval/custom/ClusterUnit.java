package com.duval.custom;

import com.duval.utils.Coordinates;

public class ClusterUnit {
	
	Coordinates coord;
	String originalFault;
	
	public ClusterUnit() {
		super();
	}

	public Coordinates getCoord() {
		return coord;
	}

	public ClusterUnit(Coordinates coord, String originalFault) {
		super();
		this.coord = coord;
		this.originalFault = originalFault;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	@Override
	public String toString() {
		return "ClusterUnit [coord=" + coord + ", originalFault=" + originalFault + "]";
	}

	public String getOriginalFault() {
		return originalFault;
	}

	public void setOriginalFault(String originalFault) {
		this.originalFault = originalFault;
	}
	
}
