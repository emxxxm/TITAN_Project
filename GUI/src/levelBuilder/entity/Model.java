package levelBuilder.entity;

import java.util.Random;

public class Model {
	// Entity
	protected int curLevelNum;
	protected NumFrequency numFrequency;
	protected StarGoals starGoals;
	private CurrentLevel currentLevel;
	protected DisableSquareList disableList;
	protected BonusFrequency bonusFreq;
	protected BucketList bucketList;
	protected Limits limits;
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
		bonusFreq = new BonusFrequency();
		numFrequency = new NumFrequency();
		previewBd = new PreviewBoard();
		sixList = new SixList();
		starGoals = new StarGoals();
	}
	
	/**
	 * generate Square type line in level file 
	 * based on disableSqaure List and bucket List
	 * @return
	 */
	public String generateSquareType(){
		String str="";
		
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				Position pos = new Position(i,j);
				if(disableList.inList(pos))
					str += 0 +" ";
				else if(bucketList.inList(pos))
					str += 2 +" ";
				else 
					str += 1 +" ";
			}
		}
		return str;
	}
	
	/**
	 * generate tile number in level file
	 * based on number frequency six list and disableSquare list 
	 * @return
	 */
	public String generateTileNum(){
		String str ="";
		
		int one = (int)(numFrequency.getFre1()*100);
		int two = (int)(numFrequency.getFre2()*100)+one;
		int three = (int)(numFrequency.getFre3()*100)+two;
		int four = (int)(numFrequency.getFre4()*100)+three;
		int five = (int)(numFrequency.getFre5()*100)+four;
		int six = 100 - five;
		
		// check thoes numer
		if(one<0||five>100||six<0)
			System.err.println("Frequency is incorrect. Can't generate file");
		
		Random rand = new Random();
		int randomNum;// = rand.nextInt(100)+1;
		boolean randAgain = false;
		
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				Position pos = new Position(i,j);
				if(disableList.inList(pos))
					str += 0+" ";
				else if(sixList.inList(pos))
					str += 6+" ";
				else{
					do{
						randomNum = rand.nextInt(100)+1;
						if(randomNum<one) {
							str += 1+" ";
							randAgain = false;
						}
						else if(randomNum<two) {
							str += 2+" ";
							randAgain = false;
						}
						else if(randomNum<three){
							str += 3+" ";
							randAgain = false;
						}
						else if(randomNum<four) {
							str += 4+" ";
							randAgain = false;
						}
						else if(randomNum<five) {
							str += 5+" ";
							randAgain = false;
						}
						else {
							randAgain = true;
						}
					}while(randAgain);
					
				}
			}
		}
		
		return str;
	}
	
	/**
	 * generate a line of board info about bonus in the level file
	 * based on the bonus frequency
	 *
	 * @return
	 */
	public String generateTileBonus(){
		String str = "";
		
		int x2 = (int)(bonusFreq.getx2()*100);
		int x3 = (int)(bonusFreq.getx3()*100)+x2;
		
		Random rand = new Random();
		int randomNum;// = rand.nextInt(100)+1;
		boolean randAgain = false;
	
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				Position pos = new Position(i,j);

				randomNum = rand.nextInt(100)+1;
					
				if(randomNum<x2) str += 2+" ";
				else if(randomNum<x3) str += 3+" ";
				else str += 1+" ";
			}
		}
		
		return str;
	}
	
	public String generateSixPosition(){
		String str = "";
		
		
		
		
		return str;
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
	
	public int getCurLevel(){
		return curLevelNum;
	}
	public boolean setCurLevel(int cur){
		this.curLevelNum = cur;
		return true;
	}

	public SixList getSix() {
		return sixList;
	}
	
	public BonusFrequency getBonusFrequency() {
		return bonusFreq;
	}
	
	
	public DisableSquareList getDisableSquareList() {
		return disableList;
	}
	public void setCurrentLevel(CurrentLevel levelMode){
		this.currentLevel = levelMode;
	}
}
