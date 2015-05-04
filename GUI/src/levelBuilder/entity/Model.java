package levelBuilder.entity;

import java.util.ArrayList;
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

	public void setBucketList(ArrayList<Position> bucket){
		this.bucketList.setList(bucket);
	}
	
	public void setSixList(ArrayList<Position> six){
		this.sixList.setList(six);
	}
	
	public void setDisableList(ArrayList<Position> disable){
		this.disableList.setList(disable);
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
