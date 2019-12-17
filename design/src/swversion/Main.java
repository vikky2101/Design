package swversion;

/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* You may add any imports here, if you wish, but only from the 
   standard library */

public class Main {

	// It stores software data
	// name along with list of all versions
	class Software {
		private String swname;
		private String swtype;
		private List<Version> versionList;

		public Software(String swname, String swtype) {
			this.swname = swname;
			this.swtype = swtype;
			versionList = new LinkedList<>();
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(swtype).append(" ");
			sb.append(swname).append("-");
			for (Version version : versionList) {
				sb.append(version).append(" ");
			}
			return sb.toString();
		}
	}

	// Version class
	// maintain sorting order
	class Version implements Comparable<Version> {

		private String version;
		private String servername;

		public final String get() {
			return this.version;
		}

		private Version(String version, String servername) {
			if (version == null || servername == null)
				throw new IllegalArgumentException("Version/Server  can not be null");
			this.version = version;
			this.servername = servername;
		}

		@Override
		public int compareTo(Version that) {
			if (that == null)
				return 1;
			String[] thisParts = this.get().split("\\.");
			String[] thatParts = that.get().split("\\.");
			int length = Math.max(thisParts.length, thatParts.length);
			for (int i = 0; i < length; i++) {
				int thisPart = i < thisParts.length ? Integer.parseInt(thisParts[i].trim()) : 0;
				int thatPart = i < thatParts.length ? Integer.parseInt(thatParts[i].trim()) : 0;
				if (thisPart < thatPart)
					return 1;
				if (thisPart > thatPart)
					return -1;
			}
			return 0;
		}

		@Override
		public boolean equals(Object that) {
			if (this == that)
				return true;
			if (that == null || !(that instanceof Version))
				return false;
			if (this.getClass() != that.getClass())
				return false;
			return this.compareTo((Version) that) == 0;
		}

		@Override
		public int hashCode() {
			return version.hashCode();
		}

		public String toString() {
			return this.version.toString() + " " + this.servername.toString();
		}

	}

	public int processData(ArrayList<String> array) {
		/*
		 * Modify this method to process `array` as indicated in the question.
		 * At the end, return the appropriate value.
		 *
		 * Please create appropriate classes, and use appropriate data
		 * structures as necessary.
		 *
		 * Do not print anything in this method.
		 *
		 * Submit this entire program (not just this method) as your answer
		 */
		// HashMap to store Software data
		HashMap<String, Software> hashMap = new HashMap<>();
		for (int i = 0; i < array.size(); i++) {
			String[] string = array.get(i).toString().split(",");
			Software software = null;
			if (!hashMap.containsKey(string[2])) {
				software = new Software(string[2], string[1]);
				software.versionList.add(new Version(string[3], string[0]));
				hashMap.put(string[2], software);
			} else {
				software = hashMap.get(string[2]);
				software.versionList.add(new Version(string[3], string[0]));
			}
		}
		int totalcount = 0;
		for (Map.Entry<String, Software> map : hashMap.entrySet()) {
			List<Version> list = map.getValue().versionList;
			Collections.sort(list);
			System.out.println(map.getValue().toString());
			for (int i = 1; i < list.size(); i++) {
				if (!list.get(i).version.equals(list.get(i - 1).version)
						&& !list.get(i).servername.equals(list.get(i - 1).servername)) {
					if (list.size() - i > 2) {
						totalcount++;
						break;
					}
				}
			}
		}
		return totalcount;
	}

	public static void main(String[] args) {
		ArrayList<String> inputData = new ArrayList<String>();
		try {
			String workingDir = System.getProperty("user.dir") + "\\input.txt";
			Scanner in = new Scanner(new BufferedReader(new FileReader(workingDir)));
			while (in.hasNextLine()) {
				String line = in.nextLine().trim();
				if (!line.isEmpty()) // Ignore blank lines
					inputData.add(line);
			}
			in.close();
			Main obj = new Main();
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
