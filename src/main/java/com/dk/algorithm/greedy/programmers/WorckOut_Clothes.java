package com.dk.algorithm.greedy.programmers;

import java.util.Arrays;

public class WorckOut_Clothes {



    /**
     *
     * @param n             :       Number of students.
     * @param losts         :       int arrays containing student numbers stolen their clothes.
     * @param reserve       :       int arrays student number who get more clothes.
     * @return              :       precesion 33.3%
     */
    public int my_solution(int n, int[] losts, int[] reserve) {
        int answer = n - losts.length;
        int len_reserve = reserve.length;
        for(int i=0; i < losts.length; i++){

            for(int j=0; j < len_reserve; j++){

                if(reserve[j] == losts[i] || reserve[j] == losts[i] +1 || reserve[j] == losts[i] -1 ){
                    reserve = removeArrayWithIndex(j, reserve);
                    answer++;
                    len_reserve--;
                }
                break;
            }
        }

        return answer;
    }


    int[] removeArrayWithIndex(int index, int[] arr){

        for(int i=index; i < arr.length -1; i++){

            arr[i] = arr[i+1];
        }
        return arr;
    }


    public static void main(String[] args){
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1, 3, 5};

        for(int i : reserve){
            System.out.println(i);
        }
    }
}


