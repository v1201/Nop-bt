public class Book {
  String id;
  String name;
  String author;
  Float price;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Float getPrice() {
    return this.price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Book(String id, String name, String author, Float price) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.price = price;
  }
}
