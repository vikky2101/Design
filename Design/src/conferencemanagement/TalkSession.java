package conferencemanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class holds morning or afternoon sessions only.
 */
public class TalkSession extends Session {

	// TalkSession is baiscally collection of talklist
	List<Talk> talklist;
	// arr corresponding to talkitems whose value is true if item is included
	// otherwise false
	boolean[] arr;

	public TalkSession(SessionData session) {
		super(session);
		talklist = new ArrayList<Talk>();
	}

	/**
	 * This fxn calculates endtime of a particular session
	 */
	@Override
	public int calculateEndTime() {
		int totaltime = 0;
		for (Talk talk : talklist) {
			totaltime += talk.getDuration();
		}
		return (totaltime + this.starttime);
	}

	/**
	 * This fxn contains scheduling logic. Basically it is knapsack algorithm.
	 */
	@Override
	public void schedule(List<Talk> talkitems) {

		int W = ((this.endtime - this.starttime) / Constants.hundred)
				* Constants.sixty;
		int N = talkitems.size();
		int[] value = new int[N + 1];
		int[] weight = new int[N + 1];
		int i = 1;
		for (Talk x : talkitems) {
			value[i] = weight[i] = x.getDuration();
			i++;
		}

		boolean[][] sol = new boolean[N + 1][W + 1];
		int[][] opt = new int[N + 1][W + 1];
		for (int k = 1; k <= N; k++) {
			for (int w = 1; w <= W; w++) {
				// not taking item k
				int exclude = opt[k - 1][w];
				// taking item k
				int include = Integer.MIN_VALUE;
				if (weight[k] <= w) {
					include = value[k] + opt[k - 1][w - weight[k]];
					opt[k][w] = Math.max(include, exclude);
					sol[k][w] = (include > exclude);
				}
			}
		}

		// fill the array if item is included or not
		arr = new boolean[N + 1];
		for (int p = N, w = W; p > 0; p--) {
			if (sol[p][w]) {
				arr[p] = true;
				w = w - weight[p];
			} else {
				arr[p] = false;
			}
		}
		updatTalkList(talkitems);
	}

	/**
	 * This fxn adds Talk to talklist.
	 */
	public void addTalk(Talk talk) {
		talklist.add(new Talk(talk));
	}

	/**
	 * This fxn removes talk from talkitems, remove it from talkitems and add it
	 * to talklists.
	 */
	private void updatTalkList(List<Talk> talkitems) {

		int i = 1;
		for (Iterator<Talk> itr = talkitems.iterator(); itr.hasNext();) {
			Talk talk = itr.next();
			if (arr[i]) {
				talk.setIsInclude(true);
				this.addTalk(talk);
				itr.remove();
			}
			i++;
		}
	}

	/**
	 * This fxn prints a particular talk session which contains list of talks.
	 */
	@Override
	public void print(int startTime) {

		int currentTime = this.starttime;
		for (Talk talk : talklist) {
			String time = formatTalkSessionTime(currentTime);
			talk.print(time);
			currentTime += talk.getDuration();
		}
	}
}