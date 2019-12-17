package parking_lot.src.main.java.parkinglot.constants;

public enum Action {
  CREATE_PARKING_LOT("create_parking_lot"),
  PARK("park"),
  LEAVE("leave"),
  STATUS("status"),
  REG_NUMBER_CARS_COLOR("registration_numbers_for_cars_with_colour"),
  SLOTS_NUMBER_CARS_COLOR("slot_numbers_for_cars_with_colour"),
  SLOTS_NUMBER_REG_NUMBER("slot_number_for_registration_number"),
  INVALID_ACTION("invalid request");

  private String action;

  Action(String action) {
    this.action = action;
  }

  public String getName() {
    return action;
  }

  public static Action getEnum(String str) {
    if (CREATE_PARKING_LOT.getName().equalsIgnoreCase(str)) {
      return CREATE_PARKING_LOT;
    } else if (PARK.getName().equalsIgnoreCase(str)) {
      return PARK;
    } else if (LEAVE.getName().equalsIgnoreCase(str)) {
      return LEAVE;
    } else if (STATUS.getName().equalsIgnoreCase(str)) {
      return STATUS;
    } else if (REG_NUMBER_CARS_COLOR.getName().equalsIgnoreCase(str)) {
      return REG_NUMBER_CARS_COLOR;
    } else if (SLOTS_NUMBER_CARS_COLOR.getName().equalsIgnoreCase(str)) {
      return SLOTS_NUMBER_CARS_COLOR;
    } else if (SLOTS_NUMBER_REG_NUMBER.getName().equalsIgnoreCase(str)) {
      return SLOTS_NUMBER_REG_NUMBER;
    } else {
      return INVALID_ACTION;
    }
  }

}
