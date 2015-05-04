package test.SixesWild.contorller;

import java.awt.event.MouseEvent;

import javax.swing.JButton;

import sixesWild.model.AllLevel;
import sixesWild.model.Board;
import sixesWild.model.Model;
import sixesWild.view.HelpView;
import sixesWild.view.RecordView;
import sixesWild.view.SelectLevelView;
import sixesWildPlayer.LaunchSixesWild;

public class TestController extends SWTestCase {
	final String inputLevels = "src/";
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
	public void testDisplayHelpController(){
//		MouseEvent me = createClicked(slv.getHelpButton());	
//		MouseEvent me2 = createClicked(slv.getHelpButton(),slv, 755, 505);	
	}
	public void testQuitHelpController(){
//		HelpView hv = new HelpView();
//		MouseEvent me = createClicked(hv.getQuitButton());
	}
	public void testDiaplayRecordController(){
//		MouseEvent me = createClicked(slv.getHelpButton());
		System.out.println("button:"+slv.getHelpButton());
		System.out.println("I am here!!hahahahah");
		MouseEvent me2 = createClicked(slv.getHelpButton(),slv,getButtonX(slv.getHelpButton())+5 ,getButtonY(slv.getHelpButton())+5 );
				
	}
	public void testQuitRecordController(){
//		RecordView rv = new RecordView(m);
//		MouseEvent me = createClicked(slv.getHelpButton());
			
	}
	public void testButton1Controller(){
//		RecordView rv = new RecordView(m);
//		MouseEvent me = createClicked(slv.getHelpButton());
		System.out.println("I am here!!");
		MouseEvent me2 = createClicked(slv.getRcordButton(),slv,getButtonX(slv.getRcordButton())+5 ,getButtonY(slv.getRcordButton())+5 );
	}


}
