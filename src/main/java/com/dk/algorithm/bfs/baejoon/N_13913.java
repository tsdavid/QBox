package com.dk.algorithm.bfs.baejoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Problem : https://www.acmicpc.net/problem/13913
 */
public class N_13913 {
    public static final int  MAX = 1000000;
    static void print(int[] from, int n, int m){
        if(n != m){
            print(from, n, from[m]);
        }
        System.out.print(m + " ");
    }
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];
        int[] from = new int[MAX];

        check[n] = true;
        dist[n] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()){
            int now = queue.remove();
            if(now - 1 >= 0){
                if(check[now -1] == false){
                    queue.add(now -1);
                    check[now -1] = true;
                    dist[now -1] = dist[now] + 1;
                    from[now -1] = now;
                }
            }

            if(now +1 < MAX){
                if(check[now +1] == false){
                    queue.add(now +1);
                    check[now +1] = true;
                    dist[now +1] = dist[now] + 1;
                    from[now +1] = now;
                }

            }

            if(now * 2 < MAX){
                if(check[now *2] == false){
                    queue.add(now *2);
                    check[now *2] = true;
                    dist[now *2] = dist[now] + 1;
                    from[now *2] = now;
                }
            }
        }
        System.out.println(dist[m]);
        print(from, n, m);
        System.out.println();
    }
}
