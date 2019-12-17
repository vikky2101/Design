package parking_lot.src.main.java.parkinglot.core;

import java.util.List;
import parking_lot.src.main.java.parkinglot.model.Vehicle;

/**
 * facade interface for any type of parking manager
 * @param <V>
 */
public interface IParkingManager<V extends Vehicle> {

  String createParkingLot(int capacity);

  String park(V vehicle) throws Exception;

  String release(int slotNumber) throws Exception;

  List<String> getStatus() throws Exception;

  List<String> getAllRegistrationNumbersForColor(String color) throws Exception;

  String getSlotNumberForRegistration(String registrationNumber) throws Exception;

  List<Integer> getAllSlotNumbersForColor(String color) throws Exception;
}
