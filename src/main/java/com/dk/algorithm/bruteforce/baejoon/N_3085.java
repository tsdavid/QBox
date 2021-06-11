package com.dk.algorithm.bruteforce.baejoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem : https://www.acmicpc.net/problem/3085
 */
public class N_3085 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] a = new char[n][n];
        for(int i=0; i < n; i++){
            // toCharArray~~
            a[i] = sc.next().toCharArray();
        }

//        for(char[] c : a){
//            System.out.println(Arrays.toString(c));
//        }
        
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                // j 방향으로 변경확인 
                if(j+1 < n){    // j+1이 끝 부분이면 변경 못함
                    // 사탕 서로 교환
                    char t = a[i][j];
                    a[i][j] = a[i][j+1];
                    a[i][j+1] = t;
                    
                    int temp = check(a, i, i, j, j+1);
                    if(ans < temp) ans = temp; // Max 값 업데이트
                    
                    // 변경한 값 다시 변경
                    t = a[i][j];
                    a[i][j] = a[i][j+1];
                    a[i][j+1] = t;
                    
                }
                
                // i 방향으로 변경확인
                if(i+1 < n){    // i+1이 끝 부분이면 변경 못함

                    char t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
                    int temp = check(a, i, i+1, j , j);
                    if(ans < temp) ans = temp;
                    t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
                    
                }
            }
        }
        System.out.println(ans);
    }


    static int check(char[][] a,
                     int start_row, int end_row,
                     int start_col, int end_col){

        int n = a.length;
        int ans = 1;

        for(int i=start_row; i<=end_row; i++){

            int cnt = 1;
            for(int j=1; j<n; j++){
//                if(a[i][j] == a[i][j-1]){
                if(a[i][j] == a[i][j-1]){
                    // 조건에 맞으면 cnt 증가
                    cnt +=1;
                }else{
                    cnt=1;
                }
                // cnt 최댓값 업데이트
                if(ans < cnt) ans = cnt;
            }
        }

        for (int i=start_col; i<= end_col; i++){

            int cnt = 1;
            for(int j=1; j<n; j++){
                if(a[j][i] == a[j-1][i]){
                    cnt +=1;
                }else{
                    cnt = 1;
                }
                if(ans < cnt) ans = cnt;
            }
        }


        return ans;
    }
}
