package model.bean.exam;

public class Product {
  private int id ;
  private String  name;
  private double  price;
  private  int  amount ;
  private String  color ;
  private String  description ;
  Category  category ;

    public Product(String name, double price, int amount, String color, String description, Category category) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public Product(int id, String name, double price, int amount, String color, String description, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
