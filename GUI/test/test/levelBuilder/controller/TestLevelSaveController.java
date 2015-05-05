package test.levelBuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import junit.framework.TestCase;
import levelBuilder.controller.LevelSaveController;
import levelBuilder.entity.Model;
import levelBuilder.game.LevelBuilder;
import levelBuilder.view.LBPanel;

public class TestLevelSaveController extends TestCase {

	public void testLevelSave(){
		Model m = new Model();
		LBPanel lbpanel = new LBPanel(m);
		LevelBuilder lb = new LevelBuilder(m,lbpanel);
		
		JButton save = lbpanel.getSave();
		
		ActionEvent ae = new ActionEvent(save, MouseEvent.MOUSE_CLICKED, "save");
		LevelSaveController controller = new LevelSaveController(m);
		controller.actionPerformed(ae);
	
	}
}
