package chessgame;

public class King extends Piece {

	public King(boolean isAvailable, boolean isBlack, int x, int y) {
		super(isAvailable, isBlack, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
		if (super.isValidMove(fromX, fromY, toX, toY) == false)
			return false;
		if (Math.abs(toY - fromY) == 1 && toX == fromX)
			return true;
		else if (Math.abs(toX - fromX) == 1 && toY == fromY)
			return true;
		else if (Math.abs(toY - fromY) == 1 && Math.abs(toX - fromX) == 1)
			return true;
		else
			return false;
	}

}
