package test.SixesWild.contorller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import junit.framework.TestCase;
import sixesWild.controller.DisplayHelpController;
import sixesWild.controller.DisplayRecordController;
import sixesWild.controller.QuitHelpController;
import sixesWild.controller.QuitLevelController;
import sixesWild.controller.QuitRecordController;
import sixesWild.controller.ResetController;
import sixesWild.controller.ReturnMenuController;
import sixesWild.controller.StartLevelController;
import sixesWild.controller.SwapController;
import sixesWild.model.AllLevel;
import sixesWild.model.Board;
import sixesWild.model.LightningBoard;
import sixesWild.model.Model;
import sixesWild.model.MyTimer;
import sixesWild.model.PuzzleBoard;
import sixesWild.view.BoardView;
import sixesWild.view.CompleteLevelView;
import sixesWild.view.HelpView;
import sixesWild.view.RecordView;
import sixesWild.view.SelectLevelView;

public class TestController extends TestCase {
	Board startingBoard;
	Model m;
	SelectLevelView slv;
	public TestController() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void setUp() throws Exception {
		AllLevel al = new AllLevel("src/", "src/stateInput.txt");
		//Initialize the board with the first level.
		startingBoard = new PuzzleBoard(al.getGivenLevel(1));
		LightningBoard lb = new LightningBoard(al.getGivenLevel(2));
		m = new Model(al, startingBoard);
		slv=new SelectLevelView(m);
	}
	
	protected void tearDown() {
		slv.setVisible(false);
		slv.dispose();
	}
	public void testQuitHelpController()
	{
		HelpView hv = new HelpView();
		JButton quitButton = hv.getQuitButton();
		String s = "";
		ActionEvent e = new ActionEvent(quitButton, MouseEvent.MOUSE_CLICKED, s);
		QuitHelpController qhc = new QuitHelpController(slv, hv);
		qhc.actionPerformed(e);
	}
	public void testReturnMenuController()
	{
		CompleteLevelView clv = new CompleteLevelView(m);
		ReturnMenuController rmc = new ReturnMenuController(slv, clv);
		String s = "";
		JButton quitButton = clv.getQuitButton();
		ActionEvent e = new ActionEvent(quitButton, MouseEvent.MOUSE_CLICKED, s);
		rmc.actionPerformed(e);
	}
	public void testDiaplayHelpController(){
		JButton helpButton = slv.getHelpButton();
		String s = "";
		ActionEvent e = new ActionEvent(helpButton, MouseEvent.MOUSE_CLICKED, s);
		DisplayHelpController dhc = new DisplayHelpController(slv);
		dhc.actionPerformed(e);
	}
	public void testQuitRecordController(){
		RecordView rv = new RecordView(m);
		QuitRecordController qrc = new QuitRecordController(slv, rv);
		JButton quitButton = rv.getQuitButton();
		String s = "";
		ActionEvent e = new ActionEvent(quitButton, MouseEvent.MOUSE_CLICKED, s);
		qrc.actionPerformed(e);
	}
	public void testDisplayRecordController(){
		DisplayRecordController drc = new DisplayRecordController(slv, m);
		JButton recordButton = slv.getRcordButton();
		String s = "";
		RecordView rv = new RecordView(m);
		ActionEvent e = new ActionEvent(recordButton, MouseEvent.MOUSE_CLICKED, s);
		drc.actionPerformed(e);
	}
	public void testQuitLevelController()
	{
		BoardView bv = new BoardView(m);
		MyTimer mt = MyTimer.getInstance();
		JButton quitButton = bv.getQuitButton();
		QuitLevelController qlc = new QuitLevelController(bv, m, mt);
		String s = " ";
		ActionEvent e = new ActionEvent(quitButton, MouseEvent.MOUSE_CLICKED, s);
		qlc.actionPerformed(e);
	}
	public void testQuitLevelControllerLightning() throws Exception
	{
		AllLevel al = new AllLevel("src/", "src/stateInput.txt");
		//Initialize the board with the first level.
		startingBoard = new PuzzleBoard(al.getGivenLevel(1));
		LightningBoard lb = new LightningBoard(al.getGivenLevel(2));
		Model lm = new Model(al, lb);
		BoardView bv = new BoardView(lm);
		MyTimer mt = MyTimer.getInstance();
		JButton quitButton = bv.getQuitButton();
		QuitLevelController qlc = new QuitLevelController(bv, lm, mt);
		String s = " ";
		ActionEvent e = new ActionEvent(quitButton, MouseEvent.MOUSE_CLICKED, s);
		qlc.actionPerformed(e);	
	}
	public void testResetController() throws Exception
	{
		AllLevel al = new AllLevel("src/", "src/stateInput.txt");
		//Initialize the board with the first level.
		PuzzleBoard pb = new PuzzleBoard(al.getGivenLevel(1));
		Model lm = new Model(al, pb);
		BoardView bv = new BoardView(lm);
		ResetController rc = new ResetController(lm, bv);
		rc.process();
	}
	public void testStartLevelController() throws Exception
	{
		AllLevel al = new AllLevel("src/", "src/stateInput.txt");
		//Initialize the board with the first level.
		PuzzleBoard pb = new PuzzleBoard(al.getGivenLevel(1));
		LightningBoard lb = new LightningBoard(al.getGivenLevel(2));
		Model pm = new Model(al, pb);
		Model lm = new Model(al, lb);
		StartLevelController slc = new StartLevelController(slv, pm, 1);
		StartLevelController slcl = new StartLevelController(slv, lm, 2);
		JButton levelButton = slv.getlevelButtons().get(0);
		JButton levelButton1 = slv.getlevelButtons().get(1);
		String s = "";
		ActionEvent e = new ActionEvent(levelButton, MouseEvent.MOUSE_CLICKED, s);
		ActionEvent e1 = new ActionEvent(levelButton1, MouseEvent.MOUSE_CLICKED, s);
		slc.actionPerformed(e);
		slcl.actionPerformed(e1);	
	}
	public void testSwapController() throws Exception
	{
		AllLevel al = new AllLevel("src/", "src/stateInput.txt");
		PuzzleBoard pb = new PuzzleBoard(al.getGivenLevel(1));
		Model pm = new Model(al, pb);
		BoardView bv = new BoardView(pm);
		SwapController sc = new SwapController(pm, bv);
		sc.register();
		MouseEvent e = new MouseEvent(bv, MouseEvent.MOUSE_DRAGGED, 0, 20, 20, 0, 0, false);
	}
}
