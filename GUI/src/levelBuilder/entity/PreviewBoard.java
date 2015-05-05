package levelBuilder.entity;

import java.util.Hashtable;

public class PreviewBoard {
	final int size = 81;
	
	protected Hashtable<Position, PreviewSquare> previewBd;
	
	public PreviewBoard(){
		previewBd = new Hashtable<Position, PreviewSquare>();
	}
	
	/**
	 * Put position and PreviewSquare to a hash table
	 * return false if exceed the size.
	 * previewSqaure will be replaced if key already exist
	 * @param ps
	 * @param sq
	 * @return boolean
	 */
	public boolean put(Position ps,PreviewSquare sq){
		if(previewBd.size()>=size) return false;
		
		previewBd.put(ps,sq);
		return true;
	}
}
