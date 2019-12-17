package parking_lot.src.main.java.parkinglot.service;

import java.util.List;
import parking_lot.src.main.java.parkinglot.model.Vehicle;

public interface IParkingService {

  String createParkingLot(int capacity) throws Exception;

  String park(Vehicle vehicle) throws Exception;

  String release(int slotNumber) throws Exception;

  List<String> getStatus() throws Exception;

  List<String> getAllRegistrationNumbersForColor(String color) throws Exception;

  String getSlotNumberForRegistration(String registrationNumber) throws Exception;

  List<Integer> getAllSlotNumbersForColor(String color) throws Exception;


}
