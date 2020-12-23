package vn.techmaster.topcar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Car {
  @JsonIgnore
  private int id;
  private String model;
  private String manufacturer;
  private int price;
  private int sales;
  private String photo;

  @Override
  public String toString() {
    return "Car [manufacturer=" + manufacturer + ", model=" + model + ", photo=" + photo + ", price=" + price + ", sales="
        + sales + "]";
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getSales() {
    return sales;
  }

  public void setSales(int sales) {
    this.sales = sales;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean matchWithKeyword(String keyword) {
    String keywordLowerCase = keyword.toLowerCase();
    return (model.toLowerCase().contains(keywordLowerCase) || manufacturer.toLowerCase().contains(keywordLowerCase));
  }
}
