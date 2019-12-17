package test;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class UniqueImage {

  public static class Image {

    private String filename;
    private int width;
    private int height;

    public Image(String filename, int width, int height) {
      this.filename = filename;
      this.width = width;
      this.height = height;
    }

    /**
     * Two Images are considered equal if they have the same filename
     * (without the extension), and the same number of pixels. Thus,
     * flag.jpg with width=60 height=40 is equal to flag.gif with width=40
     * and height=60
     */

    /**
     * Overdie hashcode because equal-hashcode contract in java
     **/
    public int hashCode() {
      int result = 17;
      result = 31 * result + filename.split("\\.")[0].hashCode();
      result = 31 * result + width * height;
      return result;
    }

    public boolean equals(Object other) {
      Image o = (Image) other;
      if (this == other) {
        return true;
      }
      if (other == null || other.getClass() != this.getClass()) {
        return false;
      }
      String[] temp1 = this.filename.split("\\.");
      String[] temp2 = o.filename.split("\\.");
      return (temp1[0].equals(temp2[0])) && width * height == o.width * o.height;
    }

    public String toString() {
      return "Image: filename=" + filename + " Size=" + width * height;
    }
  }

  public static void printImages(Set<Image> images) {
    for (Image image : images) {
      System.out.println(image);
    }
  }

  public static void main(String[] args) {
    Image[] images = {new Image("flag.jpg", 40, 60), new Image("flag.gif", 40, 60),
        new Image("smile.gif", 100, 200), new Image("smile.gif", 50, 400),
        new Image("other.jpg", 40, 60),
        new Image("lenna.jpg", 512, 512)};
    Set<Image> set = new HashSet<>(Arrays.asList(images));
    UniqueImage.printImages(set);
  }
}