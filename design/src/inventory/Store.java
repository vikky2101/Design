package inventory;

import java.util.HashMap;
import java.util.Map;

public class Store {

  private String countryLocation;
  private Map<String, Inventory> inventories;

  public String getCountryLocation() {
    return countryLocation;
  }

  public void setCountryLocation(String countryLocation) {
    this.countryLocation = countryLocation;
  }

  public Map<String, Inventory> getInventories() {
    return inventories;
  }

  public void setInventories(Map<String, Inventory> inventories) {
    this.inventories = inventories;
  }

  public Store(String country, Inventory... inventories) {
    this.countryLocation = country;
    this.inventories = new HashMap<String, Inventory>();
    for (Inventory inventory : inventories) {
      this.inventories.put(inventory.getItemType(), inventory);
    }
  }

}
