package examples;

public class Book {
    private String title;
    private double price;
    private Publisher publisher;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public void buy(String store) {
        System.out.println(String.format("Buying %s from %s", this.title, store));
    }

    public void buy(String store, int quantity) {
        System.out.println(String.format("Buying %s items of %s from %s", quantity, this.title, store));
    }


    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", publisher=" + publisher +
                '}';
    }
}
