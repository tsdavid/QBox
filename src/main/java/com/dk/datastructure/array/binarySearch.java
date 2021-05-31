package com.dk.datastructure.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import static java.lang.System.*;
public class binarySearch {

    /**
     * binarySearch
     * 1. ascending sort
     * 2. if not contain, return negative
     * reference : https://blog.daum.net/bang2001/12
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 6, 9};

        System.out.println(" Find value from array");
        System.out.println(new binarySearch().ArraysBinarySearch(arr , 1));

        // Test.. what if array is sorted by descending order.
        // Arrays sort with descending
        int[] descendingArr = Arrays.copyOf(arr, arr.length);
        reverse(descendingArr);
        out.println(Arrays.toString(descendingArr));
        out.println(new binarySearch().ArraysBinarySearch(descendingArr, 1));

        // What if No value in arr
        out.println("No Value Case.. array : " + Arrays.toString(arr));
        out.println(new binarySearch().findIndexFromArray(arr, 10));
        out.println(new binarySearch().findIndexFromArray(arr, -1));
        out.println(new binarySearch().findIndexFromArray(arr, 2));
        out.println(Arrays.binarySearch(arr, 2));
        out.println(new binarySearch().findIndexFromArray(arr, 7));
        out.println(Arrays.binarySearch(arr, 7));
        out.println(Arrays.binarySearch(arr, 9));

    }

    /** * reverse given array in place * * @param input */
    public static void reverse(int[] input) {

        int last = input.length - 1;
        int middle = input.length / 2;

        for (int i = 0; i <= middle; i++){
            int temp = input[i];
            input[i] = input[last - i];
            input[last - i] = temp;
        }
    }




    /**
     * Find Index with value.
     * @param arr
     * @param val
     * @return
     */
    public int findIndexFromArray(int[] arr, int val){
        return Arrays.binarySearch(arr, val);
    }
    public int ArraysBinarySearch(int[] arr, int val){
        return this.binarySearch(arr, val);
    }
    public static int binarySearch(int[] a, int key) {
        return binarySearch0((int[])a, 0, a.length, (int)key);
    }

    /**
     *
     * @param a             :       array
     * @param fromIndex     :       start index.
     * @param toIndex       :       end index. => array.length
     * @param key           :       target value.
     * @return
     */
    private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {

        out.println("Enter binarySearch0... Print All parameters.");
        out.println(
                " int[] a : " + Arrays.toString(a) +
                        " int fromIndex : " + fromIndex +
                        " int toIndex : " + toIndex +
                        " int key : " +  key
        );

        out.println(" Set-Up new Variables.");
        int low = fromIndex;
        int high = toIndex - 1;
        out.println(" Print Variables ...  low : " + low + " ... high : "+ high );

        while(low <= high) {
            // low <= high ==> util end of index.

            /* 중간 점의 index를 얻기위함 이라고 판단됨. */
            int mid = low + high >>> 1;
            out.println(" Print Mid : " + mid); // return Print Mid : 2
            // 0 + 4 >>> 1;
            // 4 >>> 1;
            // >>> => 정수 x의 각 비트를 y만큼 오른쪽으로 이동시킵니다. (빈자리는 0으로 채워집니다.)
            // ㄴ from https://coding-factory.tistory.com/521
            // 4 >>> 1;
            // ==> 정수 4를 32비트로 분해한 다음  각 비트를 1만큼 오른쪽으로 이동, 빈자리는 0
            // 32 비트?...?????

            /**
             * int convert to 32 bit
             * from : https://www.binaryconvert.com/result_signed_int.html?decimal=052
             *
             * int2
             * 00000000 00000000 00000000 00000010
             * int 4
             * 00000000 00000000 00000000 00000100
             * 4 >>> 1 ==> 오른쪽으로 이동.
             * 00000000 00000000 00000000 00000010
             *
             * int 2
             * print mid ==> 2
             *
             * what if
             * int 3
             * 0x00000003 = 00000000 00000000 00000000 00000011
             * 3 >>> 1
             * int 1
             * 0x00000003 = 00000000 00000000 00000000 00000001
             *
             * okay. bit shift. but what does it mean.????
             */

            /**
             * Inference about mid
             *
             * mid ==> index of array
             * high or low ==> index range of array.
             *
             *
             * inference 1. select middle index of index range?
             *          if) low : 0, high : 4 => mid(4 >>> 1) = 2.
             *              low : 1, high : 4 => mid(5 >>> 1) = 2.
             *              low : 2, high : 4 => mid(6 >>> 1) = 3.
             *              low : 3, high : 4 => mid(7 >>> 1) = 3.
             */


            // Get Middle Value of array.
            int midVal = a[mid];
            out.println(" Print midVal : " + midVal);

            if (midVal < key) {
                // compare Target Key Value and middle Value of array.
                // if key(target value) is bigger than midVal.
                // then... low  add up as middle index + 1.
                low = mid + 1;

            } else {
                // midVal >= key

                if (midVal <= key) {
                    return mid;
                }

                high = mid - 1;
            }
        }

        return -(low + 1);
    }



}
