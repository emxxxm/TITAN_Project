package levelBuilder.entity;

import java.util.ArrayList;

public class SixList {
	protected ArrayList<Position> sList;
	
	public SixList(){
		sList = new ArrayList<Position>();
	}
	
	public boolean add(Position ps){
		return sList.add(ps);
	}
	
	public void clearAll(){
		sList.clear();
	}
	
	public boolean remove(Position ps){
		return sList.remove(ps);
	}
	
}
