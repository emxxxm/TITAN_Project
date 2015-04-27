package sixesWild.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import sixesWild.controller.moves.NormalMove;
import sixesWild.controller.moves.UpdateTileMove;
import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.Square;
import sixesWild.view.BoardView;

public class PlayPanelController implements MouseListener, MouseMotionListener
{
	Model model;
	BoardView bv;
	int lastRow;
	int lastCol;
	
	public PlayPanelController(Model model, BoardView bv)
	{
		this.model=model;
		this.bv=bv;
	}
	
	public void register()
	{
		bv.getPlayPanel().setActiveListener(this);
		bv.getPlayPanel().setActiveMotionListener(this);
	}
	
	int getCol(int coorX)
	{
		//(57, 7)  (0, 0)
		float col=(float)((coorX-7)/47);
		return (int) Math.floor(col)-1;
	}
	
	int getRow(int coorY)
	{
		float row=(float)(coorY-57)/47;
		return (int) Math.floor(row)+1;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		//System.out.println("x is "+e.getX()+"y is "+e.getY());
		int newCol = this.getCol(e.getX());
		int newRow = this.getRow(e.getY());
		if(newCol!=lastCol || newRow!=lastRow)
		{
			NormalMove nm=new NormalMove(model, newRow, newCol, lastRow, lastCol);
			//If doMove is valid, update lastRow and lastCol, if it's not valid, clear the already selected squares.
			if(nm.doMove())
			{
				lastCol=newCol;
				lastRow=newRow;
				//System.out.println("Here");
			}
			else
			{
				model.getBoard().getSelectedSquares().clear();
			}

			bv.getPlayPanel().repaint();
		}		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//Set lastRow and lastCol.
		lastCol = this.getCol(e.getX());
		lastRow = this.getRow(e.getY());
		//Add the first square to selectedSquares.
		Square firstSquare = model.getBoard().getSquare(lastRow, lastCol);
		if(firstSquare.getType()==1)
		{
			model.getBoard().addSelectedSquare(model.getBoard().getSquare(lastRow, lastCol));
			bv.getPlayPanel().repaint();
		}
		System.out.println("last Col is "+lastCol);
		System.out.println("last Row is "+lastRow);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//Initialize a move to check whether the sum is 6.
		//Then, drop new squares.
		//At this point, empty the selected square array and check the result.
		//Need to update score, move left.
		UpdateTileMove utm =new UpdateTileMove(model);
		if(!utm.doMove())
		{
			model.getBoard().getSelectedSquares().clear();
		}
		model.getBoard().getSelectedSquares().clear();
		bv.getPlayPanel().repaint();
		System.out.println(model.getBoard().getCurrScore());
		bv.getScoreLabel().setText("Score: "+model.getBoard().getCurrScore());
		bv.getProgressBar().setValue(model.getBoard().getCurrScore());
		if(model.getBoard() instanceof PuzzleBoard)
		{
			bv.getMoveLeftLabel().setText("Move Left: "+((PuzzleBoard)(model.getBoard())).getMoveLeft());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Here!");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("OUT!");
		
	}
	
}
