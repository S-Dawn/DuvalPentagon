package com.duval.userinterface;

import com.duval.utils.Controller;
import com.duval.utils.Coordinates;
import com.duval.utils.Detector;
import com.duval.utils.Helper;

public class Main {
    public static void main(String[] args) {
    	Helper.showFrame();
    	Coordinates p = Controller.fc.getFaultPoints(31, 130, 192, 31, 0);
    	
    	Detector obj = new Detector(400, 200);
    	
    	System.out.println(p);
    	System.out.println(obj.FaultType(p));
    }
}
           
  