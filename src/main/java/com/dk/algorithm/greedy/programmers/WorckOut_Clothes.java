package com.dk.algorithm.greedy.programmers;

import java.util.Arrays;

public class WorckOut_Clothes {


    /**
     *
     * @param n             :       Number of students.
     * @param lost          :       int arrays containing student numbers stolen their clothes.
     * @param reserve       :       int arrays student number who get more clothes.
     * @return
     */
    public int second_solution(int n, int[] lost, int[] reserve){

        int answer = n - lost.length;

        // sort arrays
        Arrays.sort(lost);
        Arrays.sort(reserve);


        for(int i=0; i < lost.length; i++){

            int tmp_lost = lost[i];
            for(int z=0; z < reserve.length; z++){

                // check lost is in reserve
                if(tmp_lost == reserve[z]){
                    reserve = this.removeArrayWithNewArr(z, reserve);
                    lost = this.removeArrayWithNewArr(i, lost);
                    answer ++;
                    break;
                }

                // check -1
                if(tmp_lost -1 > 0 && reserve[z] == i-1){
                    reserve = this.removeArrayWithNewArr(z, reserve);
                    lost = this.removeArrayWithNewArr(i, lost);
                    answer ++;
                    break;
                }

                // check +1
                if(tmp_lost +1 <= n && reserve[z] == i+1){
                    reserve = this.removeArrayWithNewArr(z, reserve);
                    lost = this.removeArrayWithNewArr(i, lost);
                    answer ++;
                    break;
                }
            }
        }
        return answer;
    }


    /**
     *
     * @param n             :       Number of students.
     * @param losts         :       int arrays containing student numbers stolen their clothes.
     * @param reserve       :       int arrays student number who get more clothes.
     * @return              :       precesion 33.3%
     */
    public int first_solution(int n, int[] losts, int[] reserve) {
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

    int[] removeArrayWithNewArr(int index, int[] arr){

        if(arr.length -1 ==0) return null;

        int[] new_arr = new int[arr.length - 1];

        try{

            for(int i=0, j=0; i < arr.length; i++){
                if(i != index){
                    new_arr[j++] = arr[i];
                }
            }
        }catch (Exception e){

            System.out.println(Arrays.toString(arr));
            e.printStackTrace();
        }

        return new_arr;
    }


    public static void main(String[] args){

        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1, 3, 5};

        WorckOut_Clothes worckOut_clothes = new WorckOut_Clothes();
        System.out.println(worckOut_clothes.second_solution(n, lost, reserve));
//        System.out.println(Arrays.toString(worckOut_clothes.removeArrayWithNewArr(0, worckOut_clothes.removeArrayWithNewArr(0, worckOut_clothes.removeArrayWithNewArr(1, reserve)))));



    }
}


