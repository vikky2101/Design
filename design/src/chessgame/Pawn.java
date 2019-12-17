package chessgame;

public class Pawn extends Piece {

  public Pawn(boolean isAvailable, boolean isBlack, int x, int y) {
    super(isAvailable, isBlack, x, y);
  }

  @Override
  public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
		if (super.isValidMove(fromX, fromY, toX, toY) == false) {
			return false;
		}
		if (toY - fromY == 1 && toX == fromX) {
			return true;
		} else {
			return false;
		}
  }

}
