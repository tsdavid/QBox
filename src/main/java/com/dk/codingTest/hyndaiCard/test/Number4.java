package com.dk.codingTest.hyndaiCard.test;

import java.util.ArrayList;

public class Number4 {
    public static void main(String[] args) {

        String road = "11011110011111011111100011111";
        int n = 3;

        int answer = 0;

        String text = String.valueOf(road);
        for(int i=0; i < n; i++){
            text = text.replaceFirst("0", "1");
        }

        System.out.println(text);

        int cnt = 0;
        for(int i=0; i < road.length(); i++){
            if(road.charAt(i) == '0'){
                if(answer < cnt){answer = cnt;}
                break;
            }
            cnt++;
        }

//        ArrayList<String> roads = new ArrayList<>();
//        int num = 0;
//        for(int i=0; i < road.length(); i++){
//            if(road.charAt(i) == '1'){
//                num ++;
//            }
//            if(road.charAt(i) == '0'){
//                if(num != 0){
//
//                    roads.add(String.valueOf(num));
//                    num = 0;
//                }
//                roads.add("x");
//            }
//        }
//        if(num > 0){roads.add(String.valueOf(num));}
//
//        System.out.println(
//                roads.toString()
//        );
//        road.repl
//
//        int answer = 0;
//        for(int i=0; i < roads.size()-n; i++){
//
//            if(roads.get(i).equals("x")){
//                roads.in
//            }
//
//        }
    }

}
