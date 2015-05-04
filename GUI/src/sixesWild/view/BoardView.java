package sixesWild.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;

import javax.swing.JPanel;

import sixesWild.controller.CompleteLevelController;
import sixesWild.controller.PlayPanelController;
import sixesWild.controller.RemoveController;
import sixesWild.controller.ResetController;
import sixesWild.controller.SwapController;
import sixesWild.model.EliminationBoard;
import sixesWild.model.LightningBoard;
import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.ReleaseBoard;

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
	protected JProgressBar progressBar;
	protected JLabel oneStar;
	protected JLabel twoStar;
	protected JLabel threeStar;

//	public static void main(String[] args)
//	{
//		Model m=new Model();
//		BoardView bv=new BoardView(m);
//		bv.setBounds(0, 0, 900, 600);
//		bv.setVisible(true);
//	}
	
	public JLabel getTimeLabel()
	{
		return this.timeLabel;
	}
	
	public JProgressBar getProgressBar()
	{
		return this.progressBar;
	}
	
	public JButton getQuitButton()
	{
		return quitButton;
	}
	public JButton getRemoveButton()
	{
		return removeButton;
	}
	public JButton getSwapButton()
	{
		return swapButton;
	}
	
	public PlayPanel getPlayPanel()
	{
		return playPanel;
	}
	
	public JLabel getScoreLabel()
	{
		return scoreLabel;
	}
	
	public JLabel getMoveLeftLabel()
	{
		return moveLeftLabel;
	}
	//BoardView(Board b)
	public BoardView(Model m) {
		this.setBounds(0, 0, 900, 600);
		this.setVisible(true);
		this.setTitle("SixesWild");
//		System.out.println("BEFORE JLABEL!!!");
//		ImageIcon background = new ImageIcon("/home/mengwen/Desktop/images/b_5.jpg");
//		JLabel label = new JLabel(background);
//		label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
//		//label.setOpaque(true);
//		//this.add(label);
//		
////		imagePanel.setLayout(new FlowLayout());
//
//		//this.getLayeredPane().setLayout(null);
//		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
//		this.setResizable(false);
		//this.add(panel);
//		panel.setBackground(new Color(0,0,0,65));
		//this.getContentPane().setBackground(Color.GREEN);
		CompleteLevelController clc =  new CompleteLevelController(m, this);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			   public void windowClosing(WindowEvent evt) {
			     try {
					clc.processQuitClose();
					System.exit(0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
			  });
		
		levelLabel = new JLabel("Level: "+m.getBoard().getCurrLevel());
		scoreLabel = new JLabel("Score: "+m.getBoard().getCurrScore());
		removeButton = new JButton("Remove: "+m.getBoard().getRemoveLeft());		
		swapButton = new JButton("Swap: "+m.getBoard().getSwapLeft());		
		resetButton = new JButton(" Reset ");
		quitButton = new JButton("Quit");
		
		progressBar = new JProgressBar();
		ImageIcon star = new ImageIcon("/home/mengwen/Desktop/oneStar.png");
		oneStar = new JLabel("", star, JLabel.CENTER);
		//oneStar = new JLabel("1");
		ImageIcon twoStars = new ImageIcon("/home/mengwen/Desktop/twoStars.png");
		twoStar = new JLabel("", twoStars, JLabel.CENTER);
		threeStar = new JLabel("3");
		System.out.println(progressBar.getMaximumSize());
		System.out.println(m.getBoard().getStarScore().get(2));
		progressBar.setMaximum(m.getBoard().getStarScore().get(2));
		double score_1=m.getBoard().getStarScore().get(0);
		double score_2=m.getBoard().getStarScore().get(1);
		double score_3=m.getBoard().getStarScore().get(2);
		int gap_1=(int)Math.floor(530*(score_1/score_3));
		int gap_2=(int)Math.floor(530*(score_2/score_3))-gap_1;
		int gap_3=530-gap_2-gap_1;
		String s = " ";
		timeLabel = new JLabel("Time: ");
		moveLeftLabel = new JLabel("Move Left: ");
		//if board is instance of lighting:
		if(m.getBoard() instanceof LightningBoard)
		{
			System.out.println("IN LIGHTNINGBOARD!!!!!!!!!!!!!!!!!!");
			System.out.println(((LightningBoard)(m.getBoard())).getTimeLimit());
			moveLeftLabel.setVisible(false);
			timeLabel = new JLabel("Time Left: "+((LightningBoard)(m.getBoard())).getTimeLimit());
			s = "Lightning";
		}
		//if board is a puzzle board, set move left and hide time left.
		else if(m.getBoard() instanceof PuzzleBoard)
		{
			moveLeftLabel = new JLabel("Move Left: "+ ((PuzzleBoard)(m.getBoard())).getMoveLimit());
			timeLabel.setVisible(false);
			s = "Puzzle";
		}
		else if(m.getBoard() instanceof EliminationBoard)
		{
			moveLeftLabel = new JLabel("Move Left: "+ ((EliminationBoard)(m.getBoard())).getMoveLimit());
			timeLabel.setVisible(false);
			s = "Elimination";
		}
		//if board is a release board
		else
		{
//			moveLeftLabel.setVisible(false);
			moveLeftLabel = new JLabel("Move Left: "+ ((ReleaseBoard)(m.getBoard())).getMoveLimit());
			timeLabel.setVisible(false);
			s = "Release";
		}
		
		playPanel = new PlayPanel(m);
		playPanel.setBounds(300, 0, 600, 600);
		
		
		SwapController sc = new SwapController(m, this);
		RemoveController rc = new RemoveController(m, this);
		ResetController rec = new ResetController(m, this);
		//Create a controller that implements MouseListener and MouseMotionListener, 
		//register this controller to playPanel.
		swapButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// register controller
				sc.register();				
			}
		});
		removeButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// register controller
				rc.register();				
			}
		});
		
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rec.process();
			}
		});
		PlayPanelController ppc = new PlayPanelController(m, this);
		ppc.register();
		
		//playPanel.addMouseMotionListener(new PlayPanelController(m, this));
//		JPanel p=new JPanel();
//		p.setBounds(300, 0, 600, 600);
		typeLabel = new JLabel("Type: "+s);
		
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
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(playPanel, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
								.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							//The gap can be changed here!
							//The total length of progress bar should be 450+80 = 530. 
							.addGap(gap_1)
							.addComponent(oneStar)
							.addGap(gap_2)
							.addComponent(twoStar)
							.addGap(gap_3)
							.addComponent(threeStar)))
					.addGap(26))
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
					.addContainerGap(42, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(oneStar)
						.addComponent(twoStar)
						.addComponent(threeStar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(playPanel, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		getContentPane().setLayout(groupLayout);
	}
}
