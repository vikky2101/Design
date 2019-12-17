package parking_lot.src.main.java.parkinglot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import parking_lot.src.main.java.parkinglot.core.IParkingManager;
import parking_lot.src.main.java.parkinglot.core.IStrategy;
import parking_lot.src.main.java.parkinglot.core.impl.CarParkingManager;
import parking_lot.src.main.java.parkinglot.core.impl.NearestParkingStrategy;
import parking_lot.src.main.java.parkinglot.exception.ErrorCode;
import parking_lot.src.main.java.parkinglot.exception.ParkingException;
import parking_lot.src.main.java.parkinglot.exception.ParkingInvalidRequestException;
import parking_lot.src.main.java.parkinglot.model.Car;
import parking_lot.src.main.java.parkinglot.processor.IRequestProcessor;
import parking_lot.src.main.java.parkinglot.processor.impl.ParkingCommandProcessor;
import parking_lot.src.main.java.parkinglot.service.impl.ParkingServiceImpl;

/**
 * Driver of parking lot application
 */
public class Application {

  public static void main(String[] args) {
    // Choose parking strategy here
    IStrategy strategy = new NearestParkingStrategy();
    // choose parkingManager with specific strategy implementation
    IParkingManager<Car> parkingManager = new CarParkingManager<>(strategy);
    // create parking lot command  processor
    // parking service is facade service invoked by processor
    // parking service invokes underlying implementation of parking manager
    IRequestProcessor processor = new ParkingCommandProcessor(new ParkingServiceImpl(parkingManager));
    // System.out.println("========================Welcome====================================");
    try {
      if (args.length == 0) {
        processCommandBasesInput(processor);
      } else {
        processFileBasedInput(processor, args[0]);
      }
    } catch (Exception exc) {
      System.out.println(exc.getMessage());
      //exc.printStackTrace();
    }
  }

  /**
   * process file based input
   *
   * @param processor
   * @param fileName
   * @throws ParkingException
   */
  private static void processFileBasedInput(IRequestProcessor processor, String fileName)
      throws ParkingException, IOException {
     //System.out.println("==============My Parking Lot Started File Mode=====================");
    int lineNumber = 0;
    File file = new File(fileName);
    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    while (true) {
      try {
        String input;
        while ((input = bufferedReader.readLine()) != null) {
          lineNumber++;
          processor.process(input.trim());
        }
        if (input == null) {
          break;
        }
      } catch (ParkingInvalidRequestException exc) {
        // print error input description and continue processing next line
        System.out.println("Line no : " + lineNumber + " " + exc.getMessage());
      }
      catch (FileNotFoundException exc) {
        throw new ParkingException(ErrorCode.INVALID_FILE, fileName);
      }
      catch (Exception e) {
        System.out.println("Line no : " + lineNumber + " " + e.getMessage());
      }
    }
  }

  /**
   * process command line input
   *
   * @param processor
   */
  private static void processCommandBasesInput(IRequestProcessor processor) throws ParkingException {
     //System.out.println("==============My Parking Lot Started Command Line Mode=============");
     //System.out.println("==============Enter 'exit' to stop the application==================");
     //System.out.println("==============Enter input command===================================");
    BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
    while (true) {
      String input;
      try {
        input = bufferedReader.readLine().trim();
        if ("exit".equalsIgnoreCase(input)) {
          bufferedReader.close();
          break;
        } else {
          processor.process(input);
        }
      } catch (ParkingInvalidRequestException exc) {
        // log error and continue
        System.out.println(exc.getMessage());
      } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new ParkingException(ErrorCode.INPUT_ERROR, e);
      }
    }
  }

}
