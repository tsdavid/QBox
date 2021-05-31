package com.dk.algorithm.greedy.baejoon;

import java.util.Arrays;
public class N_11399 {

    public static void main(String[] args){
        int N = 5;
        int[] P = {3, 1, 4, 3, 2};

        Arrays.sort(P);
        int[] Pp = new int[P.length];
        for(int i=0; i < N; i++){

            if(i == 0){
                Pp[0] = P[0];
                continue;
            }
            Pp[i] = Pp[i-1] + P[i];
        }
        System.out.println(Arrays.toString(Pp));
        System.out.println(
                Arrays.stream(Pp).sum()
        );

    }
}
