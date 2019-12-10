
public class Cookie {
	private int xlocation;
	private int ylocation;

		public Cookie() {
			xlocation = 0;
			ylocation = 0;
		}
		
		public Cookie(int x, int y) {
			xlocation = x;
			ylocation = y;
		}
		
		public int getX() {
			return xlocation;
		}
		
		public int getY() {
			return ylocation;
		}
}
