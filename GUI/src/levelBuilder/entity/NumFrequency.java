package levelBuilder.entity;

public class NumFrequency {
	protected double f1=0;
	protected double f2=0;
	protected double f3=0;
	protected double f4=0;
	protected double f5=0;
	protected double f6=0;
	
	public NumFrequency(){}
	
	public NumFrequency(double f1,double f2,double f3,double f4,double f5,double f6){
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
		this.f4 = f4;
		this.f5 = f5;
		this.f6 = f6;
	}
	
	public boolean setFre1(double f){
		if(f < 0) return false;
		this.f1 = f;
		System.out.println("freq1 is set to " + this.f1);
		return true;
	}
	public boolean setFre2(double f){
		if(f < 0) return false;
		this.f2 = f;
		System.out.println("freq2 is set to " + this.f2);
		return true;
	}
	public boolean setFre3(double f){
		if(f < 0) return false;
		this.f3 = f;
		System.out.println("freq3 is set to " + this.f3);
		return true;
	}
	public boolean setFre4(double f){
		if(f < 0) return false;
		this.f4 = f;
		System.out.println("freq4 is set to " + this.f4);
		return true;
	}
	public boolean setFre5(double f){
		if(f < 0) return false;
		this.f5 = f;
		System.out.println("freq5 is set to " + this.f5);
		return true;
	}public boolean setFre6(double f){
		if(f < 0) return false;
		this.f6 = f;
		System.out.println("freq6 is set to " + this.f6);
		return true;
	}
	
	public double getFre1(){
		return this.f1;
	}
	public double getFre2(){
		return this.f2;
	}
	public double getFre3(){
		return this.f3;
	}
	public double getFre4(){
		return this.f4;
	}
	public double getFre5(){
		return this.f5;
	}
	public double getFre6(){
		return this.f6;
	}

}
