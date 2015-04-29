package levelBuilder.entity;

import java.util.ArrayList;

public class DisableSquareList {
	protected ArrayList<Position> dsList;
	
	public ArrayList<Position> getDisableSquareList() {
		return dsList;
	}

	public DisableSquareList(){
		dsList = new ArrayList<Position>();
	}
	
	public boolean add(Position ps){
		if(inList(ps)) return false;
		
		System.out.println("add one position "+ps.toString());
		return dsList.add(ps);
	}
	
	public void clearAll(){
		dsList.clear();
	}
	
	public boolean remove(Position ps){
		if(dsList.remove(ps)){
			System.out.println("remove one position "+ps.toString());
			return true;
		}
		return false;
	}
	
	public boolean inList(Position ps){
		for(Position pos:dsList){
			if(pos.equals(ps))
				return true;
		}
		return false;
	}
	
	public int sizeof(){
		return dsList.size();
	}
	
}
