package com.dk.algorithm.codility.training.Iterations;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class BinaryGap {

    public int solution(int N) {
        // write your code in Java SE 8
        int answer = 0;
        // System.out.println(N);

        String bianryString = Integer.toBinaryString(N);
        // System.out.println(bianryString);

        int count = 0;
        for(int i=1; i < bianryString.length(); i++){

            int number = Character.getNumericValue(bianryString.charAt(i));

            if(number == 0){
                count ++;
            }

            if(number == 1) {
                if(answer < count) {
                    answer = count;
                }
                count = 0;
            }
        }

        if(answer == bianryString.length() -1){
            return 0;
        }
        return answer;
    }


    public static void main(String[] args) {
        int n = 561892;
        System.out.println(
                new BinaryGap().solution(n)
        );
    }
}