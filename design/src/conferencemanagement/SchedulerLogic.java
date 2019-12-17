package conferencemanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains logic of scheduling.It transforms list of items into
 * talklist and schedule them into set of tracks.
 */

public class SchedulerLogic {

	// talk is basically storing input items into set of fields as
	// topic,duration,id etc
	List<Talk> talklist;
	final Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * This fxn takes list of items, transform it into talklist and schedule
	 * them.
	 */
	public List<Track> schedule(List<String> itemlist) {

		// transforms itemlist into talklist
		convertToTalkList(itemlist);
		List<Track> tracks = new ArrayList<Track>();
		// sessionData is array of session as morning,lunch,afternoon &
		// networking event
		SessionData[] sessionlist = new SessionData().initialize();
		while (talklist.size() > 0) {
			Track track = new Track();
			tracks.add(track);
			for (int i = 0; i < 4; i++) {
				Session session = getSessionType(sessionlist[i]);
				track.addNewSessions(session);
				if (talklist.size() > 0) {
					session.schedule(talklist);
				}
			}
		}
		return tracks;
	}

	/**
	 * This fxn returns Session object according to sessiontype as TalkSession
	 * if sessionType is morning or aftrenoon and IntervalSession if sessionType
	 * is lunch or networking.
	 */
	public Session getSessionType(SessionData session) {

		if (session.getType().equals("morning")
				|| session.getType().equals("afternoon")) {
			return new TalkSession(session);
		} else {
			return new IntervalSession(session);
		}
	}

	/**
	 * This fxn transform list of item into talklist.Basically it scans
	 * itemlist, fetches topic text and time and finally fill them into
	 * talklist.
	 */
	private void convertToTalkList(List<String> itemlist) {

		Iterator<String> itr = itemlist.iterator();
		talklist = new ArrayList<Talk>();
		int talktime;
		while (itr.hasNext()) {
			String topic = itr.next();
			topic = topic.replaceAll("\\s+", " ").trim();
			// pattern divides topic text into different groups 
			Pattern pattern = Pattern
					.compile("(.*)(\\s){1}([0-2]?[0-9]?[0-9]{1}min|lightning)\\b");
			Matcher matcher = pattern.matcher(topic);
			if (!matcher.matches()) {
				continue;
			}
			// fetching time using matcher group
			talktime = getTopicTime(matcher.group(3));
			if (talktime >= Constants.MIN_TALKMINUTE
					&& talktime <= Constants.MAX_TALKMINUTE) {
				talklist.add(new Talk(matcher.group(1), talktime));
			}
		}
	}

	/**
	 * This fxn retrives time of topic corresponding to every entry in itemlist.
	 */
	public int getTopicTime(String time) {

		if (time.endsWith("min")) {
			return Integer.parseInt(time.substring(0, time.indexOf("min")));
		} else if (time.endsWith("lightning")) {
			return Constants.LIGHTNING_TIME;
		}
		return 0;
	}

}
