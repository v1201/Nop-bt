import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;

public class Main {
  public static void main(String[] args) {
    int choice;
    Scanner sc = new Scanner(System.in);
    ArrayList<Book> books = new ArrayList<Book>();
    do {
      System.out.println("1. Add book records");
      System.out.println("2. Save");
      System.out.println("3. Display book records");
      System.out.println("4. Exit");
      System.out.print("Please enter your choice: ");
      choice = Integer.parseInt(sc.nextLine());
      switch (choice) {
        case 1:
          String bookId;
          String bookName;
          String bookAuthor;
          Float bookPrice;

          System.out.print("Enter book ID: ");
          bookId = sc.nextLine();

          System.out.print("Enter book name: ");
          bookName = sc.nextLine();

          System.out.print("Enter author: ");
          bookAuthor = sc.nextLine();

          System.out.print("Enter price: ");
          bookPrice = Float.parseFloat(sc.nextLine());

          Book book = new Book(bookId, bookName, bookAuthor, bookPrice);

          books.add(book);
          break;

        case 2:
          FileOutputStream fos = null;
          ObjectOutputStream oos = null;
          try {
            fos = new FileOutputStream(
                "/Users/hung/Documents/DEV/APTECH/Term_2/JAVA_CORE/Le-Vinh-Hung-TH2109030/books.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeInt(books.size());
            for (int i = 0; i < books.size(); i++) {
              oos.writeObject(books.get(i));
            }

          } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          } finally {
            try {
              oos.close();
              fos.close();
            } catch (Exception ex) {
              System.out.println("Error!");
            }

          }
          books.clear();
          System.out.println("Success!");

        case 3:
          System.out.println("BookID" + "      " + "Book Name" + "      " + "Author" + "      " + "Price");
          for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println(b.id + "     " + b.name + "     " + b.author + "     " + "$" + b.price);
          }
          break;

        default:
          break;
      }
    } while (choice != 4);
  }
}
