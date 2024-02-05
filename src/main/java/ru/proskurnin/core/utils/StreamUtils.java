package ru.proskurnin.core.utils;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUtils {
    public static List<Integer> nonDublicate(List<Integer> list){
        return list.stream()
                .distinct() // чтобы получить поток уникальных элементов.
                .collect(Collectors.toList());
    }


}
