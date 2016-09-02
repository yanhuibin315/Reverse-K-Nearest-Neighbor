package src.main.java.KNN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.main.java.Entity.Entry;
import src.main.java.Entity.Point;
import src.main.java.util.Util;

/**
 * 
 * @author Administrator
 *
 */
public class KNN {
	/*
	 * 保存空间中已有数据集
	 */
	private List<Point> train_array;
	
	public List<Point> getTrain_array() {
		return train_array;
	}

	public void setTrain_array(List<Point> train_array) {
		this.train_array = train_array;
	}

	/*
	 * 返回平面两点间距离,此处用欧式距离计算
	 */
	public double culDistance(Point p1,Point p2){
		double disX=p1.getX()-p2.getX();
		double disY=p1.getY()-p2.getY();
		return java.lang.Math.sqrt(disX*disX+disY*disY);
	}

	/*
	 * 给点集中的点按照到未知点的距离排序
	 */
	public void sortDistance(List<Point> ls){
		for(int i=0;i<ls.size()-1;i++){
			for(int j=0;j<=i;j++){
				if(ls.get(j).getDis()>ls.get(j+1).getDis()){
					double db=ls.get(j+1).getDis();
					ls.get(j+1).setDis(ls.get(j).getDis());
					ls.get(j).setDis(db);
				}
			}
		}
	}
	
	/*
	 * 找到点集的前k个值中String最多的String并返回
	 */
	public String findMaxValue(List<Point> ls,int k){
		Map<String,Integer> map=new HashMap();
		map.put("Zero", 0);
		map.put("One", 0);
		map.put("Two", 0);
		map.put("Others", 0);
		for(int i=0;i<k;i++){
			Integer value=map.get(ls.get(i).getValue());
			map.put(ls.get(i).getValue(), value+1);
		}
		System.out.println(map);
		
		String str=getMaxKey(map);
		return str;
		
	}

	@Override
	public String toString() {
		return "KNN [train_array=" + train_array + "]";
	}
	
	public String getMaxKey(Map<String,Integer> map){
		int temp=0;
		String str="";
		for(Map.Entry<String,Integer> m:map.entrySet()){
			if(m.getValue()>temp){
				temp=m.getValue();
				str=m.getKey();
			}
		}
		return str;
	}
	
	
}


