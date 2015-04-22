package levelBuilder.entity;

import java.util.ArrayList;

public class BucketList {
	protected ArrayList<Position> bList;
	
	public BucketList(){
		bList = new ArrayList<Position>();
	}
	
	public boolean add(Position ps){
		return bList.add(ps);
	}
	
	public void clearAll(){
		bList.clear();
	}
	
	public boolean remove(Position ps){
		return bList.remove(ps);
	}
}
