package com.dk.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayConvertingOther {


    public ArrayList<Integer> convertToArrayList(int[] arr){
        ArrayList<Integer> list = new ArrayList(Arrays.asList(arr));
        return list;
    }

    public IntStream convertToStream(int[] arr){
        IntStream intStream = Arrays.stream(arr);
        return intStream;
    }

    public static void main(String[] args){
        ArrayConvertingOther arrayConvertingOther = new ArrayConvertingOther();

        int[] arr = {1,3,5,7};
        System.out.println(arr);
        System.out.println(arrayConvertingOther.convertToArrayList(arr));

        arrayConvertingOther.convertToStream(arr).forEach(a -> System.out.println(a));

    }
}
