package hotelmanagement;

import java.util.HashMap;

public class Hotel {

  private String rating;
  private String branchType;
  private HashMap<String, Integer> dayPrice;
  private HashMap<String, HashMap<String, Integer>> priceRate;

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getBranchType() {
    return branchType;
  }

  public void setBranchType(String branchType) {
    this.branchType = branchType;
  }

  public HashMap<String, Integer> getDayPrice() {
    return dayPrice;
  }

  public void setDayPrice(HashMap<String, Integer> dayPrice) {
    this.dayPrice = dayPrice;
  }

  public Integer getPriceRate(String customerType, String dayType) {
    return priceRate.get(customerType).get(dayType);
  }

  public void setPriceRate(HashMap<String, HashMap<String, Integer>> priceRate) {
    this.priceRate = priceRate;
  }

  public Hotel(String rating, String branchType,
      HashMap<String, HashMap<String, Integer>> priceRate) {
    this.rating = rating;
    this.branchType = branchType;
    this.priceRate = priceRate;
  }
}
