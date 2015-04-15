package sixesWild.model;

public class Square 
{
	protected Tile tile;
	protected int row;
	protected int col;
	
	public Square(Tile tile, int row, int col)
	{
		this.tile=tile;
		this.row=row;
		this.col=col;
	}
}
