package sixesWild.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import sixesWild.controller.DisplayHelpController;
import sixesWild.controller.DisplayRecordController;
import sixesWild.controller.StartLevelController;
import sixesWild.model.Model;


public class SelectLevelView extends JFrame {
	protected Model m;
	
	protected JButton btnRecord;
	protected JButton btnHelp;
	
	protected ArrayList<JButton> levelButtons = new ArrayList<JButton>();
	
	public JButton getRcordButton(){
		return btnRecord;
	}
	
	public JButton getHelpButton(){
		return btnHelp;
	}
	public ArrayList<JButton> getlevelButtons(){
		return levelButtons;
	}
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//			Model m=new Model();
//			SelectLevelView window = new SelectLevelView(m);
////			window.levelButtons.get(1).setEnabled(false);
//			window.setVisible(true);
//	}

	/**
	 * Create the application.
	 */
	public SelectLevelView(Model m) 
	{
		this.m=m;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		btnRecord = new JButton("Record");
		btnHelp = new JButton("Help");
		this.getContentPane().setBackground(Color.BLACK);
		this.getContentPane().setForeground(Color.BLACK);
		this.setBounds(100, 100, 750, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Sixes Wild");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD,  40));
		lblNewLabel.setForeground(Color.white);
		
		btnRecord.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnRecord.setBackground(Color.YELLOW);
		
		btnHelp.setForeground(Color.BLACK);
		btnHelp.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JButton btnLevel = new JButton("Level 1");
		btnLevel.setBackground(Color.RED);
		btnLevel.setOpaque(true);
		btnLevel.setBorderPainted(false);
		
		JButton btnLevel_1 = new JButton("Level 2");
		btnLevel_1.setForeground(Color.BLACK);
		btnLevel_1.setBackground(Color.CYAN);
		btnLevel_1.setOpaque(true);
		btnLevel_1.setBorderPainted(false);
		
		
		JButton btnLevel_2 = new JButton("Level 3");
		btnLevel_2.setForeground(Color.BLACK);
		btnLevel_2.setBackground(Color.GREEN);
		btnLevel_2.setOpaque(true);
		btnLevel_2.setBorderPainted(false);

		
		JButton btnLevel_3 = new JButton("Level 4");
		btnLevel_3.setForeground(Color.BLACK);
		btnLevel_3.setBackground(Color.ORANGE);
		btnLevel_3.setOpaque(true);
		btnLevel_3.setBorderPainted(false);
		
		JButton btnLevel_4 = new JButton("Level 5");
		btnLevel_4.setBackground(Color.RED);
		btnLevel_4.setOpaque(true);
		btnLevel_4.setBorderPainted(false);
		
		JButton btnLevel_5 = new JButton("Level 6");
		btnLevel_5.setBackground(Color.CYAN);
		btnLevel_5.setOpaque(true);
		btnLevel_5.setBorderPainted(false);
		
		JButton btnLevel_6 = new JButton("Level 7");
		btnLevel_6.setBackground(Color.GREEN);
		btnLevel_6.setOpaque(true);
		btnLevel_6.setBorderPainted(false);
		
		JButton btnLevel_7 = new JButton("Level 8");
		btnLevel_7.setBackground(Color.ORANGE);
		btnLevel_7.setOpaque(true);
		btnLevel_7.setBorderPainted(false);
		
		JButton btnLevel_8 = new JButton("Level 9");
		btnLevel_8.setBackground(Color.RED);
		btnLevel_8.setOpaque(true);
		btnLevel_8.setBorderPainted(false);
		
		JButton btnLevel_9 = new JButton("Level 10");
		btnLevel_9.setBackground(Color.CYAN);
		btnLevel_9.setOpaque(true);
		btnLevel_9.setBorderPainted(false);
		
		JButton btnLevel_10 = new JButton("Level 11");
		btnLevel_10.setBackground(Color.GREEN);
		btnLevel_10.setOpaque(true);
		btnLevel_10.setBorderPainted(false);
		
		JButton btnLevel_11 = new JButton("Level 12");
		btnLevel_11.setBackground(Color.ORANGE);
		btnLevel_11.setOpaque(true);
		btnLevel_11.setBorderPainted(false);
		
		JButton btnLevel_12 = new JButton("Level 13");
		btnLevel_12.setBackground(Color.RED);
		btnLevel_12.setOpaque(true);
		btnLevel_12.setBorderPainted(false);
		
		JButton btnLevel_13 = new JButton("Level 14");
		btnLevel_13.setBackground(Color.CYAN);
		btnLevel_13.setOpaque(true);
		btnLevel_13.setBorderPainted(false);
		
		JButton btnLevel_14 = new JButton("Level 15");
		btnLevel_14.setBackground(Color.GREEN);
		btnLevel_14.setOpaque(true);
		btnLevel_14.setBorderPainted(false);
		
		JButton btnLevel_15 = new JButton("Level 16");
		btnLevel_15.setBackground(Color.ORANGE);
		btnLevel_15.setOpaque(true);
		btnLevel_15.setBorderPainted(false);
		
		JButton btnLevel_16 = new JButton("Level 17");
		btnLevel_16.setBackground(Color.RED);
		btnLevel_16.setOpaque(true);
		btnLevel_16.setBorderPainted(false);
		
		JButton btnLevel_17 = new JButton("Level 18");
		btnLevel_17.setBackground(Color.CYAN);
		btnLevel_17.setOpaque(true);
		btnLevel_17.setBorderPainted(false);
		
		JButton btnLevel_18 = new JButton("Level 19");
		btnLevel_18.setBackground(Color.GREEN);
		btnLevel_18.setOpaque(true);
		btnLevel_18.setBorderPainted(false);
		
		JButton btnLevel_19 = new JButton("Level 20");
		btnLevel_19.setBackground(Color.ORANGE);
		btnLevel_19.setOpaque(true);
		btnLevel_19.setBorderPainted(false);
		
		levelButtons.add(btnLevel);		
		levelButtons.add(btnLevel_1);		
		levelButtons.add(btnLevel_2);		
		levelButtons.add(btnLevel_3);	
		levelButtons.add(btnLevel_4);
		levelButtons.add(btnLevel_5);	
		levelButtons.add(btnLevel_6);		
		levelButtons.add(btnLevel_7);	
		levelButtons.add(btnLevel_8);
		levelButtons.add(btnLevel_9);		
		levelButtons.add(btnLevel_10);		
		levelButtons.add(btnLevel_11);
		levelButtons.add(btnLevel_12);		
		levelButtons.add(btnLevel_13);		
		levelButtons.add(btnLevel_14);		
		levelButtons.add(btnLevel_15);		
		levelButtons.add(btnLevel_16);
		levelButtons.add(btnLevel_17);		
		levelButtons.add(btnLevel_18);				
		levelButtons.add(btnLevel_19);
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(93)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnRecord, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(91)
							.addComponent(lblNewLabel)
							.addGap(84)
							.addComponent(btnHelp))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLevel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_4, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_8, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_12, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_16, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLevel_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_5, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_9, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_13, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_17, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLevel_2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_6, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_10, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_14, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_18, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLevel_19, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_15, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_11, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_7, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLevel_3, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnHelp)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(btnRecord, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel_4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLevel_12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_15, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLevel_16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_17, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_18, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel_19, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		this.getContentPane().setLayout(groupLayout);
		//Assume the first 5 levels are available and the others are disabled for now.
		//Add controllers for all the buttons here.
		for(int i=0;i<levelButtons.size();i++)
		{
			levelButtons.get(i).setEnabled(m.getAllLevels().getGivenLevel(i+1).isLocked());
		}
		for(int i=0;i<levelButtons.size();i++)
		{
			//This may be changed later.
			levelButtons.get(i).addActionListener(new StartLevelController(this,m,i+1));
		}
		//Is entity needed in DisplayRecordController?
		btnRecord.addActionListener(new DisplayRecordController(this));
		btnHelp.addActionListener(new DisplayHelpController(this));
	
	}
}