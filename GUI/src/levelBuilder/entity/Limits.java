package levelBuilder.entity;

public class Limits {
	protected int moveLimits=1;
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
	
	public boolean setMoveLimits(int moveLimits){
		if(moveLimits>0){
			this.moveLimits = moveLimits;
			System.out.println("move limit "+this.moveLimits);
			return true;
		}
		return false;
	}
	
	public boolean setRemoveLimits(int removeLimit){
		if(removeLimit>=0){
			this.removeLimits = removeLimit;
			System.out.println("remove limit "+this.removeLimits);
			return true;
		}
		return false;
	}
	
	public boolean setTimeLimits(int timeL){
		if(timeL>=0){
			this.timeLimits = timeL;
			System.out.println("time limit "+this.timeLimits);
			return true;
		}
		return false;
	}
	
	public boolean setSwapLimits(int swapL){
		if(swapL>=0){
			this.swapLimits = swapL;
			System.out.println("swap limit "+this.swapLimits);
			return true;
		}
		return false;
	}
}
