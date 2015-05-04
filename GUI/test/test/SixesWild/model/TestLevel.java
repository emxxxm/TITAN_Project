package test.SixesWild.model;

import java.util.ArrayList;

import sixesWild.model.Level;
import junit.framework.TestCase;

public class TestLevel extends TestCase{
	public void testBoard(){
		ArrayList<Integer> stars = null;
		ArrayList<Integer> freqs = null;
		ArrayList<Integer> multi = null;
		ArrayList<Integer> sqrType = null;
		ArrayList<Integer> tileNum = null;
		ArrayList<Integer> tileMulti = null;

		Level testLevel = new Level(10,0,12,13,14,15, stars,freqs,multi,sqrType,tileNum,tileMulti);
		assertEquals(null,testLevel.getNumFrequency());
		assertEquals(null,testLevel.getMultiFrequency());
		assertEquals(null,testLevel.getStarScore());
		assertEquals(10,testLevel.getLevelNum());
		assertEquals(12,testLevel.getMoveLimit());
		assertEquals(13,testLevel.getTimeLimit());
		assertEquals(14,testLevel.getSwapLimit());
		assertEquals(15,testLevel.getRemoveLimit());
		assertEquals(null,testLevel.getTileNum());
		assertEquals(null,testLevel.getTileMulti());
		assertEquals(null,testLevel.getSquareType());
		assertTrue(testLevel.isLocked());
		assertEquals(0,testLevel.getLockState());
		testLevel.setLocked(1);
		assertFalse(testLevel.isLocked());
		assertEquals(1,testLevel.getLockState());		
		
		
	}

}
