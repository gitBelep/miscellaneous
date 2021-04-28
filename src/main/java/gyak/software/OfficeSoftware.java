package gyak.software;

public class OfficeSoftware extends Software{
    private double price;
    private String name;

    public OfficeSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        this.price = super.getPrice() * 1.05;
    }


}
