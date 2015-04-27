package sixesWild.view;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import sixesWild.controller.moves.NormalMove;
import sixesWild.model.Model;
import sixesWild.model.Square;
import sixesWild.model.Tile;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;

public class PlayPanel extends JPanel
{
	//Model should include an ArrayList of levels.
	/*
	 * Model model;
	 * int currentLevel;
	 * 
	 */
	protected Model model;
	protected ArrayList<Color> c=new ArrayList<Color>(9);
	
	MouseListener activeListener;
	MouseMotionListener activeMotionListener;
	
	//Can pass in an array of numbers here!
	public PlayPanel(Model model) 
	{
		this.model=model;
		this.setSquareColor();
	}
	
	public void setActiveListener(MouseListener ml)
	{
		this.removeMouseListener(activeListener);;
		activeListener = ml;
		if(ml!=null)
		{
			this.addMouseListener(ml);
		}
		return;
	}
	
	public void setActiveMotionListener(MouseMotionListener mml)
	{
		this.removeMouseMotionListener(activeMotionListener);
		activeMotionListener = mml;
		if(mml != null)
		{
			this.addMouseMotionListener(mml);
		}
		return;
	}
	
	public void setSquareColor()
	{
		//Put the things above in Tile.
		Random rand=new Random();
		for(int i=0;i<9;i++)
		{
			float r=rand.nextFloat();
			float g=rand.nextFloat();
			float b=rand.nextFloat();
			
			c.add(new Color(r,g,b));
		}
		return;
	}
	
	@Override
	protected void paintComponent(Graphics graph)
	{
		super.paintComponent(graph);
		//Use 0, 1, 2 to represent disable, enable and bucket.
		
		//ArrayList<Square> square ? 
		//ArrayList<Tile>
		//ArrayList<Tile> tiles=model.getTile();
		ArrayList<Integer> squareType=model.getBoard().getSquareType();
		ArrayList<Integer> squareNum=model.getBoard().getTileNum();
		ArrayList<Integer> squareMulti=model.getBoard().getTileMulti();
		ArrayList<Square> selectedSquare=model.getBoard().getSelectedSquares();
		//i represents row, j represents col.
		for(int row=0;row<9;row++)
		{
			for(int col=0;col<9;col++)
			{
				//If this is a normal square.
				if(squareType.get(row*9+col)==1)
				{
					graph.drawRect(57+col*47,7+row*47, 40, 40);
					graph.setColor(c.get(squareNum.get(row*9+col)-1));
					graph.fillRect(57+col*47,7+row*47, 40, 40);
					graph.setColor(Color.BLACK);
					graph.drawString((squareNum.get(row*9+col)).toString(), (int)(57+col*47+57+col*47+40)/2, (int)(7+row*47+7+row*47+40)/2);
					graph.drawString("X"+(squareMulti.get(row*9+col)).toString(), (int)(57+col*47+57+col*47+40)/2+5, (int)(7+row*47+7+row*47+40)/2+18);
				}
				//If this is a bucket or it's a background.
				//How to deal with this when 6 is in the bucket.
				//Check whether the tile in the target bucket square has number 6. If it has, draw the number, it it doesn't, don't draw. 
				else if(squareType.get(row*9+col)==2)
				{
					graph.drawRect(57+col*47,7+row*47, 40, 40);
					graph.setColor(c.get(6));
					graph.fillRect(57+col*47,7+row*47, 40, 40);
				}
				else
				{
					graph.drawRect(57+col*47,7+row*47, 40, 40);
					graph.setColor(c.get(7));
					graph.fillRect(57+col*47,7+row*47, 40, 40);
				}
			}
			if(selectedSquare.size()!=0)
			{
				//System.out.println("Here");
				for(int i=0;i<selectedSquare.size();i++)
				{
					//Row and col here are being reversed, fix this latter.
					int tRow = selectedSquare.get(i).getRow();
					int tCol = selectedSquare.get(i).getCol();
					//System.out.print("tRow is "+tRow+" tCol is "+tCol);
					//System.out.println();
					graph.setColor(c.get(8));
					graph.fillRect(57+tCol*47, 7+tRow*47, 40, 40);
					graph.setColor(Color.BLACK);
					graph.drawString((squareNum.get(tRow*9+tCol)).toString(), (int)(57+tCol*47+57+tCol*47+40)/2, (int)(7+tRow*47+7+tRow*47+40)/2);
					graph.drawString("X"+(squareMulti.get(tRow*9+tCol)).toString(), (int)(57+tCol*47+57+tCol*47+40)/2+5, (int)(7+tRow*47+7+tRow*47+40)/2+18);
				}
			}
		}
	}
}
