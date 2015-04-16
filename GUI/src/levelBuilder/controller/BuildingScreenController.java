package levelBuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilder.view.LBPanel;
import levelBuilder.view.RequestScreen;


public class BuildingScreenController implements ActionListener {
	RequestScreen request;
	
	public BuildingScreenController(RequestScreen rs) {
		this.request = rs;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		request.setVisible(false);
		
		// create screen
		LBPanel panel = new LBPanel();
		panel.setVisible(true);

		// set controller for previous button
//		secondScreen.getPreviousButton().addActionListener(new PrevScreenController(main, secondScreen));
		
	}
}
