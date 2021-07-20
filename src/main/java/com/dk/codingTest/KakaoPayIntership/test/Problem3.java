package com.dk.codingTest.KakaoPayIntership.test;

public class Problem3 {

    public int solution(){

        String line1 = "abbbcbbb";
        String line2 = "bbb";

        int answer = 0;

        int index = 0;
        while(true){

            String target =line1.substring(index, index+line2.length());
            if(target.equals(line2)) {answer ++;}
            System.out.println(target);


            index ++;
            if(index + line2.length() > line1.length()){break;}

            for(int c=1; 2*c + line2.length() < line1.length(); c++){
                String target_ = "";
                for(int l=1; l<line2.length()+1; l++){
                    target_ = target_.concat(Character.toString(line1.charAt(index * l)));
                }
                if(target_.equals(line2)){answer++;}
            }


        }

        return 0;

    }

    public static void main(String[] args) {
        new Problem3().solution();
    }
}
