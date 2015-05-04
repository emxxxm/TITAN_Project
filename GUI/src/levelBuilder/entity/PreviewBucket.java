package levelBuilder.entity;

import java.awt.Color;

public class PreviewBucket extends PreviewSquare{

	protected Color bucketColor;
	
	public PreviewBucket(Position ps, Color color){
		super(ps);
		this.bucketColor = color;
	}
	
	//TODO GET SET
}
