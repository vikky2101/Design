package marsroverproblem;

public class Robot {

	private Coordinates coordinates;
	private Direction direction;
	private Platue platue;

	public Robot(Coordinates coord, Direction dir, Platue platue) {
		this.coordinates = coord;
		this.direction = dir;
		this.platue = platue;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Platue getPlatue() {
		return platue;
	}

	public void setPlatue(Platue platue) {
		this.platue = platue;
	}

	public void moveleft() {
       this.direction.left();
	}

	public void moveright() {
		this.direction.right();

	}

	public void move() {
        Coordinates afterMove = new Coordinates(this.coordinates.x + this.direction.stepX(), 
        		this.coordinates.y + this.direction.stepY());
           
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(coordinates.x).append(" ").append(coordinates.y).append(" ").append(direction);
		return sb.toString();
	}

}
