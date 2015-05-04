package levelBuilder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

import levelBuilder.entity.BonusFrequency;
import levelBuilder.entity.Limits;
import levelBuilder.entity.Model;
import levelBuilder.entity.NumFrequency;
import levelBuilder.entity.StarGoals;

public class LevelSaveController implements ActionListener {
	
	Model model;
	
	public LevelSaveController(Model model){
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent arg0){

		String curLevel = "src/level"+model.getCurLevel();
		
//		File f = new File
		
		try {
			BufferedWriter level = new BufferedWriter(new FileWriter(curLevel));
		
			level.write("20");
			level.newLine();
			level.write(""+model.getCurLevel());
			level.newLine();
			Limits ls = model.getLimits();
			level.write(""+ls.getMoveLimits());
			level.newLine();
			level.write(""+ls.getTimeLimits());
			level.newLine();
			level.write(""+ls.getSwapLimits());
			level.newLine();
			level.write(""+ls.getRemoveLimits());
			level.newLine();
			StarGoals sg = model.getStarGoals();
			level.write(""+sg.getOne()+" "+sg.getTwo()+" "+sg.getThree());
			level.newLine();
			NumFrequency freq = model.getNumFrequency();
			level.write(""+(int)(freq.getFre1()*100)
					+" "+(int)(freq.getFre2()*100)
					+" "+(int)(freq.getFre3()*100)
					+" "+(int)(freq.getFre4()*100)
					+" "+(int)(freq.getFre5()*100)
					+" "+(int)(freq.getFre6()*100));
			level.newLine();
			BonusFrequency bf = model.getBonusFrequency();
			int x2 = (int)(bf.getx2()*100);
			int x3 = (int)(bf.getx3()*100);
			level.write(""+(100-x2-x3)+" "+x2+" "+x3);
			level.newLine();
			level.write(model.generateSquareType());
			System.out.println();
			level.newLine();
			
			level.write(model.getSix().printList());
			level.newLine();
			
//			level.write(model.generateTileNum());
//			level.newLine();
//			level.write(model.generateTileBonus());
//			level.newLine();
			
//			level.write(model.generateTileNum());
//			level.newLine();
//			level.write(model.generateTileBonus());
//			level.newLine();
			
			
			
			System.out.println("write to file");
			level.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Can't file write.");
		}
		
		
		
	}

}
