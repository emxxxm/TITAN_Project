package levelBuilder.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import levelBuilder.controller.CloseListener;

public class QuitScreen extends JFrame{

	JButton btnSave;
	JButton btnQuit;
	
	public QuitScreen(){
		super();
		setTitle("Quit");
		setSize(300, 200);
		getContentPane().setLayout(null);
		
		btnSave = new JButton("Save and quit");
		btnSave.setBounds(76, 64, 117, 25);
		getContentPane().add(btnSave);
		
		btnQuit = new JButton("Quit without saving");
		btnQuit.setBounds(50, 102, 175, 25);
		getContentPane().add(btnQuit);
		
		JLabel lblQuitWithoutSaving = new JLabel("Quit without saving?");
		lblQuitWithoutSaving.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuitWithoutSaving.setBounds(65, 26, 160, 25);
		getContentPane().add(lblQuitWithoutSaving);
		
		btnSave.addActionListener(new CloseListener());
		btnQuit.addActionListener(new CloseListener());
	}
	
	
	
}
