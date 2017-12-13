package chessgame;

import java.util.Scanner;

public class ChessGame {
	Board board;
	Player whitePlayer;
	Player blackPlayer;
	boolean whiteTurn = true;

	public ChessGame(Player white, Player black) {
		board = new Board();
		this.whitePlayer = white;
		this.blackPlayer = black;

	}

	public void initiliazeBoard() {
		System.out.println("Initilaizing board");
		for (int i = 0; i < this.whitePlayer.getPieces().size(); i++) {
			board.getSquare(this.whitePlayer.getPieces().get(i).getX(), this.whitePlayer.getPieces().get(i).getY())
					.occupySquare(this.whitePlayer.getPieces().get(i));
		}
		for (int i = 0; i < this.blackPlayer.getPieces().size(); i++) {
			board.getSquare(this.blackPlayer.getPieces().get(i).getX(), this.blackPlayer.getPieces().get(i).getY())
					.occupySquare(this.blackPlayer.getPieces().get(i));
		}

	}

	public void play(Piece piece, int fromX, int fromY, int toX, int toY) {
		System.out.println("Moving piece ");
		board.move(piece, fromX, fromY, toX, toY);

	}

}
