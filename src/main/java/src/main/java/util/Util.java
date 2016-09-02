package src.main.java.util;

import java.util.List;
import java.util.Map;

import src.main.java.Entity.Point;

public class Util {
	
	/**
	 * 读取文件里的数据集，添加到List里返回
	 * @param filename
	 * @return
	 */
	public List<Point> readSet(String filename){
		return null;
		
	}
	
	public String getMaxKey(Map<String,Integer> map){
		int temp=0;
		String str="";
		for(Map.Entry<String,Integer> m:map.entrySet()){
			if(m.getValue()>temp)
				str=m.getKey();
		}
		return str;
	}

}
