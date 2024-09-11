import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int T = Integer.parseInt(br.readLine()); //테스트 수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N+1];
            dp[0] = 0;
            dp[1] = 1;

            if (N > 1) {
                dp[2] = 1;
                for (int j = 3; j <= N; j++) {
                    dp[j] = dp[j - 3] + dp[j - 2];
                }
            }
            System.out.println(dp[N]);
        }
    }
}