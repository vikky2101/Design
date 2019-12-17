package conferencemanagement;

/**
 * This class sessions information such as sessiontype,strattime,endtime,id.
 * 
 */
public class SessionData {
	private int id;
	private String type;
	private int starttime;
	private int endtime;

	public SessionData() {
	}

	public SessionData(int id, String type, int starttime, int endtime) {
		super();
		this.id = id;
		this.type = type;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStarttime() {
		return starttime;
	}

	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}

	public int getEndtime() {
		return endtime;
	}

	public void setEndtime(int endtime) {
		this.endtime = endtime;
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
		SessionData[] sessionlist = { new SessionData(1, "morning", Constants.morningstartingtime, Constants.morningendtime),
				new SessionData(2, "lunch", Constants.morningendtime, Constants.afternoonstartingtime),
				new SessionData(3, "afternoon", Constants.afternoonstartingtime, Constants.afternoonendtime),
				new SessionData(4, "networking", Constants.minimin_network_starting_time, Constants.afternoonendtime) };
		return sessionlist;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id + " ");
		sb.append(this.type + " ");
		sb.append(this.starttime + " ");
		sb.append(this.endtime + " ");
		return sb.toString();
	}

}
