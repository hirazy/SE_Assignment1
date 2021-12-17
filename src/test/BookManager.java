package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class BookManager {
    // TODO: your code here
    // attribute books
    ArrayList<Book> books;

    public BookManager() {
        // TODO: your code here
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        // TODO: your code here
        return books;
    }

    /**
     * update this.books by reading books from file books.txt
     */
    public void loadFromFile() throws FileNotFoundException {
        System.out.println("Loading books...");

        // TODO: your code here
        File f = new File(".\\book.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String stringId = line.substring(1,6).trim();
            String name = line.substring(6,51);
            String stringPrice = line.substring(51,61);
            int id = Integer.parseInt(stringId);
            double price = Double.parseDouble(stringPrice);
            Book book1 = new Book(id,name,price);
            books.add(book1);
        }

    }

    /**
     * print books (one/line) in required format
     */
    public void printBooks(ArrayList<Book> books) {
        // TODO: your code here
        System.out.format("%-5s %-45s %-10s","ID","Name","Price");
        System.out.println();
        for (Book book : books) {
            System.out.format("%5d %-45s %10.2f", book.id, book.name, book.price);
            System.out.println();
        }
    }

    /**
     * if book.id is not duplicated, add book to this.books
     * return whether added or not
     */
    public boolean add(Book book) throws FileNotFoundException {
        // TODO: your code here
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id != book.id) {
                books.add(book);
                System.out.println("Added successfully.");
                return true;
            }
        }
        System.out.println("Duplicated ID !");
        return false;
    }
    /**
     * return book specified by id, null if not found
     */
    public Book getBookById(int id) {
        // TODO: your code here
        for (Book book : books) {
            if (id != book.id) {
                return book;
            }
        }
        return null;
    }

    /**
     * delete book from this.books
     */
    public void delete(Book book) {
        // TODO: your code here
        boolean isDeleted = false;
        for (Book value : books) {
            if (book.id == value.id) {
                isDeleted = true;
                System.out.println("Deleted successfully");
                break;
            }
        }
        if (!isDeleted){
            System.out.println("Invalid ID !");
        }
    }

    /**
     * update this.books to be sorted by price from high -> low
     */
    public void sortDescByPrice() {
        // TODO: your code here
        ArrayList<Book> sortedByPrice = new ArrayList<>();
        Book tempo;
        for (int j = 0; j < books.size() - 1 ;j++){
            for ( int i = 0; i < books.size() - 1;i++){
                Book book1 = books.get(i);
                Book book2 = books.get(i+1);
                if (book1.price > book2.price) {
                    tempo = book1;
                    books.set(i,books.get(i+1));
                    books.set(i+1,tempo);
                    sortedByPrice = books;
                }
            }
        }
        System.out.format("%-5s %-45s %-10s","ID","Name","Price");
        System.out.println();
        for (Book book : sortedByPrice) {
            System.out.format("%5d %-45s %10.2f", book.id, book.name, book.price);
            System.out.println();

        }
    }


    /**
     * return all books having name contains keyword (case in-sensitive)
     */
    public ArrayList<Book> searchByName(String keyword) {
        ArrayList<Book> matches = new ArrayList<>();
        // TODO: your code here
        for (Book book : books) {
            if (book.name.contains(keyword.toLowerCase(Locale.ROOT))) {
                matches.add(book);
                return matches;
            }
        }
        return null;
    }
    /**
     * write this.books to file books.txt in required format
     */
    public void saveToFile() throws FileNotFoundException {
        // TODO: your code here
        File f = new File("book.txt");
        PrintWriter writer = new PrintWriter(f);
        for (Book book : books) {
            writer.printf("%5d %-45s %10.2f", book.id, book.name, book.price);
        }
        writer.close();
    }
}

