package parking_lot.src.main.java.parkinglot.exception;

public enum ErrorCode {

  INVALID_FILE("File doesn't exists"),
  INPUT_ERROR("Command line input error"),
  INVALID_REQUEST("Invalid or Unsupported Request Command"),
  PARKING_NOT_INIT("Parking not initialize"),
  NO_SLOT_AVAILABLE("Sorry, parking lot is full"),
  NOT_FOUND("Not found");

  private String errorMsg;

  ErrorCode(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public String getErrorMsg() {
    return this.errorMsg;
  }
}
