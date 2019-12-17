package marsroverproblem;

public class RightCommand implements ICommand {

  @Override
  public void execute(Robot robot) {
    robot.moveRight();
  }

}
