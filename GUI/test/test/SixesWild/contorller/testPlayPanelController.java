package test.SixesWild.contorller;

import javax.swing.JButton;

import org.w3c.dom.events.MouseEvent;

import sixesWild.model.AllLevel;
import sixesWild.model.Board;
import sixesWild.model.Model;
import sixesWild.view.BoardView;
import sixesWild.view.SelectLevelView;

public class testPlayPanelController extends PPTestCase {
	final String inputLevels = "src/input.txt";
	final String inputStates = "src/stateInput.txt";
	Board startingBoard;
	Model m;
	SelectLevelView slv;
	public AllLevel initializeLevels() throws Exception
	{
		AllLevel allLevels = new AllLevel(inputLevels, inputStates);
		return allLevels;
	}
	protected void setUp() throws Exception {
		AllLevel al=initializeLevels();
		//Initialize the board with the first level.
		startingBoard = new Board(al.getGivenLevel(1));
		m = new Model(al, startingBoard);
		slv=new SelectLevelView(m);
	}
	public int getButtonX(JButton button){
		System.out.println("X:"+button.getLocation().x);
		return button.getLocation().x;
	}
	public int getButtonY(JButton button){
		System.out.println("Y:"+button.getLocation().y);
		return button.getLocation().y;
	}

	protected void tearDown() {
		slv.setVisible(false);
		slv.dispose();
	}
	
	public void testQuitController(){
		BoardView rv = new BoardView(m);
		MouseEvent me = (MouseEvent) createClicked(rv.getQuitButton());			
	}
	public void testRemoveButton(){
		BoardView rv = new BoardView(m);
		MouseEvent me = (MouseEvent) createClicked(rv.getRemoveButton());			
	}
	public void testSwapButton(){
		BoardView rv = new BoardView(m);
		MouseEvent me = (MouseEvent) createClicked(rv.getSwapButton());			
	}

	public void testPlayPanelClick(){
//		BoardView rv = new BoardView(m);
//		MouseEvent me = (MouseEvent) createClicked(startingBoard,rv.getPlayPanel(),5,5);			
	}
}
