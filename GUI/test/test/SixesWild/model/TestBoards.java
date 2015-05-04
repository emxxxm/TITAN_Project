package test.SixesWild.model;

import java.util.ArrayList;

import sixesWild.model.EliminationBoard;
import sixesWild.model.Level;
import sixesWild.model.LightningBoard;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.ReleaseBoard;
import junit.framework.TestCase;

public class TestBoards extends TestCase {
	ArrayList<Integer> stars;
	ArrayList<Integer> freqs;
	ArrayList<Integer> multi;
	ArrayList<Integer> sqrType;
	ArrayList<Integer> tileNum;
	ArrayList<Integer> tileMulti;
	Level testLevel;

	protected void setUp() {
		stars = new ArrayList<Integer>();
		freqs = new ArrayList<Integer>();
		multi = new ArrayList<Integer>();
		sqrType = new ArrayList<Integer>();
		tileNum = new ArrayList<Integer>();
		tileMulti = new ArrayList<Integer>();

		for (int i = 0; i < 81; i++) {
			sqrType.add(1);
			tileMulti.add(1);
			tileNum.add(1);
		}
		sqrType.set(18, 2);
		tileNum.set(9, 6);
		tileNum.set(72, 6);

		freqs.add(20);
		freqs.add(10);
		freqs.add(20);
		freqs.add(20);
		freqs.add(20);
		freqs.add(10);

		multi.add(100);
		multi.add(0);
		multi.add(0);

		testLevel = new Level(10, 0, 12, 13, 14, 15, stars, freqs, multi,
				sqrType, tileNum, tileMulti);

	}

	public void testEB() {
		EliminationBoard testEB = new EliminationBoard(testLevel);

		assertFalse(testEB.allMarked());
		assertEquals(12, testEB.getMoveLimit());
		assertEquals(12, testEB.getMoveLeft());

		assertFalse(testEB.updateMoveLeft(2)); // invalid update of moveLeft:
												// move left can not be
												// increased

		System.out.println(testEB.getMoveLeft());
		assertEquals(12, testEB.getMoveLeft());
		assertEquals(12, testEB.getMoveLimit());
		assertTrue(testEB.updateMoveLeft(-2));
		assertEquals(10, testEB.getMoveLeft());
		assertEquals(12, testEB.getMoveLimit());
		assertFalse(testEB.updateMoveLeft(-12));// invalid update: move left
												// falls below 0

	}

	public void testLB() {
		LightningBoard testLB = new LightningBoard(testLevel);
		assertEquals(13, testLB.getTimeLeft());
		assertEquals(13, testLB.getTimeLimit());
		assertFalse(testLB.setTimeLeft(20));
		assertTrue(testLB.setTimeLeft(-2));
		assertEquals(11, testLB.getTimeLeft());
		assertEquals(13, testLB.getTimeLimit());

	}

	public void testPB() {
		PuzzleBoard testPB = new PuzzleBoard(testLevel);
		assertEquals(12, testPB.getMoveLimit());
		assertEquals(12, testPB.getMoveLeft());

		assertFalse(testPB.updateMoveLeft(10));
		assertFalse(testPB.updateMoveLeft(-20));
		assertTrue(testPB.updateMoveLeft(-10));
		assertEquals(12, testPB.getMoveLimit());
		assertEquals(2, testPB.getMoveLeft());

	}

	public void testRB() {
		ReleaseBoard testRB = new ReleaseBoard(testLevel);
		System.out.println(testRB.getBucketRow(0));
		assertEquals(2, testRB.getBucketRow(0));
		assertEquals(-1, testRB.getBucketRow(2));
		for (int i = 0; i < 9; i++) {
			testRB.updateBucket(i);
		}
		assertTrue(testRB.allBucketFilled());
	}
}
