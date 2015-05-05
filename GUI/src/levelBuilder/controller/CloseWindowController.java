package levelBuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import levelBuilder.entity.Model;
import levelBuilder.view.RequestScreen;

public class CloseWindowController implements ActionListener {
	
	JFrame frame;
	Model model;
	public CloseWindowController(JFrame f){
		this.frame = f;
	}
	
	public CloseWindowController(JFrame fClose, Model m){
		this.frame = fClose;
		this.model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		//System.exit(0);
		if(model != null){
			RequestScreen rs = new RequestScreen(model);
			rs.setVisible(true);
		}
		

	}
	
	
}
