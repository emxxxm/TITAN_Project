package sixesWild.model;

import java.util.ArrayList;
import java.util.Random;

public class ReleaseBoard extends Board
{	
	protected ArrayList<Integer> numFrequency;
	protected ArrayList<Integer> multiFrequency;
	
	public ReleaseBoard(Level l)
	{
		super(l);
		this.numFrequency = l.getNumFrequency();
		this.multiFrequency = l.getMultiFrequency();
	}
	
	public void updateBucket(int col)
	{
		//bucket row.
		int bRow=0;
		int i;
		for(i=0;i<9;i++)
		{
			if(this.getSquare(i, col).getType()==2)
			{
				bRow = i;
				break;
			}
		}
		//If bucket not found, return.
		if(i==9)
		{
			return;
		}
		System.out.println(i);
		//Check whether the first avaluable square above the bucket is 6, if not, return.
		//First, find the location of the first valid square.
		for(i=bRow; i>=0; i--)
		{
			if(this.getSquare(i, col).getType() == 1)
			{
				break;
			}
		}
		System.out.println("IN HERE!!!    "+i);
		//If there is no valid square above, return.
		if(i==-1)
		{
			return;
		}
		else
		{
			//If the number of the first valid square is not 6, return.
			System.out.println(this.getSquare(i, col).getTile().getNum());
			
			if(this.getSquare(i, col).getTile().getNum()!=6)
			{
				
				System.out.println("NOT 6");
				return;
			}
			//If it is 6, do a normal move.
			else
			{
				//Search all the squares in the same column with the current selected square.
				for(int j = i+1; j>=0; j--)
				{
					//Can the bucket contain numbers other than 6?
					if(j==0)
					{
						System.out.println("In j == 0");
						this.getSquare(j,col).getTile().setNum(this.getNewNum());
						this.getSquare(j,col).getTile().setMulti(this.getNewMulti());
					}
					else
					{
						int k;
						//Find the next valid square.
						System.out.println("j is "+j);
						for(k=j-1; k>=0; k--)
						{
							System.out.println(k);
							if(this.getSquare(k, col).getType()==1)
							{
								System.out.println(this.getSquare(k,col).getTile().getNum());	
								this.getSquare(j,col).getTile().setNum(this.getSquare(k,col).getTile().getNum());
								this.getSquare(j,col).getTile().setMulti(this.getSquare(k,col).getTile().getMulti());
								System.out.println("k is "+k);
								System.out.println(k++);
								j = k;
								break;							
							}
						}
						//If all the squares on top of the selected squares are not valid, drop a number in the selected square.
						if(k==-1)
						{
							this.getSquare(j,col).getTile().setNum(this.getNewNum());
							this.getSquare(j,col).getTile().setMulti(this.getNewMulti());
							break;
						}
					}					
				}
				return;
			}
		}
		
		
	}
	
	public int getBucketRow(int col)
	{
		for(int i=0; i<9; i++)
		{
			if(this.getSquare(i, col).getType()==2)
			{
				return i;
			}
		}
		//If the given col doesn't contain a bucket.
		return -1;
	}
	
	/**
	 * Check whether all buckets are filled. Return true if it is.
	 * @author Yihong Zhou, Mengwen Li
	 * @returns
	 */
	public boolean allBucketFilled()
	{
		int i=0;
		for(i=0; i<81; i++)
		{
			if(this.getSquare(i/9, i%9).getType() == 2)
			{
				if(this.getSquare(i/9, i%9).getTile().getNum()!=6)
				{
					break;
				}
			}
		}
		if(i==81)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Get the falling number according to the numFrequency.
	 * @author Mengwen Li, Yihong Zhou
	 * @param numFrequency
	 * @return
	 */
	public int getNewNum()
	{
		Random random = new Random();
		int num = random.nextInt(100)+1;
		int numSet=0;
		if(num<=numFrequency.get(0))
		{
			numSet=1;
		}
		else if(num <= numFrequency.get(0)+numFrequency.get(1))
		{
			numSet=2;
		}
		else if(num <= numFrequency.get(0)+numFrequency.get(1)+numFrequency.get(2))
		{
			numSet=3;
		}
		else if(num <= numFrequency.get(0)+numFrequency.get(1)+numFrequency.get(2)+numFrequency.get(3))
		{
			numSet=4;
		}
		else if(num <= numFrequency.get(0)+numFrequency.get(1)+numFrequency.get(2)+numFrequency.get(3)+numFrequency.get(4))
		{
			numSet=5;
		}
		else
		{
			numSet=6;
		}
		return numSet;
	}
	
	/**
	 * Get the falling multi according to the multiFrequency.
	 * @author Mengwen Li, Yihong Zhou
	 * @param numFrequency
	 * @return
	 */
	public int getNewMulti()
	{
		Random random = new Random();
		int multi = random.nextInt(100)+1;
		int multiSet=0;
		if(multi<=multiFrequency.get(0))
		{
			multiSet=1;
		}
		else if(multi <= multiFrequency.get(0)+multiFrequency.get(1))
		{
			multiSet=2;
		}
		else if(multi <= multiFrequency.get(0)+multiFrequency.get(1)+multiFrequency.get(2))
		{
			multiSet=3;
		}
		return multiSet;
	}
			
}
