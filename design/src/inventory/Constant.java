package inventory;

import java.util.regex.Pattern;

public class Constant {

  public static final String IPOD = "IPOD";
  public static final String IPHONE = "IPHONE";
  public static final String BRAZIL = "BRAZIL";
  public static final String ARGENTINA = "ARGENTINA";
  public static final int BRAZIL_IPHONE_PRICE = 100;
  public static final int BRAZIL_IPHONE_COUNT = 100;
  public static final int BRAZIL_IPOD_PRICE = 65;
  public static final int BRAZIL_IPOD_COUNT = 100;
  public static final int ARG_IPHONE_PRICE = 150;
  public static final int ARG_IPHONE_COUNT = 50;
  public static final int ARG_IPOD_PRICE = 100;
  public static final int ARG_IPOD_COUNT = 100;
  public static final Pattern BRAZIL_REGEX = Pattern.compile("B[0-9]{3}[A-Z]{2}[A-Z0-9]{7}");
  public static final Pattern ARGENTINA_REGEX = Pattern.compile("A[A-Z]{2}[A-Z0-9{9}]");

}
