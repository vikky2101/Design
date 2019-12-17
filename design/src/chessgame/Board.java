package chessgame;

public class Board {

  Square squareSet[][];

  public Board() {
    squareSet = new Square[8][8];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        squareSet[i][j] = new Square(i, j);
      }
    }
  }

  public Square getSquare(int x, int y) {
    return squareSet[x][y];
  }

  public boolean move(Piece piece, int fromX, int fromY, int toX, int toY) {
    if (!piece.isAvailable() || !piece.isValidMove(fromX, fromY, toX, toY)) {
      System.out.println("Move is invalid " + fromX + fromY + toX + toY);
      return false;
    } else if (squareSet[toX][toY].isOccupied() == true
        && squareSet[toX][toY].piece.isBlack() == piece.isBlack()) {
      System.out.println("Move is invalid 2");
      return false;
    } else {
			if (squareSet[toX][toY].piece != null) {
				squareSet[toX][toY].piece.setAvailable(false);
			}
      squareSet[toX][toY].occupySquare(piece);
      squareSet[fromX][fromY].releaseSquare();
      piece.setX(toX);
      piece.setY(toY);
      System.out.println("Move is successful");
      return true;
    }

  }

}