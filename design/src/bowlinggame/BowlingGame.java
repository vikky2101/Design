/**
 *
 */
package bowlinggame;

public class BowlingGame {

  int roll[];
  int score;
  int curr_Roll;

  public void BowlingGame() {
    roll = new int[21];
  }

  public void roll(int ballsDown) {
    this.roll[curr_Roll++] = ballsDown;
  }

  public int getScore() {
    for (int frame = 0; frame < 10; frame++) {
      if (roll[frame] == 10) {
        score += 10 + roll[frame + 1] + roll[frame + 2];
        frame++;
      } else if (roll[frame] + roll[frame + 1] == 10) {
        score += 10 + roll[frame + 2];
        frame += 2;
      } else {
        score += roll[frame] + roll[frame + 1];
        frame += 2;
      }
    }

    return score;
  }

}
