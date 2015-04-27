package levelBuilder.move;

import levelBuilder.entity.BonusFrequency;
import levelBuilder.entity.Move;
import levelBuilder.game.LevelBuilder;
/**
 * Set the frequencies of bonus squares.
 * @author Ying Lu
 *
 */
public class SetBonusFreqMove extends Move{
	protected BonusFrequency bf;
	protected double x2;
	protected double x3;
	
	protected double x2_undo;
	protected double x3_undo;
	
	public SetBonusFreqMove(BonusFrequency bf, double freqx2, double freqx3){
		this.bf=bf;
		this.x2=freqx2;
		this.x3=freqx3;
		this.x2_undo = bf.getx2();
		this.x3_undo = bf.getx3();
	}
	

	@Override
	public boolean execute(LevelBuilder lb) {
		if(!valid(lb)){
			return false;
		}
		
		lb.getLbPanel().getx2().setText(""+x2);
		lb.getLbPanel().getx3().setText(""+x3);

		bf.setx2(x2);
		bf.setx3(x3);
		return true;
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		lb.getLbPanel().getx2().setText(""+x2_undo);
		lb.getLbPanel().getx3().setText(""+x3_undo);

		return bf.setx2(x2_undo)&&bf.setx3(x3_undo);
	}

	@Override
	public boolean valid(LevelBuilder lb) {
		boolean returnBool;
		if(x2>=0 && x2<=1 && x3>=0 && x3<=1){
			System.out.println("Bonus frequency input value is valid");
			returnBool=true;
		}else{
			System.out.println("Bonus frequency input value is not valid");
			returnBool=false;
		}
		
		return returnBool;
	}

	@Override
	public boolean updateBoard() {
		// TODO Auto-generated method stub
		return false;
	}

}
