package sixesWild.model;

public class Tile 
{
	protected int num;
	protected int multi;
	
	public Tile(int num, int multi)
	{
		this.num = num;
		this.multi = multi;
	}
	
	public int getNum()
	{
		return this.num;
	}
	
	public int getMulti()
	{
		return this.multi;
	}
	
	public void setNum(int newNum)
	{
		this.num = newNum;
		return;
	}
	
	public void setMulti(int multi)
	{
		this.multi = multi;
		return;
	}
}
