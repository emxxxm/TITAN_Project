package sixesWild.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import sixesWild.controller.moves.NormalMove;
import sixesWild.controller.moves.SwapMove;
import sixesWild.controller.moves.UpdateTileMove;
import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.Square;
import sixesWild.view.BoardView;

public class SwapController extends MouseAdapter
{
	Model model;
	BoardView bv;
	int lastRow;
	int lastCol;
	
	public SwapController(Model model, BoardView bv)
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
	public void mouseDragged(MouseEvent e) {
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
		lastCol = this.getCol(e.getX());
		lastRow = this.getRow(e.getY());
		//Add the first square to selectedSquares.
		Square firstSquare = model.getBoard().getSquare(lastRow, lastCol);
		if(firstSquare.getType()==1)
		{
			model.getBoard().addSelectedSquare(model.getBoard().getSquare(lastRow, lastCol));
			bv.getPlayPanel().repaint();
		}		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		SwapMove sm =new SwapMove(model);
		if(!sm.doMove())
		{
			model.getBoard().getSelectedSquares().clear();
		}
		model.getBoard().getSelectedSquares().clear();
		bv.getPlayPanel().repaint();
		bv.getSwapButton().setText("Swap: "+model.getBoard().getSwapLeft());
		PlayPanelController ppc = new PlayPanelController(model, bv);
		ppc.register();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
