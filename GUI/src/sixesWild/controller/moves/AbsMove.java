package sixesWild.controller.moves;

import sixesWild.model.Board;

public abstract class AbsMove 
{	
	public abstract boolean isValid();
	public abstract boolean doMove();
}
