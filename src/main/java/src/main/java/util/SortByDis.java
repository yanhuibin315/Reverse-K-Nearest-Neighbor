package src.main.java.util;

import java.util.Comparator;

import src.main.java.Entity.Point;
/**
 * °´ÕÕ¾àÀëÅÅĞò
 * @author Administrator
 *
 */
public class SortByDis implements Comparator{

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Point p1=(Point) o1;
		Point p2=(Point) o2;
		if(p1.getDis()>p2.getDis())
			return 1;
		else
			return 0;
	}

}
