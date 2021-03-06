package levelBuilder.entity;

import java.util.ArrayList;

public class BucketList {
	protected ArrayList<Position> bList;
	
	public BucketList(){
		bList = new ArrayList<Position>();
	}
	
	public ArrayList<Position> getBucketList() {
		return bList;
	}
	public boolean add(Position ps){
		if(inList(ps)) return false;

		if(bList.add(ps)){
			System.out.println("Bucket at Position (" + ps.row + " ," + ps.col +") is set!");
			return true;
		}
		return false;
	}
	
	public void clearAll(){
		bList.clear();
	}
	public void setList(ArrayList<Position> bucket){
		this.bList = bucket;
	}
	public boolean remove(Position ps){
		if(bList.remove(ps)){
			System.out.println("Bucket at Position (" + ps.row + " ," + ps.col +") is removed!");
			return true;
		}
		return false;
	}

	public boolean inList(Position ps){
		for(Position pos:bList){
			if(pos.equals(ps))
				return true;
		}
		return false;
	}

	public int sizeof(){
		return bList.size();
	}
}
