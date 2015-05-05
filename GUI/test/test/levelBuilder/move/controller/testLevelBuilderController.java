package test.levelBuilder.move.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import junit.framework.TestCase;
import levelBuilder.entity.CurrentLevel;
import levelBuilder.entity.Model;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.controller.DisableSquareController;
import levelBuilder.move.controller.EnableSquareController;
import levelBuilder.move.controller.EnterLevelController;
import levelBuilder.move.controller.SetBonusFreqController;
import levelBuilder.move.controller.SetBucketController;
import levelBuilder.move.controller.SetFreqController;
import levelBuilder.move.controller.SetLimitsController;
import levelBuilder.move.controller.SetSixController;
import levelBuilder.move.controller.SetStarGoalsController;
import levelBuilder.view.LBPanel;

public class testLevelBuilderController extends TestCase {
	LevelBuilder lb;
	Model m;
	
	public void setUp(){
		m = new Model();
		LBPanel panel = new LBPanel(m);
		lb = new LevelBuilder(m, panel);
	}
	
	public void testEnterNumber(){
		JTextField lnum = lb.getLbPanel().getLevelNumber();
		lnum.setText("2");
		EnterLevelController el = new EnterLevelController(lb);
		ActionEvent e = new ActionEvent(lnum, KeyEvent.KEY_PRESSED, "Return");
		el.actionPerformed(e);	
		assertEquals(m.getCurLevel(), 2);
	}
	public void testSetStarGoalsController(){
		JTextField star1 = lb.getLbPanel().getFirstStar();
		JTextField star2 = lb.getLbPanel().getSecondStar();
		JTextField star3 = lb.getLbPanel().getThirdStar();
		
		star1.setText("100");
		star2.setText("200");
		star3.setText("300");
		SetStarGoalsController setStar = new SetStarGoalsController(lb);
		ActionEvent e3 = new ActionEvent(star3, KeyEvent.KEY_PRESSED, "setFirstStar");
		setStar.actionPerformed(e3);
		assertEquals(m.getStarGoals().getOne(), 100);
		assertEquals(m.getStarGoals().getTwo(), 200);
		assertEquals(m.getStarGoals().getThree(), 300);
	}
	public void testSetLimitsController(){
		JTextField time = lb.getLbPanel().getTimeLimit();
		JTextField move = lb.getLbPanel().getMoveLimit();
		JTextField remove = lb.getLbPanel().getRemoveLimit();
		JTextField swap = lb.getLbPanel().getSwapLimit();
		
		time.setText("0");
		move.setText("10");
		remove.setText("5");
		swap.setText("2");
		
		SetLimitsController lc = new SetLimitsController(lb);
		ActionEvent e = new ActionEvent(time, KeyEvent.KEY_PRESSED, "SetLimit");
		lc.actionPerformed(e);
		assertEquals(m.getLimits().getMoveLimits(), 10);
		assertEquals(m.getLimits().getTimeLimits(),0);
		assertEquals(m.getLimits().getRemoveLimits(),5);
		assertEquals(m.getLimits().getSwapLimits(), 2);
	}
	public void testSetFrequencyController(){
		JTextField f1 = lb.getLbPanel().getFreq1();
		JTextField f2 = lb.getLbPanel().getFreq2();
		JTextField f3 = lb.getLbPanel().getFreq3();
		JTextField f4 = lb.getLbPanel().getFreq4();
		JTextField f5 = lb.getLbPanel().getFreq5();
		JTextField f6 = lb.getLbPanel().getFreq6();
		
		f1.setText("0.2");
		f2.setText("0.2");
		f3.setText("0.2");
		f4.setText("0.2");
		f5.setText("0.2");
		f6.setText("0.0");
		
		SetFreqController fc = new SetFreqController(lb);
		ActionEvent e = new ActionEvent(f6, KeyEvent.KEY_PRESSED, "SetFreq");
		fc.actionPerformed(e);	
	}
	public void testDisableSquareController(){
		JTextField rowFrom = lb.getLbPanel().getRowFrom();
		JTextField rowTo = lb.getLbPanel().getRowTo();
		JTextField colFrom = lb.getLbPanel().getColFrom();
		JTextField colTo = lb.getLbPanel().getColTo();
		rowFrom.setText("1");
		rowTo.setText("1");
		colFrom.setText("1");
		colTo.setText("1");
		
		DisableSquareController dc = new DisableSquareController(lb);
		ActionEvent e = new ActionEvent(lb.getLbPanel().getBtnDisable(), MouseEvent.MOUSE_PRESSED,"disable");
		EnableSquareController ec = new EnableSquareController(lb);
		dc.actionPerformed(e);
		ActionEvent e1 = new ActionEvent(lb.getLbPanel().getBtnEnable(), MouseEvent.MOUSE_PRESSED,"enable");
		ec.actionPerformed(e1);
	}
	public void testBonusFreqController(){
		JTextField x2 = lb.getLbPanel().getx2();
		JTextField x3 = lb.getLbPanel().getx3();
		
		x2.setText("0.2");
		x3.setText("0.3");
		
		SetBonusFreqController bfc = new SetBonusFreqController(lb);
		ActionEvent e = new ActionEvent(x3, KeyEvent.KEY_PRESSED, "bonus");
		
		bfc.actionPerformed(e);
	}
	public void testBucketController(){
		JTextField sixRow = lb.getLbPanel().getBucketRow();
		JTextField sixCol = lb.getLbPanel().getBucketCol();
		
		sixRow.setText("1");
		sixCol.setText("2");
		SetBucketController bc = new SetBucketController(lb);
		ActionEvent e = new ActionEvent(lb.getLbPanel().getBtnBucket(), MouseEvent.MOUSE_PRESSED, "bucket");
		SetSixController sc = new SetSixController(lb);
		ActionEvent e1 = new ActionEvent(lb.getLbPanel().getSixButton(), MouseEvent.MOUSE_PRESSED, "six");
		bc.actionPerformed(e);
		sc.actionPerformed(e1);
		
		m.setCurLevel(4);
		CurrentLevel levelMode = new CurrentLevel();
		levelMode.put(4, "Release");
		m.setCurrentLevel(levelMode);
		bc.actionPerformed(e);
		sc.actionPerformed(e1);
	}
}
