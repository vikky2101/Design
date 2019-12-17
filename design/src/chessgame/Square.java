package chessgame;

public class Square {

	int x,y;
	Piece piece;
	
	public Square(int x, int y) {
           this.x = x;
           this.y = y;
           this.piece = null;
	}
	
	public boolean isOccupied(){
		return this.piece != null;
	}
	
	public void occupySquare(Piece piece){
		if(this.piece != null)
			this.piece.setAvailable(false);
		this.piece = piece;
	}
	
	public void releasSquare(){
		this.piece = null;
	}
}
