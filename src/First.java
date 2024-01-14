import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class First {

    public static void main(String[] args) {
        List<Integer> randomNumbers = new Random()
                .ints(1000, 10, 10000)
                .boxed()
                .collect(Collectors.toList());

        long primeCount = randomNumbers.stream()
                .filter(First::isPrime)
                .count();

        System.out.println("Количество простых чисел: " + primeCount);

        int sum = randomNumbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("Сумма чисел: " + sum);

        randomNumbers.forEach(System.out::println);

        Map<Integer, String> numberToStringMap = randomNumbers.stream()
                .collect(Collectors.toMap(
                        number -> number,
                        number -> "Number: " + number));

        System.out.println("Карта чисел: " + numberToStringMap);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}