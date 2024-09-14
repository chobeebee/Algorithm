import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 2xn크기의 직사각형 : 1x2, 2x1, 2x2
         * 방법의 수를 10,007로 나눈 나머지를 출력
         *
         * n=1 : 1
         * n=2 : 3
         * n=3 : 5 : 1*2 + 3
         * n=4 : 11 : 3*2 + 5
         * n=5 : ((n-2)*2) + (n-1)
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        }
        System.out.println(dp[N]);
    }
}