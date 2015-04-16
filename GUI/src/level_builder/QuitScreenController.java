package level_builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitScreenController implements ActionListener{
	QuitScreen request;
	
	public QuitScreenController(QuitScreen rs) {
		this.request = rs;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		request.setVisible(false);
		
		// create screen
		QuitScreen quit = new QuitScreen();
		quit.setVisible(true);
		// set controller for previous button
//		secondScreen.getPreviousButton().addActionListener(new PrevScreenController(main, secondScreen));
		
	}

}
