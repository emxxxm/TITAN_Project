package sixesWild.view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import sixesWild.model.Model;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CompleteLevelView extends JFrame
{
	protected JButton quitButton;
	protected JLabel levelLabel;
	protected JLabel starLabel;
	protected JLabel scoreLabel;
	protected Model model;
	
//	public static void main(String args[])
//	{
//		CompleteLevelView clv = new CompleteLevelView();
//		clv.setBounds(0, 0, 300, 200);
//		clv.setVisible(true);		
//	}
	
	public JLabel getLevelLabel()
	{
		return this.levelLabel;
	}
	
	public JLabel getStarLabel()
	{
		return this.starLabel;
	}
	
	public JLabel getScoreLabel()
	{
		return this.scoreLabel;
	}
	
	public JButton getQuitButton()
	{
		return this.quitButton;
	}
	
	public CompleteLevelView(Model m) 
	{
		this.model = m;
		this.setSize(300, 200);
		quitButton = new JButton("Select Level");
		
		levelLabel = new JLabel("Current Level");
		
		starLabel = new JLabel("Stars");
		
		scoreLabel = new JLabel("Score: 4500");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(131)
							.addComponent(starLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(110)
							.addComponent(scoreLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(103)
							.addComponent(levelLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(91)
							.addComponent(quitButton)))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(60, Short.MAX_VALUE)
					.addComponent(levelLabel)
					.addGap(18)
					.addComponent(starLabel)
					.addGap(18)
					.addComponent(scoreLabel)
					.addGap(34)
					.addComponent(quitButton)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
}
