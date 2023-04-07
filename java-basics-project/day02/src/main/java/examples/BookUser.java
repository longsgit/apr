package examples;

public class BookUser {
    public static void main(String[] args) {
        Book b1 = new Book("Golang tricks", 45.55);
        Publisher publisher = new Publisher("Apress");
        b1.setPublisher(publisher);
        System.out.println(b1);
        b1.buy("Amazon");
        b1.buy("Flipkart", 10);
        b1 = null; //Eligible for GC

    }
}
