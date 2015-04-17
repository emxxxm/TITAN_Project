package sixesWild.model;

public class Square 
{
	protected Tile tile;
	protected int row;
	protected int col;
	//Is this correct? 
	protected int type;
	
	public Square(Tile tile, int row, int col, int type)
	{
		this.tile=tile;
		this.row=row;
		this.col=col;
		this.type=type;
	}
	
}
