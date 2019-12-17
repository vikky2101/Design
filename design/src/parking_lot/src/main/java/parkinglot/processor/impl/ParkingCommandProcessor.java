package parking_lot.src.main.java.parkinglot.processor.impl;

import java.util.List;
import parking_lot.src.main.java.parkinglot.constants.Action;
import parking_lot.src.main.java.parkinglot.exception.ErrorCode;
import parking_lot.src.main.java.parkinglot.exception.ParkingInvalidRequestException;
import parking_lot.src.main.java.parkinglot.model.Car;
import parking_lot.src.main.java.parkinglot.processor.IRequestProcessor;
import parking_lot.src.main.java.parkinglot.service.IParkingService;

public class ParkingCommandProcessor implements IRequestProcessor {

  private IParkingService parkingService;

  public ParkingCommandProcessor(IParkingService parkingService) {
    this.parkingService = parkingService;
  }

  /**
   * process input and generate action command that can be interpreted by parking service
   *
   * @param input
   * @throws Exception
   */
  public void process(String input) throws Exception {
    String command[] = input.split(" ");
    String msg;
    List<String> msgList;
    List<Integer> slotList;
    try {
      switch (Action.getEnum(command[0])) {
        case CREATE_PARKING_LOT:
          try {
            msg = parkingService.createParkingLot(Integer.parseInt(command[1]));
            System.out.println(msg);
          } catch (NumberFormatException exc) {
            throw new ParkingInvalidRequestException(ErrorCode.INVALID_REQUEST,
                command[0] + " " + command[1]);
          }
          break;
        case PARK:
          // to do input validation
          msg = parkingService.park(new Car(command[1], command[2]));
          System.out.println(msg);
          break;
        case LEAVE:
          try {
            msg = parkingService.release(Integer.valueOf(command[1]));
            System.out.println(msg);
          } catch (NumberFormatException exc) {
            throw new ParkingInvalidRequestException(ErrorCode.INVALID_REQUEST,
                command[0] + " " + command[1]);
          }
          break;
        case STATUS:
          msgList = parkingService.getStatus();
          System.out.println("Slot No.    Registration No    Colour");
          for (String s : msgList) {
            System.out.println(s);
          }
          break;
        case REG_NUMBER_CARS_COLOR:
          // to do input validation
          msgList = parkingService.getAllRegistrationNumbersForColor(command[1]);
          StringBuilder sb = new StringBuilder();
          for (String s : msgList) {
            sb.append(s).append(", ");
          }
          System.out.println(sb.substring(0, sb.length() - 2));
          break;
        case SLOTS_NUMBER_CARS_COLOR:
          // to do input validation
          slotList = parkingService.getAllSlotNumbersForColor(command[1]);
          sb = new StringBuilder();
          for (int t : slotList) {
            sb.append(t).append(", ");
          }
          System.out.println(sb.substring(0, sb.length() - 2));
          break;
        case SLOTS_NUMBER_REG_NUMBER:
          // to do input validation
          String slot = parkingService.getSlotNumberForRegistration(command[1]);
          System.out.println(slot);
          break;
        default:
          throw new ParkingInvalidRequestException(ErrorCode.INVALID_REQUEST, command[0]);
      }

    } catch (Exception e) {
      throw e;
    }
  }

  public void setService(IParkingService service) {
    this.parkingService = service;
  }
}
