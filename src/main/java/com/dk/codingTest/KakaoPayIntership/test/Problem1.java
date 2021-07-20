package com.dk.codingTest.KakaoPayIntership.test;

import static java.lang.System.out;
public class Problem1 {

    Problem1() {
        int[] money = {12345678, 1000000000, 123456789};
        int[] minratio = {10, 50, 0};
        int[] maxratio = {20, 99 ,0};
        int[] ranksize = {250000, 100000, 1};
        int[] threshold = {10000000, 0, 0};
        int[] months = {4, 6, 360};
        int[] result = {9000014, 6150, 123456789};


        for (int i = 0; i<money.length; i++){
            int answer = this.solution(money[i],minratio[i],maxratio[i], ranksize[i],threshold[i],months[i]);
            out.println("My Answer : " + answer + " Result : " + result[i]);
        }
    }



    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months){


        // 1. 소유가정금액
        // 2. moths에 맞게 loop 수행하면서, 세율 측정
        // 조건 1. 산정된 세율이 Max ratio를 넘지 않는지,
        // 조건 2. 최소에 부합하는지


        int calMoney = (money/10) * 10 - threshold;
        // 2. moths 개월수 만큼 looping
        for(int m=0; m < months; m++){
            // 1. 소유가정금액
            calMoney = (calMoney/10) * 10;
            out.println("Money : " + money + " Cal Money : " + calMoney);

            // 조건 1. 소유 가정 금액 이  threshold 보다 (미만) 이면 세율 0;
            if(calMoney < 0) {
                out.println(" calMoney : " + calMoney + " vs " + " threshold : "  + threshold + " ::::::::::::::::: ");
                break;
            }
            // 세율 구하기
            int taxRatio = Math.min(((calMoney / ranksize) + minratio -1), maxratio);
            out.println(" calculated tax ratio : " + taxRatio);

            int tax = calMoney * taxRatio/100;
            out.println("Month : " + m + " this moneth tax  : " + tax + " balance : " + String.valueOf(calMoney - tax));

            calMoney = calMoney - tax;

        }

        int answer = calMoney + threshold;



        return answer;
    }

    public static void main(String[] args) {
        int money = 12345678;
        int calMoney = money / 100;
        System.out.println(calMoney*100);
//        new Problem1();
    }
}
