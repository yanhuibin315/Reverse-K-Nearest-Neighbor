package test_RKNN;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import RkNN.Rknn;
import src.main.java.Entity.Point;

public class Test_Rknn {
	public static void main(String[] args) {
		Rknn rknn=new Rknn();
		
		List<Point> ls=new ArrayList<Point>();
		
		List<Point> train=new ArrayList<Point>();
		
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
		
		train.addAll(ls);
		
		System.out.println(ls.size());
		System.out.println(ls.toString());
		
		System.out.println("������x:");
		Scanner scan=new Scanner(System.in);
		double x=scan.nextDouble();
		System.out.println("������y:");
		double y=scan.nextDouble();
		Point p1=new Point();
		p1.setX(x);
		p1.setY(y);
		
		rknn.setTrain_array(ls);
		System.out.println("������Kֵ:");
		int k=scan.nextInt();
		rknn.setPointKNN(p1, k);
		rknn.setPointRnn(p1, k);
		
		
		
		
	}

}
