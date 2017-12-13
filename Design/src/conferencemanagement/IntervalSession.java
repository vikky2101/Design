package conferencemanagement;


import java.util.List;

/**
 * This class is used to represent lunch or networking type of session.
 *****/



public class IntervalSession extends Session {

	@Override
	public int calculateEndTime() {
		return this.endtime;
	}

	public IntervalSession(SessionData session) {
		super(session);
	}

	@Override
	public void schedule(List<Talk> Talk) {
		// TODO Auto-generated method stub
	}

	/**
	 * This fxn prints lunch or networking session in readable format.
	 */
	@Override
	public void print(int prevSessionEndTime) {
		if (prevSessionEndTime == 0) {
			prevSessionEndTime = this.starttime;
		}
		if ("lunch".equals(this.type)) {
			int duration = ((this.endtime - this.starttime) / Constants.hundred)
					* Constants.sixty;
			System.out.println(formatIntervalSessionTime(this.starttime) + "Lunch "
					+ duration + Constants.minute);
			return;
		}
		if ("networking".equals(this.type)) {
			int minNetworkingStartTime = Constants.minNetworkingStartTime;
			if (prevSessionEndTime - Constants.afternoonstartingtime > minNetworkingStartTime) {
				System.out.println(formatIntervalSessionTime(prevSessionEndTime)
						+ "Networking Event\n");
			} else {
				System.out
						.println(formatIntervalSessionTime(Constants.minimin_network_starting_time)
								+ "Networking Event\n");
			}
		}
	}
}
