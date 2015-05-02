package levelBuilder.move;

import levelBuilder.entity.BucketList;
import levelBuilder.entity.Move;
import levelBuilder.entity.Position;
import levelBuilder.game.LevelBuilder;

public class SetBucketMove extends Move{
	protected BucketList bucket;
	protected Position pos;
	
	public SetBucketMove(BucketList bucket, Position pos){
		this.bucket = bucket;
		this.pos = pos;
	}
	
	@Override
	public boolean execute(LevelBuilder lb) {
		if(!valid(lb)) return false;
		
		return bucket.add(pos);
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		return bucket.remove(pos);
	}

	@Override
	public boolean valid(LevelBuilder lb) {
		if((!lb.getModel().getDisableSquareList().inList(pos)) && pos.isValid()) return true;
		return false;
	}

	@Override
	public boolean updateBoard() {
		// TODO Auto-generated method stub
		return false;
	}

}
