package org.example;

import java.util.List;

public class AverageCalculator {
    public double calculateAverageOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .average()
                .orElse(0);
    }
}