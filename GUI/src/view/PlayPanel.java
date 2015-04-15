package sixesWild.view;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import sixesWild.model.Model;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.TextArea;
import java.util.ArrayList;

public class PlayPanel extends JPanel{
	Model model;
	//Can pass in an array of numbers here!
	public PlayPanel(Model model) 
	{
		this.model=model;
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//Use 0, 1, 2 to represent disable, enable and bucket.
		
		//ArrayList<Square> square ? 
		//ArrayList<Tile>
		ArrayList<Integer> squareType=model.getSquareType();
		ArrayList<Integer> squareNum=model.getSquareNum();
		ArrayList<Integer> squareMulti=model.getSquareMulti();
		//Put the things above in Tile.
		ArrayList<Color> squareColor=model.getSquareColor();
		//i represents row, j represents col.
		for(int row=0;row<9;row++)
		{
			for(int col=0;col<9;col++)
			{
				//If this is a normal square.
				if(squareType.get(row*9+col)==1)
				{
					g.drawRect(57+col*47,7+row*47, 40, 40);
					g.setColor(squareColor.get(row*9+col));
					g.fillRect(57+col*47,7+row*47, 40, 40);
					g.setColor(Color.WHITE);
					g.drawString((squareNum.get(row*9+col)).toString(), (int)(57+col*47+57+col*47+40)/2, (int)(7+row*47+7+row*47+40)/2);
					g.drawString("X"+(squareMulti.get(row*9+col)).toString(), (int)(57+col*47+57+col*47+40)/2+5, (int)(7+row*47+7+row*47+40)/2+18);
				}
				//If this is a bucket or it's a background.
				//How to deal with this when 6 is in the bucket.
				//Can change the type to 1.
				else
				{
					g.drawRect(57+col*47,7+row*47, 40, 40);
					g.setColor(squareColor.get(row*9+col));
					g.fillRect(57+col*47,7+row*47, 40, 40);
				}				
			}
		}
	}
}
