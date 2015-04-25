package levelBuilder.entity;

public class Model {
	// Entity
	protected NumFrequency numFrequency;
	protected StarGoals starGoals;
	private CurrentLevel currentLevel;
	protected DisableSquareList disableList;
	protected Multiplier multiplier;
	protected BucketList bucketList;
	protected Limits limits;
	protected Multiplier multi;
	protected PreviewBoard previewBd;
	protected SixList sixList;

	public Model(){
		initialize();
	}
	
	private void initialize(){
		currentLevel = new CurrentLevel();
		bucketList = new BucketList();
		disableList = new DisableSquareList();
		limits = new Limits();
		multi = new Multiplier();
		numFrequency = new NumFrequency();
		previewBd = new PreviewBoard();
		sixList = new SixList();
		starGoals = new StarGoals();
	}
	
	
	
	
	public CurrentLevel getCurrentLevel() {
		return currentLevel;
	}
	public StarGoals getStarGoals() {
		return starGoals;
	}
	public Limits getLimits() {
		return limits;
	}
	public NumFrequency getNumFrequency(){
		return numFrequency;
	}
	public BucketList getBucket(){
		return bucketList;
		
	}

	public SixList getSix() {
		// TODO Auto-generated method stub
		return sixList;
	}
}
