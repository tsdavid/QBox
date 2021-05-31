package com.dk.algorithm.greedy.baejoon;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem : https://www.acmicpc.net/problem/1931
 * Answer sheet  : https://st-lab.tistory.com/145
 */
public class N_1931 {

    public static void sub_main() throws java.io.IOException{

        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        java.util.StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new java.util.StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] arr1, int[] arr2){
                return (arr1[1] == arr2[1]) ? arr1[0] - arr2[0] : arr1[1] - arr1[2];
            }
        });

        int cnt = 0;
        int prev_end = 0;
        for (int i=0; i < N; i++){
            if(prev_end <= time[i][0]){
                prev_end = time[i][1];
                cnt ++;
            }
        }
        System.out.println(cnt);

    }

    public static void main(String[] args){

        int N = 11;
        int[] starts = {1,3,0,5,3,5,6,8,8,11,12};
        int[] ends = {4,5,6,7,8,9,10,11,12,12,14};

        System.out.println(String.valueOf(starts.length) +
                " ::" + String.valueOf(ends.length));

        int[][] times = new int[N][2];
        for(int i =0; i < N; i++){
            times[i][0] = starts[i];
            times[i][1] = ends[i];
        }

        System.out.println(" Print Original 2d-Arrays");
        for(int i=0; i < N; i++){
            System.out.println(Arrays.toString(times[i]));
        }

        // Sorting Arrays.
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                int val = (o1[1] == o2[1]) ? o1[0] - o2[0] : o1[1] - o2[1];

                // sort with Second Index, end time
                return val;
            }
        });

        System.out.println(" Print Sorted 2d-Arrays");
        for(int i=0; i < N; i++){
            System.out.println(Arrays.toString(times[i]));
        }


        System.out.println("==== Get Ready ====");
        int cnt = 0;
        int prev_end = 0;
        for(int i=0; i < N; i++) {

            // if prev end time is smaller or same than start time.
            // else prev end is bigger than start time => pass.
            if(prev_end <= times[i][0]){
                // update prev end Time.
                System.out.println(Arrays.toString(times[i]));
                prev_end = times[i][1];
                cnt++;
            }
        }
        System.out.println("==== Get Answer ====");
        System.out.println(cnt);

    }
}
