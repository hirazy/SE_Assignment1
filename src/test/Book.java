package test;

public class Book {
    // TODO: your code here
    // attributes id, name, price
    int id;
    String name;
    Double price;

    // constructor
    public Book(int id, String name, double price) {
        // TODO: your code here
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        // TODO: your code here
        this.name = name;
    }

    public void setPrice(double price) {
        // TODO: your code here
        this.price = price;
    }

    /**
     * return this as a String in the required format
     */
    @Override
    public String toString() {
        // TODO: your code here
        String id = Integer.toString(this.id);
        String price = Double.toString(this.price);
        return id.concat(name).concat(price);
    }
}
