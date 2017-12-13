package chessgame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Player white = new Player(false);
		Player black = new Player(true);
		ChessGame game = new ChessGame(white, black);
		game.initiliazeBoard();
		// Game will be started by white Player
		game.play(white.getPieces().get(6), white.getPieces().get(6).getX(), white.getPieces().get(6).getY(), 0, 5);

		game.play(black.getPieces().get(8), black.getPieces().get(8).getX(), black.getPieces().get(8).getY(), 0, 2);

	}

}
