package levelBuilder.entity;

import java.util.ArrayList;

public class DisableSquareList {
	protected ArrayList<Position> dsList;
	
	public DisableSquareList(){
		dsList = new ArrayList<Position>();
	}
	
	public boolean add(Position ps){
		System.out.println("add one position "+ps.toString());
		return dsList.add(ps);
	}
	
	public void clearAll(){
		dsList.clear();
	}
	
	public boolean remove(Position ps){
		System.out.println("remove one position "+ps.toString());
		return dsList.remove(ps);
	}
	
	public boolean inList(Position ps){
		for(Position pos:dsList){
			if(pos.equals(ps))
				return true;
		}
		return false;
	}
	
}
