package levelBuilder.view;

import javax.swing.JFrame;
import javax.swing.JButton;

import levelBuilder.controller.BuildingScreenController;

public class RequestScreen extends JFrame {
	JButton btnStartBuildingLevels;
	
	JButton level[] = new JButton[21];
	
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
