import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Second {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "orange", "banana", "grape", "kiwi");

        strings.stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

        List<String> uppercasedStrings = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercased strings: " + uppercasedStrings);

        boolean hasLongString = strings.stream()
                .anyMatch(s -> s.length() > 5);
        System.out.println("Contains a string with length > 5: " + hasLongString);

        String concatenatedString = strings.stream()
                .reduce("", (result, element) -> result + element + ",");
        System.out.println("Concatenated string: " + concatenatedString);

        int totalLength = strings.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Total length of all strings: " + totalLength);
    }
}