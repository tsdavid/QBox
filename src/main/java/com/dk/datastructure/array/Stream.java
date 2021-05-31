package com.dk.datastructure.array;

import java.util.Arrays;
import java.util.Collections;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Stream {

    public static void main(String[] args) {

        Stream stream = new Stream();

        int[] data = {1, 3, 5, 7, 9};
        System.out.println(
                stream.StreamSum(data)
        );


        String[] strings = {"1", "3", "5", "7", "9"};
        System.out.println(
                stream.Stringstream_ConvetTo_IntStream_then_Sum(strings)
        );



    }

    public int StreamSum(int[] arr){
        return Arrays.stream(arr).sum();
    }

    public int Stringstream_ConvetTo_IntStream_then_Sum(String[] strings) {

        return Arrays.stream(strings).mapToInt(Integer::parseInt).sum();

    }


}
