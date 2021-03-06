package gyak.week14d02;

public class Item {
    private final String product;
    private final int price;

    public Item(String product, int price) {
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return product +" * "+ price +" Ft";
    }

}
