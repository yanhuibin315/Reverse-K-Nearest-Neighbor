package src.main.java.Entity;

import java.util.List;

/**
 * ��¼ƽ���ϵĵ�
 * @author Administrator
 *
 */
public class Point {
	
	private double x;
	
	private double y;
	
	private String value;//point's value
	
	private double dis;//point to x's distance
	
	private List<Point> nn;//knn����
	
	private List<Point> rnn;//rknn����
	
	public List<Point> getnn() {
		return nn;
	}

	public void setnn(List<Point> nn) {
		this.nn = nn;
	}

	public List<Point> getRnn() {
		return rnn;
	}

	public void setRnn(List<Point> rnn) {
		this.rnn = rnn;
	}

	public double getDis() {
		return dis;
	}
	
	public void setDis(double dis) {
		this.dis = dis;
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x2) {
		this.x = x2;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", value=" + value + ", dis="
				+ dis + "]";
	}
	
	public boolean equalPoint(Point p1){
		if(p1.getX()==this.getX()&&p1.getY()==this.getY())
			return true;
		else
			return false;
	}
	
}
