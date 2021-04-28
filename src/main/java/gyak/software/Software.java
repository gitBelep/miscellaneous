package gyak.software;

public abstract class Software {
    private String name;
    private double price;

    public Software(String name, int price) {
        this.name = name;
        this.price = price;
    }

    abstract void increasePrice();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
