package conferencemanagement;

import java.util.List;

/**
 * This class contains whole sessions info.
 */

public abstract class Session {

  protected int id;
  protected int startTime;
  protected int endTime;
  protected int currentTime;
  protected String type;

  public Session() {
  }

  public Session(SessionData session) {
    this.id = session.getId();
    this.type = session.getType();
    this.startTime = session.getStartTime();
    this.endTime = session.getEndTime();
  }

  public abstract int calculateEndTime();

  public abstract void schedule(List<Talk> Talk);

  public abstract void print(int preSessionEndTime);

  /**
   * This fxn prints talk in proper readable format for TalkSession type session such as morning or
   * afternoon session.
   */
  public String formatTalkSessionTime(int starttime) {

    int diff = 0, hr = 0, min = 0;
    String var = "AM";
    if (starttime == Constants.MORNINGSTARTINGTIME) {
      return String.format("%02d:%02d %s ", Constants.NINE, min, var);

    } else if (starttime >= Constants.MORNINGSTARTINGTIME
        && starttime <= Constants.MORNINGENDTIME) {
      diff = ((starttime - Constants.MORNINGSTARTINGTIME));
      hr = diff / Constants.SIXTY;
      min = (diff - hr * Constants.SIXTY);
      hr += Constants.NINE;
    } else if (starttime >= Constants.AFTERNOONSTARTINGTIME
        && starttime <= Constants.AFTERNOONENDTIME) {
      diff = ((starttime - Constants.AFTERNOONSTARTINGTIME));
      hr = diff / Constants.SIXTY;
      min = (diff - hr * Constants.SIXTY);
      hr += Constants.MIN_TALKMINUTE;
    }
    if (starttime >= Constants.MORNINGENDTIME) {
      var = "PM";
    } else {
      var = "AM";
    }
    return String.format("%02d:%02d %s ", hr, min, var);
  }

  /**
   * This fxn prints session format for IntervalSession type such as lunch or networking.
   */
  public String formatIntervalSessionTime(int starttime) {

    int diff = 0, hr = 0, min = 0;
    String var = "PM";
    if (starttime == Constants.MORNINGENDTIME) {
      hr = Constants.TWELVE;
    } else if (starttime >= Constants.AFTERNOONSTARTINGTIME
        && starttime <= Constants.AFTERNOONENDTIME) {
      diff = (starttime - Constants.AFTERNOONSTARTINGTIME);
      hr = diff / Constants.SIXTY;
      min = (diff - hr * Constants.SIXTY);
      hr += Constants.MIN_TALKMINUTE;
    }
    return String.format("%02d:%02d %s ", hr, min, var);
  }

}
