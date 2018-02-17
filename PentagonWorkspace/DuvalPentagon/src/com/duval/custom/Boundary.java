package com.duval.custom;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.duval.datasource.DSData;
import com.duval.datasource.DSDataPatch;
import com.duval.datasource.GenData;

public class Boundary {
	
	private List<ClusterUnit> dataset;
	int m = 800,n =600;

	private ArrayList<Point> PDList = new ArrayList<>();
	private ArrayList<Point> D1List = new ArrayList<>();
	private ArrayList<Point> D2List = new ArrayList<>();
	private ArrayList<Point> SList = new ArrayList<>();
	private ArrayList<Point> TList = new ArrayList<>();
	private ArrayList<Point> T3List = new ArrayList<>();

	public Boundary() {
		super();
		dataset = new ArrayList<ClusterUnit>();
	}

	public void appendList(List<DSData> list) {
		ClusterUnit unit;
		for (GenData obj : list) {
			unit = new ClusterUnit(obj.getCoordinates(), obj.getFault());
			this.dataset.add(unit);
		}
	}

	public void appendListPatch(List<DSDataPatch> list) {
		ClusterUnit unit;
		for (GenData obj : list) {
			unit = new ClusterUnit(obj.getCoordinates(), obj.getFault());
			this.dataset.add(unit);
		}
	}
	
	public void initiateConvexHull() {
		int x, y;
		for(ClusterUnit obj:dataset) {
			x = (int) obj.getCoord().getX();
			y = (int) obj.getCoord().getY();
			if(obj.getOriginalFault().equalsIgnoreCase("PD")) {
				PDList.add(new Point(x, y));
			}
			else if(obj.getOriginalFault().equalsIgnoreCase("D1")) {
				D1List.add(new Point(x, y));
			}
			else if(obj.getOriginalFault().equalsIgnoreCase("D2")) {
				D2List.add(new Point(x, y));
			}
			else if(obj.getOriginalFault().equalsIgnoreCase("S")) {
				SList.add(new Point(x, y));
			}
			else if(obj.getOriginalFault().equalsIgnoreCase("T1")) {
				TList.add(new Point(x, y));
			}
			else if(obj.getOriginalFault().equalsIgnoreCase("T2")) {
				TList.add(new Point(x, y));
			}
			else if(obj.getOriginalFault().equalsIgnoreCase("T3")) {
				T3List.add(new Point(x, y));
			}
			else if(obj.getOriginalFault().equalsIgnoreCase("T1/T2") || obj.getOriginalFault().equalsIgnoreCase("T2/T1")) {
				TList.add(new Point(x, y));
			}
			else {
				try {
					throw new Exception("Invalid Fault Encountered");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			QuickHull quickHull = new QuickHull();
			PDList = quickHull.quickHull(PDList);
			D1List = quickHull.quickHull(D1List);
			D2List = quickHull.quickHull(D2List);
			SList = quickHull.quickHull(SList);
			TList = quickHull.quickHull(TList);
			T3List = quickHull.quickHull(T3List);
			
		}
	}

	public ArrayList<Point> getPDList() {
		return PDList;
	}

	public ArrayList<Point> getD1List() {
		return D1List;
	}

	public ArrayList<Point> getD2List() {
		return D2List;
	}

	public ArrayList<Point> getSList() {
		return SList;
	}

	public ArrayList<Point> getTList() {
		return TList;
	}

	public ArrayList<Point> getT3List() {
		return T3List;
	}

}
