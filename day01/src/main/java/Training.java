public class Training {
    private String name;
    private int numberOfDays;
    private double price;

    public Training(String name, int numberOfDays, double price) {
        this.name = name;
        this.numberOfDays = numberOfDays;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Training{" +
                "name='" + name + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", price=" + price +
                '}';
    }
}
