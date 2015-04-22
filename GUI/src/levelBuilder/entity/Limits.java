package levelBuilder.entity;

public class Limits {
	protected int moveLimits;
	protected int removeLimits;
	protected int timeLimits;
	protected int swapLimits;
	
	public Limits(int moveLimits, int removeLimits, int timeLimits, int swapLimits){
		this.moveLimits = moveLimits;
		this.removeLimits = removeLimits;
		this.timeLimits = timeLimits;
		this.swapLimits = swapLimits;
	}
	
	public int getMoveLimits(){
		return moveLimits;
	}
	
	public int getRemoveLimits(){
		return removeLimits;
	}
	
	public int getTimeLimits(){
		return timeLimits;
	}
	
	public int getSwapLimits(){
		return swapLimits;
	}
	
	//TODO set
}
