package gyak;

public class FelbontasOsszegre {

    public int bontsdFel1(int part, int number) {
        checkData(part, number);
        int a = 0;
        int b = 0;
        switch (part) {
            case 4:
                a = 1;  //a = 1 & b = 1
            case 3:
                b = 1;
        }
        System.out.println(" *");
        return countAndWrite(number, a, b);
    }

    private int countAndWrite(int number, int a, int b) {
        int max = 0;
        if (a == 1) {
            max = number - a - b - 1;
        }
        int counter = 0;

        for (; a <= max; a++) {
            counter += hundreds3Parts(number, a, b);
        }
        System.out.println(counter);
        return counter;
    }

    private int hundreds3Parts(int number, int a, int b) {
        int max = 0;
        if (b == 1) {
            max = number - a - b - 1;
        }
        int counter = 0;

        for (; b <= max; b++) {
            counter += onesAndTens2Parts(number, a, b);
        }
        return counter;
    }

    private int onesAndTens2Parts(int number, int a, int b) {
        int counter = 0;
        int max = number - a - b - 1;
        for (int c = 1; c <= max; c++) {
            int d = max - c + 1;
            counter++;
            System.out.println(a + "+" + b + "+" + c + "+" + d);
        }
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
        if (part == 2) {
            return number - 1;
        }
        if (part == 3) {
            result = three(number);
        }
        if (part == 4) {
            result = four(number);
        }
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

    public int bontsdFel2(int part, int number) {
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

        System.out.println(counter +"\n *");
        return counter;
    }

    public int bontsdFel3(int part, int number){
        checkData(part, number);
        int result = -7;
        if(part == 2) {
            result = bont2(number);
        }
        if(part == 3) {
            result = bont3(number);
        }
        if(part == 4) {
            result = bont4(number);
        }
        System.out.println(result +"\n *");
        return result;
    }

    private int bont2(int number){
        int counter = 0;
        for(int i = 1; i < number; i++){
            for(int j = 1; j < number; j++){
                if(i+j == number){
                    System.out.println("0+0+"+ i +"+"+j);
                    counter++;
                }
            }
        }
        return counter;
    }

    private int bont3(int number){
        int counter = 0;
        for(int i = 1; i < number; i++){
            for(int j = 1; j < number; j++){
                for(int k = 1; k < number; k++) {
                    if (i + j + k == number) {
                        System.out.println("0+" + i + "+" + j +"+"+ k);
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    private int bont4(int number){
        int counter = 0;
        for(int i = 1; i < number; i++){
            for(int j = 1; j < number; j++){
                for(int k = 1; k < number; k++) {
                    for (int m = 1; m < number; m++) {
                        if (i + j + k + m == number) {
                            System.out.println(i + "+" + j + "+" + k + "+" + m);
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }

}
