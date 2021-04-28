package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class PrimeFastCheck {

    public void checkPrime(int... a) {
        List<Integer> primes = new ArrayList<>();
        for (int u = 0; u < a.length; u++) {
            if (isPrime(a[u])) {
                primes.add(a[u]);
            }
        }
        primes.sort(null);
        for (int i : primes) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private boolean isPrime(int a) {
        if (a == 2) return true;
        if (a < 2 || a % 2 == 0) return false;

        int max = (int) Math.pow(a, 0.5);
        for (int i = 3; i <= max; i += 2) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeFastCheck fc = new PrimeFastCheck();
        fc.checkPrime(1,0,-4,100, 18,23,22,19,25);
        fc.checkPrime(8);
        fc.checkPrime(1,4,2,3,5,49,50,6);
    }

}
