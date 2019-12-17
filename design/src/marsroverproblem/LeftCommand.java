package marsroverproblem;

public class LeftCommand implements ICommand {

  @Override
  public void execute(Robot robot) {
    robot.moveLeft();
  }

}
