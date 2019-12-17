package parking_lot.src.main.java.parkinglot.service.impl;

import java.util.List;
import parking_lot.src.main.java.parkinglot.core.IParkingManager;
import parking_lot.src.main.java.parkinglot.model.Vehicle;
import parking_lot.src.main.java.parkinglot.service.IParkingService;

public class ParkingServiceImpl implements IParkingService {

  private IParkingManager parkingManager;

  public ParkingServiceImpl(IParkingManager parkingManager) {
    this.parkingManager = parkingManager;
  }

  public String createParkingLot(int capacity) {
    return this.parkingManager.createParkingLot(capacity);
  }

  public String park(Vehicle vehicle) throws Exception {
    return this.parkingManager.park(vehicle);
  }

  public String release(int slotNumber) throws Exception {
    return this.parkingManager.release(slotNumber);
  }

  public List<String> getStatus() throws Exception {
    return this.parkingManager.getStatus();
  }

  public List<String> getAllRegistrationNumbersForColor(String color) throws Exception {
    return this.parkingManager.getAllRegistrationNumbersForColor(color);
  }

  public String getSlotNumberForRegistration(String registrationNumber) throws Exception {
    return this.parkingManager.getSlotNumberForRegistration(registrationNumber);
  }

  public List<Integer> getAllSlotNumbersForColor(String color) throws Exception {
    return this.parkingManager.getAllSlotNumbersForColor(color);
  }
}
