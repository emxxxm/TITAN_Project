package levelBuilder.entity;

public class Multiplier {
	protected double x2;
	protected double x3;
	
	public Multiplier(double x2, double x3){
		this.x2 = x2;
		this.x3 = x3;
	}
	
	public double getx2(){
		return x2;
	}
	public double getx3(){
		return x3;
	}
	public double setx2(double x2){
		this.x2 = x2;
		return x2;
	}
	public double setx3(double x3){
		this.x3 = x3;
		return x3;
	}
}
