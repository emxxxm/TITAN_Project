package levelBuilder.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import levelBuilder.controller.BoardPreviewController;
import levelBuilder.controller.CloseWindowController;
import levelBuilder.controller.LevelSaveController;
import levelBuilder.controller.QuitScreenController;
import levelBuilder.entity.Model;
import levelBuilder.game.LevelBuilder;
import levelBuilder.move.controller.*;
import levelBuilder.view.RequestScreen;

public class LBPanel extends JFrame{
	
	Model model;
	
	JLabel levelBuilder;
	JButton btnSave;
	JButton btnPreview;
	JButton btnUndo;
	JButton btnRedo;
	JButton btnEnable;
	JButton btnDisable;
	JButton btnSetSix;
	JButton btnBucket;
	JButton btnQuit;
	
	private JTextField levelNumber;
	private JTextField mode;
	private JTextField firstStar;
	private JTextField secondStar;
	private JTextField thirdStar;
	private JTextField moveLimit;
	private JTextField swapLimit;
	private JTextField timeLimit;
	private JTextField removeLimit;
	private JTextField textField_10;
	private JTextField rowFrom;
	private JTextField rowTo;
	private JTextField colFrom;
	private JTextField frequency1;
	private JTextField frequency2;
	private JTextField frequency3;
	private JTextField frequency4;
	private JTextField frequency5;
	private JTextField frequency6;
	private JTextField colTo;
	private JTextField x2;
	private JTextField x3;
	private JTextField bucketRow;
	private JTextField bucketCol;
	
	public LBPanel(Model model){
		super();
		this.model = model;
		setTitle("Level Builder");
		setSize(828, 568);
		initialize();
		
		btnPreview.addActionListener(new BoardPreviewController(model));
		btnQuit.addActionListener(new CloseWindowController(this, model));
	}
	
	private void initialize(){
		levelBuilder = new JLabel();
		levelBuilder.setBounds(22, 0, 211, 35);
		levelBuilder.setFont(new Font("Calibri", Font.BOLD, 19));
		levelBuilder.setText("Level Builder");
		
		JLabel lblBuilderlevel = new JLabel("Level Number:");
		lblBuilderlevel.setBounds(22, 50, 93, 22);
		
		levelNumber = new JTextField();
		levelNumber.setBounds(121, 47, 134, 28);
		levelNumber.setColumns(10);	
		levelNumber.setToolTipText("Enter level number here");
		
		JLabel lblMode = new JLabel("Mode :");
		lblMode.setBounds(22, 99, 42, 16);
		
		mode = new JTextField();
		mode.setBounds(121, 93, 134, 28);
		mode.setColumns(10);
		
		JLabel lblSetStars = new JLabel("Set Stars:");
		lblSetStars.setBounds(22, 139, 233, 16);
		lblSetStars.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JLabel lblFirstStar = new JLabel("First Star:");
		lblFirstStar.setBounds(22, 170, 68, 22);
		
		JLabel lblSecondStar = new JLabel("Two Stars:");
		lblSecondStar.setBounds(22, 203, 96, 25);
		
		JLabel lblThirdStar = new JLabel("Three Stars:");
		lblThirdStar.setBounds(22, 243, 96, 25);
		
		firstStar = new JTextField();
		firstStar.setBounds(127, 167, 134, 28);
		firstStar.setColumns(10);
		
		secondStar = new JTextField();
		secondStar.setBounds(127, 201, 134, 28);
		secondStar.setColumns(10);
		
		thirdStar = new JTextField();
		thirdStar.setBounds(127, 241, 134, 28);
		thirdStar.setColumns(10);
		
		JLabel lblSetMoveLimit = new JLabel("Set Move Limit:");
		lblSetMoveLimit.setBounds(23, 336, 96, 16);
		
		JLabel lblNewLabel = new JLabel("Set Remove Limit:");
		lblNewLabel.setBounds(22, 370, 112, 16);
		
		JLabel lblNewLabel_1 = new JLabel("Set Swap Limit: ");
		lblNewLabel_1.setBounds(22, 404, 99, 16);
		
		JLabel lblNewLabel_2 = new JLabel("Set Time Limit: ");
		lblNewLabel_2.setBounds(22, 441, 98, 16);
		
		moveLimit = new JTextField();
		moveLimit.setBounds(140, 330, 134, 28);
		moveLimit.setColumns(10);
		
		swapLimit = new JTextField();
		swapLimit.setBounds(140, 398, 134, 28);
		swapLimit.setColumns(10);
		
		timeLimit = new JTextField();
		timeLimit.setBounds(140, 435, 134, 28);
		timeLimit.setColumns(10);
		
		JLabel lblRow = new JLabel("Row:");
		lblRow.setBounds(314, 45, 30, 16);
		
		JLabel lblColumn = new JLabel("Column:");
		lblColumn.setBounds(314, 93, 53, 16);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(405, 9, 36, 16);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(516, 9, 20, 16);
		
		textField_10 = new JTextField();
		textField_10.setBounds(-1400, -830, 0, 0);
		textField_10.setColumns(10);
		
		rowFrom = new JTextField();
		rowFrom.setBounds(385, 39, 74, 28);
		rowFrom.setColumns(10);
		
		rowTo = new JTextField();
		rowTo.setBounds(490, 39, 74, 28);
		rowTo.setColumns(10);
		
		colFrom = new JTextField();
		colFrom.setBounds(385, 87, 74, 28);
		colFrom.setColumns(10);
		
		btnEnable = new JButton("Enable");
		btnEnable.setBounds(600, 40, 98, 29);
		btnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		removeLimit = new JTextField();
		removeLimit.setBounds(140, 364, 134, 28);
		removeLimit.setColumns(10);
		
		JLabel lblSetFrequencyOf = new JLabel("Set Frequency of Tiles of Each Value:");
		lblSetFrequencyOf.setBounds(329, 137, 264, 16);
		lblSetFrequencyOf.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JLabel label = new JLabel("1 :");
		label.setBounds(349, 171, 16, 16);
		
		JLabel label_1 = new JLabel("2 :");
		label_1.setBounds(349, 211, 16, 16);
		
		JLabel label_2 = new JLabel("3 :");
		label_2.setBounds(349, 251, 16, 16);
		
		frequency1 = new JTextField();
		frequency1.setBounds(377, 165, 63, 28);
		frequency1.setColumns(10);
		
		frequency2 = new JTextField();
		frequency2.setBounds(377, 205, 63, 28);
		frequency2.setColumns(10);
		
		frequency3 = new JTextField();
		frequency3.setBounds(377, 245, 63, 28);
		frequency3.setColumns(10);
		
		JLabel label_3 = new JLabel("4 :");
		label_3.setBounds(481, 171, 16, 16);
		
		JLabel label_4 = new JLabel("5 :");
		label_4.setBounds(481, 211, 16, 16);
		
		JLabel label_5 = new JLabel("6 :");
		label_5.setBounds(481, 251, 16, 16);
		
		frequency4 = new JTextField();
		frequency4.setBounds(503, 165, 63, 28);
		frequency4.setColumns(10);
		
		frequency5 = new JTextField();
		frequency5.setBounds(503, 205, 63, 28);
		frequency5.setColumns(10);
		
		frequency6 = new JTextField();
		frequency6.setBounds(503, 245, 63, 28);
		frequency6.setColumns(10);
		
		colTo = new JTextField();
		colTo.setBounds(490, 87, 74, 28);
		colTo.setColumns(10);
		
		btnDisable = new JButton("Disable\r\n");
		btnDisable.setBounds(600, 88, 98, 29);
		
		JLabel lblSetFrequencyOf_1 = new JLabel("Set Frequency of Bonus Tiles:");
		lblSetFrequencyOf_1.setBounds(329, 302, 239, 16);
		lblSetFrequencyOf_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JLabel lblX = new JLabel("x2:");
		lblX.setBounds(345, 331, 25, 28);
		
		JLabel lblX_1 = new JLabel("x3:");
		lblX_1.setBounds(475, 331, 24, 28);
		
		x2 = new JTextField();
		x2.setBounds(376, 331, 63, 28);
		x2.setColumns(10);
		
		x3 = new JTextField();
		x3.setBounds(505, 331, 63, 28);
		x3.setColumns(10);
		
		JLabel lblRow_1 = new JLabel("Row:");
		lblRow_1.setBounds(334, 406, 30, 16);
		
		JLabel lblSetPositionOf = new JLabel("Set Position of \"6 Tile\" and Bucket:");
		lblSetPositionOf.setBounds(329, 372, 239, 16);
		lblSetPositionOf.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		bucketRow = new JTextField();
		bucketRow.setBounds(375, 400, 63, 28);
		bucketRow.setColumns(10);
		
		JLabel lblColumn_1 = new JLabel("Column: ");
		lblColumn_1.setBounds(314, 447, 57, 16);
		
		bucketCol = new JTextField();
		bucketCol.setBounds(377, 441, 63, 28);
		bucketCol.setColumns(10);
		
		btnSetSix = new JButton("Set Six");
		btnSetSix.setBounds(479, 400, 90, 30);
		
		btnBucket = new JButton("Bucket!");
		btnBucket.setBounds(479, 442, 90, 30);
		getContentPane().setLayout(null);
		getContentPane().add(lblFirstStar);
		getContentPane().add(lblSetStars);
		getContentPane().add(lblSetFrequencyOf);
		getContentPane().add(lblMode);
		getContentPane().add(lblBuilderlevel);
		getContentPane().add(levelNumber);
		getContentPane().add(mode);
		getContentPane().add(lblColumn);
		getContentPane().add(lblRow);
		getContentPane().add(rowFrom);
		getContentPane().add(rowTo);
		getContentPane().add(colFrom);
		getContentPane().add(colTo);
		getContentPane().add(btnEnable);
		getContentPane().add(btnDisable);
		getContentPane().add(label_2);
		getContentPane().add(frequency3);
		getContentPane().add(label_5);
		getContentPane().add(frequency6);
		getContentPane().add(label_1);
		getContentPane().add(frequency2);
		getContentPane().add(label_4);
		getContentPane().add(frequency5);
		getContentPane().add(label);
		getContentPane().add(frequency1);
		getContentPane().add(label_3);
		getContentPane().add(frequency4);
		getContentPane().add(firstStar);
		getContentPane().add(secondStar);
		getContentPane().add(thirdStar);
		getContentPane().add(levelBuilder);
		getContentPane().add(lblFrom);
		getContentPane().add(lblTo);
		getContentPane().add(textField_10);
		getContentPane().add(lblNewLabel);
		getContentPane().add(removeLimit);
		getContentPane().add(lblSetPositionOf);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(timeLimit);
		getContentPane().add(lblColumn_1);
		getContentPane().add(bucketCol);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(moveLimit);
		getContentPane().add(lblSetFrequencyOf_1);
		getContentPane().add(lblX);
		getContentPane().add(x2);
		getContentPane().add(lblX_1);
		getContentPane().add(x3);
		getContentPane().add(swapLimit);
		getContentPane().add(lblRow_1);
		getContentPane().add(bucketRow);
		getContentPane().add(lblSecondStar);
		getContentPane().add(lblThirdStar);
		getContentPane().add(lblSetMoveLimit);
		getContentPane().add(btnSetSix);
		getContentPane().add(btnBucket);
		
		btnUndo = new JButton("Undo");
		btnUndo.setBounds(600, 263, 98, 29);
		getContentPane().add(btnUndo);
		
		btnRedo = new JButton("Redo");
		btnRedo.setBounds(600, 307, 98, 29);
		getContentPane().add(btnRedo);
		
		btnPreview = new JButton("Preview");
		btnPreview.setBounds(600, 348, 98, 29);
		getContentPane().add(btnPreview);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(600, 398, 98, 29);
		getContentPane().add(btnSave);
		
		JLabel lblSetLimits = new JLabel("Set Limits:");
		lblSetLimits.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblSetLimits.setBounds(23, 295, 74, 30);
		getContentPane().add(lblSetLimits);
		
		btnQuit  = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuit.setBounds(600, 440, 98, 29);
		getContentPane().add(btnQuit);
		
		//initializeControllers();
	}
	
	public void initializeControllers(LevelBuilder lb){
		// initialize the enter level text field
		//TODO
		levelNumber.addActionListener(new EnterLevelController(lb));
		
		firstStar.addActionListener(new SetStarGoalsController(lb));
		secondStar.addActionListener(new SetStarGoalsController(lb));
		thirdStar.addActionListener(new SetStarGoalsController(lb));
		
		timeLimit.addActionListener(new SetLimitsController(lb));
		moveLimit.addActionListener(new SetLimitsController(lb));
		removeLimit.addActionListener(new SetLimitsController(lb));
		swapLimit.addActionListener(new SetLimitsController(lb));
		
		x2.addActionListener(new SetBonusFreqController(lb));
		x3.addActionListener(new SetBonusFreqController(lb));
		
		btnDisable.addActionListener(new DisableSquareController(lb));
		btnEnable.addActionListener(new EnableSquareController(lb));
		frequency1.addActionListener(new SetFreqController(lb));
		frequency2.addActionListener(new SetFreqController(lb));
		frequency3.addActionListener(new SetFreqController(lb));
		frequency4.addActionListener(new SetFreqController(lb));
		frequency5.addActionListener(new SetFreqController(lb));
		frequency6.addActionListener(new SetFreqController(lb));
		
		btnBucket.addActionListener(new SetBucketController(lb));
		
		btnSetSix.addActionListener(new SetSixController(lb));
		
		btnUndo.addActionListener(new UndoController(lb));
		btnRedo.addActionListener(new RedoController(lb));
	
		btnSave.addActionListener(new LevelSaveController(lb.getModel()));
	}

	public JTextField getLevelNumber() {
		return levelNumber;
	}

	public JTextField getMode() {
		return mode;
	}
	
	public JTextField getFirstStar() {
		return firstStar;
	}
	public JTextField getSecondStar() {
		return secondStar;
	}
	public JTextField getThirdStar() {
		return thirdStar;
	}
	public JTextField getTimeLimit() {
		return timeLimit;
	}
	public JTextField getMoveLimit() {
		return moveLimit;
	}
	public JTextField getRemoveLimit() {
		return removeLimit;
	}
	public JTextField getSwapLimit() {
		return swapLimit;
	}
	public JTextField getRowFrom(){
		return rowFrom;
	}
	public JTextField getRowTo(){
		return rowTo;
	}
	public JTextField getColFrom(){
		return colFrom;
	}
	public JTextField getColTo(){
		return colTo;
	}
	public JTextField getFreq1(){
		return frequency1;
	}
	public JTextField getFreq2(){
		return frequency2;
	}
	public JTextField getFreq3(){
		return frequency3;
	}
	public JTextField getFreq4(){
		return frequency4;
	}
	public JTextField getFreq5(){
		return frequency5;
	}
	public JTextField getFreq6(){
		return frequency6;
	}
	public JTextField getBucketRow(){
		return bucketRow;
	}
	public JTextField getBucketCol(){
		return bucketCol;
	}
	public JButton getBucketButton(){
		return btnBucket;
	}
	public JButton getSixButton(){
		return btnSetSix;
	}
	public JTextField getx2(){
		return x2;
	}
	public JTextField getx3(){
		return x3;
	}
	public JButton getUndo(){
		return btnUndo;
	}
	public JButton getRedo(){
		return btnRedo;
	}
}
