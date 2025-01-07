import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 1,2,3의 합으로 정수 n을 나타내는 방법의 수 구하기.
         *
         * 테스트 케이스 T / 정수 n <= 1,000,000
         * 방법의 수를 1,000,000,009로 나눈 나머지 출력
         *
         * n = 1 : 1
         * n = 2 : 1+1, 2
         * n = 3 : 1+1+1, 1+2, 2+1, 3
         *
         * dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
        int mod = 1000000009; //방법의 수를 나눌 값
        int max = 1000000; //정수 최대 값
        long[] dp = new long[max+1]; //1,2,3의 합으로 나타내는 방법의 수

        //초기값
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= max; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % mod;
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[n]);
        }
    }
}