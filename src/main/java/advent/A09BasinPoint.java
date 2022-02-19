package advent;

import java.util.Objects;

public class A09BasinPoint {
    private final int r;
    private final int c;
    private final int value;
    private int basinParts;

    public A09BasinPoint(int r, int c, int value) {
        this.r = r;
        this.c = c;
        this.value = value;
        this.basinParts = 1;  //itself
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getValue() {
        return value;
    }

    public void addBasinPart(){
        this.basinParts += 1;
        //System.out.println(this);
    }

    public int getBasinParts() {
        return basinParts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A09BasinPoint that = (A09BasinPoint) o;
        return r == that.r && c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }

    @Override
    public String toString() {
        return "(" + r + "," + c +")" + value + "~"+ basinParts +';';
    }

}
