package test_KNN;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.main.java.Entity.Point;
import src.main.java.KNN.KNN;

public class Test_KNN {
	
	public static void main(String[] args) {
		
		KNN knn=new KNN();
		
		List<Point> ls=new ArrayList<Point>();
		
		int i,j;
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				Point po = new Point();
				po.setX(i);
				po.setY(j);
				
				switch((i+j)%3){
					case 0:po.setValue("Zero");break;
					case 1:po.setValue("One");break;
					case 2:po.setValue("Two");break;
					default:po.setValue("Others");
				}
				ls.add(po);
			}
		}
		
		System.out.println(ls.size());
		System.out.println(ls.toString());
		
		System.out.println("请输入x:");
		Scanner scan=new Scanner(System.in);
		double x=scan.nextDouble();
		System.out.println("请输入y:");
		double y=scan.nextDouble();
		Point p1=new Point();
		p1.setX(x);
		p1.setY(y);
		
		
		for(i=0;i<ls.size();i++){
			double dis=0;
			dis=knn.culDistance(p1,ls.get(i));
			ls.get(i).setDis(dis);
		}
		
		knn.sortDistance(ls);
		System.out.println(ls.toString());
		
		
		System.out.println("请输入K值:");
		int k=scan.nextInt();
		p1.setnn(ls);
		String str=knn.findMaxValue(ls, k);
		System.out.println("您输入的x的str估测为："+str);
		
		scan.close();
		
	}

}

