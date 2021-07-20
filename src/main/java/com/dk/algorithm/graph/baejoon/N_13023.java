package com.dk.algorithm.graph.baejoon;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem : https://www.acmicpc.net/problem/13023
 */
class Edge {
    int from, to;
    Edge(int from, int to){
        this.from = from;
        this.to = to;
    }
}
public class N_13023 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // number of people.
        int m = scanner.nextInt();  //  number of edges.
        boolean[][] a = new boolean[n][n];  // 인접 행렬
        ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n]; // 인접 리스트
//        ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();

        ArrayList<Edge> edges = new ArrayList<Edge>();
        for(int i=0; i < n; i++){
            g[i] = new ArrayList<Integer>();
        }
        System.out.println(Arrays.toString(g));

        for(int i=0; i < m; i++){
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            a[from][to] = a[to][from] = true;       // 인접 행렬

            g[from].add(to);
            g[to].add(from);

            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));
        }
    }
}
