package conferencemanagement;

import java.util.List;

/**
 * This class contains whole sessions info.
 */

public abstract class Session {
	protected int id;
	protected int starttime;
	protected int endtime;
	protected int currendtime;
	protected String type;

	public Session() {
	}

	public Session(SessionData session) {
		this.id = session.getId();
		this.type = session.getType();
		this.starttime = session.getStarttime();
		this.endtime = session.getEndtime();
	}

	public abstract int calculateEndTime();

	public abstract void schedule(List<Talk> Talk);

	public abstract void print(int preSessionEndTime);

	/**
	 * This fxn prints talk in proper readable format for TalkSession type
	 * session such as morning or afternoon session.
	 */
	public String formatTalkSessionTime(int starttime) {

		int diff = 0, hr = 0, min = 0;
		String var = "AM";
		if (starttime == Constants.morningstartingtime) {
			return String.format("%02d:%02d %s ", Constants.nine, min, var);

		} else if (starttime >= Constants.morningstartingtime
				&& starttime <= Constants.morningendtime) {
			diff = ((starttime - Constants.morningstartingtime));
			hr = diff / Constants.sixty;
			min = (diff - hr * Constants.sixty);
			hr += Constants.nine;
		} else if (starttime >= Constants.afternoonstartingtime
				&& starttime <= Constants.afternoonendtime) {
			diff = ((starttime - Constants.afternoonstartingtime));
			hr = diff / Constants.sixty;
			min = (diff - hr * Constants.sixty);
			hr += Constants.min_talkminute;
		}
		if (starttime >= Constants.morningendtime) {
			var = "PM";
		} else {
			var = "AM";
		}
		return String.format("%02d:%02d %s ", hr, min, var);
	}

	/**
	 * This fxn prints session format for IntervalSession type such as lunch or
	 * networking.
	 */
	public String formatIntervalSessionTime(int starttime) {

		int diff = 0, hr = 0, min = 0;
		String var = "PM";
		if (starttime == Constants.morningendtime) {
			hr = Constants.twelve;
		} else if (starttime >= Constants.afternoonstartingtime
				&& starttime <= Constants.afternoonendtime) {
			diff = (starttime - Constants.afternoonstartingtime);
			hr = diff / Constants.sixty;
			min = (diff - hr * Constants.sixty);
			hr += Constants.min_talkminute;
		}
		return String.format("%02d:%02d %s ", hr, min, var);
	}

}
