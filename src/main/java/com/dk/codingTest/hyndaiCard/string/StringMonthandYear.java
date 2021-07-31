package com.dk.codingTest.hyndaiCard.string;

import java.util.Calendar;

public class StringMonthandYear {

    public static void main(String[] args) {

        String input = "12월 30일";
        StringMonthandYear stringMonthandYear = new StringMonthandYear();
        System.out.println(stringMonthandYear.solution(input));


    }

    public int solution(String str){

        int answer = 0;
        int month = Integer.parseInt(str.split("월 ")[0]);
        int day = Integer.parseInt(str.split("월 ")[1].split("일")[0]);

        int[] dayList = {0, 31, 28, 31,30,31, 30, 31, 31, 30, 31, 30, 31};
        for(int i=0; i < month; i++){
            answer += dayList[i];
        }
        return answer + day;
    }
}
