package level_builder;

import javax.swing.JFrame;
import javax.swing.JButton;



public class RequestScreen extends JFrame {
	
	
	public RequestScreen(){
		super();
		setTitle("Start Building Levels");
		setSize(600, 400);
		getContentPane().setLayout(null);
		
		JButton btnStartBuildingLevels = new JButton("Start building levels!");
		btnStartBuildingLevels.setBounds(195, 144, 175, 25);
		getContentPane().add(btnStartBuildingLevels);

		btnStartBuildingLevels.addActionListener(new BuildingScreenController(this));
	
	}
	

	

}
