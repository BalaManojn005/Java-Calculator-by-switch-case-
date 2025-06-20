import java.util.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(10, 3, 7, 15, 2, 18, 5, 20, 11, 25));
        System.out.println("Original List: " + numbers);
         numbers.removeIf(Main::isPrime);

        System.out.println("After removing primes: " + numbers);
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
