package levelBuilder.entity;

import java.util.ArrayList;

public class DisableSquareList {
	protected ArrayList<Position> dsList;
	
	public DisableSquareList(){
		dsList = new ArrayList<Position>();
	}
	
	public boolean add(Position ps){
		return dsList.add(ps);
	}
	
	public void clearAll(){
		dsList.clear();
	}
	
	public boolean remove(Position ps){
		return dsList.remove(ps);
	}
	
	
}
