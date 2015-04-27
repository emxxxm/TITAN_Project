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
					.addContainerGap(181, Short.MAX_VALUE)
					.addComponent(quitButton))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(134, Short.MAX_VALUE)
					.addComponent(starLabel)
					.addGap(128))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(94, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scoreLabel)
						.addComponent(levelLabel))
					.addGap(101))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addComponent(levelLabel)
					.addGap(30)
					.addComponent(starLabel)
					.addGap(18)
					.addComponent(scoreLabel)
					.addGap(34)
					.addComponent(quitButton))
		);
		getContentPane().setLayout(groupLayout);
	}
}
