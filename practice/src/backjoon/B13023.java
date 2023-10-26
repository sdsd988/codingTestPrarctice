package backjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B13023 {

    static boolean visited[];
    static ArrayList<Integer> [] A;
    static boolean arrive;

    public static void main(String[] args) {
        int N;
        int M;
        arrive = false;
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            int S = scanner.nextInt();
            int E = scanner.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);

            if(arrive) break;

        }

        if(arrive)
            System.out.println("1");
        else System.out.println("0");
    }

    public static void DFS(int now, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[now] = true;
        for (int i : A[now]) {
            if(!visited[i]){
                DFS(i, depth + 1);
            }
        }


        visited[now] = false;
    }
}
