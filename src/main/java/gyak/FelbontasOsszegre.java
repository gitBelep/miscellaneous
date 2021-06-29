package gyak;

public class FelbontasOsszegre {

    public int bontsdFel(int part, int number) {
        checkData(part, number);
        int a = 0;
        int b = 0;
        int c;
        int d;
        int max = number - part + 1;
        int counter = 0;


        if (part == 2) {
            for (c = 1; c <= max - a - b - 2 + part; c++) {
                d = max - a - b - c - 1 + part;
                counter++;
                System.out.println(a + "+" + b + "+" + c + "+" + d);
            }
        }

        if (part == 3) {
            for (b = 1; b <= max - a - 3 + part; b++) {
                for (c = 1; c <= max - a - b - 2 + part; c++) {
                    d = max - a - b - c - 1 + part;
                    counter++;
                    System.out.println(a + "+" + b + "+" + c + "+" + d);
                }
            }
        }

        if (part == 4) {
            for (a = 1; a <= max; a++) {
                for (b = 1; b <= max - a - 3 + part; b++) {
                    for (c = 1; c <= max - a - b - 2 + part; c++) {
                        counter++;
                        d = max - a - b - c - 1 + part;
                        System.out.println(a + "+" + b + "+" + c + "+" + d);
                    }
                }
            }
        }

        System.out.println(" *" );
        return counter;
    }

    private void checkData(int part, int number) {
        if (number < part) {
            throw new IllegalArgumentException("A felbontandó szám legalább akkora legyen, mint a tagok száma!");
        }
        if (part < 2 || 4 < part) {
            throw new IllegalArgumentException("A tagok száma legalább 2 legfeljebb 4 legyen!");
        }
    }


    public int howMany(int part, int number) {
        int result = 0;
        if (part == 2) { return number - 1; }
        if (part == 3) { result = three(number); }
        if (part == 4) { result = four(number); }
        return result;
    }

    private int three(int number) {
        int sum = 0;
        for (int i = number - 2; i > 0; i--) {
            sum += i;
        }
        return sum;
    }

    private int four(int number) {
        int sum = 0;
        for (int k = number - 3; k > 0; k--) {
            sum += three(k + 2);
        }
        return sum;
    }

}
