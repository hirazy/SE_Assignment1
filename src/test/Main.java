package test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO: your code here
        BookManager bookManage = new BookManager();
        int n = 10;
        Scanner sc = new Scanner(System.in);
        while (n != 0) {
            System.out.println("------------------------------------");
            System.out.println("1. list all books");
            System.out.println("2. add a new book");
            System.out.println("3. edit book");
            System.out.println("4. delete a book");
            System.out.println("5. search books by name");
            System.out.println("6. sort book descending by price");
            System.out.println();
            System.out.println("0. save & exit");
            System.out.println("------------------------------------");
            System.out.print("Your option: ");
            n = sc.nextInt();
            switch( n ) {
                case 0:
                    bookManage.saveToFile();
                    break;
                case 1:
                    bookManage.loadFromFile();
                    bookManage.printBooks(bookManage.books);
                    break;
                case 2:
                    bookManage.loadFromFile();
                    int id;
                    String name;
                    double price;
                    System.out.print("Enter book id: ");
                    id = sc.nextInt();
                    System.out.print("Enter book name: ");
                    sc.nextLine();
                    name = sc.nextLine();
                    System.out.print("Enter book price: ");
                    price = sc.nextDouble();
                    Book book = new Book(id,name,price);
                    bookManage.add(book);
            }

            }
        }
    }