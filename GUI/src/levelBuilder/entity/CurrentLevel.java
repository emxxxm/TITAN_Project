package levelBuilder.entity;

import java.util.Hashtable;

/**
 * Saves the list of modes and their matching level numbers.
 *
 */
public class CurrentLevel {
	protected Hashtable<Integer, String> levelMode;
	
	public CurrentLevel(){
		levelMode = new Hashtable<Integer, String>();
	}
	
	/**
	 * Put Integer and String to hash table.
	 * 
	 * @param key
	 * @param value
	 * @return String value
	 */
	public String put(Integer key, String value){
		levelMode.put(key, value);		
		return value;
	}
	
	public String get(Integer key){
		return levelMode.get(key);
	}
	
	public int size(){
		return levelMode.size();
	}
	
}
