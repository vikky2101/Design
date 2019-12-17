package parking_lot.src.main.java.parkinglot.exception;

public class ParkingException extends Exception {

  private ErrorCode errorCode;

  private String excMsg;

  public ParkingException(ErrorCode errorCode) {
    super(errorCode.getErrorMsg());
    this.errorCode = errorCode;
    this.excMsg = errorCode.getErrorMsg();
  }

  public ParkingException(ErrorCode errorCode, String excMsg) {
    super(errorCode.getErrorMsg());
    this.errorCode = errorCode;
    this.excMsg = excMsg;
  }

  public ParkingException(ErrorCode errorCode, Throwable exc) {
    super(errorCode.getErrorMsg(), exc);
    this.errorCode = errorCode;
    this.excMsg = errorCode.getErrorMsg();
  }

  @Override
  public String getMessage(){
    return errorCode.getErrorMsg()+" : "+excMsg;
  }

}
