package levelBuilder.controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilder.entity.Model;
import levelBuilder.view.PreviewScreen;

public class BoardPreviewController implements ActionListener{
	//PreviewScreen request;
	Model model;
	
	public BoardPreviewController(Model model) {
//		this.request = rs;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		request.setVisible(false);
		
		// create screen
		PreviewScreen preview = new PreviewScreen(model);
		preview.setVisible(true);
		// set controller for previous button
//		secondScreen.getPreviousButton().addActionListener(new PrevScreenController(main, secondScreen));
		
	}
}
