package com.dk.algorithm.codility.training.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CyclicRotation {

    // you can also use imports, for example:
    // import java.util.*;

    // you can write to stdout for debugging purposes, e.g.
    // System.out.println("this is a debug message");

    public int[] solution(int[] A, int K) {
        // Do Something in K times.
        for(int i = 0; i < K; i++){

            int tmp = A[A.length-1];

            int[] tmpArr = new int[A.length];

            for(int j = 0; j < A.length-1; j++){
                tmpArr[j+1] = A[j];
                // rotate Arrays.
            }
            tmpArr[0] = tmp; // Update
            A = tmpArr;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(String k : map.keySet()){

        }
        return A;

    }

    public static void main(String[] args) {
        int[] arr = {3,8,9,7,6};
        new CyclicRotation().solution(arr, 1);
    }

}
