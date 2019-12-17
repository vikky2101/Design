package chessgame;

public class Rook extends Piece {

  public Rook(boolean isAvailable, boolean isBlack, int x, int y) {
    super(isAvailable, isBlack, x, y);
  }

  @Override
  public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
		if (super.isValidMove(fromX, fromY, toX, toY) == false) {
			return false;
		}
		if (toY == fromY || toX == fromX) {
			return true;
		} else {
			return false;
		}
  }

}
