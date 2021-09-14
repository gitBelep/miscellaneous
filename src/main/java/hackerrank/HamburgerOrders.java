package hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HamburgerOrders {

    public List<Integer> reciving(List<List<Integer>> orders) {
        int size = orders.size();
        List<Order> orderList = new ArrayList<>(size);
        for (int i = 0; i < orders.size(); i++) {
            orderList.add(new Order(i, orders.get(i)));
        }

        orderList.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if (o1.getReady() > o2.getReady()) {
                    return 1;
                } else if (o1.getReady() < o2.getReady()) {
                    return -1;
                } else {
                    if (o1.getI() > o2.getI()) {
                        return 1;
                    } else if (o1.getI() < o2.getI()) {
                        return -1;
                    }
                }
                return 0;
            }
        } );

        List<Integer> result = new ArrayList<>(size);
        for (Order actual : orderList) {
            result.add(actual.getI() + 1);
        }
        return result;
    }

}


class Order {
    private final int i;
    private final int ready;

    public Order(int i, List<Integer> ready) {
        this.i = i;
        this.ready = ready.get(0) + ready.get(1);
    }

    public int getI() {
        return i;
    }

    public int getReady() {
        return ready;
    }

}
