import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현
         * 자연수 n, 최소 개수의 제곱수 합
         * 1: 1^2 : 1개
         * 2: 1^2+1^2 : 2개
         * 3: 1^2+1^2+1^2 : 3개
         * 4: 2^2 : 1개
         * 5: 2^2+1^2 : 2개
         * 6: 2^2+1^2+1^2 : 3개
         * 7: 2^2+1^2+1^2+1^2 : 4개
         * 8: 2^2+2^2 : 2개
         * 9: 3^2 : 1개
         * 10:3^2+1^2 : 2개
         * 11:3^2+1^2+1^2 : 3개
         * 12:3^2+1^2+1^2+1^2 : 4개
         * 13:3^2+2^2 : 2개
         *
         * dp[i] = dp[i-j*j]+1
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }

        System.out.println(dp[N]);
    }
}