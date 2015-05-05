package levelBuilder.entity;

public class BonusFrequency {
	protected double x2=0;
	protected double x3=0;
	
	public BonusFrequency(){}
	
	public BonusFrequency(double x2, double x3){
		this.x2 = x2;
		this.x3 = x3;
	}
	
	public double getx2(){
		return x2;
	}
	public double getx3(){
		return x3;
	}
	public boolean setx2(double x2){
		this.x2 = x2;
		System.out.println("set x2 bonus frequency to "+x2);
		return true;
	}
	public boolean setx3(double x3){
		this.x3 = x3;
		System.out.println("set x3 bonus frequency to "+x3);
		return true;
	}
}
