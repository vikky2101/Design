package chessgame;

public class Square {

  int x, y;
  Piece piece;

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Piece getPiece() {
    return piece;
  }

  public Square(int x, int y) {
    this.x = x;
    this.y = y;
    this.piece = null;
  }

  public boolean isOccupied() {
    return this.piece != null;
  }

  public void occupySquare(Piece piece) {
    if (this.piece != null) {
      this.piece.setAvailable(false);
    }
    this.piece = piece;
  }

  public void releaseSquare() {
    this.piece = null;
  }
}
