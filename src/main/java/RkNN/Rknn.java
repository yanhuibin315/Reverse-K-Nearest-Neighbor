package RkNN;

import java.util.ArrayList;
import java.util.List;

import src.main.java.Entity.Point;
import src.main.java.KNN.KNN;

/**
 * 步骤：
 * 1：获取数据集
 * 2：取得查询点
 * 3：遍历数据集点中的KNN，找到包含x的KNN对应的点集并加入到x的RNN队列
 * 4：返回RNN中前k个结果的最多类型
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
	 * 计算点集中每个点的KNN
	 * @param k
	 */
	public void setPointKNN(Point p,int k){
		KNN knn=new KNN();
		
		int outdex=-1;
		for(Point p1:train_array){
			List<Point> train=new ArrayList<Point>();
			train.addAll(train_array);
			outdex++;
			int index=-1;//记录当前Point在List里的位置
			
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
	 * 根据给定的k值，设置查询点的RNN队列
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
	 * 找到点集中以p做knn的点的集合
	 * 遍历数据集Set的KNN，如果存在p1=p，则添加p1
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
