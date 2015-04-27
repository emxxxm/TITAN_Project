package levelBuilder.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import levelBuilder.entity.Model;

public class PreviewScreen extends JFrame{
	Model model;
	
	JLabel previewLevel;
	JLabel curLevel;
	JLabel curMode;
	
	
	public PreviewScreen(Model m){
		super();
		setTitle("BoardPreview");
		setSize(800, 500);
		getContentPane().setLayout(null);
		
		initialize();
		addToPanel();
	}
	
	void initialize(){
		previewLevel = new JLabel();
		previewLevel.setBounds(22, 0, 200, 35);
		previewLevel.setText("Preview level");
	
		curLevel = new JLabel();
		curLevel.setBounds(22, 50, 200, 35);
		curLevel.setText(""+model.getCurLevel());
		

	}
	
	void addToPanel(){
		getContentPane().add(previewLevel);

	}
}
