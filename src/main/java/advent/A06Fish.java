package advent;

public class A06Fish {
    private int counter;

    public A06Fish(int counter) {
        this.counter = counter;
    }

    public A06Fish getCloserToReproduce(){
        if(counter > 0) {
            this.counter--;
            return null;
        } else {
            this.counter = 6;
            return new A06Fish(8);
        }
    }

    @Override
    public String toString() {
        return " "+ counter;
    }

}
