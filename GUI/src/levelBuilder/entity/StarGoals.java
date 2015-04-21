package levelBuilder.entity;

public class StarGoals {
	protected int oneStar;
	protected int twoStars;
	protected int threeStars;
	
	public boolean setOne(int score){
		if(score<0) return false;
		
		this.oneStar = score;
		return true;
	}
	
	public boolean setTwo(int score){
		if(score<0) return false;
		
		this.twoStars = score;
		return true;
	}
	
	public boolean setThree(int score){
		if(score<0) return false;
		
		this.threeStars = score;
		return true;
	}
	
	public int getOne(){
		return oneStar;
	}
	
	public int getTwo(){
		return twoStars;
	}
	public int getThree(){
		return threeStars;
	}
}
