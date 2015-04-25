package levelBuilder.entity;

import java.util.ArrayList;

public class BucketList {
	protected ArrayList<Position> bList;
	
	public BucketList(){
		bList = new ArrayList<Position>();
	}
	
	public boolean add(Position ps){
		if(bList.add(ps)){
			System.out.println("Bucket at Position (" + ps.row + " ," + ps.col +") is set!");
			return true;
		}
		return false;
	}
	
	public void clearAll(){
		bList.clear();
	}
	
	public boolean remove(Position ps){
		if(bList.remove(ps)){
			System.out.println("Bucket at Position (" + ps.row + " ," + ps.col +") is removed!");
			return true;
		}
		return false;
	}
}
