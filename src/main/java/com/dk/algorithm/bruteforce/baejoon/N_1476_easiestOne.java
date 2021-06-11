package com.dk.algorithm.bruteforce.baejoon;

import java.util.Scanner;

/**
 * PROBLEM : https://www.acmicpc.net/problem/1476
 */
public class N_1476_easiestOne {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int e = scanner.nextInt() -1;
        int s = scanner.nextInt() -1;
        int m = scanner.nextInt() -1;
        for(int i=0;; i++){
            if(i % 15 == e && i % 28 == s && i % 19 == m){
                System.out.println(i+1);
                break;
            }
        }
    }
}
