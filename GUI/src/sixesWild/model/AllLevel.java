package sixesWild.model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AllLevel 
{
	Level[] levels;
	
	public AllLevel(String filePath) throws Exception
	{
		ArrayList<Integer> tileNum = new ArrayList<Integer>();
		File file=new File(filePath);
		BufferedReader reader=null;
		try
		{
			reader=new BufferedReader(new FileReader(file));
			String text=null;
			text=reader.readLine();
			if(text!=null)
			{
				
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
		finally
		{
			try
			{
				if(reader!=null)
				{
					reader.close();
				}
			}
			catch(IOException e)
			{
			}
		}	
	}
}
