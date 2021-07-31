package com.dk.codingTest.hyndaiCard.bfsDfs;

import java.util.Arrays;

public class WordChange {

    public static void main(String[] args) {

        String begin = "hit"; String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        WordChange wordChange = new WordChange();
        System.out.println(
                wordChange.solution(begin, target, words)
        );



    }
    static int Scount = 999;

    public int solution(String begin, String target, String[] words){

        if(!Arrays.asList(words).contains(target)){return 0;}
        boolean[] check = new boolean[words.length];

        for(int i=0; i < begin.length(); i++){
            this.mydfs(i, target, begin, words, check, 0);
        }

        return Scount;
    }

    public void mydfs(int i, String target, String current, String[] words, boolean[] check, int count){

        if(check[i]){
            return;
        }

        check[i] = true;
        System.out.println(count);

        if(target.equals(current)){
            if(Scount > count && count != 0){
                Scount = count;
            }
            return;
        }

        for(int j=0; j < words.length; j++){
            if(!check[j]){
                if(getTargetWord(i, current).equals(getTargetWord(i, words[j]))){
                    mydfs(j, target, words[j], words, check, count++);
                }
            }
        }

    }

    private String getTargetWord(int i, String word){
        return word.replaceAll(Character.toString(word.charAt(i)), "");
    }





    static boolean[] visited;
    static int answer = 0;

    public int hammii_solution(String begin, String target, String[] words){

        visited = new boolean[words.length];

        return answer;
    }

    public static void hammii_dfs(String begin, String target, String[] words, int cnt){

        if(begin.equals(target)){
            answer = cnt;
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(visited[i]){
                continue;
            }

            int k = 0; // 같은 스펠링 몇개인지 세기
            for(int j=0; j < begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    k++;
                }
            }

            if(k == begin.length() -1){
                visited[i] = true;
                hammii_dfs(words[i], target, words, cnt++);
                visited[i] = false;
            }
        }
    }



}
