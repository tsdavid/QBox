package com.dk.algorithm.greedy.programmers;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * Problem : https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class WorckOut_Clothes {


    /**
     * Source From : https://velog.io/@delay/programmers42862
     * @param n
     * @param lost
     * @param reserve
     * @return              : Precesion 100.0%
     */
    public int velog_solution(int n, int[] lost, int[] reserve) {

        int[] all = new int[n];

        for(int i : reserve){
            all[i -1]++;
            // all[i]++ ==> all[i] = all[i] + 1;
            // all[i-1] = 1;  ==> [1, 0, 1, 0, 1]
        }
        out.println(" Print Out all Arrays.");
        out.println(Arrays.toString(all));

        for(int i : lost)
            all[i-1]--;

        out.println(" Print Out all Arrays.");
        out.println(Arrays.toString(all));

        for(int i =0; i < all.length; i++){

            if(all[i] < 0){ // all[i] => 음수 ==> 수업 참여가 어려운 친구들.
                if(i != all.length -1 && all[i +1] > 0){
                    all[i]++;
                    all[i+1]--;
                }else if(i != 0 && all[i-1] > 0){
                    all[i]++;
                    all[i-1]--;
                }
            }
            out.println(" Print Out all Arrays.");
            out.println(Arrays.toString(all));
        }
        int answer = 0;
        for(int i = 0; i < all.length; i++){
            if(!(all[i] < 0)){
                answer++;
            }
        }

        return answer;
    }




    /**
     *
     * @param n
     * @param lost
     * @param reserve
     * @return              :       Precesion 83.3%
     */
    public int third_solution(int n, int[] lost, int[] reserve) {

        // init answer;
        int answer = n - lost.length;
        out.println(" init Answer : " + answer);

        // sort Arrays
        Arrays.sort(lost);
        Arrays.sort(reserve);



        // if lost is in reserve.
        // remove element and count up answer.
        for(int i=0; i< lost.length; i++){

            int t_index = Arrays.binarySearch(reserve, lost[i]);
            if(t_index > 0){
                reserve[t_index] = -9; // set-up null
                lost[i] = -9;
                answer++;
            }
        }

        for(int i=0; i < lost.length; i++){

            int tmp_lost = lost[i];
            out.println(" Answer Has been changed : " + answer);
            out.println(" reserve has benn change : " + Arrays.toString(reserve));

            if(tmp_lost == -9) { continue;}


            // possible to borrow.
            for(int j=0; j < reserve.length; j++){

                int tmp_reserve = reserve[j];
                // reserve & lost
                if(tmp_reserve == -9) { continue; }

                if(tmp_lost == 1){
                    if(tmp_reserve == tmp_lost +1){
                        answer ++;
                        reserve[j] = -9;
                        out.println(" Answer Has been changed : " + answer);
                        out.println(" reserve has benn change : " + Arrays.toString(reserve));
                        break;
                    }
                }else if(tmp_lost > 1 && tmp_lost < n){
                    if(tmp_reserve == tmp_lost -1 || tmp_reserve == tmp_lost +1){
                        answer ++;
                        reserve[j] = -9;
                        out.println(" Answer Has been changed : " + answer);
                        out.println(" reserve has benn change : " + Arrays.toString(reserve));
                        break;
                    }
                }else if(tmp_lost == n){
                    if(tmp_reserve == tmp_lost -1){
                        answer ++;
                        reserve[j] = -9;
                        out.println(" Answer Has been changed : " + answer);
                        out.println(" reserve has benn change : " + Arrays.toString(reserve));
                        break;
                    }
                }

//                // tmp_lost =1
//                // tmp_lost -1 ==0 ==> continue
//                if(tmp_lost -1 != 0 && tmp_reserve == tmp_lost -1){
//                    answer ++;
//                    reserve[j] = -9;
//                    out.println(" Answer Has been changed : " + answer);
//                    out.println(" reserve has benn change : " + Arrays.toString(reserve));
//                    break;
//                }
//
//                if(tmp_lost +1 <= n && tmp_reserve == tmp_lost +1){
//                    answer ++;
//                    reserve[j] = -9;
//                    out.println(" Answer Has been changed : " + answer);
//                    out.println(" reserve has benn change : " + Arrays.toString(reserve));
//                    break;
//                }

            }
        }
        out.println(" === Print Answer : " + answer);
        return answer;
    }


    /**
     *
     * @param n             :       Number of students.
     * @param lost          :       int arrays containing student numbers stolen their clothes.
     * @param reserve       :       int arrays student number who get more clothes.
     * @return              :       precesion 00.00%
     */
    public int second_solution(int n, int[] lost, int[] reserve){

        // init answer;
        int answer = n - lost.length;

        // sort arrays
        Arrays.sort(lost);
        Arrays.sort(reserve);


        // check condition.
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

        int[] n = {5, 5, 3};
        int[][] lost = {{2,4}, {2,4}, {3}};
        int[][] reserve = {{1, 3, 5}, {3}, {1}};
        int[] returns = {5, 4, 2};

        int[] answer_sheet = new int[n.length];
        WorckOut_Clothes worckOut_clothes = new WorckOut_Clothes();
        for(int i=0; i < n.length; i++) {

            out.println(" Trial n " + i + "th");
            int answer = worckOut_clothes.velog_solution(n[i], lost[i], reserve[i]);
            answer_sheet[i] = (returns[i] == answer) ? 1 : 0;
        }
        System.out.println(" Print Answer Sheet : " + Arrays.toString(answer_sheet));
        System.out.println(" Precesion : " + n.length + "/" + Arrays.stream(answer_sheet).sum());
        Arrays.stream(answer_sheet).sum();



    }
}


