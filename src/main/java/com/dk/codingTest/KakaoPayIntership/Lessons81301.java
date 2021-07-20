package com.dk.codingTest.KakaoPayIntership;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 숫자 문자과 영단어 : https://programmers.co.kr/learn/courses/30/lessons/81301
 *
 */
public class Lessons81301 {

    public Lessons81301() {

        String[] caseS = {"one4seveneight", "23four5six7", "2three45sixseven", "123"};
        int[] results = {1478, 234567, 234567, 123};
        boolean[] answers = new boolean[results.length];

        for(int i=0; i < caseS.length; i++){
            if(results[i] == this.mysolution(caseS[i])){
                answers[i] = true;
            }
        }

        // Print Out Pass or Fail
        System.out.println(Arrays.toString(answers));

    }

    public int mysolution(String s) {

        String[] converters = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        String answerString = "";
        System.out.println(s);

        // 1. 숫자인지 문자 인지 확인
        for(int i=0; i < s.length(); i++){
            char tmp = s.charAt(i);
            System.out.println("tmp : " + tmp);

            /**
             * 숫자인 케이스, 정답에 바로 기재
             */
            // 2. if) 숫자 => 숫자로,
            if(Character.isDigit(tmp)) {
                answerString = answerString.concat(Character.toString(tmp));
                System.out.println("answerString " +answerString);

            // 3. if) 문자 => 문자 최소 3개를 합쳐서 숫자로 치환 ==> 30분 소요. 시점...
            }else{

                String findNum = s.substring(i,i+3);
                System.out.println("findNumber " +findNum);

                for(int j=0; j< converters.length; j++){
                    if(converters[j].startsWith(findNum)){
                        System.out.println("Fit Number : " + converters[j]);

                        // get Number and update Number.
                        answerString = answerString.concat(String.valueOf(j));

                        // update i.
                        int sizeOfNumber = converters[j].length() -1;
                        i = i+sizeOfNumber;

                    }
                }
            }
        }
        // 4. start-with을 통해 치환될 숫자를 얻으면, 해당 단어를 제외. 다시 1번으로

        System.out.println("answerString : " + answerString); // 총 37분 소요
        return Integer.parseInt(answerString);
    }

    public static void main(String[] args) {

        new Lessons81301();

//        String test= "";
//        test = test.concat("h");
//        test = test.concat("h1");
//        System.out.println(test);


    }
}
