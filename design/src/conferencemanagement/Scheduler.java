package conferencemanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class schedules list of different items into set of tracks.It takes input file, process it
 * and call other APIs to prepares list of tracks.
 */

public class Scheduler {

  // store list of events
  private List<String> itemList;
  // list of different tracks after scheduling
  private List<Track> trackList;
  final Logger logger = Logger.getLogger(this.getClass().getName());

  /**
   * This fxn call other fxns that reads input file, schedule them into set of tracks and in the end
   * displays tracklists respectively.
   */
  public void process(String filename) {

    String currentDir = System.getProperty("user.dir");
    StringBuilder sb = new StringBuilder(currentDir);
    sb.append(File.separator);
    sb.append("src");
    sb.append(File.separator);
    sb.append(filename);
    readInputList(sb.toString());
    // scheduling itemList to get set of tracks
    SchedulerLogic sl = new SchedulerLogic();
    trackList = sl.schedule(itemList);
    // displaying set of tracks
    displayTracks();
  }

  /**
   * This fxn reads input file and persists item from file into itemlist.
   */
  private void readInputList(String inputfile) {

    if (inputfile == null || inputfile.isEmpty()) {
      logger.warning("Input File is missing");
      System.exit(0);
    }
    itemList = new ArrayList<String>();
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(inputfile));
      String line = null;
      while ((line = br.readLine()) != null) {
        itemList.add(line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * This fxn displays all tracks.
   */
  private void displayTracks() {
    System.out.println("No of Tracks : " + Track.no_of_tracks);
    for (Track track : trackList) {
      System.out.println("Track : " + track.getTrack_Id());
      track.print();
    }
  }

  public static void main(String args[]) {
    String file = "input";
    if (args.length != 0) {
      file = args[0];
    }
    Scheduler obj = new Scheduler();
    obj.process(file);
  }

}
