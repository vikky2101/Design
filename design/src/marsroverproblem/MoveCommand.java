package marsroverproblem;

public class MoveCommand implements ICommand {

  @Override
  public void execute(Robot robot) {
    robot.move();
  }

}
