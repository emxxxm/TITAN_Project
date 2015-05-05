package test.levelBuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import junit.framework.TestCase;
import levelBuilder.controller.LoadLevelController;
import levelBuilder.entity.Model;
import levelBuilder.game.LevelBuilder;
import levelBuilder.view.LBPanel;
import levelBuilder.view.RequestScreen;

public class TestLoadLevelController extends TestCase {

	public void testLoadLevel(){
		Model m = new Model();
		LBPanel lbpanel = new LBPanel(m);
		LevelBuilder lb = new LevelBuilder(m,lbpanel);
		RequestScreen rs = new RequestScreen(m);
		
		
		JButton jbtn1 = rs.getLevel();
		JButton jbtn2 = rs.getLeve2();
		JButton jbtn3 = rs.getLeve3();
		JButton jbtn4 = rs.getLeve4();
		
		ActionEvent ae1 = new ActionEvent(jbtn1, MouseEvent.MOUSE_CLICKED, "LOAD LEVEL1");
		ActionEvent ae2 = new ActionEvent(jbtn2, MouseEvent.MOUSE_CLICKED, "LOAD LEVEL2");
		ActionEvent ae3 = new ActionEvent(jbtn3, MouseEvent.MOUSE_CLICKED, "LOAD LEVEL3");
		ActionEvent ae4 = new ActionEvent(jbtn4, MouseEvent.MOUSE_CLICKED, "LOAD LEVEL4");
		ActionEvent ae5 = new ActionEvent(jbtn4, MouseEvent.MOUSE_CLICKED, "no file read");

		LoadLevelController controller1 = new LoadLevelController(m,lb,"src/level1",rs);
		LoadLevelController controller2 = new LoadLevelController(m,lb,"src/level2",rs);
		LoadLevelController controller3 = new LoadLevelController(m,lb,"src/level3",rs);
		LoadLevelController controller4 = new LoadLevelController(m,lb,"src/level4",rs);
		LoadLevelController controller5 = new LoadLevelController(m,lb,"src/level49",rs);

		controller1.actionPerformed(ae1);
		controller2.actionPerformed(ae2);
		controller3.actionPerformed(ae3);
		controller4.actionPerformed(ae4);
		controller5.actionPerformed(ae5);
	}
}
