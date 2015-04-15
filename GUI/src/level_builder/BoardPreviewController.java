package level_builder;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPreviewController implements ActionListener{
	PreviewScreen request;
	
	public BoardPreviewController(PreviewScreen rs) {
		this.request = rs;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		request.setVisible(false);
		
		// create screen
		PreviewScreen preview = new PreviewScreen();
		preview.setVisible(true);
		// set controller for previous button
//		secondScreen.getPreviousButton().addActionListener(new PrevScreenController(main, secondScreen));
		
	}
}
