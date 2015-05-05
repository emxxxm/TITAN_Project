package sixesWild.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextPane;

import sixesWild.model.Model;

public class RecordView extends JFrame
{
	//How to represent stars?
	protected JButton quitButton;
	protected Model model;
	protected ArrayList<JLabel> highScoreLabel;
	protected ArrayList<Integer> highScore;
	protected ArrayList<Integer> starCount;
	protected final String scoreFile = "src/highScore.txt";
	
	public JButton getQuitButton()
	{
		return quitButton;		
	}
	
	public RecordView(Model m) 
	{
		this.model = m;
		this.setSize(900, 600);
		//Read in the highscore file.
		try
		{
			highScore = new ArrayList<Integer>();
			starCount = new ArrayList<Integer>();
			ArrayList<String> recordString = new ArrayList<String>();
			BufferedReader r = new BufferedReader(new FileReader(scoreFile));
			String text=null;
			text=r.readLine();
			while(text!=null)
			{
				recordString.add(text);
				text=r.readLine();
			}
			System.out.println(recordString.get(0));
			System.out.println(recordString.get(1));
			String[] scoreArray=recordString.get(0).split(" ");
			String[] starArray=recordString.get(1).split(" ");
			for(int i=0;i<m.getAllLevels().getNumLevels();i++)
			{
				highScore.add(Integer.parseInt(scoreArray[i]));
				starCount.add(Integer.parseInt(starArray[i]));
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			System.out.println("IOException!");
			e.printStackTrace();
		}
		quitButton = new JButton("Return");
		
		JLabel lblNewLabel = new JLabel("SixesWild Highest Score");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		
		JLabel label = new JLabel("<html>Level 1   <br>Highest Score: " + highScore.get(0)+" <br>Stars achieved: " + starCount.get(0) + "</html>");
		
		JLabel label_0 = new JLabel("<html>Level 2   <br>Highest Score: " + highScore.get(1) + " <br>Stars achieved: " + starCount.get(1) + " </html>");
		
		JLabel label_1 = new JLabel("<html>Level 3   <br>Highest Score: " + highScore.get(2) + "<br>Stars achieved: " + starCount.get(2) + "</html>");
	
		JLabel label_2 = new JLabel("<html>Level 4   <br>Highest Score: " + highScore.get(3) + "<br>Stars achieved: " + starCount.get(3) + "</html>");
		
		JLabel label_3 = new JLabel("<html>Level 5   <br>Highest Score: " + highScore.get(4) + "<br>Stars achieved: " + starCount.get(4) + "</html>");
		
		JLabel label_4 = new JLabel("<html>Level 6   <br>Highest Score: " + highScore.get(5) + "<br>Stars achieved: " + starCount.get(5) + "</html>");
		
		JLabel label_5 = new JLabel("<html>Level 7   <br>Highest Score: " + highScore.get(6) + "<br>Stars achieved: " + starCount.get(6) + "</html>");
		
		JLabel label_6 = new JLabel("<html>Level 8   <br>Highest Score: " + highScore.get(7) + "<br>Stars achieved: " + starCount.get(7) + "</html>");
		
		JLabel label_7 = new JLabel("<html>Level 9   <br>Highest Score: " + highScore.get(8) + "<br>Stars achieved: " + starCount.get(8) + "</html>");
		
		JLabel label_8 = new JLabel("<html>Level 10   <br>Highest Score: " + highScore.get(9) + "<br>Stars achieved: " + starCount.get(9) + "</html>");
		
		JLabel label_9 = new JLabel("<html>Level 11   <br>Highest Score: " + highScore.get(10) + "<br>Stars achieved: " + starCount.get(10) + "</html>");
		
		JLabel label_10 = new JLabel("<html>Level 12   <br>Highest Score: " + highScore.get(11) + "<br>Stars achieved: " + starCount.get(11) + "</html>");
		
		JLabel label_11 = new JLabel("<html>Level 13   <br>Highest Score: " + highScore.get(12) + "<br>Stars achieved: " + starCount.get(12) + "</html>");
		
		JLabel label_12 = new JLabel("<html>Level 14   <br>Highest Score: " + highScore.get(13) + "<br>Stars achieved: " + starCount.get(13) + "</html>");
		
		JLabel label_13 = new JLabel("<html>Level 15   <br>Highest Score: " + highScore.get(14) + "<br>Stars achieved: " + starCount.get(14) + "</html>");
		
		JLabel label_14 = new JLabel("<html>Level 16   <br>Highest Score: " + highScore.get(15) + "<br>Stars achieved: " + starCount.get(15) + "</html>");
		
		JLabel label_15 = new JLabel("<html>Level 17   <br>Highest Score: " + highScore.get(16) + "<br>Stars achieved: " + starCount.get(16) + "</html>");
		
		JLabel label_16 = new JLabel("<html>Level 18   <br>Highest Score: " + highScore.get(17) + "<br>Stars achieved: " + starCount.get(17) + "</html>");
		
		JLabel label_17 = new JLabel("<html>Level 19   <br>Highest Score: " + highScore.get(18) + "<br>Stars achieved: " + starCount.get(18) + "</html>");
		
		JLabel label_18 = new JLabel("<html>Level 20   <br>Highest Score: " + highScore.get(19) + "<br>Stars achieved: " + starCount.get(19) + "</html>");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(327)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(quitButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
												.addComponent(label, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
												.addGap(38))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label_0, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
												.addGap(38)))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
											.addGap(38)))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
										.addGap(38)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addGap(38)))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_7, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_6, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
							.addGap(81)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_0, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(145)
					.addComponent(quitButton))
		);
		getContentPane().setLayout(groupLayout);
	}
}
