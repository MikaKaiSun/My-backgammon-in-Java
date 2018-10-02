package ynu.xzw;

public class Chess {
	boolean isBlack;
	int x;
	int y;
	public Chess(boolean isBlack, int x, int y) {
		this.isBlack = isBlack;
		this.x = x;
		this.y = y;
	}
	public boolean isBlack() {
		return isBlack;
	}
	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
