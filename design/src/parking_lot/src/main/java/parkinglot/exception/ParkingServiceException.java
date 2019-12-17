package parking_lot.src.main.java.parkinglot.exception;

public class ParkingServiceException extends Exception {

  private ErrorCode errorCode;

  private String excMsg;

  public ParkingServiceException(ErrorCode errorCode) {
    super(errorCode.getErrorMsg());
    this.errorCode = errorCode;
    this.excMsg = errorCode.getErrorMsg();
  }

  public ParkingServiceException(ErrorCode errorCode, String excMsg) {
    super(errorCode.getErrorMsg());
    this.errorCode = errorCode;
    this.excMsg = excMsg;
  }

  public ParkingServiceException(ErrorCode errorCode, Throwable exc) {
    super(errorCode.getErrorMsg(), exc);
    this.errorCode = errorCode;
    this.excMsg = errorCode.getErrorMsg();
  }

  @Override
  public String getMessage(){
    return errorCode.getErrorMsg()+" : "+excMsg;
  }

}
