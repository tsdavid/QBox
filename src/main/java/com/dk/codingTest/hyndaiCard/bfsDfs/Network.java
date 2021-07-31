package com.dk.codingTest.hyndaiCard.bfsDfs;

public class Network {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

//        Network network = new Network();
//        System.out.println(network.solution(computers, n));

        System.out.println(computers.length);

    }

    public int solution(int[][] computers, int n) {

        int networks = computers.length;
        for (int x = 0; x < computers.length - 1; x++) {
            int y = x + 1;

            if (computers[x][y] == 1 && computers[y][x] == 1) {
                networks--;
            }
        }

        return networks;

    }

    public int velog_ajufresh_solution(int n, int[][] computers) {

        int answer = 0;
        boolean[] check = new boolean[n];
        // N 갯수 만큼 boolean 배열을 만들고 모든 요소를  false로 초기화화

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, i, check);
                answer++;
            }
        }
        return answer;
    }


    boolean[] dfs(int[][] computers, int i, boolean[] check) {
        check[i] = true; // 탐색 marking

        for (int j = 0; j < computers.length; j++) {
            {
                if (i != j && computers[i][j] == 1 && !check[j]) {
                    check = dfs(computers, j, check);
                }
            }
        }
        return check;


    }
}
