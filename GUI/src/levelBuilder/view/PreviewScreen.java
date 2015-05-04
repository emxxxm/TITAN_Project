package levelBuilder.view;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import sixesWild.view.PlayPanel;
import levelBuilder.controller.CloseWindowController;
import levelBuilder.entity.Model;

public class PreviewScreen extends JFrame{

	Model model;
	
//	JLabel levelNumber;
//	JLabel curLevelNum;
//	JLabel curMode;
	
	protected JLabel levelLabel;
	protected JLabel timeLabel;
	protected JLabel moveLeftLabel;
	protected JLabel typeLabel;
	
	protected JLabel oneStar;
	protected JLabel twoStar;
	protected JLabel threeStar;
	
	protected JButton removeButton;
	protected JButton swapButton;
	protected JButton resetButton;
	protected JButton quitButton;

	protected PreviewPlayPanel previewPlayPanel;


	public PreviewScreen(Model m){
		super();
		this.model=m;
		this.setBounds(0, 0, 900, 600);
		this.setVisible(true);
		this.setTitle("Preview");
		
		
		initialize();
		addToPanel();
		getContentPane().setLayout(null);
		quitButton.addActionListener(new CloseWindowController(this));
	}
	
	void initialize(){
		levelLabel = new JLabel();
		levelLabel.setBounds(22, 13, 126, 50);
		levelLabel.setText("Level number: "+Integer.toString(model.getCurLevel()));
		
		timeLabel = new JLabel();
		timeLabel.setBounds(22, 33, 126, 50);
		timeLabel.setText("score: "+model.getLimits().getTimeLimits());	

		moveLeftLabel = new JLabel();
		moveLeftLabel.setBounds(22, 53, 126, 50);
		moveLeftLabel.setText("Moves Left: "+model.getLimits().getMoveLimits());

		typeLabel = new JLabel();
		typeLabel.setBounds(22, 73, 126, 50);
		typeLabel.setText("Type: "+model.getCurrentLevel().get(model.getCurLevel()));

		oneStar= new JLabel();
		oneStar.setBounds(22, 113, 126, 50);
		oneStar.setText("One Star: "+model.getStarGoals().getOne());
		
		twoStar= new JLabel();
		twoStar.setBounds(22, 133, 126, 50);
		twoStar.setText("Two Star: "+model.getStarGoals().getTwo());
		
		threeStar= new JLabel();
		threeStar.setBounds(22, 153, 126, 50);
		threeStar.setText("Three Star: "+model.getStarGoals().getThree());
	
		removeButton= new JButton();
		removeButton.setBounds(22, 216, 113, 27);
		removeButton.setText("Remove: "+model.getLimits().getRemoveLimits());
	
		swapButton= new JButton();
		swapButton.setBounds(22, 256, 113, 27);
		swapButton.setText("Swap: "+model.getLimits().getSwapLimits());
	
		resetButton= new JButton();
		resetButton.setBounds(22, 296, 113, 27);
		resetButton.setText("Reset");
	
		quitButton= new JButton();
		quitButton.setBounds(22, 336, 113, 27);
		quitButton.setText("QUIT");
		
		previewPlayPanel = new PreviewPlayPanel(model);
		previewPlayPanel.setBounds(300, 0, 600, 600);
		
	}
	
	void addToPanel(){
		getContentPane().add(levelLabel);
		getContentPane().add(timeLabel);
		getContentPane().add(moveLeftLabel);
		getContentPane().add(typeLabel);

		getContentPane().add(oneStar);
		getContentPane().add(twoStar);
		getContentPane().add(threeStar);
		
		getContentPane().add(removeButton);
		getContentPane().add(swapButton);
		getContentPane().add(resetButton);
		getContentPane().add(quitButton);
		
		getContentPane().add(previewPlayPanel);
	}
	
	public Model getModel() {
		return model;
	}

	public JLabel getLevelLabel() {
		return levelLabel;
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public JLabel getMoveLeftLabel() {
		return moveLeftLabel;
	}

	public JLabel getTypeLabel() {
		return typeLabel;
	}

	public JLabel getOneStar() {
		return oneStar;
	}

	public JLabel getTwoStar() {
		return twoStar;
	}

	public JLabel getThreeStar() {
		return threeStar;
	}

	public JButton getRemoveButton() {
		return removeButton;
	}

	public JButton getSwapButton() {
		return swapButton;
	}

	public JButton getResetButton() {
		return resetButton;
	}

	public JButton getQuitButton() {
		return quitButton;
	}

	public PreviewPlayPanel getPreviewPlayPanel() {
		return previewPlayPanel;
	}
}
