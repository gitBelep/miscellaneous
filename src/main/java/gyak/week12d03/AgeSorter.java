package gyak.week12d03;

public class AgeSorter {

    public int[] sortAges(int[] ages) {
        int size = ages.length;
        int[] result = new int[size];
        for (int k = 0; k < size; k++) {
            int min = 200;
            int remember = -1;
            for (int i = 0; i < size; i++) {
                if (ages[i] < min) {
                    min = ages[i];
                    remember = i;
                }
            }
            ages[remember] = 200;
            result[k] = min;
        }
        return result;
    }

}
