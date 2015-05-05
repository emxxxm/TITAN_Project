package test.sixWild.view;

import java.util.ArrayList;

import sixesWild.model.AllLevel;
import sixesWild.model.Board;
import sixesWild.model.EliminationBoard;
import sixesWild.model.Level;
import sixesWild.model.LightningBoard;
import sixesWild.model.Model;
import sixesWild.model.PuzzleBoard;
import sixesWild.model.ReleaseBoard;
import sixesWild.view.BoardView;
import sixesWild.view.CompleteLevelView;
import sixesWild.view.HelpView;
import sixesWild.view.PlayPanel;
import sixesWild.view.RecordView;
import sixesWild.view.SelectLevelView;
import junit.framework.TestCase;

public class testSixWildView extends TestCase {
	Model m;
	AllLevel allLevel;
	PuzzleBoard pb;
	
	public void setUp() throws Exception{
//		ArrayList<Integer> starGoals = new ArrayList<Integer>();
//		ArrayList<Integer> numFrequency = new ArrayList<Integer>();
//		ArrayList<Integer> multiFrequency = new ArrayList<Integer>();
//		
//		ArrayList<Integer> squareType = new ArrayList<Integer>();
//		ArrayList<Integer> tileNum = new ArrayList<Integer>();
//		ArrayList<Integer> tileMulti = new ArrayList<Integer>();
//		Level l = new Level(1, 0, 0, 0, 0, 0, starGoals,numFrequency, multiFrequency, squareType, tileNum, tileMulti);
		allLevel = new AllLevel("src/", "src/stateInput.txt");
		pb = new PuzzleBoard(allLevel.getGivenLevel(1));
		m = new Model(allLevel, pb);
		
		
	}
	
	public void testView(){
		ReleaseBoard rbd = new ReleaseBoard(allLevel.getGivenLevel(4));
		m = new Model(allLevel, rbd);
		SelectLevelView slv = new SelectLevelView(m);
	
		BoardView bd = new BoardView(m);
		PlayPanel panel = new PlayPanel(m);
		RecordView record = new RecordView(m);
		HelpView help = new HelpView();
		CompleteLevelView clv = new CompleteLevelView(m);
	}
	public void testBoardView(){
		PuzzleBoard pbd = new PuzzleBoard(allLevel.getGivenLevel(1));
		m = new Model(allLevel, pbd);
		BoardView pbdv = new BoardView(m);
		PlayPanel ppanel = new PlayPanel(m);
		PlayPanel panel = new PlayPanel(m);
		RecordView record = new RecordView(m);
		HelpView help = new HelpView();
		CompleteLevelView clv = new CompleteLevelView(m);
		
		LightningBoard lbd = new LightningBoard(allLevel.getGivenLevel(2));
		m = new Model(allLevel, lbd);
		BoardView lbdv = new BoardView(m);
		PlayPanel lpanel = new PlayPanel(m);
		PlayPanel panel1 = new PlayPanel(m);
		RecordView record1 = new RecordView(m);
		HelpView help1 = new HelpView();
		CompleteLevelView clv1 = new CompleteLevelView(m);
		
		EliminationBoard ebd = new EliminationBoard(allLevel.getGivenLevel(3));
		m = new Model(allLevel, lbd);
		BoardView ebdv = new BoardView(m);
		PlayPanel epanel = new PlayPanel(m);
		PlayPanel panel2 = new PlayPanel(m);
		RecordView record2 = new RecordView(m);
		HelpView help2 = new HelpView();
		CompleteLevelView clv2 = new CompleteLevelView(m);
	}
}


