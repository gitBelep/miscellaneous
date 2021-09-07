package hackerrank;

public class BonAppetit {

    public String divideTheBill(int[] items, int notEaten, int annasPart) {
        int sum = 0;
        for (int i = 0; i < items.length; i++) {
            if (i != notEaten) {
                sum += items[i];
            }
        }
        int forAnna = sum / 2;
        int difference =  annasPart - forAnna;
        return difference == 0 ? "Bon Appetit" : ""+difference;
    }

}
