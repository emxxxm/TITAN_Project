package sixesWild.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import sixesWild.controller.moves.NormalMove;
import sixesWild.model.Model;
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
			NormalMove nm=new NormalMove(model, newCol, newRow, lastCol, lastRow);
			if(nm.isValid())
			{
				nm.doMove();
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
		lastRow = this.getRow(e.getX());		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
