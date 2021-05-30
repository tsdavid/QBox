package com.dk.sort;

import java.util.Arrays;

public class ArraysSort {

    public static void main(String[] args){

        int[] arr = {2, 4, 6, 1, 5, 8, 10};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        // [1, 2, 4, 5, 6, 8, 10]
        // Arrays.sort => DualPivotQuicksort.sort(a, 0, a.length - 1, null, 0, 0);


    }
}
