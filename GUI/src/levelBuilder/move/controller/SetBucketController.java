package levelBuilder.move.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilder.entity.Move;
import levelBuilder.entity.Position;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.SetBucketMove;
import levelBuilder.view.LBPanel;

public class SetBucketController implements ActionListener {

	protected LevelBuilder lb;
	protected LBPanel panel;

	public SetBucketController(LevelBuilder lb) {
		this.lb = lb;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (lb.getMode() == "Release") {
			Integer x = Integer.parseInt(lb.getLbPanel().getBucketRow()
					.getText());
			Integer y = Integer.parseInt(lb.getLbPanel().getBucketCol()
					.getText());

			Position pos = new Position(x, y);
			Move m = new SetBucketMove(lb.getModel().getBucket(), pos);

			if (m.execute(lb)) {
				lb.pushMove(m);
			}

		}
		else{
			System.out.println("Set bucket is not available in current mode");
		}
	}
}
