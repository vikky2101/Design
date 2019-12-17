package chessgame;

public class Queen extends Piece {

  public Queen(boolean isAvailable, boolean isBlack, int x, int y) {
    super(isAvailable, isBlack, x, y);
  }

  @Override
  public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
		if (super.isValidMove(fromX, fromY, toX, toY) == false) {
			return false;
		}
		if (toX == fromX) {
			return true;
		} else if (toY == fromY) {
			return true;
		} else if (toX - fromX == toY - fromY) {
			return true;
		} else {
			return false;
		}
  }

}
