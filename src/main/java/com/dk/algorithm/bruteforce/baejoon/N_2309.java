package com.dk.algorithm.bruteforce.baejoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem : https://www.acmicpc.net/problem/2309
 */
public class N_2309 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = 9;
        int[] a = new int[n];
        for(int i =0; i<n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){

                // Calculate Sum without i and j
                int sum = 0;
                for(int k=0; k<n; k++){
                    if(i == k || j == k) continue;
                    sum += a[k];
                }

                // Check Answer
                if(sum == 100){
                    for(int k=0; k < n; k++){
                        if(i == k || j ==k) continue;
                        System.out.println(a[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }

}
