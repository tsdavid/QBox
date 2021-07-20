package com.dk.algorithm.bfs.baejoon;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Problem : https://www.acmicpc.net/problem/14226
 */
public class N_14226 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n+1][n+1];
        for(int i=0; i <=n; i++){
            Arrays.fill(d[i], -1);
        }
        System.out.println(Arrays.toString(d));


        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(0);
        d[1][0] = 0;    // 기준점
        while (!q.isEmpty()){
            int s = q.remove();
            int c = q.remove();
        }
    }
}
