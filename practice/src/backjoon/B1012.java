package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1012 {

    static boolean graph[][];
    static boolean visited[][];
    static final int max = 50 + 10;
    static int dirY[] = {1, -1, 0, 0};
    static int dirX[] = {0, 0, 1, -1};

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if (!visited[newX][newY] && graph[newX][newY]) {
                dfs(newX,newY);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        // #0. 입력 및 초기화

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        // #1. 그래프 정보 입력
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph = new boolean[max][max];
            visited = new boolean[max][max];
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                graph[Integer.parseInt(st.nextToken())+1][Integer.parseInt(st.nextToken())+1] = true;
            }

            // #2. 방문하지 않은 지점부터 돌기
            for (int x = 0; x <= M; x++) {
                for (int y = 0; y <= N; y++) {
                    if (graph[x][y] && !visited[x][y]) {
                        dfs(x, y);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
            answer = 0;

        }


    }
}
