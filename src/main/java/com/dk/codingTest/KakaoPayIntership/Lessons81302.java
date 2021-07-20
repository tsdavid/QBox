package com.dk.codingTest.KakaoPayIntership;

import org.w3c.dom.NodeList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 거리두기 확인하기 : https://programmers.co.kr/learn/courses/30/lessons/81302
 */
public class Lessons81302 {

    public Lessons81302() {

        String[][] caseS = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

//        for(String[] arr : caseS){
//            System.out.println(Arrays.toString(arr));
//            for(String str : arr){
//                System.out.println(str);
//            }
//        }

        System.out.println(caseS[0][0].charAt(0));

        int[] results = {1, 0, 1, 1, 1};


        // Print Out Pass or Fail
//        System.out.println(Arrays.toString(this.mysolution(caseS)));
        String[] case1 = {
                "POOOP",
                "OXXOX",
                "OPXPX",
                "OOXOX",
                "POXXP"
        };
        this.mySolution(case1);

    }

    public int[] mysolution(String[][] places) {

        // 0. 전체 대기실을 순회하면서 체크하기.
        // 1. 존재하는 P들의 좌표가 서로 맨해튼 거리가 3이상인지, P가 존재하지 않으면 잘 지켜짐.
        // 2. if) 2이하 라면, 중간에 파티션이 있는지
        // 3. 거리가 지켜졌으면 1

        /**
         * P : 응시자가 앉은 잘;
         * O : 빈테이블
         * X : 파티션
         */

        int[] answer = new int[places.length];
        for(int a=0; a < answer.length; a++){
            answer[a] = 1;
        }
        System.out.println("Init Anser : " + Arrays.toString(answer));

        // 0번 room 기준 => room 전체 순회
        for(int roomNum =0; roomNum < places.length; roomNum++){// 30분 소요
            String[] targetRoom = places[roomNum];

            // break 시점.
            // 1. row, column 이 max를 치는 순간
            // 2. 거두리기가 실패한걸 확인한 순간.

            ArrayList<String> pList = new ArrayList<>();
            for(int row=0; row < 5; row++){
                for (int col=0; col < 5 ; col++){
                    char targetChar = targetRoom[row].charAt(col);
                    if(targetChar == 'P') { // 사람이 앉아있는 케이스
                        // 거리두기 확인.
                        String position = String.valueOf(row) + "," + String.valueOf(col);
                        pList.add(position);
                    }
                }
            }

            System.out.println(roomNum + "  pList : " + pList.toString());

            // P List 순회, 앉아있는 사람 리트스 순회
            for(int i=0; i < pList.size() - 1; i++){

                if(answer[roomNum] == 0) {break;}

                String targetPosition = pList.get(i);
//                System.out.println("targetPosition : " + targetPosition);

                for (int j=i+1; j < pList.size(); j++){

                    if(answer[roomNum] == 0) {break;}

                    String comparePosition = pList.get(j);

                    String[] As = targetPosition.split(","); String[] Bs = comparePosition.split(",");
                    int r1 = Integer.parseInt(As[0]); int r2 = Integer.parseInt(Bs[0]);
                    int c1 = Integer.parseInt(As[1]); int c2 = Integer.parseInt(Bs[1]);


                    int calrow = (r1+r2) / 2;
//                    if(r1 == 0 || r2 == 0){ calrow = Math.abs(r1-r2) -1;}
//                    else{calrow = Math.abs(r1 -r2);}

                    // 맨해튼 거리가 3 미만 이면 ..
                    if(this.getDistance(r1, c1, r2, c2) < 3){ // 1시간 소요

                        // 주변을 탐색

                        // case 1. row가 같고, col이 다를때,
                        if(r1 == r2 && c1 != c2){

                            // 바로 옆에 붙은 경우,  거리두기 실패
                            if(Math.abs(c1 -c2) == 1) {
                                answer[roomNum] = 0;
                                break;
                            }
                            // 가운데 파티션이 없으면, 거리두기 실패
//                            char possiblePartition = c1 - c2 > 0 ?  targetRoom[r1].charAt(c1-c2) : targetRoom[r1].charAt(c2-c1);
//                            if(possiblePartition != 'X') {
//                                System.out.println("RoomNum : " + roomNum + " 가운데 파티션이 없으면 거두기 실패" + " targetPosition vs comparePosition : "  + targetPosition + " vs " + comparePosition);
//                                answer[roomNum] = 0;
//                                break;
//                            }
//                            System.out.println(targetRoom[Math.abs(c1-c2) -1].charAt(c1));
                            if(targetRoom[calrow].charAt(c1) != 'X') {
                                System.out.println("RoomNum : " + roomNum + " 가운데 파티션이 없으면 거두기 실패" + " targetPosition vs comparePosition : "  + targetPosition + " vs " + comparePosition);
                                answer[roomNum] = 0;
                                break;
                            }
                        }

                        // case 2. row가 다르고, col이 같고,
                        if(r1 != r2 && c1 == c2){

                            System.out.println("case 2. row가 다르고, col이 같고,");

                            // 바로 옆에 붙은 경우,  거리두기 실패
                            if(Math.abs(r1 -r2) == 1) {
                                answer[roomNum] = 0;
                                break;
                            }

                            // 가운데 파티션이 없으면, 거리두기 실패
//                            char possiblePartition = r1 - r2 > 0 ?  targetRoom[r1-r2].charAt(c1) : targetRoom[r2-r1].charAt(c1);
//                            if(possiblePartition != 'X') {
//                                System.out.println("RoomNum : " + roomNum + " 가운데 파티션이 없으면 거두기 실패" + " targetPosition vs comparePosition : "  + targetPosition + " vs " + comparePosition);
//                                answer[roomNum] = 0;
//                                break;
//                            }
//                            System.out.println("possiblePartition : "  + possiblePartition);

                            if(targetRoom[calrow].charAt(c1) != 'X') {
//                                System.out.println("R1 : " + r1 + " R2 : " + r2 + " C1 : " +  c1 + " possiblePartition : " + " targetRoom[" + String.valueOf(Math.abs(r1-r2) -1) + "].charAt(" + c1 + ")" +targetRoom[Math.abs(r1-r2) -1].charAt(c1));
                                System.out.println("RoomNum : " + roomNum + " 가운데 파티션이 없으면 거두기 실패" + " targetPosition vs comparePosition : "  + targetPosition + " vs " + comparePosition);
                                answer[roomNum] = 0;
                                break;
                            }

                        }
                        // case 3. row가 다르고, col이 다르고
                        if(r1 != r2 && c1 != c2){

                            System.out.println("case 3. row가 다르고, col이 다르고");


                            if(targetRoom[r1].charAt(c2) != 'X' || targetRoom[r2].charAt(c1) != 'X' ){
                                System.out.println("RoomNum : " + roomNum + " 거두기 실패" + " targetPosition vs comparePosition : "  + targetPosition + " vs " + comparePosition);
                                answer[roomNum] = 0;
                                break;
                            }
                        }

                    }
                }
            }





        }

        return answer; // 총 1시간 15분 소요

    }


    int getDistance(int r1, int c1, int r2, int c2){

        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public int mySolution(String[] case1){


        int[][] matrix = new int[case1.length][case1[0].length()];
        ArrayList<Node> nodeList = new ArrayList<>();

        for(int j=0; j < case1.length; j++){

            for(int i=0; i < case1[j].length(); i++){

                char chr = case1[j].charAt(i);
                switch (chr) {
                    case 'P' :
                        matrix[j][i] = 1;
                        nodeList.add(new Node(j,i));
                        break;
                    case 'O' :
                        matrix[j][i] = 0;
                        break;
                    case 'X' :
                        matrix[j][i] = -1;
                        break;
                }
            }
        }

        // calculate distance.
        for(int i=0; i < nodeList.size() -1; i++){
            for(int j = i+1; j < nodeList.size(); j++){

                int dist = calDistance(nodeList.get(i).getRow(), nodeList.get(i).getCol(), nodeList.get(j).getCol(), nodeList.get(j).getCol());
                if(dist < 3){

                }
            }
        }

        return 0;
    }

    int calDistance(int r1, int c1, int r2, int c2){
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    class Node {

        int row; int col;
        Node(int row, int col){
            this.row = row;
            this.col = col;
        }

        int getRow() {return row;}
        int getCol() {return col;}
    }


    public static void main(String[] args) {

        new Lessons81302();

        // 1시간 반 소요
        // break 탈출이 애ㅔ매함.

    }
}
