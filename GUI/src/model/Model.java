package sixesWild.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Model 
{	//initialize
	public ArrayList<Integer> getSquareType()
	{
		ArrayList<Integer> a=new ArrayList<Integer>(81);
		for(int i=0;i<81;i++)
		{
			a.add(i%2);
		}
		return a;
	}
	public ArrayList<Integer> getSquareNum()
	{
		ArrayList<Integer> a=new ArrayList<Integer>(81);
		for(int i=0;i<81;i++)
		{
			a.add(i%5+1);
		}
		return a;
	}
	public ArrayList<Integer> getSquareMulti()
	{
		ArrayList<Integer> a=new ArrayList<Integer>(81);
		for(int i=0;i<81;i++)
		{
			a.add(i%2+1);
		}
		return a;
	}
	public ArrayList<Color> getSquareColor()
	{
		ArrayList<Color> c=new ArrayList<Color>(81);
		Random rand=new Random();
		for(int i=0;i<81;i++)
		{
			float r=rand.nextFloat();
			float g=rand.nextFloat();
			float b=rand.nextFloat();
			
			c.add(new Color(r,g,b));
		}
		return c;
	}
}
