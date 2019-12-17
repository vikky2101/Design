package marsroverproblem;

public class Robot {

  private Coordinates coordinates;
  private Direction direction;
  private Plateau plateau;

  public Robot(Coordinates coordinates, Direction dir, Plateau plateau) {
    this.coordinates = coordinates;
    this.direction = dir;
    this.plateau = plateau;
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

  public Plateau getPlateau() {
    return plateau;
  }

  public void setPlateau(Plateau plateau) {
    this.plateau = plateau;
  }

  public void moveLeft() {
    this.direction.left();
  }

  public void moveRight() {
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
