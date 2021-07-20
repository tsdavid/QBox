package com.dk.codingTest.KakaoPayIntership.test;

import java.util.Arrays;

public class Problem2 {

    public static void main(String[] args) {
        new Problem2();
    }
    public Problem2() {

        int rows = 4;
        int cols = 3;
        int[][] swipes = {
                {1,1,2,4,3},
                {3,2,1,2,3},
                {4,1,1,4,3},
                {2,2,1,3,3}
        };

        this.solution(rows, cols, swipes);

    }
    public int[] solution(int rows, int columns, int[][]swipes){


        int[] answer = new int[swipes.length];

        // 1. make init matrix
        int[][] matrix = new int[rows][columns];
        for(int i=0; i < rows; i++){
            for(int j=0; j < columns; j++){
                matrix[i][j] = ((i-1) * columns + j);
            }
        }

        // swipes 를 looping 해야되네
        for(int j =0; j < swipes.length; j++){

            int[] swipe = swipes[j];
            int dir = swipe[0];
            int r1 = swipe[1]-1; int c1 = swipe[2] -1; int r2 = swipe[3] -1; int c2 = swipe[4] -1;

            int sum = 0; int fixed;
            switch (dir){
                case 1:

                    // r2, c1 ~ r2, c2 숫자 합치기
                    // 3 1   ~ 3 4
                    for(int i = c1; i < c2; i++){
                        sum = sum + matrix[r2][i];

                        int tmp = matrix[r2][i];

                        // swithcing matrix.
                        for(int k=r2-1; k == r1; k--){
                            matrix[k+1][i] = matrix[k][i];
                        }

                        matrix[r1][i] = tmp;
                    }


                    break;
                case 2:
                    // r1, c1 ~ r1 ,c2 숫자 합치기
                    // 1 2  1 4
                    for(int i = c1; i <c2; i++){
                        sum = sum + matrix[r1][i];
                        int tmp = matrix[r1][i];

                        for(int k=r1+1; k<r2; k++){
                            matrix[k-1][i] = matrix[k][i];
                        }
                        matrix[r2][i] = tmp;
                    }
                    break;
                case 3:
                    // r1, c2 ~ r2 ,c2 숫자 합치기
                    // 1 4  3  4
                    for(int i = r1; i < r2; i++){
                        sum = sum + matrix[i][c2];
                        int tmp = matrix[i][c2];

                        for(int k =c1+1; k < c2; k++){
                            matrix[i][k-1] = matrix[i][k];
                        }
                        matrix[i][c2] = tmp;
                    }
                    break;
                case 4:
                    // r1, c1 ~ r2 ,c1 숫자 합치기
                    // 1 2  3  2
                    fixed = c1;
                    for(int i = r1; i <r2; i++){
                        sum = sum + matrix[i][c1];
                        int tmp = matrix[i][c1];

                        for(int k=c2-1; k == c1; k--){
                            matrix[i][k+1] = matrix[k][i];
                        }
                        matrix[i][c1] = tmp;

                    }
                    break;
            }
            for(int[] arr : matrix){
                System.out.println(Arrays.toString(arr));
            }
            answer[j] = sum;

            // siwthcing position.

        }

        return answer;
    }

}
