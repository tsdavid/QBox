package com.dk.algorithm.bfs.baejoon;

import java.util.ArrayList;

public class N1260 {

    static ArrayList<Integer>[] a;
    static boolean[] c;
    public static void dfs(int x) {

        if(c[x]) {return;}
        c[x] = true;
        System.out.println(x + " ");
        for(int y : a[x]){
        }
    }
}
