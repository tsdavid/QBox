package com.dk.algorithm.greedy.baejoon;

public class N_13305 {

    /**
     * PROBLEM : https://st-lab.tistory.com/192
     * ANSWER SHEET : https://st-lab.tistory.com/192
     * @param args
     */
    public static void main(String[] args){



        // first city

        // if prices[0] is not cheapest  != buy all oil!
        // buy minimum oil enough to go next city

        // second city
        // check next city's price
        // if this city's price is cheaper than next one.
        // buy oil to go next city

        int N = 4;
        int[] distances = {2, 3, 1};
        int[] prices    = {5, 2, 4, 1};

        // check cheapest
        int cheapestIndex = 0;
        int tmp = 999;
        for(int i=0; i < prices.length; i++){
            if(tmp > prices[i]){
                tmp = prices[i];
                cheapestIndex = i;
            }
        }
        System.out.println("Cheapest Index : " + cheapestIndex); // cheapest oil station on route.


        // first
        int oilMoney = 0;
        int cnt_city = 0;

        for(int i=0; i < prices.length; i++){

            if(cnt_city >= distances.length-1) break;

            for(int j = i+1; i < prices.length; j++){

                oilMoney += prices[i] * distances[cnt_city++];
                if(prices[i] > prices[j]) break;


            }
        }
        System.out.println(oilMoney);
    }
}
