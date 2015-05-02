package test.levelBuilder.view;

import java.util.ArrayList;

import junit.framework.TestCase;
import levelBuilder.entity.Model;
import levelBuilder.entity.Position;
import levelBuilder.game.LevelBuilder;
import levelBuilder.view.LBPanel;
import levelBuilder.view.PreviewPlayPanel;
import levelBuilder.view.PreviewScreen;
import levelBuilder.view.RequestScreen;

public class testPanel extends TestCase {
	LevelBuilder lb;
	LBPanel panel;
	Model m;
	
	
	public void setUp(){
		m = new Model();
		panel = new LBPanel(m);
		lb = new LevelBuilder(m, panel);
		RequestScreen rs = new RequestScreen(m);
		
	}
	
	public void testPreivew(){
		m.getNumFrequency().setFre1(0.1);
		m.getNumFrequency().setFre2(0.2);
		m.getNumFrequency().setFre3(0.3);
		m.getNumFrequency().setFre4(0.1);
		m.getNumFrequency().setFre5(0.2);
		m.getNumFrequency().setFre5(0.1);
		ArrayList<Position>  disableList = new ArrayList<Position>();
		ArrayList<Position> bucketList = new ArrayList<Position>();
		ArrayList<Position> sixList = new ArrayList<Position>();
		Position spos = new Position(0,1);
		Position bpos = new Position(1,1);
		Position pos = new Position(0,0);
		disableList.add(pos);
		bucketList.add(bpos);
		sixList.add(spos);
		m.setSixList(sixList);
		m.setDisableList(disableList);
		m.setBucketList(bucketList);
		PreviewScreen preScreen = new PreviewScreen(m);
		PreviewPlayPanel prePanel = new PreviewPlayPanel(m);
		
	}
	
}
