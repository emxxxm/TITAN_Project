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
	
	protected double f1_undo;
	protected double f2_undo;
	protected double f3_undo;
	protected double f4_undo;
	protected double f5_undo;
	protected double f6_undo;
	
	public SetFreqMove(NumFrequency freq, Double f1, Double f2, Double f3, Double f4, Double f5, Double f6){
		this.freq = freq;
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
		this.f4 = f4;
		this.f5 = f5;
		this.f6 = f6;
		this.f1_undo = freq.getFre1();
		this.f2_undo = freq.getFre2();
		this.f3_undo = freq.getFre3();
		this.f4_undo = freq.getFre4();
		this.f5_undo = freq.getFre5();
		this.f6_undo = freq.getFre6();
	}
	@Override
	public boolean execute(LevelBuilder lb) {
		if(!valid(lb))
			return false;
		
		lb.getLbPanel().getFreq1().setText(""+f1);
		lb.getLbPanel().getFreq2().setText(""+f2);
		lb.getLbPanel().getFreq3().setText(""+f3);
		lb.getLbPanel().getFreq4().setText(""+f4);
		lb.getLbPanel().getFreq5().setText(""+f5);
		lb.getLbPanel().getFreq6().setText(""+f6);

		
		return freq.setFre1(f1)
				&&freq.setFre2(f2)
				&&freq.setFre3(f3)
				&&freq.setFre4(f4)
				&&freq.setFre5(f5)
				&&freq.setFre6(f6);
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		
		lb.getLbPanel().getFreq1().setText(""+f1_undo);
		lb.getLbPanel().getFreq2().setText(""+f2_undo);
		lb.getLbPanel().getFreq3().setText(""+f3_undo);
		lb.getLbPanel().getFreq4().setText(""+f4_undo);
		lb.getLbPanel().getFreq5().setText(""+f5_undo);
		lb.getLbPanel().getFreq6().setText(""+f6_undo);
		
		return freq.setFre1(f1_undo)
				&&freq.setFre2(f2_undo)
				&&freq.setFre3(f3_undo)
				&&freq.setFre4(f4_undo)
				&&freq.setFre5(f5_undo)
				&&freq.setFre6(f6_undo);
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
