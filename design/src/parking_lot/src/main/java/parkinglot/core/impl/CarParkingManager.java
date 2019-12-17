package parking_lot.src.main.java.parkinglot.core.impl;

import parking_lot.src.main.java.parkinglot.core.IParkingManager;
import parking_lot.src.main.java.parkinglot.core.IStrategy;
import parking_lot.src.main.java.parkinglot.exception.ErrorCode;
import parking_lot.src.main.java.parkinglot.exception.ParkingServiceException;
import parking_lot.src.main.java.parkinglot.model.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CarParkingManager - manages car parking for single level
 *
 * @param <V>
 */
public class CarParkingManager<V extends Vehicle> implements IParkingManager<V> {

  private IStrategy strategy;

  private AtomicInteger availability = new AtomicInteger();

  private int capacity;

  private Map<Integer, Optional<V>> slotMap;

  public CarParkingManager(IStrategy strategy) {
    this.strategy = strategy;
  }

  public String createParkingLot(int capacity) {
    this.slotMap = new ConcurrentHashMap<>(capacity);
    this.capacity = capacity;
    for (int i = 1; i <= capacity; i++) {
      slotMap.put(i, Optional.empty());
      this.strategy.addSlot(i);
    }
    this.availability.set(capacity);
    String str = String.format("Created a parking lot with %s slots", capacity);
    return str;

  }

  public String park(V vehicle) throws ParkingServiceException {
    if (slotMap == null) {
      throw new ParkingServiceException(ErrorCode.PARKING_NOT_INIT, "Please Check initialization");
    }
    if (availability.get() == 0) {
      return ErrorCode.NO_SLOT_AVAILABLE.getErrorMsg();
    } else {
      int slotNo = this.strategy.getSlot();
      this.slotMap.put(slotNo, Optional.of(vehicle));
      this.availability.decrementAndGet();
      this.strategy.removeSlot(slotNo);
      String str = String.format("Allocated slot number: %s", slotNo);
      return str;
    }
  }

  public String release(int slotNumber) throws ParkingServiceException {
    if (slotMap == null) {
      throw new ParkingServiceException(ErrorCode.PARKING_NOT_INIT);
    }
    this.slotMap.put(slotNumber, Optional.empty());
    this.availability.incrementAndGet();
    this.strategy.addSlot(slotNumber);
    String str = String.format("Slot number %s is free", slotNumber);
    return str;
  }

  public List<String> getStatus() throws ParkingServiceException {
    if (slotMap == null) {
      throw new ParkingServiceException(ErrorCode.PARKING_NOT_INIT);
    }
    List<String> status = new ArrayList<>();
    for (int i = 1; i <= capacity; i++) {
      Optional<V> optional = this.slotMap.get(i);
      if (optional.isPresent()) {
        StringBuilder sb = new StringBuilder();
        sb.append(i).append("           ").append(optional.get().getRegistrationNumber())
            .append("      ")
            .append(optional.get().getColor());
        status.add(sb.toString());
      }
    }
    return status;
  }

  public List<String> getAllRegistrationNumbersForColor(String color)
      throws ParkingServiceException {
    if (slotMap == null) {
      throw new ParkingServiceException(ErrorCode.PARKING_NOT_INIT);
    }
    List<String> allRegNos = new ArrayList<>();
    for (int i = 1; i <= capacity; i++) {
      Optional<V> optional = this.slotMap.get(i);
      if (optional.isPresent() && color.equalsIgnoreCase(optional.get().getColor())) {
        StringBuilder sb = new StringBuilder();
        sb.append(optional.get().getRegistrationNumber());
        allRegNos.add(sb.toString());
      }
    }
    return allRegNos;
  }

  public String getSlotNumberForRegistration(String registrationNumber)
      throws ParkingServiceException {
    if (slotMap == null) {
      throw new ParkingServiceException(ErrorCode.PARKING_NOT_INIT);
    }
    String slotNo = ErrorCode.NOT_FOUND.getErrorMsg();
    for (int i = 1; i <= capacity; i++) {
      Optional<V> optional = this.slotMap.get(i);
      if (optional.isPresent() && registrationNumber
          .equalsIgnoreCase(optional.get().getRegistrationNumber())) {
        return String.valueOf(i);
      }
    }
    return slotNo;
  }

  public List<Integer> getAllSlotNumbersForColor(String color) throws ParkingServiceException {
    if (slotMap == null) {
      throw new ParkingServiceException(ErrorCode.PARKING_NOT_INIT);
    }
    List<Integer> allSlots = new ArrayList<>();
    for (int i = 1; i <= capacity; i++) {
      Optional<V> optional = this.slotMap.get(i);
      if (optional.isPresent() && color.equalsIgnoreCase(optional.get().getColor())) {
        allSlots.add(i);
      }
    }
    return allSlots;
  }
}
