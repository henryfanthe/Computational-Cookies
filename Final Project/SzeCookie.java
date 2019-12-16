
public class SzeCookie extends Cookie{
	private int type = 1;
	private int level;
	
	public SzeCookie() {
		level = 1;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int newLevel) {
		level = newLevel;
	}
	
	public int getType() {
		return type;
	}
}
