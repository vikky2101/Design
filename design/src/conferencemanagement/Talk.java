package conferencemanagement;

import java.util.UUID;

/**
 * This class holds item read from input file. It contains fields as id, topic,
 * time duration and isInclude field.
 */
public class Talk {

	private final String id;
	private String topic;
	private int duration;
	private boolean isInclude;

	public String getTopic() {
		return topic;
	}

	public boolean getIsInclude() {
		return isInclude;
	}

	public void setIsInclude(boolean isInclude) {
		this.isInclude = isInclude;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getId() {
		return id;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Talk(String topic, int duration) {

		this.id = UUID.randomUUID().toString();
		this.topic = topic;
		this.duration = duration;
		this.isInclude = false;
	}

	public Talk(Talk t) {

		this.id = t.id;
		this.topic = t.topic;
		this.duration = t.duration;
		this.isInclude = true;
	}

	public int getDuration() {
		return duration;
	}

	public void print(String startTime) {
		StringBuffer sb = new StringBuffer();
		sb.append(startTime);
		sb.append(this.getTopic());
		sb.append(" ");
		sb.append(this.getDuration());
		sb.append(Constants.minute);
		System.out.println(sb.toString());
	}

}
