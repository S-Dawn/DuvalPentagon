package com.duval.utils;

public class Coordinates {

	double x;
	double y;

	public Coordinates(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coordinates [x=" + x + ", y=" + y + "]";
	}

	public static boolean onSegment(Coordinates p, Coordinates q, Coordinates r) {
		if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && q.y <= Math.max(p.y, r.y)
				&& q.y >= Math.min(p.y, r.y))
			return true;
		return false;
	}

	public static int orientation(Coordinates p, Coordinates q, Coordinates r) {
		double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

		if (val == 0)
			return 0;
		return (val > 0) ? 1 : 2;
	}

	public static boolean doIntersect(Coordinates p1, Coordinates q1, Coordinates p2, Coordinates q2) {

		int o1 = orientation(p1, q1, p2);
		int o2 = orientation(p1, q1, q2);
		int o3 = orientation(p2, q2, p1);
		int o4 = orientation(p2, q2, q1);

		if (o1 != o2 && o3 != o4)
			return true;

		if (o1 == 0 && onSegment(p1, p2, q1))
			return true;

		if (o2 == 0 && onSegment(p1, q2, q1))
			return true;

		if (o3 == 0 && onSegment(p2, p1, q2))
			return true;

		if (o4 == 0 && onSegment(p2, q1, q2))
			return true;

		return false;
	}

	public static boolean isInside(Coordinates polygon[], int n, Coordinates p) {
		int INF = 10000;
		if (n < 3)
			return false;

		Coordinates extreme = new Coordinates(INF, p.y);

		int count = 0, i = 0;
		do {
			int next = (i + 1) % n;
			if (doIntersect(polygon[i], polygon[next], p, extreme)) {
				if (orientation(polygon[i], p, polygon[next]) == 0)
					return onSegment(polygon[i], p, polygon[next]);

				count++;
			}
			i = next;
		} while (i != 0);

		return (count & 1) == 1 ? true : false;
	}

	public static void main(String args[]) {
		Coordinates polygon1[] = { new Coordinates(0, 0), new Coordinates(10, 0), new Coordinates(10, 10),
				new Coordinates(0, 10) };
		int n = 4;

		Coordinates p = new Coordinates(20, 20);
		System.out.println("Point P(" + p.x + ", " + p.y + ") lies inside polygon1: " + isInside(polygon1, n, p));
		p = new Coordinates(5, 5);
		System.out.println("Point P(" + p.x + ", " + p.y + ") lies inside polygon1: " + isInside(polygon1, n, p));

		Coordinates polygon2[] = { new Coordinates(0, 0), new Coordinates(5, 5), new Coordinates(5, 0) };
		n = 3;

		p = new Coordinates(3, 3);
		System.out.println("Point P(" + p.x + ", " + p.y + ") lies inside polygon2: " + isInside(polygon2, n, p));
		p = new Coordinates(5, 1);
		System.out.println("Point P(" + p.x + ", " + p.y + ") lies inside polygon2: " + isInside(polygon2, n, p));
		p = new Coordinates(8, 1);
		System.out.println("Point P(" + p.x + ", " + p.y + ") lies inside polygon2: " + isInside(polygon2, n, p));

		Coordinates polygon3[] = { new Coordinates(0, 0), new Coordinates(10, 0), new Coordinates(10, 10),
				new Coordinates(0, 10), new Coordinates(5, 5) };
		n = 5;

		p = new Coordinates(-1, 10);
		System.out.println("Point P(" + p.x + ", " + p.y + ") lies inside polygon3: " + isInside(polygon3, n, p));
	}

	public boolean equals(Coordinates obj) {
		if (this.x == obj.getX() && this.y == obj.getY())
			return true;
		else
			return false;
	}

	public static boolean isEqualArray(Coordinates arr1[], Coordinates arr2[]) {
		if (arr1.length != arr2.length)
			return false;

		for (int i = 1; i < arr1.length; i++) {
			if (!arr1[i].equals(arr2[i])) {
				return false;
			}
		}
		return true;
	}

	public static Coordinates[] copyArray(Coordinates arr1[]) {

		Coordinates temp[] = new Coordinates[arr1.length];

		for (int i = 0; i < arr1.length; i++) {
			temp[i] = arr1[i];
		}
		return temp;
	}

	public static double distance(Coordinates a, Coordinates b) {
		double x1 = a.getX(), x2 = b.getX();
		double y1 = a.getY(), y2 = b.getY();

		double dist = Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);
		dist = Math.sqrt(dist);

		return dist;
	}

}
