package chessgame;

public abstract class Piece {

  private boolean isAvailable;
  private int x, y;
  private boolean isBlack;

  public Piece(boolean isAvailable, boolean isBlack, int x, int y) {
    this.isAvailable = isAvailable;
    this.isBlack = isBlack;
    this.x = x;
    this.y = y;
  }

  public boolean isBlack() {
    return isBlack;
  }

  public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
		if (fromX < 0 || fromY > 7 || toX < 0 || toY > 7 || ((fromX == toX) && (fromY == toY))) {
			return false;
		} else {
			return true;
		}
  }

  public boolean isAvailable() {
    return this.isAvailable;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
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
