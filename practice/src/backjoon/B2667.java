package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class B2667 {
    static final int max = 25+10;
    static boolean graph[][];
    static boolean visited[][];
    static int counterDanji;
    static int dirY[] = {1, -1, 0, 0};
    static int dirX[] = {0, 0, 1, -1};

    static void dfs(int x, int y) {
        visited[x][y] = true;
        counterDanji++;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirX[i];
            int newY = x + dirY[i];
            if (!visited[newX][newY] && graph[newX][newY])
                dfs(newX, newY);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new boolean[max][max];
        visited = new boolean[max][max];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++)
                graph[i][j] = s.charAt(j - 1) == '1';
        }

        ArrayList<Integer> countList = new ArrayList<>();
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                if (graph[i][j] && !visited[i][j]) {
                    counterDanji = 0;
                    dfs(i, j);
                    countList.add(counterDanji);
                }
        System.out.println(countList.size());
        Collections.sort(countList);
        for (int i = 0; i < countList.size(); i++)
            System.out.println(countList.get(i));
        br.close();


    }

}


