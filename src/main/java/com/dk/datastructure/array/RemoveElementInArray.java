package com.dk.datastructure.array;

import java.util.Arrays;

public class RemoveElementInArray {

    public static void main(String[] args){

        int[] arr = {1, 3, 5, 6, 9};

        System.out.println(Arrays.toString(arr));
//        arr = new RemoveElementInArray().useTwoArrays(2, arr);
        arr = new RemoveElementInArray().useOneArraysButDuplicate(2, arr);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 빈 array 하나를 새로 만들어서 element 삭제
     * @param index
     * @param arr
     * @return
     */
    public int[] useTwoArrays(int index, int[] arr){

        int[] new_arr = new int[arr.length - 1];

        for(int i=0, j=0; i < arr.length; i++){ // arr array를 모두 순환 해야 하고, 순환 중에 i != index condition을 찾는다.
            if(i != index){
                new_arr[j++] = arr[i];
            }
        }
        return new_arr;
    }

    public int[] useOneArraysButDuplicate(int index, int[] arr){
        for (int i=index; i<arr.length -1; i++){
            arr[i] = arr[i +1];
        }
        return arr;
    }

}
