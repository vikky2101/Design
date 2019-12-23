package parking_lot.src.test.java.parkinglot.service;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import parking_lot.src.main.java.parkinglot.core.IParkingManager;
import parking_lot.src.main.java.parkinglot.core.IStrategy;
import parking_lot.src.main.java.parkinglot.core.impl.CarParkingManager;
import parking_lot.src.main.java.parkinglot.core.impl.NearestParkingStrategy;
import parking_lot.src.main.java.parkinglot.exception.ParkingServiceException;
import parking_lot.src.main.java.parkinglot.model.Car;
import parking_lot.src.main.java.parkinglot.service.IParkingService;
import parking_lot.src.main.java.parkinglot.service.impl.ParkingServiceImpl;

public class ParkingService {

  IStrategy strategy = new NearestParkingStrategy();
  IParkingManager<Car> parkingManager = new CarParkingManager<>(strategy);
  IParkingService parkingService = new ParkingServiceImpl(parkingManager);

  @Test(expected = ParkingServiceException.class)
  public void park_invalid() throws Exception {
    String msg = parkingService.park(new Car("KA-01-HH-1234", "White"));
    Assert.assertEquals("Created a parking lot with 6 slots", msg);
  }

  @Test
  public void createParkingLot() throws Exception {
    String msg = parkingService.createParkingLot(6);
    Assert.assertEquals("Created a parking lot with 6 slots", msg);
  }

  @Test
  public void park_valid() throws Exception {
    parkingService.createParkingLot(6);
    String msg = parkingService.park(new Car("KA-01-HH-1234", "White"));
    Assert.assertEquals("Allocated slot number: 1", msg);
  }

  @Test
  public void park_slot_full() throws Exception {
    parkingService.createParkingLot(2);
    parkingService.park(new Car("KA-01-HH-1234", "White"));
    parkingService.park(new Car("KA-01-HH-1235", "White"));
    String msg = parkingService.park(new Car("KA-01-HH-1224", "White"));
    Assert.assertEquals("Sorry, parking lot is full", msg);
  }

  @Test
  public void mix_tc() throws Exception {
    String msg = parkingService.createParkingLot(6);
    Assert.assertEquals("Created a parking lot with 6 slots", msg);
    msg = parkingService.park(new Car("KA-01-HH-1234", "White"));
    Assert.assertEquals("Allocated slot number: 1", msg);
    msg = parkingService.park(new Car("KA-01-HH-1235", "White"));
    Assert.assertEquals("Allocated slot number: 2", msg);
    List<String> list = parkingService.getStatus();
    Assert.assertNotNull(list);
    Assert.assertEquals(2, list.size());
    list = parkingService.getAllRegistrationNumbersForColor("White");
    Assert.assertNotNull(list);
    Assert.assertEquals(2, list.size());
    msg = parkingService.getSlotNumberForRegistration("KA-01-HH-1234");
    Assert.assertEquals("1", msg);
    List<Integer> slots = parkingService.getAllSlotNumbersForColor("White");
    Assert.assertNotNull(list);
    Assert.assertEquals(2, list.size());
    msg = parkingService.release(1);
    Assert.assertEquals("Slot number 1 is free", msg);
  }

}
