package com.dk.algorithm.bruteforce.baejoon;

import java.util.Scanner;

/**
 * PROBLEM : https://www.acmicpc.net/problem/1476
 */
public class N_1476 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        sc.close();

        int e = 1; int s = 1; int m = 1;
        int year = 1;
        while (true){


            if(E == e && S == s && M == s){
                System.out.println(year);
                break;
            }

            if(e == 15)
                e = 1;
            else
                e ++;

            if(s == 28)
                s = 1;
            else
                s ++;

            if(m == 19)
                m = 1;

            else
                m ++;

            year++;
            System.out.println(" e : " + e + " s : " + s + " m : " + m);

        }
    }
}
