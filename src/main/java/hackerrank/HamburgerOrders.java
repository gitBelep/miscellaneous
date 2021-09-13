package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class HamburgerOrders {

    public void reciving(List<List<Integer>> orders){
        List<Order> orderList = new ArrayList<>();
        for(int i = 0; i < orders.size(); i++){
            orderList.add(new Order(i, orders.get(i)));
        }

    }


}

class Order{
    private int i;
    private int ready;

    public Order(int i, List<Integer> ready) {
        this.i = i;
        this.ready = ready.get(0) + ready.get(1);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getReady() {
        return ready;
    }

    public void setReady(int ready) {
        this.ready = ready;
    }

}
