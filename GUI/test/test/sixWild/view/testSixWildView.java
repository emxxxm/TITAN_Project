package test.sixWild.view;

import java.util.ArrayList;

import sixesWild.model.AllLevel;
import sixesWild.model.Board;
import sixesWild.model.Level;
import sixesWild.model.Model;
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
	Board bd;
	
	public void setUp() throws Exception{
//		ArrayList<Integer> starGoals = new ArrayList<Integer>();
//		ArrayList<Integer> numFrequency = new ArrayList<Integer>();
//		ArrayList<Integer> multiFrequency = new ArrayList<Integer>();
//		
//		ArrayList<Integer> squareType = new ArrayList<Integer>();
//		ArrayList<Integer> tileNum = new ArrayList<Integer>();
//		ArrayList<Integer> tileMulti = new ArrayList<Integer>();
//		Level l = new Level(1, 0, 0, 0, 0, 0, starGoals,numFrequency, multiFrequency, squareType, tileNum, tileMulti);
		allLevel = new AllLevel("src/input.txt", "src/stateInput.txt");
		bd = new Board(allLevel.getGivenLevel(1));
		m = new Model(allLevel, bd);
		
		
	}
	
	public void testView(){
		
		SelectLevelView slv = new SelectLevelView(m);
		BoardView bd = new BoardView(m);
		PlayPanel panel = new PlayPanel(m);
		RecordView record = new RecordView(m);
		HelpView help = new HelpView();
		CompleteLevelView clv = new CompleteLevelView(m);
	}
}
