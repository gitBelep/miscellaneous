package streams;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OrderService {
    private List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order) {
        orders.add(order);
    }

    //Határozd meg a rendelések darabszámát egy paraméterként kapott státusz alapján!
    public int countOrderWithStatus(String status) {
        return (int) orders.stream()
                .map(Order::getStatus)
                .filter(stat -> stat.equals(status))
                .count();
        //orders.stream() .filter(o -> o.getStatus().equals(status))
        //                .count();
    }

    // Gyűjtsd össze azokat a rendeléseket, amelyekben van egy paraméterként kapott kategóriájú termék!
    public List<Order> ordersByCategory(String category) {
        Predicate<Product> containsCategory = product -> {
            return product.getCategory()
                    .equals(category);
        };
        Predicate<Order> containsProductWithCategory = o -> {
            return o.getProducts()
                    .stream()
                    .anyMatch(p -> containsCategory.test(p));
            //.anyMatch(containsCategory::test);
            //.anyMatch(containsCategory);
        };
        return orders.stream()
                .filter(containsProductWithCategory::test)
                .collect(Collectors.toList());
    }

    public List<Order> ordersByCategoryKris(String category) {
        return orders.stream()
                .filter(o -> o.getProducts()
                        .stream()
                        .anyMatch(product -> product.getCategory()
                                .equals(category)))
                .collect(Collectors.toList());
    }

    //Gyűjtsd össze a termékeket a rendelésekből,amelyeknek egy paraméterül kapott összegnél magasabb az áruk!
    public List<Product> listProductsWithGreaterPriceAs(int price){
        return orders.stream()
                .map(Order::getProducts)
                .flatMap(p -> p.stream())
                // .flatMap(order -> order.getProducts().stream())
                .filter(p -> p.getPrice() > price)
                .collect(Collectors.toList());
    }

    //metódus paraméterként vár két dátumot, és adjuk vissza a két dátum közötti árbevételt,
    public double incomesBetween(LocalDate startDate, LocalDate endDate){
        return orders.stream()
                .filter(o ->o.getOrderDate().isAfter(startDate))
                .filter(o -> o.getOrderDate().isBefore(endDate))
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    //      Keressünk meg egy terméket a neve alapján, amit paraméterként lehet megadni!
    public Product findProduct(String name){
        return orders.stream()
                .flatMap(o -> o.getProducts().stream())
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow( () -> new IllegalArgumentException("No such product."));
    }

    //      Adjuk vissza azt a rendelést, ami a legdrágább terméket tartalmazza! Ha több ilyen van, bármelyiket.
    public Order findOrderWithMostExpensiveProduct(){
        Double maxPrice = orders.stream()
                .flatMap(o -> o.getProducts().stream())
                .map(prod -> prod.getPrice())
                .max(Double::compareTo)
                .get();

        return orders.stream()
                .filter(o ->  o.getProducts().stream()
                        .anyMatch(p -> p.getPrice() == maxPrice))
                .findFirst().orElse( new Order("non existing", LocalDate.now()) );
    }

}
