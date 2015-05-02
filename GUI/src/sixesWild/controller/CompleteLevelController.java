package sixesWild.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.WindowConstants;

import sixesWild.model.EliminationBoard;
import sixesWild.model.LightningBoard;
import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.view.BoardView;
import sixesWild.view.CompleteLevelView;
import sixesWild.view.SelectLevelView;

public class CompleteLevelController 
{
	Model m;
	BoardView bv;
	
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
				}
			}
		}
		else if(m.getBoard() instanceof LightningBoard)
		{
			LightningBoard lb = (LightningBoard)(m.getBoard());
			System.out.println(lb.getTimeLeft());
			if(lb.getTimeLeft()==0)
			{
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
				}
			}
		}
		else if(m.getBoard() instanceof EliminationBoard)
		{
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
}
