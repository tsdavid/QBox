package com.dk.codingTest.hyndaiCard.bfsDfs;

import java.lang.annotation.Target;

public class TargetNumber {

    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int returns = 5;

        TargetNumber targetNumber = new TargetNumber();
        System.out.println(targetNumber.velog_solution(numbers, target));

    }

    public int velog_solution(int[] numbers, int target){

        int answer = 0;
        answer = bfs(numbers, target, numbers[0], 1) + bfs(numbers, target, -numbers[0], 1);

        return answer;

    }


    public int bfs(int[] numbers, int target, int sum, int i){

        System.out.println(
                "Call BFS : Sum : " + sum + " int i : " + i
        );

        if( i==numbers.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }

        int result = 0;
        result += bfs(numbers, target, sum + numbers[i], i + 1);
        result += bfs(numbers, target, sum - numbers[i], i + 1);
        return result;
    }
}
