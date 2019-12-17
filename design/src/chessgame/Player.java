package chessgame;

import java.util.ArrayList;
import java.util.List;

public class Player {

  private List<Piece> pieceList;
  private boolean isBlack;

  public Player(boolean isBlack) {
    pieceList = new ArrayList<>();
    this.isBlack = isBlack;
    if (isBlack == true) {
      pieceList.add(new Rook(true, true, 0, 0));
      pieceList.add(new King(true, true, 1, 0));
      pieceList.add(new Bishop(true, true, 2, 0));
      pieceList.add(new Queen(true, true, 3, 0));
      pieceList.add(new King(true, true, 4, 0));
      pieceList.add(new Bishop(true, true, 5, 0));
      pieceList.add(new Knight(true, true, 6, 0));
      pieceList.add(new Rook(true, true, 7, 0));
      for (int i = 0; i < 8; i++) {
        pieceList.add(new Pawn(true, true, i, 1));
      }
    } else {
      pieceList.add(new Rook(true, false, 0, 7));
      pieceList.add(new King(true, false, 1, 7));
      pieceList.add(new Bishop(true, false, 2, 7));
      pieceList.add(new Queen(true, false, 3, 7));
      pieceList.add(new King(true, false, 4, 7));
      pieceList.add(new Bishop(true, false, 5, 7));
      pieceList.add(new Knight(true, false, 6, 7));
      pieceList.add(new Rook(true, false, 7, 7));
      for (int i = 0; i < 8; i++) {
        pieceList.add(new Pawn(true, false, i, 6));
      }
    }
  }

  public List<Piece> getPieces() {
    return this.pieceList;
  }

}
