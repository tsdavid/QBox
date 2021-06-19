package com.dk.algorithm.bfs.baejoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Problem : https://www.acmicpc.net/problem/1697
 */
public class N_1697 {

    public static final int MAX = 1000000;  // 해를 구하는 최댓값. x-1, x + 1, 2x 이니까 K 범위를 훨씬 넘어가면 답을 찾기가 어려운,...

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();      // 내 위치
        int m = scanner.nextInt();      // 동생 위치

        boolean[] check = new boolean[MAX]; // 방문한 Node를 표기하는 check array,
        int[] dist = new int[MAX];  // 방문한 Node까지의 소요 비용

        check[n] = true; // 기준 Node true
        dist[n] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()){   // if queue is not empty
            int now = q.remove();  // get queue

            // 이동 방법,  x -1, x +1, 2*x
            if(now -1 >- 0) {
                if(check[now -1] == false){ // now -1로 이동하려는 곳이 방문한 적이 없는지 확인
                    q.add(now -1);  // 방문지 enqueue
                    check[now -1] = true; // 방문지 확인
                    dist[now -1] = dist[now] + 1; // 이동 소요 비용은 1씩 증가.
                }
            }
            if(now + 1 < MAX) {
                if(check[now + 1] == false) {
                    q.add(now +1);
                    check[now + 1] = true;
                    dist[now + 1] = dist[now] + 1;
                }
            }
            if(now * 2 < MAX){
                if(check[now*2] == false){
                    q.add(now*2);
                    check[now*2] = true;
                    dist[now*2] = dist[now] + 1;
                }
            }

        }
        System.out.println(dist[m]);
    }
}
