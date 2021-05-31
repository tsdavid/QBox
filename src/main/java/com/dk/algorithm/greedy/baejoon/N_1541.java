package com.dk.algorithm.greedy.baejoon;

import java.util.Arrays;
import java.util.Scanner;

public class N_1541 {

    public static void main(String[] args){

        String str = "55-50+40";
        String[] strings = str.split("-");
//        System.out.println(
//                Arrays.toString(strings)
//        );

        int[] arr = new int[strings.length];
        for(int i = 0; i < strings.length; i++){

            int tmp = 0;
            if(strings[i].indexOf("+") > 0){

                String[] strings1 = strings[i].split("\\+");
                arr[i] = Arrays.stream(strings1).mapToInt(Integer::parseInt).sum();
            }else{
                arr[i] = Integer.parseInt(strings[i]);
            }
        }

//        System.out.println(Arrays.toString(arr));

        int answer = 0;
        for(int i=0; i < arr.length; i++){
            if(i == 0 ){
                answer = arr[0];
                continue;
            }
            answer -= arr[i];

        }
        System.out.println(answer);




    }
}
