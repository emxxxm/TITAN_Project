package levelBuilder.entity;

public class PreviewUsable extends PreviewSquare{

	protected int number;
	protected int multi;
	
	public PreviewUsable(Position ps, int number, int multiplier) {
		super(ps);
		this.number = number;
		this.multi = multiplier;
	}
	
	//TODO get and set

}
