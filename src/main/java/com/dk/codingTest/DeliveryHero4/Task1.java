package com.dk.codingTest.DeliveryHero4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
        String C = "Example";

        new Solution().solution(S,C);
    }
}
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//S = >John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker
//C =>Example
class Solution {
    public String solution(String S, String C) {


//        Map<String,Integer> map = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<String>();

        // 1. parsing Name, get First and Last Name.
        // 1-1. Get Each Name.
        for(String name : S.split("; ")) {

            String firstName;
            String lastName;

            // Case> exist Middle Name or Not => Check with Length.
            int num = 1;
            if (name.split(" ").length == 3) {
                num++;
            } // middle name case.
            firstName = name.split(" ")[0].toLowerCase();
            lastName = name.split(" ")[num].toLowerCase();
//            System.out.println("Name : " + name + " // First Name : "  + firstName + " // Last Name  : " + lastName );

            // get Retained Name.
            // 1. remove hyphens 2. truncate 8 letters. 3. Lower Case.
            if (lastName.contains("-")) {
                int pst = lastName.indexOf("-");
                lastName = (lastName.substring(0, pst) + lastName.substring(pst + 1)).substring(0, 8);
//                System.out.println(lastName);
            }

            String answer = "";
            String possibleName = firstName.concat(".").concat(lastName);
            String emailFormat = "@".concat(C.toLowerCase()).concat(".com");

            // Check Duplicate.
            if (!arrayList.contains(possibleName + emailFormat)) {  // contain false

                answer = possibleName + emailFormat;
                arrayList.add(answer);
//                System.out.println(answer);

            } else { // contain true.
                for (int i = 2; i < arrayList.size() + 1; i++) {
                    if (!arrayList.contains(possibleName + i + emailFormat)) { // contain Array in +1 name?
                        answer = possibleName + i + emailFormat;
                        arrayList.add(answer);
                        break;
                    }
                }
            }
//            System.out.println(arrayList.toString());


        }
        String anw = "";
        for (int i = 0; i < arrayList.size(); i++) {
            anw = anw.concat(arrayList.get(i)) + "; ";
        }
//        System.out.println(anw);
        return anw.substring(0, anw.lastIndexOf(';'));

    }
}
