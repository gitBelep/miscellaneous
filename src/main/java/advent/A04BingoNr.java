package advent;

public class A04BingoNr {
    private final int nr;
    private boolean drawn;

    public A04BingoNr(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }

    public boolean isDrawn() {
        return drawn;
    }

    public void setDrawn() {
        this.drawn = true;
    }

    @Override
    public String toString() {
        return ""+ nr;
    }

}
