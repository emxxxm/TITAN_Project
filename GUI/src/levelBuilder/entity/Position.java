package levelBuilder.entity;

public class Position{
	protected int row;
	protected int col;
	
	public Position(int row,int col){
		this.row = row;
		this.col = col;
	}
	
	@Override
	public boolean equals(Object o){
		if(o==null) return false;
		
		if(o instanceof Position){
			Position oo = (Position) o;
			return this.row == oo.row && this.col == oo.col;
		}
		
		return false;
	}
	
	public String toString(){
		String str="[";
		str = str + row +" "+ col+"]";
		return str;
	}
}
