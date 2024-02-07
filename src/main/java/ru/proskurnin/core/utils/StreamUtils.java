package ru.proskurnin.core.utils;

import ru.proskurnin.core.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamUtils {
    public static List<Integer> nonDublicate(List<Integer> list){
        return list.stream()
                .distinct() // чтобы получить поток уникальных элементов.
                .collect(Collectors.toList());
    }

    public static int maxThree(List<Integer> list){
        return list.stream()
                .sorted((a, b) -> Integer.compare(b, a)) // сортируем в обратном порядке
                .skip(2) // пропускаем первые два числа (наибольшие)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Список слишком короткий ))"));
    }

    public static int maxThreeUnique(List<Integer> list){
        return list.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a)) // сортируем в обратном порядке
                .skip(2) // пропускаем первые два числа (наибольшие)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Список слишком короткий ))"));
    }

    public static List<String> threeOlderEngineer(List<Employee> list){
        return list.stream()
                .filter(e -> "Engineer".equals(e.getPosition()))
                .sorted(Comparator.comparingInt(Employee::getAge).reversed()) // Сортировка по убыванию возраста
                .limit(3) // Ограничение до трех сотрудников
                .map(Employee::getName) // Преобразование в список имен
                .collect(Collectors.toList());
    }

    public static Double averageAge(List<Employee> list){
        return  list.stream()
                .filter(employee -> "Engineer".equals(employee.getPosition()))
                .mapToDouble(Employee::getAge) // Получение потока возрастов
                .average() // Расчет среднего
                .orElse(0);
    }

    public static String longestWord(List<String> list){
        return  list.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public static Map<String,Long> countWords(String str){
        return   Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void printWords(List<String> list){
        list.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }

    public static String maxLength(String[][] arrayOfStrings){
        return Arrays.stream(arrayOfStrings)
                .flatMap(Arrays::stream) // Преобразуем в один поток строк
                .flatMap(str -> Arrays.stream(str.split(" "))) // Разбиваем на слова и преобразуем в поток
                .max(Comparator.comparingInt(String::length)) // Находим максимальное по длине слово
                .orElse("");
    }


}
