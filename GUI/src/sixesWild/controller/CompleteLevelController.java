package sixesWild.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.WindowConstants;

import sixesWild.model.EliminationBoard;
import sixesWild.model.LightningBoard;
import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.ReleaseBoard;
import sixesWild.view.BoardView;
import sixesWild.view.CompleteLevelView;
import sixesWild.view.SelectLevelView;

public class CompleteLevelController 
{
	Model m;
	BoardView bv;
	protected final String scoreFile = "src/highScore.txt";
	
	public CompleteLevelController(Model m, BoardView bv)
	{
		this.m = m;
		this.bv = bv;
	}
	
	public void processQuitClose() throws IOException
	{
		CompleteLevelView clv = new CompleteLevelView(m);		
		//clv.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		clv.getQuitButton().setVisible(false);
		if(m.getBoard() instanceof PuzzleBoard)
		{
			PuzzleBoard pb = (PuzzleBoard)(m.getBoard());
			//If there is not move left.
			clv.setVisible(true);
			bv.setVisible(false);
			//If the score is less than 1-star score.
			if(pb.getCurrScore() < pb.getStarScore().get(0))
			{
				//handle the loose condition. 
				this.handleLoseCondition(clv);
			}
			else
			{
				this.handleWinCondition(clv);
				this.recordScore();
			}
		}
		else if(m.getBoard() instanceof LightningBoard)
		{
			LightningBoard lb = (LightningBoard)(m.getBoard());
			System.out.println(lb.getTimeLeft());
			System.out.println("HERE!!!");
			clv.setVisible(true);
			bv.setVisible(false);
			//If the score is less than 1-star score.
			if(lb.getCurrScore() < lb.getStarScore().get(0))
			{
				//handle the loose condition.
				this.handleLoseCondition(clv);
			}
			else
			{
				this.handleWinCondition(clv);
				this.recordScore();
			}
		}
		else if(m.getBoard() instanceof EliminationBoard)
		{
			EliminationBoard eb = (EliminationBoard)(m.getBoard());
			//If there is not move left.
			clv.setVisible(true);
			bv.setVisible(false);
			//If the score is less than 1-star score.
			if(eb.getCurrScore() < eb.getStarScore().get(0) || !eb.allMarked())
			{
				//handle the loose condition.
				this.handleLoseCondition(clv);
			}
			else
			{
				this.handleWinCondition(clv);
				this.recordScore();
			}
		}
		else if(m.getBoard() instanceof ReleaseBoard)
		{
			ReleaseBoard rb = (ReleaseBoard)(m.getBoard());
			clv.setVisible(true);
			bv.setVisible(false);
			//If the score is less than 1-star score.
			if(rb.getCurrScore() < rb.getStarScore().get(0) || !rb.allBucketFilled() )
			{
				//handle the loose condition.
				this.handleLoseCondition(clv);
			}
			else
			{
				this.handleWinCondition(clv);
			}
		}
		SelectLevelView slv = new SelectLevelView(m);
		clv.getQuitButton().addActionListener(new ReturnMenuController(slv,clv));
	}
	
	public void process() throws IOException
	{	
		CompleteLevelView clv = new CompleteLevelView(m);		
		//clv.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		if(m.getBoard() instanceof PuzzleBoard)
		{
			PuzzleBoard pb = (PuzzleBoard)(m.getBoard());
			//If there is not move left.
			if(pb.getMoveLeft() == 0)
			{
				clv.setVisible(true);
				bv.setVisible(false);
				//If the score is less than 1-star score.
				if(pb.getCurrScore() < pb.getStarScore().get(0))
				{
					//handle the loose condition.
					this.handleLoseCondition(clv);
				}
				else
				{
					this.handleWinCondition(clv);
					this.recordScore();
				}
			}
		}
		else if(m.getBoard() instanceof LightningBoard)
		{
			LightningBoard lb = (LightningBoard)(m.getBoard());
			System.out.println(lb.getTimeLeft());
			if(lb.getTimeLeft()==0)
			{
				//System.out.println("HERE!!!");
				clv.setVisible(true);
				bv.setVisible(false);
				//If the score is less than 1-star score.
				if(lb.getCurrScore() < lb.getStarScore().get(0))
				{
					//handle the loose condition.
					this.handleLoseCondition(clv);
				}
				else
				{
					this.handleWinCondition(clv);
					this.recordScore();
				}
			}
		}
		else if(m.getBoard() instanceof EliminationBoard)
		{
			//System.out.println("IN ELIMINATIONBOARD");
			EliminationBoard eb = (EliminationBoard)(m.getBoard());
			//If there is not move left.
			if(eb.getMoveLeft() == 0)
			{
				clv.setVisible(true);
				bv.setVisible(false);
				//If the score is less than 1-star score.
				if(eb.getCurrScore() < eb.getStarScore().get(0) || !eb.allMarked())
				{
					//handle the loose condition.
					this.handleLoseCondition(clv);
				}
				else
				{
					this.handleWinCondition(clv);
					System.out.println("BEFORE RECORDSCORE!!||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					this.recordScore();
				}
			}
		}
		else if(m.getBoard() instanceof ReleaseBoard)
		{
			ReleaseBoard rb = (ReleaseBoard)(m.getBoard());
			//If there is not move left.
			if(rb.getMoveLeft() == 0){
				clv.setVisible(true);
				bv.setVisible(false);
				//If the score is less than 1-star score.
				if(rb.getCurrScore() < rb.getStarScore().get(0) || !rb.allBucketFilled() )
				{
					//handle the loose condition.
					this.handleLoseCondition(clv);
				}
				else
				{
					this.handleWinCondition(clv);
				}
			}
		}
		SelectLevelView slv = new SelectLevelView(m);
		clv.getQuitButton().addActionListener(new ReturnMenuController(slv,clv));
	}
	
	private void handleLoseCondition(CompleteLevelView clv)
	{
		clv.getLevelLabel().setText("Level: "+m.getBoard().getCurrLevel());
		clv.getStarLabel().setText("LOSE!");
		clv.getScoreLabel().setText("Score: "+m.getBoard().getCurrScore());
		return;
	}
	
	private void handleWinCondition(CompleteLevelView clv) throws IOException
	{
		int nextLevel = 0;
		nextLevel = m.getBoard().getCurrLevel()+1;
		if(nextLevel < m.getAllLevels().getNumLevels())
		{
			m.getAllLevels().getGivenLevel(nextLevel).setLocked(1);
		}
		File file = new File("src/stateInput.txt");
		FileWriter fStream = new FileWriter(file,false);
		for(int i=0; i<m.getAllLevels().getNumLevels(); i++)
		{
			fStream.write(m.getAllLevels().getGivenLevel(i+1).getLockState()+" ");
		}
		fStream.close();
		this.setLevelStarScore(clv);
		return;
	}
	
	private void setLevelStarScore(CompleteLevelView clv)
	{
		clv.getLevelLabel().setText("YOU WIN!!!");
		if(m.getBoard().getCurrScore() > m.getBoard().getStarScore().get(2))
		{
			clv.getStarLabel().setText("3 star");
		}
		else if(m.getBoard().getCurrScore() > m.getBoard().getStarScore().get(1))
		{
			clv.getStarLabel().setText("2 star");
		}
		else
		{
			clv.getStarLabel().setText("1 star");
		}
		clv.getScoreLabel().setText("Score: "+m.getBoard().getCurrScore());
	}
	
	private void recordScore() throws IOException
	{
		ArrayList<Integer> highScore = new ArrayList<Integer>();
		ArrayList<Integer> starCount = new ArrayList<Integer>();
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
		int currScore = m.getBoard().getCurrScore();
		int currStar;
		
		//Set the new high score.
		if(currScore > highScore.get(m.getBoard().getCurrLevel()-1))
		{
			System.out.println("##############################");
			System.out.println(currScore);
			highScore.set(m.getBoard().getCurrLevel()-1, currScore);
			if(currScore > m.getBoard().getStarScore().get(2))
			{
				currStar = 3;
			}
			else if(currScore > m.getBoard().getStarScore().get(1))
			{
				currStar = 2;
			}
			else
			{
				currStar = 1;
			}
			starCount.set(m.getBoard().getCurrLevel()-1, currStar);			
			File file = new File("src/highScore.txt");
			FileWriter fStream = new FileWriter(file,false);
			for(int i=0; i<m.getAllLevels().getNumLevels(); i++)
			{
				System.out.println(highScore.get(i));
				fStream.write(highScore.get(i)+" ");
			}
			fStream.write("\n");
			for(int i=0; i<m.getAllLevels().getNumLevels(); i++)
			{
				fStream.write(starCount.get(i)+" ");
			}
			fStream.close();
		}
	}
}
