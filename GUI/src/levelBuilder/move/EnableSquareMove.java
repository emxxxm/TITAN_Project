package levelBuilder.move;

import levelBuilder.entity.DisableSquareList;
import levelBuilder.entity.Move;
import levelBuilder.entity.Position;
import levelBuilder.game.LevelBuilder;

public class EnableSquareMove extends Move{
	
	protected DisableSquareList dsList;
	protected int rowFrom;
	protected int rowTo;
	protected int colFrom;
	protected int colTo;
	
	public EnableSquareMove(DisableSquareList dsList, int rowFrom, int rowTo, int colFrom, int colTo){
		this.dsList = dsList;
		this.rowFrom = rowFrom;
		this.rowTo = rowTo;
		this.colFrom = colFrom;
		this.colTo = colTo;
	}
	
	@Override
	public boolean execute(LevelBuilder lb) {

		if(!valid(lb)) return false;
		
		for(int i=rowFrom;i<=rowTo;i++){
			for(int j = colFrom;j<=colTo;j++){
				dsList.remove(new Position(i,j));
			}
		}
		return true;
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		for(int i=rowFrom;i<=rowTo;i++){
			for(int j=colFrom;j<=colTo;j++){
				dsList.add(new Position(i,j));
			}
		}
		return true;
	}

	@Override
	public boolean valid(LevelBuilder lb) {
		if(rowFrom<0||rowFrom>=9
				||rowTo<0||rowTo>=9
				||colFrom<0||colFrom>=9
				||colTo<0||colTo>=9) 
			return false;			

		if(rowFrom>rowTo||colFrom>colTo) 
			return false;
		
		for(int i=rowFrom;i<=rowTo;i++){
			for(int j=colFrom;j<=colTo;j++){
				if(!dsList.inList(new Position(i,j)))
						return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean updateBoard() {
		// TODO Auto-generated method stub
		return false;
	}

}
