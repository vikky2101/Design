package parking_lot.src.main.java.parkinglot.core.impl;

import java.util.TreeSet;
import parking_lot.src.main.java.parkinglot.core.IStrategy;

/**
 * NearestParkingStrategy - gives nearest vacant slot
 */
public class NearestParkingStrategy implements IStrategy {

  private TreeSet<Integer> freeSlots;

  public NearestParkingStrategy() {
    this.freeSlots = new TreeSet();
  }

  public void addSlot(int slot) {
    freeSlots.add(slot);
  }

  public int getSlot() {
    return freeSlots.first();
  }

  public void removeSlot(int slot) {
    freeSlots.remove(slot);

  }
}
