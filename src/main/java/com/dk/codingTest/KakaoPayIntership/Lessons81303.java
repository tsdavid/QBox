package com.dk.codingTest.KakaoPayIntership;

import lombok.val;

import java.util.*;


/**
 * 표 편집 : https://programmers.co.kr/learn/courses/30/lessons/81303
 *
 *
 */
public class Lessons81303 {

    public Lessons81303() {

//        int n = 8; int k = 2;String result = "OOOOXOOO"; String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
//        String answer = this.solution(n, k, cmd);
//        System.out.println("Answer : " + result.equals(answer));

        int n2 = 8; int k2 = 2;String result2 = "OOXOXOOO"; String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        String answer2 = this.solution(n2, k2, cmd2);
        System.out.println("Answer2 : " + result2.equals(answer2));


    }


    public String solution(int n, int k, String[] cmd){


        int currentPoistion = k;    // index
//        int trashIndex = -1; int trashVal = -1;
        Stack<Integer> trashList = new Stack<>();

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i< n; i++){
            arr.add(i);
        }

        System.out.println("initPosition : " + currentPoistion + " Trash : " + trashList.toString() + " List : " + arr.toString());

        for(String command : cmd){


            // Set-Up Command Line.
            String cmdType; int count = 0;
            if(command.length() > 1){
                cmdType = command.split(" ")[0];
                count = Integer.parseInt(command.split(" ")[1]);
            } else{cmdType = command;}


            // U
            if(cmdType.equals("U")){
                currentPoistion = currentPoistion - count;
                System.out.println("Received Command : " + command + " Up Command Change Position(index) : " + currentPoistion + " it's elemet : " + arr.get(currentPoistion));
            }

            // D
            if(cmdType.equals("D")){
                currentPoistion = currentPoistion + count;
                System.out.println("Received Command : " + command + " Down Command Change Position(index) : " + currentPoistion + " it's elemet : " + arr.get(currentPoistion));
            }

            // C
            if(cmdType.equals("C")){

//                int tmpPosition = currentPoistion;
                // trash
                trashList.add(arr.get(currentPoistion));
                // remove element
                arr.remove(currentPoistion);
                // update position,if needed
                if(arr.size()-1 == currentPoistion){currentPoistion = arr.size()-1;}

                System.out.println("Received Command : " + command + " C CLI Change Position(Index) : " + currentPoistion + " Current List : " + arr + " CurrentTrashList : " + trashList);

            }

            // Z
            if(cmdType.equals("Z")){
                int reload = trashList.pop();
                int index = arr.size() -1 < reload ? arr.size() : reload;

                arr.add(index, reload);
                System.out.println("Received Command : " + command + " About Trash Index : " + index + " trash Val : " + reload + " Upodated List : "+ arr);

            }

        }

        String answer = "";
        for(int i=0; i < n; i++){
            if(trashList.contains(i)){
                answer = answer.concat("X");
            }else {answer = answer.concat("O");}
        }


        System.out.println("List : " + arr + " Answer : " + answer);


        return answer;
    }

    public static void main(String[] args) {
//         ArrayList<Integer> arr = new ArrayList<>();
//         arr.add(0, 0); arr.add(1, 1);arr.add(2, 3);
//         System.out.println(arr);
//         arr.add(2,2);
//        System.out.println(arr);
//        System.out.println(arr.size());

        new Lessons81303();

    }
}
