package backjoon;

import java.io.*;

public class B1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toUpperCase();

        //1. 알파뱃별 counting
        int[] count = new int[26];

        int maxValue = 0;   
        char maxChar = '?';

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'A';
            ++count[idx];

            if(maxValue < count[idx]){
                maxValue = count[idx];
                maxChar = str.charAt(i);
            } else if (maxValue == count[idx]) {
                maxChar = '?';
            }

        }

        bw.write(maxChar);
        bw.close();
        br.close();
    }
}
