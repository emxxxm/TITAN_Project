package levelBuilder.game;

import java.util.Enumeration;

import levelBuilder.entity.*;
import levelBuilder.view.*;

public class LevelBuilder {
	
	private Model model;
	// View
	//protected SplashScrn splashScrn;
	//protected RequestScreen requestScrn;
	private LBPanel lbPanel;
	//protected PreviewScreen previewScrn;
	//protected QuitScreen quitScrn;
	
	//TODO 
	//protected Application app;

	protected java.util.Stack<Move> moves = new java.util.Stack<Move>();
	
	protected java.util.Stack<Move> redo_moves = new java.util.Stack<Move>();
	
	// constructor
	public LevelBuilder(Model m, LBPanel lb){
		this.model = m;
		this.setLbPanel(lb);
		initialize();
	}
	
	//TODO
	//protected boolean addModelElement()
	
	public boolean hasComplete(){
		//TODO
		return false;
	}
	
	public void initialize(){
		//TODO
		//initializeEntity();
		initializeView();
		initializeController();
		
	}
	
	private void initializeView() {
		// TODO Auto-generated method stub
		
	}

	private void initializeController() {
		// TODO Auto-generated method stub
		getLbPanel().initializeControllers(this);
	}

//	private void initializeEntity() {
//		currentLevel = new CurrentLevel();
//		bucketList = new BucketList();
//		disableList = new DisableSquareList();
//		limits = new Limits();
//		multi = new Multiplier();
//		numFrequency = new NumFrequency();
//		previewBd = new PreviewBoard();
//		sixList = new SixList();
//		starGoals = new StarGoals();
//	}

	public String getName(){
		return "Level Builder";
	}
	
	/**
	 * Return all moves made so far within level builder.
	 * <p>
	 * 
	 * @return Enumeration Move objects that make up the history of the game.
	 */
	public Enumeration<Move> getMoves() {
		return moves.elements();
	}
	
	protected Move popMove() {
		// Return null if the stack of moves is empty.
		if (moves.isEmpty())
			return null;

		// pop most recent.
		return moves.pop();
	}
	
	public boolean pushMove(Move m) {
		moves.push(m);
		redo_moves.clear();
		return true;
	}
	
	protected Move popRedoMove(){
		// Return null if the stack of moves is empty.
		if (redo_moves.isEmpty())
			return null;

		// pop most recent.
		return redo_moves.pop();
	}
	
	public boolean pushRedoMove(Move m){
		redo_moves.push(m);
		return true;
	}
	
	/**
	 * undo move only the stacks is not empty
	 * push the move to the redo stack if undo successfully 
	 * @return boolean
	 */
	public boolean undoMove(){
		Move m = popMove();
		// unable to undo
		if (m == null){
			// signal our disapproval.
			java.awt.Toolkit.getDefaultToolkit().beep();
			return false;
		}
		
		if(!m.undo(this)){
			// if we can't undo the move, we push it back onto the stack
			moves.push(m); //pushMove(m);
			return false;
		}
		else { 
			pushRedoMove(m);
		}
		return true;
	}
	
//	/**
//	 * pop out all the elements in the redo stack
//	 */
//	protected void clearRedoStack(){
//		while(!redo_moves.isEmpty()){
//			redo_moves.pop();
//		}
//	}
	
	/**
	 * redo move only if previous one move is undo
	 * @return boolean
	 */
	public boolean redoMove(){
		Move m = popRedoMove();
		
		if(m== null){
			// signal our disapproval.
			java.awt.Toolkit.getDefaultToolkit().beep();
			return false;
		}
		
		if(!m.execute(this)){
			pushRedoMove(m);
			return false;
		}
		else {
			moves.push(m); //pushMove(m);
		}
		return true;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public LBPanel getLbPanel() {
		return lbPanel;
	}

	public void setLbPanel(LBPanel lbPanel) {
		this.lbPanel = lbPanel;
	}

	public String getMode(){
		return getModel().getCurrentLevel().get(getModel().getCurLevel());
	}
}

