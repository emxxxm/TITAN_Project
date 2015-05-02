package test.levelBuilder.entity;

import junit.framework.TestCase;
import levelBuilder.controller.LevelSaveController;
import levelBuilder.controller.LoadLevelController;
import levelBuilder.entity.Model;
import levelBuilder.game.LevelBuilder;
import levelBuilder.view.LBPanel;
import levelBuilder.view.RequestScreen;

public class TestLoadLevelController extends TestCase {
	Model m;
	
	LevelBuilder lb;
	
	
	public void setUp(){
		m = new Model();
		LBPanel panel = new LBPanel(m);
		lb = new LevelBuilder(m, panel);
	}
	
	public void testLoadLevel(){
		setUp();
		m.setCurLevel(1);
		m.setCurrentLevel(m.getCurrentLevel());
		LevelSaveController save = new LevelSaveController(m);
		LoadLevelController load = new LoadLevelController(m, lb, "level1", new RequestScreen(m));
		
		
	}
}
