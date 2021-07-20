package com.dk.codingTest.DeliveryHero4;

public class Task3 {
    public static void main(String[] args) {
        Integer str = 44432;
        new Task3().solution(str);
    }

    public int solution(int S) {


        while (true){
            int CheckNumber = S++;
            if(checkDup(CheckNumber)){
//                System.out.println(String.valueOf(CheckNumber));
                return CheckNumber;
            }
        }
    }

    boolean checkDup(int number){

        String S = String.valueOf(number);
        for(int i=0; i < S.length() -1; i++){
            // Compare Each element.
            int f = Character.getNumericValue(S.charAt(i));
            int s = Character.getNumericValue(S.charAt(i+1));
            // if tow digit is same. it return false.
            if(f == s) { return false; }
        }
        return true;
    }
}
