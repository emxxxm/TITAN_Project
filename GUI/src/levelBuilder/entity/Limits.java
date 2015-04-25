package levelBuilder.entity;

public class Limits {
	protected int moveLimits=0;
	protected int removeLimits=0;
	protected int timeLimits=0;
	protected int swapLimits=0;
	
	public Limits(){}
	
//	public Limits(int moveLimits, int removeLimits, int timeLimits, int swapLimits){
//		this.moveLimits = moveLimits;
//		this.removeLimits = removeLimits;
//		this.timeLimits = timeLimits;
//		this.swapLimits = swapLimits;
//	}
	
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
	
	public void setMoveLimits(int moveLimits){
		this.moveLimits = moveLimits;
		System.out.println("move limit "+this.moveLimits);
	}
	
	public void setRemoveLimits(int removeLimit){
		this.removeLimits = removeLimit;
		System.out.println("remove limit "+this.removeLimits);
	}
	
	public void setTimeLimits(int timeL){
		this.timeLimits = timeL;
		System.out.println("time limit "+this.timeLimits);
	}
	
	public void setSwapLimits(int swapL){
		this.swapLimits = swapL;
		System.out.println("swap limit "+this.swapLimits);
	}
}
