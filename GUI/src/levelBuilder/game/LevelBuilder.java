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
		//TODO shizheyangma?
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
		return (Move) moves.pop();
	}
	
	public boolean pushMove(Move m) {
		moves.push(m);
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

	
}

