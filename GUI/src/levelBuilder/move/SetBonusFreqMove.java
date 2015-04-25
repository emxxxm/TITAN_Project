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
	
	public SetBonusFreqMove(BonusFrequency bf, double freqx2, double freqx3){
		this.bf=bf;
		this.x2=freqx2;
		this.x3=freqx3;
	}
	

	@Override
	public boolean execute(LevelBuilder lb) {
		if(!valid(lb)){
			return false;
		}
		bf.setx2(x2);
		bf.setx3(x3);
		return true;
	}

	@Override
	public boolean undo(LevelBuilder lb) {
		// TODO Auto-generated method stub
		return false;
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
