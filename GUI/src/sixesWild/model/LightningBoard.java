package sixesWild.model;

public class LightningBoard extends Board
{
	int timeLimit;
	int timeLeft;
	public LightningBoard(Level level) {
		super(level);
		this.timeLimit = level.getTimeLimit();
		this.timeLeft = level.getTimeLimit();
	}
	
	public int getTimeLimit()
	{
		return this.timeLimit;
	}
	
	public int getTimeLeft()
	{
		return this.timeLeft;
	}
	
	public boolean setTimeLeft(int delta)
	{
		if(delta > 0)
		{
			return false;
		}
		this.timeLeft+=delta;
		return true;
	}
	
	
}
