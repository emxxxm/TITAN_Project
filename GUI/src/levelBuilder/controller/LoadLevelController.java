package levelBuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import levelBuilder.entity.CurrentLevel;
import levelBuilder.entity.Model;
import levelBuilder.entity.Position;
import levelBuilder.game.LevelBuilder;
import levelBuilder.view.LBPanel;
import levelBuilder.view.RequestScreen;

public class LoadLevelController implements ActionListener{
	Model model;
	String file;
	LevelBuilder lb;
	
	public LoadLevelController(Model m, LevelBuilder lb, String file){
		this.model = m;
		this.lb = lb;
		this.file = file;
		
	}
	
	public void actionPerformed(ActionEvent arg0){
		
		try{
			System.out.println(file);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			ArrayList<String> buffer = new ArrayList<String>();
			String line = reader.readLine();
			while(line!=null){
				buffer.add(line);
				line = reader.readLine();
			}
			//System.out.println(buffer.get(0));
			
			int numTotalLevels = Integer.parseInt(buffer.get(0));
			int currentLevel = Integer.parseInt(buffer.get(1));
			int mLimit = Integer.parseInt(buffer.get(2));
			int tLimit = Integer.parseInt(buffer.get(3));
			int sLimit = Integer.parseInt(buffer.get(4));
			int rLimit = Integer.parseInt(buffer.get(5));
			
			model.getLimits().setMoveLimits(mLimit);
			model.getLimits().setRemoveLimits(rLimit);
			model.getLimits().setSwapLimits(sLimit);
			model.getLimits().setTimeLimits(tLimit);
			model.setCurLevel(currentLevel);
			
			LBPanel panel = lb.getLbPanel();
			CurrentLevel LevelMode = new CurrentLevel();
			int r = currentLevel % 4;
			String mode;
			
			if(r == 1){
				mode = "Puzzle";
				LevelMode.put(currentLevel, mode);
				panel.getMode().setText(mode);
			}
			else if( r == 2){
				mode = "Lightning";
				LevelMode.put(currentLevel, mode);
			}
			else if(r == 3){
				mode = "Elimination";
				LevelMode.put(currentLevel, mode);
			}
			else if(r == 4){
				mode = "Release";
				LevelMode.put(currentLevel, mode);
			}
			else{
				System.err.println("Mode: Cannot compute mode");
			}
			model.setCurrentLevel(LevelMode);
			
			String curLevel = Integer.toString(currentLevel);
			String moveLimit = Integer.toString(mLimit);
			String timeLimit = Integer.toString(tLimit);
			String swapLimit = Integer.toString(sLimit);
			String removeLimit = Integer.toString(rLimit);
//			String numTotalLevels = buffer.get(0);
//			String currentLevel = buffer.get(1);
//			String moveLimit = buffer.get(2);
//			String timeLimit = buffer.get(3);
//			String swapLimit = buffer.get(4);
//			String removeLimit = buffer.get(5);
			String[] starGoalsArray = buffer.get(6).split(" ");
			String[] numFreqArray = buffer.get(7).split(" ");
			String[] multiFreqArray = buffer.get(8).split(" ");
			String[] squareTypeInput = buffer.get(9).split(" ");
			String[] sixListInput = buffer.get(10).split(" ");
			
			System.out.println(numFreqArray[0]);
			double freq1 = Integer.parseInt(numFreqArray[0]);
			double freq2 = Integer.parseInt(numFreqArray[1]);
			double freq3 = Integer.parseInt(numFreqArray[2]);
			double freq4 = Integer.parseInt(numFreqArray[3]);
			double freq5 = Integer.parseInt(numFreqArray[4]);
			double freq6 = Integer.parseInt(numFreqArray[5]);
			
			freq1 = freq1/100;
			freq2 = freq2/100;
			freq3 = freq3/100;
			freq4 = freq4/100;
			freq5 = freq5/100;
			freq6 = freq6/100;
			model.getNumFrequency().setFre1(freq1);
			model.getNumFrequency().setFre2(freq2);
			model.getNumFrequency().setFre3(freq3);
			model.getNumFrequency().setFre4(freq4);
			model.getNumFrequency().setFre5(freq5);
			model.getNumFrequency().setFre6(freq6);
			
			
			int star1 = Integer.parseInt(starGoalsArray[0]);
			int star2 = Integer.parseInt(starGoalsArray[1]);
			int star3 = Integer.parseInt(starGoalsArray[2]);
			model.getStarGoals().setOne(star1);
			model.getStarGoals().setTwo(star2);
			model.getStarGoals().setThree(star3);
			
			
			double x2Freq = Integer.parseInt(multiFreqArray[1]);
			double x3Freq = Integer.parseInt(multiFreqArray[2]);
			
			x2Freq = x2Freq/100;
			x3Freq = x3Freq/100;
			model.getBonusFrequency().setx2(x2Freq);
			model.getBonusFrequency().setx3(x3Freq);
			
			ArrayList<Position> disableList = new ArrayList<Position>();
			ArrayList<Position> bucketList = new ArrayList<Position>();
			ArrayList<Position> sixList = new ArrayList<Position>();
			for(int i = 0; i < squareTypeInput.length; i++){
				if(squareTypeInput[i] == "0"){
					int row = i / 9 ; // 0-8 or 1-9????????
					int col = i % 9 ;// 0-8 or 1-9????????
					
					Position pos = new Position(row, col);
					disableList.add(pos);
				}
				
				if(squareTypeInput[i] == "2"){
					int row = i / 9;// 0-8 or 1-9????????
					int col = i % 9;// 0-8 or 1-9????????
					
					Position pos = new Position(row, col);
					bucketList.add(pos);
					
				}
			}
			
			for(int i = 0; i < sixListInput.length - 1; i=i+2){
				int row = Integer.parseInt(sixListInput[i]);
				int col = Integer.parseInt(sixListInput[i+1]);
				Position pos = new Position(row,col);
				sixList.add(pos);
				
			}
			
			panel.getLevelNumber().setText(curLevel);
			
			panel.getMoveLimit().setText(moveLimit);
			panel.getTimeLimit().setText(timeLimit);
			panel.getSwapLimit().setText(swapLimit);
			panel.getRemoveLimit().setText(removeLimit);
			
			panel.getFreq1().setText(Double.toString(freq1));
			panel.getFreq2().setText(Double.toString(freq2));
			panel.getFreq3().setText(Double.toString(freq3));
			panel.getFreq4().setText(Double.toString(freq4));
			panel.getFreq5().setText(Double.toString(freq5));
			panel.getFreq6().setText(Double.toString(freq6));
			
			panel.getFirstStar().setText(starGoalsArray[0]);
			panel.getSecondStar().setText(starGoalsArray[1]);
			panel.getThirdStar().setText(starGoalsArray[2]);
			panel.getx2().setText(Double.toString(x2Freq));
			panel.getx3().setText(Double.toString(x3Freq));
			
			panel.setVisible(true);
		}
		catch(IOException e){
			System.err.println("no input file");
		}
		
		
		
		
		
	}
}
