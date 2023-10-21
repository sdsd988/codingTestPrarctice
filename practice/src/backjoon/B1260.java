package backjoon;

import java.util.*;

public class B1260 {

    static boolean visited[];
    static ArrayList<Integer>A[] ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int start = scanner.nextInt();

        //그래프 생성
        A = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        // 그래프 완성
        for (int i = 0; i < M; i++) {
            int S = scanner.nextInt();
            int E = scanner.nextInt();

            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 1; i < N+1; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N + 1];
        DFS(start);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(start);
        System.out.println();

    }

    private static void DFS(int node) {
        System.out.print(node+" ");
        visited[node] = true;
        for (Integer integer : A[node]) {
            if (!visited[integer]) {
                DFS(integer);
            }
        }
    }
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);

        visited[node] = true;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            System.out.print(node+" ");
            for (Integer integer : A[node]) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    queue.add(integer);
                }
            }
        }
    }


}
