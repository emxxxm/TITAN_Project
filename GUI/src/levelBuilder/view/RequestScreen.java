package levelBuilder.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

import levelBuilder.controller.BuildingScreenController;
import levelBuilder.controller.LoadLevelController;
import levelBuilder.entity.Model;
import levelBuilder.game.LevelBuilder;


import javax.swing.LayoutStyle.ComponentPlacement;

public class RequestScreen extends JFrame {
	JButton btnStartBuildingLevels;


	protected ArrayList<JButton> levelButtons = new ArrayList<JButton>();
	Model m;
	public RequestScreen(Model m){
		super();
		this.m = m;		
		
		initialize();
	}
		JButton[] level = new JButton[21];
	
	
	public RequestScreen(){
		super();
		setTitle("Start Building Levels");
		setSize(600, 400);
		getContentPane().setLayout(null);
		
		btnStartBuildingLevels = new JButton("Start building levels!");
		btnStartBuildingLevels.setBounds(33, 21, 175, 25);
		getContentPane().add(btnStartBuildingLevels);
		
		btnStartBuildingLevels.addActionListener(new BuildingScreenController(this));

	
		buttonInitialize();
		buttonController();
	}

	private void buttonController() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Start Building Levels");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		
		
		this.getContentPane().setBackground(Color.BLACK);
		this.getContentPane().setForeground(Color.BLACK);
		this.setBounds(100, 100, 750, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Level Builder");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lblNewLabel.setForeground(Color.white);
		
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
		
		JButton btnCreateNew = new JButton("Create New!");
		btnCreateNew.setBackground(Color.GRAY);
		btnCreateNew.setOpaque(true);
		btnCreateNew.setBorderPainted(false);
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(93)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
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
								.addComponent(btnLevel_18, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnLevel_19, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
								.addComponent(btnLevel_15, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
								.addComponent(btnLevel_11, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
								.addComponent(btnLevel_7, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
								.addComponent(btnLevel_3, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
							.addContainerGap(96, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCreateNew)
							.addGap(25))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(32, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(54))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(btnCreateNew)
							.addPreferredGap(ComponentPlacement.RELATED)))
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
					.addContainerGap(77, Short.MAX_VALUE))
		);
		this.getContentPane().setLayout(groupLayout);
		//Assume the first 5 levels are available and the others are disabled for now.
		//Add controllers for all the buttons here.
		LBPanel panel = new LBPanel(m);
		LevelBuilder lb = new LevelBuilder(m, panel);
		for(int i=0;i<levelButtons.size();i++)
		{	int levelNum = i + 1;
			String file = "level" + levelNum;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				levelButtons.get(i).addActionListener(new LoadLevelController(m, lb, file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				levelButtons.get(i).addActionListener(new BuildingScreenController(this));
			}
			
		}
		/*
		for(int i=0;i<levelButtons.size();i++)
		{
			//This may be changed later.
			levelButtons.get(i).addActionListener(new StartLevelController(this,m,i+1));
		}
		//Is entity needed in DisplayRecordController?
		btnRecord.addActionListener(new DisplayRecordController(this));
		btnHelp.addActionListener(new DisplayHelpController(this));
	*/
		btnCreateNew.addActionListener(new BuildingScreenController(this));
	}

	private void buttonInitialize() {
		level[1] = new JButton("level1");
		level[1].setBounds(33, 83, 89, 23);
		getContentPane().add(level[1]);
		
		level[2] = new JButton("level2");
		level[2].setBounds(152, 83, 89, 23);
		getContentPane().add(level[2]);
		
		level[3] = new JButton("level3");
		level[3].setBounds(273, 83, 89, 23);
		getContentPane().add(level[3]);
		
		level[4] = new JButton("level4");
		level[4].setBounds(402, 83, 89, 23);
		getContentPane().add(level[4]);
		
		level[5] = new JButton("level5");
		level[5].setBounds(33, 129, 89, 23);
		getContentPane().add(level[5]);
		
		level[6] = new JButton("level6");
		level[6].setBounds(152, 129, 89, 23);
		getContentPane().add(level[6]);
		
		level[7] = new JButton("level7");
		level[7].setBounds(273, 129, 89, 23);
		getContentPane().add(level[7]);
		
		level[8] = new JButton("level8");
		level[8].setBounds(402, 129, 89, 23);
		getContentPane().add(level[8]);
		
		level[9] = new JButton("level9");
		level[9].setBounds(33, 177, 89, 23);
		getContentPane().add(level[9]);
		
		level[10] = new JButton("level10");
		level[10].setBounds(152, 177, 89, 23);
		getContentPane().add(level[10]);
		
		level[11] = new JButton("level11");
		level[11].setBounds(273, 177, 89, 23);
		getContentPane().add(level[11]);
		
		level[12] = new JButton("level12");
		level[12].setBounds(402, 177, 89, 23);
		getContentPane().add(level[12]);
		
		level[13] = new JButton("level13");
		level[13].setBounds(33, 227, 89, 23);
		getContentPane().add(level[13]);
		
		level[14] = new JButton("level14");
		level[14].setBounds(152, 227, 89, 23);
		getContentPane().add(level[14]);
		
		level[15] = new JButton("level15");
		level[15].setBounds(273, 227, 89, 23);
		getContentPane().add(level[15]);
		
		level[16] = new JButton("level16");
		level[16].setBounds(402, 227, 89, 23);
		getContentPane().add(level[16]);
		
		level[17] = new JButton("level17");
		level[17].setBounds(33, 277, 89, 23);
		getContentPane().add(level[17]);
		
		level[18] = new JButton("level18");
		level[18].setBounds(152, 277, 89, 23);
		getContentPane().add(level[18]);
		
		level[19] = new JButton("level19");
		level[19].setBounds(273, 277, 89, 23);
		getContentPane().add(level[19]);
		
		level[20] = new JButton("level20");
		level[20].setBounds(402, 277, 89, 23);
		getContentPane().add(level[20]);

	}
}
