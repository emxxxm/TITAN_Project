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
	
	public int getType()
	{
		return this.type;
	}
	
	public Tile getTile()
	{
		return this.tile;
	}
	
	public int getRow()
	{
		return this.row;
	}
	
	public int getCol()
	{
		return this.col;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Square)
		{
			Square s = (Square)o; 
			if(s.getRow()==this.row && s.getCol()==this.col)
			{
				return true;
			}
		}
		return false;
		
	}
}
