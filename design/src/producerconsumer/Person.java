package producerconsumer;

public class Person {

  private String name;

  public Person(String name, int phoneNo) {
    this.name = name;
    this.phoneNo = phoneNo;
  }

  private int phoneNo;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(int phoneNo) {
    this.phoneNo = phoneNo;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", phoneNo=" + phoneNo +
        '}';
  }
}
