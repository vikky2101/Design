package conferencemanagement;


import java.util.List;

/**
 * This class is used to represent lunch or networking type of session.
 *****/



public class IntervalSession extends Session {

	@Override
	public int calculateEndTime() {
		return this.endTime;
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
			prevSessionEndTime = this.startTime;
		}
		if ("lunch".equals(this.type)) {
			int duration = ((this.endTime - this.startTime) / Constants.HUNDRED)
					* Constants.SIXTY;
			System.out.println(formatIntervalSessionTime(this.startTime) + "Lunch "
					+ duration + Constants.MINUTE);
			return;
		}
		if ("networking".equals(this.type)) {
			int minNetworkingStartTime = Constants.MIN_NETWORKING_START_TIME;
			if (prevSessionEndTime - Constants.AFTERNOONSTARTINGTIME > minNetworkingStartTime) {
				System.out.println(formatIntervalSessionTime(prevSessionEndTime)
						+ "Networking Event\n");
			} else {
				System.out
						.println(formatIntervalSessionTime(Constants.MINIMIN_NETWORK_STARTING_TIME)
								+ "Networking Event\n");
			}
		}
	}
}
