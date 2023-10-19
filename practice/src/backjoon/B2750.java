package backjoon;

import java.util.Scanner;

public class B2750 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N ; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < N-1 ; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int tem = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tem;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(A[i]);
        }
    }
}
