package DailyCodingProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PipesBH {
    // Example                       plant ->   (A,1), (B,5), (C,11)
    //                               A     ->   (B,2), (C,4)
    public List<House> findCheapestVariation(Map<String, Map<String, Integer>> web) {
        List<House> targets = new ArrayList<>();

        for (Map.Entry<String, Map<String, Integer>> e : web.entrySet()) {
            for (Map.Entry<String, Integer> in : e.getValue().entrySet()) {
                House actualHouse = new House(in.getKey(), e.getKey(), in.getValue());
                int index = targets.indexOf(actualHouse);
                System.out.println("index: "+ index);
                if(0 <= index ) {                          //contains a House with same name
                    House oldHouse = targets.get(index);
                    if(actualHouse.cost < oldHouse.cost ){
                        //System.out.println("Swap ~ actualHouse.cost: "+ actualHouse.cost +", oldHouse.cost: "+ oldHouse.cost);
                        targets.set(index, actualHouse);
                    }
                } else {
                    targets.add(actualHouse);
                    //System.out.println("No swap ~ House: "+ actualHouse);
                }
            }
        }
        return targets;
    }

}

class House {
    String name;
    String from;
    int cost;

    public House(String name, String from, int cost) {
        this.name = name;
        this.from = from;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return name.equals(house.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "{Name: "+ name +", from: " + from +", costs: " + cost +'}';
    }

}