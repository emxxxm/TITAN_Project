package levelBuilder.move.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilder.entity.Move;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.SetFreqMove;
import levelBuilder.view.LBPanel;

public class SetFreqController implements ActionListener {

	protected LevelBuilder lb;
	protected LBPanel panel;

	public SetFreqController(LevelBuilder lb) {
		this.lb = lb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Double f1 = Double.parseDouble(lb.getLbPanel().getFreq1().getText());
		Double f2 = Double.parseDouble(lb.getLbPanel().getFreq2().getText());
		Double f3 = Double.parseDouble(lb.getLbPanel().getFreq3().getText());
		Double f4 = Double.parseDouble(lb.getLbPanel().getFreq4().getText());
		Double f5 = Double.parseDouble(lb.getLbPanel().getFreq5().getText());
		Double f6;
		
		if (lb.getMode() == "Release") {
			f6 = Double.parseDouble("0");
		} else {
			f6 = Double.parseDouble(lb.getLbPanel().getFreq6().getText());
		}
		Move m = new SetFreqMove(lb.getModel().getNumFrequency(), f1, f2, f3,
				f4, f5, f6);

		if (m.execute(lb)) {
			lb.pushMove(m);
		}
	}

}
