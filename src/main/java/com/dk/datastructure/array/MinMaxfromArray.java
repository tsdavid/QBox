package com.dk.datastructure.array;

public class MinMaxfromArray {

    public static void main(String[] args){

        int[] arr = {1, 2, 4, 5, 6, 8, 10, -5};


        // get Minimum value.
        int least = 0;
        for(int i : arr){
            if(least > i){
                least = i; // update min
            }
        }
        System.out.println(" Minimum Value : " + least);

        // get Maximum value.
        int max = 1;
        for(int i : arr){
            if (max < i) {
                max = i; // update Max.
            }
        }
        System.out.println(" Maximum Value : " + max);


        System.out.println(arr[arr.length -1]);
    }
}
