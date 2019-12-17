package swversion;

import java.util.*;
import java.io.*;

public class Driver {

  class Software {

    private String name;
    private String type;
    private List<Version> versionList;

    public Software(String name, String type) {
      this.name = name;
      this.type = type;
      versionList = new LinkedList<>();
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(type).append(" ");
      sb.append(name).append("-");
      for (Version version : versionList) {
        sb.append(version).append(" ");
      }
      return sb.toString();
    }
  }

  class Version implements Comparable<Version> {

    private String version;
    private String serverName;

    public final String getVersion() {
      return this.version;
    }

    private Version(String version, String serverName) {
      if (version == null || serverName == null) {
        throw new IllegalArgumentException("Version/Server  can not be null");
      }
      this.version = version;
      this.serverName = serverName;
    }

    @Override
    public int compareTo(Version that) {
      if (that == null) {
        return 1;
      }
      String[] thisParts = this.getVersion().split("\\.");
      String[] thatParts = that.getVersion().split("\\.");
      int length = Math.max(thisParts.length, thatParts.length);
      for (int i = 0; i < length; i++) {
        int thisPart = i < thisParts.length ? Integer.parseInt(thisParts[i].trim()) : 0;
        int thatPart = i < thatParts.length ? Integer.parseInt(thatParts[i].trim()) : 0;
        if (thisPart < thatPart) {
          return 1;
        }
        if (thisPart > thatPart) {
          return -1;
        }
      }
      return 0;
    }

    @Override
    public boolean equals(Object that) {
      if (this == that) {
        return true;
      }
      if (that == null || !(that instanceof Version)) {
        return false;
      }
      if (this.getClass() != that.getClass()) {
        return false;
      }
      return this.compareTo((Version) that) == 0;
    }

    @Override
    public int hashCode() {
      return version.hashCode();
    }

    public String toString() {
      return this.version.toString() + " " + this.serverName.toString();
    }

  }

  public int processData(ArrayList<String> array) {

    HashMap<String, Software> hashMap = new HashMap<>();
    for (int i = 0; i < array.size(); i++) {
      String[] string = array.get(i).split(",");
      Software software ;
      if (!hashMap.containsKey(string[2])) {
        software = new Software(string[2], string[1]);
        software.versionList.add(new Version(string[3], string[0]));
        hashMap.put(string[2], software);
      } else {
        software = hashMap.get(string[2]);
        software.versionList.add(new Version(string[3], string[0]));
      }
    }
    int totalCount = 0;
    for (Map.Entry<String, Software> map : hashMap.entrySet()) {
      List<Version> list = map.getValue().versionList;
      Collections.sort(list);
      System.out.println(map.getValue().toString());
      for (int i = 1; i < list.size(); i++) {
        if (!list.get(i).version.equals(list.get(i - 1).version)
            && !list.get(i).serverName.equals(list.get(i - 1).serverName)) {
          if (list.size() - i > 2) {
            totalCount++;
            break;
          }
        }
      }
    }
    return totalCount;
  }

  public static void main(String[] args) {
    ArrayList<String> inputData = new ArrayList<>();
    try {
      String workingDir = System.getProperty("user.dir") + "\\input.txt";
      Scanner in = new Scanner(new BufferedReader(new FileReader(workingDir)));
      while (in.hasNextLine()) {
        String line = in.nextLine().trim();
        if (!line.isEmpty()) // Ignore blank lines
        {
          inputData.add(line);
        }
      }
      in.close();
      Driver obj = new Driver();
      int retVal = obj.processData(inputData);
      workingDir = System.getProperty("user.dir") + "\\output.txt";
      PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(workingDir)));
      output.println("" + retVal);
      output.close();
    } catch (IOException e) {
      System.out.println("IO error in input.txt or output.txt");
    }
  }
}
