package sixesWild.view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import sixesWild.model.Model;

public class BoardView extends JFrame
{
	protected JLabel levelLabel;
	protected JLabel scoreLabel;
	protected JButton removeButton;
	protected JButton swapButton;
	protected JButton resetButton;
	protected JButton quitButton;
	protected JLabel timeLabel;
	protected JLabel moveLeftLabel;
	protected PlayPanel playPanel;
	protected JLabel typeLabel;

//	public static void main(String[] args)
//	{
//		Model m=new Model();
//		BoardView bv=new BoardView(m);
//		bv.setBounds(0, 0, 900, 600);
//		bv.setVisible(true);
//	}
	
	
	public JButton getQuitButton()
	{
		return quitButton;
	}
	public JButton getRemoveButton()
	{
		return removeButton;
	}
	
	public PlayPanel getPlayPanel()
	{
		return playPanel;
	}
	
	public BoardView(Model m) {
		this.setBounds(0, 0, 900, 600);
		this.setVisible(true);
		this.setTitle("SixesWild");
		
		levelLabel = new JLabel("Level: ");
		scoreLabel = new JLabel("Score: 100");
		removeButton = new JButton("Remove: 3");		
		swapButton = new JButton("Swap: 3");		
		resetButton = new JButton("Reset");	
		quitButton = new JButton("Quit");		
		timeLabel = new JLabel("Time: ");		
		moveLeftLabel = new JLabel("Move Left: ");
		
		playPanel = new PlayPanel(m);
		playPanel.setBounds(300, 0, 600, 600);

//		JPanel p=new JPanel();
//		p.setBounds(300, 0, 600, 600);
		
		typeLabel = new JLabel("Type: ");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(removeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(quitButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
									.addGap(185))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(swapButton, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
									.addGap(185))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
									.addGap(185))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(scoreLabel, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
									.addGap(192))
								.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(moveLeftLabel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(typeLabel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(playPanel, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
							.addGap(38))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(levelLabel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(778, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(levelLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scoreLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(moveLeftLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(typeLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(removeButton)
					.addGap(31)
					.addComponent(swapButton)
					.addGap(31)
					.addComponent(resetButton)
					.addGap(31)
					.addComponent(quitButton)
					.addContainerGap(117, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(93, Short.MAX_VALUE)
					.addComponent(playPanel, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		getContentPane().setLayout(groupLayout);
	}
}
