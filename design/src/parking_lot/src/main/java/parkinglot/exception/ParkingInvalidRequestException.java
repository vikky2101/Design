package parking_lot.src.main.java.parkinglot.exception;

public class ParkingInvalidRequestException extends Exception {

  private ErrorCode errorCode;

  private String excMsg;

  public ParkingInvalidRequestException(ErrorCode errorCode) {
    super(errorCode.getErrorMsg());
    this.errorCode = errorCode;
    this.excMsg = errorCode.getErrorMsg();
  }

  public ParkingInvalidRequestException(ErrorCode errorCode, String excMsg) {
    super(errorCode.getErrorMsg());
    this.errorCode = errorCode;
    this.excMsg = excMsg;
  }

  public ParkingInvalidRequestException(ErrorCode errorCode, Throwable exc) {
    super(errorCode.getErrorMsg(), exc);
    this.errorCode = errorCode;
    this.excMsg = errorCode.getErrorMsg();
  }

  @Override
  public String getMessage(){
    return errorCode.getErrorMsg()+" : "+excMsg;
  }

}
