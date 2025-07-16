package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        AverageCalculator calculator = new AverageCalculator();
        double average = calculator.calculateAverageOfEvenNumbers(numbers);
        System.out.println("Среднее значение четных чисел: " + average);
    }
}