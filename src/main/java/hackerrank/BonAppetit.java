package hackerrank;

public class BonAppetit {

    public String divideTheBill(int[] items, int notEaten, int forAnna) {
        int sum = 0;
        for (int i = 0; i < items.length; i++) {
            if (i != notEaten) {
                sum += items[i];
            }
        }
        int annasPart = sum / 2;
        return forAnna == annasPart ? "Bon Appetit" : String.valueOf(forAnna - annasPart);
    }

}
