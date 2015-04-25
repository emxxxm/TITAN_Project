package levelBuilder.move;

import levelBuilder.entity.Move;
import levelBuilder.entity.NumFrequency;
import levelBuilder.game.LevelBuilder;

public class SetFreqMove extends Move{
	protected NumFrequency freq;
	protected double f1;
	protected double f2;
	protected double f3;
	protected double f4;
	protected double f5;
	protected double f6;
	
	public SetFreqMove(NumFrequency freq, Double f1, Double f2, Double f3, Double f4, Double f5, Double f6){
		this.freq = freq;
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
		this.f4 = f4;
		this.f5 = f5;
		this.f6 = f6;
	}
	@Override
	public boolean execute(LevelBuilder lb) {
		if(!valid(lb))
			return false;
		
		return freq.setFre1(f1)&&freq.setFre1(f2)&&freq.setFre1(f3)&&freq.setFre1(f4)
				&&freq.setFre1(f5)&&freq.setFre1(f6);
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean valid(LevelBuilder lb) {
		// TODO Auto-generated method stub
		return (f1+f2+f3+f4+f5+f6) == 1;
	}

	@Override
	public boolean updateBoard() {
		// TODO Auto-generated method stub
		return false;
	}

}
