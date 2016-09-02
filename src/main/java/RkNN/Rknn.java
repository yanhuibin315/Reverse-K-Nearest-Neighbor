package RkNN;

import java.util.ArrayList;
import java.util.List;

import src.main.java.Entity.Point;
import src.main.java.KNN.KNN;

/**
 * ���裺
 * 1����ȡ���ݼ�
 * 2��ȡ�ò�ѯ��
 * 3���������ݼ����е�KNN���ҵ�����x��KNN��Ӧ�ĵ㼯�����뵽x��RNN����
 * 4������RNN��ǰk��������������
 * @author Administrator
 *
 */
public class Rknn {
	
	private List<Point> train_array;

	public List<Point> getTrain_array() {
		return train_array;
	}

	public void setTrain_array(List<Point> train_array) {
		this.train_array = train_array;
	}
	
	
	
	/**
	 * ����㼯��ÿ�����KNN
	 * @param k
	 */
	public void setPointKNN(Point p,int k){
		KNN knn=new KNN();
		
		int outdex=-1;
		for(Point p1:train_array){
			List<Point> train=new ArrayList<Point>();
			train.addAll(train_array);
			outdex++;
			int index=-1;//��¼��ǰPoint��List���λ��
			
			for(Point p2:train){
				index++;
				if(p2.equalPoint(p1)){
					train.set(index, p);
				}
			}
			
			for(int i=0;i<train.size();i++){
				double dis=0;
				dis=knn.culDistance(p1,train.get(i));
				train.get(i).setDis(dis);
			}
			
			knn.sortDistance(train);
			train_array.get(outdex).setnn(train);
		}
	}
	
	/**
	 * ���ݸ�����kֵ�����ò�ѯ���RNN����
	 */
	public void setPointRnn(Point p,int k){
		for(Point p1:train_array){
			for(int i=0;i<k;i++){
				if(p1.getnn().get(i).equalPoint(p)){
					p.getRnn().add(p1);
					break;
				}
			}
		}
	}
	
	/**
	 * �ҵ��㼯����p��knn�ĵ�ļ���
	 * �������ݼ�Set��KNN���������p1=p�������p1
	 * @param p
	 * @return
	 */
	public List<Point> findPointSet(Point p){
		List ls=new ArrayList<Point>();
		for(Point p1:train_array){
			for(Point x:p1.getnn()){
				if(x.equalPoint(p)){
					ls.add(p1);
					break;
				}
			}
		}
		return ls;
	}

}
