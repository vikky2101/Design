package chessgame;

import java.util.ArrayList;

public class Player {

	private ArrayList<Piece> piecelist;
	private boolean isBlack;

	public Player(boolean isBlack) {
		piecelist = new ArrayList<>();
		this.isBlack = isBlack;
		if (isBlack == true) {
			piecelist.add(new Rook(true, true, 0, 0));
			piecelist.add(new King(true, true, 1, 0));
			piecelist.add(new Bishop(true, true, 2, 0));
			piecelist.add(new Queen(true, true, 3, 0));
			piecelist.add(new King(true, true, 4, 0));
			piecelist.add(new Bishop(true, true, 5, 0));
			piecelist.add(new Knight(true, true, 6, 0));
			piecelist.add(new Rook(true, true, 7, 0));
			for (int i = 0; i < 8; i++) {
				piecelist.add(new Pawn(true, true, i, 1));
			}
		} else {
			piecelist.add(new Rook(true, false, 0, 7));
			piecelist.add(new King(true, false, 1, 7));
			piecelist.add(new Bishop(true, false, 2, 7));
			piecelist.add(new Queen(true, false, 3, 7));
			piecelist.add(new King(true, false, 4, 7));
			piecelist.add(new Bishop(true, false, 5, 7));
			piecelist.add(new Knight(true, false, 6, 7));
			piecelist.add(new Rook(true, false, 7, 7));
			for (int i = 0; i < 8; i++) {
				piecelist.add(new Pawn(true, false, i, 6));
			}
		}
	}

	public ArrayList<Piece> getPieces() {
		return this.piecelist;
	}

}
