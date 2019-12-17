package conferencemanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class holds list of items grouped into different sessions.
 */

public class Track {

  static int no_of_tracks;
  int track_Id;
  List<Session> sessionsList;

  public Track() {
    track_Id = ++no_of_tracks;
    sessionsList = new ArrayList<>();
  }

  public int getTrack_Id() {
    return track_Id;
  }

  public List<Session> getSessionsList() {
    return sessionsList;
  }

  public void setSessionsList(List<Session> sessionsList) {
    this.sessionsList = sessionsList;
  }

  public void addNewSessions(Session session) {
    sessionsList.add(session);
  }


  /**
   * This fxn prints a single track that contains list of session
   */
  public void print() {
    int preSessionEndTime = 0, currSessionEndTime = 0;
    Iterator<Session> itr = sessionsList.iterator();
    while (itr.hasNext()) {
      Session session = itr.next();
      currSessionEndTime = session.calculateEndTime();
      session.print(preSessionEndTime);
      preSessionEndTime = currSessionEndTime;
    }
  }
}
