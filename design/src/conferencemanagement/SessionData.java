package conferencemanagement;

/**
 * This class sessions information such as sessiontype,strattime,endtime,id.
 */
public class SessionData {

  private int id;
  private String type;
  private int startTime;
  private int endTime;

  public SessionData() {
  }

  public SessionData(int id, String type, int startTime, int endTime) {
    super();
    this.id = id;
    this.type = type;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getStartTime() {
    return startTime;
  }

  public void setStartTime(int starttime) {
    this.startTime = starttime;
  }

  public int getEndTime() {
    return endTime;
  }

  public void setEndTime(int endtime) {
    this.endTime = endtime;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  /**
   * This fxn initialize array of sessionData .
   */
  public SessionData[] initialize() {
    SessionData[] sessionList = {
        new SessionData(1, "morning", Constants.MORNINGSTARTINGTIME, Constants.MORNINGENDTIME),
        new SessionData(2, "lunch", Constants.MORNINGENDTIME, Constants.AFTERNOONSTARTINGTIME),
        new SessionData(3, "afternoon", Constants.AFTERNOONSTARTINGTIME,
            Constants.AFTERNOONENDTIME),
        new SessionData(4, "networking", Constants.MINIMIN_NETWORK_STARTING_TIME,
            Constants.AFTERNOONENDTIME)};
    return sessionList;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.id + " ");
    sb.append(this.type + " ");
    sb.append(this.startTime + " ");
    sb.append(this.endTime + " ");
    return sb.toString();
  }

}
