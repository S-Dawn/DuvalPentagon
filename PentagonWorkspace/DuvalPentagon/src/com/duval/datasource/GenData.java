package com.duval.datasource;

import com.duval.utils.Coordinates;

public interface GenData {
	
	public Coordinates getCoordinates();
	
	public void setCoordinates(Coordinates coor);
	
	public String getFault();
	
	public void setFault(String fault);	
	
	public String getPredictedFault();
	
	public void setPredictedFault(String predictedFault);
	
	public String toString();
	
	public boolean isAmbiguous();

}
