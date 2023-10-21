package programmers;

public class P01 {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n + 2];
        int answer = 0;

        for (int l : lost) {
            lost[l]--;
        }

        for (int r : reserve) {
            reserve[r]++;
        }

        for (int i = 1; i <= n; i++) {
            if (student[i] == 1) {
                if (student[i - 1] == -1) {
                    student[i]--;
                    student[i - 1]++;
                } else if (student[i + 1] == -1) {
                    student[i]--;
                    student[i + 1]++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (student[i] >= 0) {
                answer++;
            }
        }

        return answer;
    }
}
