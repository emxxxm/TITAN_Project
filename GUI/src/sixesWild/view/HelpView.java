package sixesWild.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;


public class HelpView extends JFrame{
	JLabel lblHelp;
	JTextPane txtpnHereIsHow;
	JButton btnQuit;
	
	public JLabel getLable(){
		return lblHelp;
	}
	
	public JTextPane getTextPane(){
		return txtpnHereIsHow;
	}
	
	public JButton getQuitButton(){
		return btnQuit;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			HelpView window = new HelpView();
			window.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public HelpView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblHelp = new JLabel("Help");
		lblHelp.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		
		txtpnHereIsHow = new JTextPane();
		txtpnHereIsHow.setEditable(false);
		txtpnHereIsHow.setText("Here is how to play this game");
		
		btnQuit = new JButton("Quit");
		
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtpnHereIsHow, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(26, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHelp)
							.addPreferredGap(ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
							.addComponent(btnQuit)
							.addGap(18))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblHelp)
						.addComponent(btnQuit))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnHereIsHow, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		this.getContentPane().setLayout(groupLayout);
	}
}