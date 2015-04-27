package levelBuilder.move;

import levelBuilder.entity.BucketList;
import levelBuilder.entity.Move;
import levelBuilder.entity.Position;
import levelBuilder.entity.SixList;
import levelBuilder.game.LevelBuilder;

public class SetSixMove extends Move{
	protected SixList six;
	protected Position pos;
	
	public SetSixMove(SixList six, Position pos){
		this.six = six;
		this.pos = pos;
	}
	
	@Override
	public boolean execute(LevelBuilder lb) {
		if(!valid(lb)) return false;
		
		return six.add(pos);
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		return six.remove(pos);
	}

	@Override
	public boolean valid(LevelBuilder lb) {
		if(!pos.isDisable()) return true;
		return false;
	}

	@Override
	public boolean updateBoard() {
		// TODO Auto-generated method stub
		return false;
	}


}
