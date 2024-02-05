package ru.proskurnin.core;

import ru.proskurnin.core.utils.StreamUtils;

import java.util.Arrays;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        List<Integer> originalList = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 6, 4, 7, 8, 9, 1);
        System.out.println(StreamUtils.nonDublicate(originalList));
    }
}
