package test.levelBuilder.entity;

import java.util.ArrayList;

import junit.framework.TestCase;
import levelBuilder.entity.BonusFrequency;
import levelBuilder.entity.DisableSquareList;
import levelBuilder.entity.Model;
import levelBuilder.entity.NumFrequency;
import levelBuilder.entity.Position;
import levelBuilder.game.LevelBuilder;
import levelBuilder.view.LBPanel;

public class TestLevelBuilderEntity extends TestCase {
	Model m;
	LevelBuilder lb;
	LBPanel panel;
	public void setUp(){
		m = new Model();
		panel = new LBPanel(m);
		lb = new LevelBuilder(m, panel);
	}
	
	public void testFreqConstructor(){
		setUp();
		NumFrequency freq = new NumFrequency(0.2,0.2,0.2,0.2,0.2,0.0);
		
		assertEquals(freq.getFre1(), 0.2);
		assertEquals(freq.getFre2(), 0.2);
		assertEquals(freq.getFre3(), 0.2);
		assertEquals(freq.getFre4(), 0.2);
		assertEquals(freq.getFre5(), 0.2);
		assertEquals(freq.getFre6(), 0.0);
	}
	public void testBonusFreqConstructor(){
		double x2 = 0.2;
		double x3 = 0.3;
		
		BonusFrequency bf = new BonusFrequency(x2,x3);
	}
	public void testHasWon(){
		setUp();
		
		assertFalse(lb.hasComplete());
	}
	
	public void testSquareType(){
		setUp();
		ArrayList<Position>  disableList = new ArrayList<Position>();
		ArrayList<Position> bucketList = new ArrayList<Position>();
		ArrayList<Position> sixList = new ArrayList<Position>();
		Position spos = new Position(0,1);
		Position bpos = new Position(1,1);
		Position pos = new Position(0,0);
		disableList.add(pos);
		bucketList.add(bpos);
		sixList.add(spos);
		m.setSixList(sixList);
		m.setDisableList(disableList);
		m.setBucketList(bucketList);
		String type = m.generateSquareType();
		assertTrue(type.contains("0"));
		assertTrue(type.contains("2"));
		
		m.getSix().clearAll();
		m.getBucket().clearAll();
		m.getDisableSquareList().clearAll();
		
		
		
		
	}
	
}
