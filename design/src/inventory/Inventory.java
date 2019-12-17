package inventory;

public class Inventory {

  protected String itemType;
  protected int itemPrice;
  protected int itemCount;

  public Inventory(String itemType, int itemPrice, int itemCount) {
    this.itemCount = itemCount;
    this.itemPrice = itemPrice;
    this.itemType = itemType;
  }

  public Inventory(String itemType, int itemCount) {
    this.itemCount = itemCount;
    this.itemType = itemType;
  }


  public String getItemType() {
    return itemType;
  }

  public void setItemType(String itemType) {
    this.itemType = itemType;
  }

  public int getItemPrice() {
    return itemPrice;
  }

  public void setItemPrice(int itemPrice) {
    this.itemPrice = itemPrice;
  }

  public int getItemCount() {
    return itemCount;
  }

  public void setItemCount(int itemCount) {
    this.itemCount = itemCount;
  }


}
