package level_builder;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

public class SplashScrn extends JFrame implements ActionListener{
	    
		static void renderSplashFrame(Graphics2D g, int frame) {

			String game="Sixes Wild";
			String team="TITAN";
			String mengwen="Mengwen Li";
			String ying="Ying Lu";
			String xiaoman="Xiaoman Xu";
			String xiaoren="Xiaoren Yang";
			String yihong="Yihong Zhou";
			
			
			g.setPaintMode();
			g.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
			g.drawString(game, 250,20);
			
			g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
			g.drawString(team,280,120);
			g.drawString(mengwen, 280, 150);
			g.drawString(ying, 280, 180);
			g.drawString(xiaoman, 280, 210);
			g.drawString(xiaoren, 280, 240);
			g.drawString(yihong, 280, 270);
			
	    }
	    
		public SplashScrn() {
		
		        final SplashScreen splash = SplashScreen.getSplashScreen();
		        if (splash == null) {
		            System.out.println("SplashScreen.getSplashScreen() returned null");
		            return;
		        }
		        Graphics2D g = splash.createGraphics();
		        if (g == null) {
		            System.out.println("g is null");
		            return;
		        }
		        for(int i=0; i<100; i++) {
		           // renderSplashFrame(g, i);
		            splash.update();
		            try {
		                Thread.sleep(10);
		            }
		            catch(InterruptedException e) {
		            }
		        }
		        splash.close();
		       
//		        RequestScreen rs = new RequestScreen();
//				rs.setVisible (true);
//				
		        toFront();
		    
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
			
		}
		
	    private static WindowListener closeWindow = new WindowAdapter(){
	        public void windowClosing(WindowEvent e){
	            e.getWindow().dispose();
	        }
	    };
	/*     
	    public static void main (String args[]) {
	        SplashScrn sixeswild = new SplashScrn();
	    }
*/



}
