package com.dk.sort;

import java.util.Arrays;

public class selection_sort {

    public int[] selection_sort(int[] arr){

        for(int i=0; i < arr.length; i++){

            int least = i;
            for(int j = i+1; j < arr.length; j++) {

                // Check minimum value.
                if(arr[least] > arr[j]){
                    // Update least.
                    least = j;
                }
            }

            // Change old least and new least.
            int tmp = arr[least];
            arr[least] = arr[i];
            arr[i] = tmp;

            printStep(arr, i + 1);
        }
        return arr;
    }


    void printStep(int[] arr, int val) {
        System.out.println("     Step  " + val + " = " + Arrays.toString(arr));

    }

    public static void main(String[] args){

        int[] data = {5, 3, 8, 4, 9, 1, 6, 2, 7};
        System.out.println(" Original : " + Arrays.toString(data));
        int[] result_data = new selection_sort().selection_sort(data);
        System.out.println(" Selection Sort : " + Arrays.toString(result_data));


    }

}
