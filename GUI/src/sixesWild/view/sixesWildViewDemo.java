package sixesWild.view;

import sixesWild.model.Model;

public class sixesWildViewDemo 
{
	public static void main(String[] args)
	{
		Model m=new Model();
		SelectLevelView slv=new SelectLevelView(m);
		
		slv.setVisible(true);
	}
}