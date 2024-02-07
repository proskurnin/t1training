package ru.proskurnin.core;

import ru.proskurnin.core.model.Employee;
import ru.proskurnin.core.utils.StreamUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        List<Integer> originalList = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 6, 4, 7, 8, 9, 1);
        System.out.println(StreamUtils.nonDublicate(originalList));

        List<Integer> maxThreeNumbers = Arrays.asList(5, 2, 10, 9, 4, 3, 10, 1, 13);
        System.out.println(StreamUtils.maxThree(maxThreeNumbers));

        List<Integer> maxThreeUniqueNumbers = Arrays.asList(5, 2, 10, 9, 4, 3, 10, 1, 13);
        System.out.println(StreamUtils.maxThreeUnique(maxThreeUniqueNumbers));

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 35, "Engineer"),
                new Employee("Bob", 40, "Engineer"),
                new Employee("Charlie", 45, "Engineer"),
                new Employee("David", 30, "Manager"),
                new Employee("Emma", 38, "Engineer"),
                new Employee("Frank", 42, "Engineer"),
                new Employee("Grace", 37, "Engineer"));
        System.out.println(StreamUtils.threeOlderEngineer(employees));

        List<Employee> newEmployees = Arrays.asList(
                new Employee("Alice", 35, "Engineer"),
                new Employee("Bob", 40, "Engineer"),
                new Employee("Charlie", 45, "Engineer"),
                new Employee("Frank", 74, "Engineer"),
                new Employee("Grace", 63, "Engineer"));
        System.out.println(StreamUtils.averageAge(newEmployees));

        List<String> words = Arrays.asList("apple", "banana", "grapefruit", "orange", "kiwi");
        System.out.println(StreamUtils.longestWord(words));

        String str = "apple banana apple orange banana apple";
        System.out.println(StreamUtils.countWords(str));

        StreamUtils.printWords(Arrays.asList("banana", "apple", "kiwi", "orange", "grape", "pear"));

        String[][] arrayOfStrings = {
                {"apple banana", "kiwi grape", "orange pear", "pineapple watermelon", "strawberry blueberry"},
                {"cat", "dog", "elephant", "lion", "tiger"},
                {"green", "red", "yellow", "blue", "purple"}
        };
        System.out.println(StreamUtils.maxLength(arrayOfStrings));
    }


}
