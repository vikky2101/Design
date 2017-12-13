package chessgame;

public class Knight extends Piece {

	public Knight(boolean isAvailable, boolean isBlack, int x, int y) {
		super(isAvailable, isBlack, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
		if (super.isValidMove(fromX, fromY, toX, toY) == false)
			return false;
		if (toY == fromY + 2 && (toX == fromX - 1 || toX == fromX + 1))
			return true;
		else if (toY == fromY - 2 && (toX == fromX - 1 || toX == fromX + 1))
			return true;
		else if (toX == fromX - 2 && (toY == fromY - 1 || toY == fromY + 1))
			return true;
		else if (toX == fromX + 2 && (toY == fromY - 1 || toY == fromY + 1))
			return true;
		else
			return false;
	}
}
