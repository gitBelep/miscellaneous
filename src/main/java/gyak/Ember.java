package gyak;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;

class EmberQueue{
    static Collator collHu = Collator.getInstance(new Locale("hu","HU"));

    public static Queue<Ember> eq = new PriorityQueue<>(new Comparator<Ember>() {
        @Override
        public int compare( Ember o1, Ember o2) {
            return collHu.compare(o1.getName(),o2.getName());
        }
    });

    static Ember findEmber(String name){
        for (Ember r : eq){
            if(name.equals(r.getName())){
                return r;
            }
        }
        return new Ember(0.0, "Nincs ilyen");
    }

    public static void main(String[] args) {
        eq.offer(new Ember(5.1,"G"));
        eq.offer(new Ember(6.1,"H"));
        eq.offer(new Ember(7.1,"J"));
        eq.offer(new Ember(4.1,"É"));
        System.out.println(eq);
        eq.offer(new Ember(3.1,"B"));
        System.out.println(eq);
        eq.offer(new Ember(2.1,"Á"));
        System.out.println(eq);
        eq.offer(new Ember(1.1,"A"));
        System.out.println(eq.poll());
        System.out.println(eq.poll());
        System.out.println(eq.poll());
        System.out.println(eq.poll());
        System.out.println(eq.remove(findEmber("H") ) +" ~ H-t remove for-each-csel");
        System.out.println(eq.remove(findEmber("Z") ) +" ~ Z-t remove for-each-csel");
        System.out.println(eq.poll());
        System.out.println(eq.poll());
        System.out.println(eq.poll());
        System.out.println(eq.poll());
    }
}

// - - - -

public class Ember {
    private double money;
    private String name;

    public Ember(double money, String name) {
        this.money = money;
        this.name = name;
    }

    @Override
    public String toString() {
        return name +": "+ money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
