package parking_lot.src.main.java.parkinglot.core;

/**
 * facade interface for strategy
 */
public interface IStrategy {

  void addSlot(int slot);

  int getSlot();

  void removeSlot(int slot);
}
