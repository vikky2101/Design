package parking_lot.src.main.java.parkinglot.model;

public class Vehicle {

  private String color;

  private String registrationNumber;

  public Vehicle(String registrationNumber, String color) {
    this.registrationNumber = registrationNumber;
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "color='" + color + '\'' +
        ", registrationNumber='" + registrationNumber + '\'' +
        '}';
  }
}
