package inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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
			ArrayList<String> outputData = new ArrayList<String>();
			for (int i = 0; i < inputData.size(); i++) {
				outputData.add(OrderService.processOrder(inputData.get(i)));
			}
			workingDir = System.getProperty("user.dir") + "\\output.txt";
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(workingDir)));
			for (int i = 0; i < outputData.size(); i++) {
				outputData.add(OrderService.processOrder(outputData.get(i)));
			}
			output.close();
		} catch (IOException e) {
			System.out.println("IO error in input.txt or output.txt");
		}
	}

}
