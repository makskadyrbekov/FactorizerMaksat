import java.util.ArrayList;
import java.util.List;

class Factorizer {

    // Find prime factors of a number
    public List<Integer> primeFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        if (number <= 1) return factors;

        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }
        return factors;
    }

    // Check if a number is prime
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        return primeFactors(number).size() == 1;
    }

    // Check if a number is composite
    public boolean isComposite(int number) {
        return number > 1 && !isPrime(number);
    }

    // Reduce a fraction using prime factors
    public String reduce(int numerator, int denominator) {
        if (denominator == 0) return "Undefined";

        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        if (denominator == 1) return String.valueOf(numerator);
        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Factorizer factorizer = new Factorizer();

        // Prime factors tests
        System.out.println("Prime factors of 9: " + factorizer.primeFactors(9));
        System.out.println("Prime factors of 10: " + factorizer.primeFactors(10));

        // Prime check tests
        System.out.println("Is 17 prime? " + factorizer.isPrime(17));
        System.out.println("Is 36 prime? " + factorizer.isPrime(36));

        // Composite check tests
        System.out.println("Is 36 composite? " + factorizer.isComposite(36));
        System.out.println("Is 17 composite? " + factorizer.isComposite(17));

        // Fraction reduction tests
        System.out.println("Reduce 36/12: " + factorizer.reduce(36, 12));
        System.out.println("Reduce 12/14: " + factorizer.reduce(12, 14));
    }
}
