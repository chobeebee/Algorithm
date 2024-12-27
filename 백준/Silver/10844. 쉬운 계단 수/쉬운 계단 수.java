import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 계단 수 : 인접한 모든 자리의 차이가 1
         * 길이가 N인 계단 수가 총 몇개 있는지 구하기. 0으로 시작하는 수는 계단 수가 아님
         * 1<= N <=100
         * 정답은 1,000,000,000으로 나눈 나머지 출력
         *
         * 12 23 34 45 56 67 78 89 98 87 76 65 54 43 32 21 10
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine()); //계단 길이

        int MOD = 1000000000;
        long[][] dp = new long[N+1][10]; //[계단 길이][자리 수] : 계단 수의 개수

        //계단 길이가 1이면 1~9이니까 각 1개
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }

        //계단 길이가 2이상
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                //첫번재 자리에 0이 올 수 없음
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                }
                //9 다음에 올 숫자가 없음
                if (j + 1 <= 9) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        //총 계단 수
        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j]) % MOD;
        }

        System.out.println(result);
    }
}