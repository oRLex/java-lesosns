package lesson12.dao;

public class Book extends Identifiable {
  final String title;
  final String author;

  public Book(int id, String title, String author) {
    super(id);
    this.title = title;
    this.author = author;
  }
}
