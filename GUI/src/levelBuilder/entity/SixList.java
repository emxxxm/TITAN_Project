package levelBuilder.entity;

import java.util.ArrayList;

public class SixList {
	protected ArrayList<Position> sList;
	
	public SixList(){
		sList = new ArrayList<Position>();
	}
	
	public boolean add(Position ps){
		if(sList.add(ps)){
			System.out.println("Six at Position (" + ps.row + " ," + ps.col +") is set!");
			return true;
		}
		return false;
	}
	
	public void clearAll(){
		sList.clear();
	}
	
	public boolean remove(Position ps){
		if(sList.remove(ps)){
			System.out.println("Six at Position (" + ps.row + " ," + ps.col +") is removed!");
			return true;
		}
		return false;
	}
	
}
