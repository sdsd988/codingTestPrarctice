package backjoon;

import java.util.Scanner;

public class B2023 {

    static int N;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7,1);

    }

    static void DFS(int number, int jarisu) {
        if (jarisu == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(number * 10 + i)) {
                DFS(number * 10 + i, jarisu + i);
            }
        }
    }


    static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++)
            if (num % i == 0) return false;

        return true;
    }

}
