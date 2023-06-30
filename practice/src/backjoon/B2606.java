package backjoon;

import java.util.Scanner;

public class B2606 {

    static boolean [][] graph;
    static boolean [] visited;
    static int N,M;
    static int answer;

    public static void dfs(int idx) {
        answer++;
        visited[idx] = true;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]&&graph[idx][i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        //0. 입력 및 초기화
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];


        //1. 그래프 정보 입력

        int x,y;
        for (int i = 0; i < M; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            graph[x][y] = graph[y][x] = true;
        }

        dfs(1);

        System.out.println(answer - 1);
        sc.close();
    }
}
