package com.dk.codingTest.hyndaiCard.test;

import java.util.ArrayList;

public class Number1 {

    public static void main(String[] args) {

        String[] color = {"RG", "WR", "BW", "GG"};
        int[] prices = {5000, 6000};
        int result = 21000;

        Number1 number1 = new Number1();

        System.out.println(
                number1.solution(color, prices)
        );

    }

    public int solution(String[] color, int[] prices){

        int result = 0;

        ArrayList<String> tops = new ArrayList<>();
        ArrayList<String> bottoms = new ArrayList<>();

        for(int i=0; i < color.length; i++){

            if(Character.toString(color[i].charAt(0)).equals(Character.toString(color[i].charAt(1)))){
                result += prices[0];
                continue;
            }
            tops.add(Character.toString(color[i].charAt(0)));
            bottoms.add(Character.toString(color[i].charAt(1)));
        }


        for(int i=0; i<tops.size(); i++){

            System.out.println("Tops : " + tops.toString());
            System.out.println("Bottoms : " + bottoms.toString());

            String top = tops.get(i);
            System.out.println("TOP : " + top);

            for(int j=0; j < bottoms.size(); j++){
                if(top.equals(bottoms.get(j))){
                    System.out.println("5000 : " + bottoms.get(j));

                    bottoms.remove(j);
                    result += prices[0];
                    break;
                }
            }
        }


        System.out.println(
                tops.toString()
        );

        System.out.println(
                bottoms.toString()
        );

        if(bottoms.size() > 0){
            result += bottoms.size() * prices[1];
        }

        return result;
    }
}
