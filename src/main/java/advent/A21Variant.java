package advent;

public class A21Variant {
    private long universe;
    private int place;
    private int point;

    public A21Variant(long universe, int place, int point) {
        this.universe = universe;
        this.place = place;
        this.point = point;
    }

    public long getUniverse() {
        return universe;
    }

    public int getPlace() {
        return place;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "Univ=" + universe +
                ", place=" + place +
                ", pt=" + point;
    }
}
