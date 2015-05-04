package levelBuilder.entity;

public class StarGoals {
	protected int oneStar=0;
	protected int twoStars=0;
	protected int threeStars=0;
	
	public StarGoals(){}
	
	public boolean setOne(int score){
		if(score<0) return false;
		
		this.oneStar = score;
		System.out.println(this.oneStar);

		return true;
	}
	
	public boolean setTwo(int score){
		if(score<0) return false;
		
		this.twoStars = score;
		System.out.println(this.twoStars);
		return true;
	}
	
	public boolean setThree(int score){
		if(score<0) return false;
		
		this.threeStars = score;
		System.out.println(this.threeStars);

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
