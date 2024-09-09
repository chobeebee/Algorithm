import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    static int[] dX = {1,-1,0,0};
    static int[] dY = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        /**
         * 1,2,3을 합하여 n값을 구하는 방법 수
         *
         * dp라....
         *
         * dp[1]
         * 1
         * ---------
         * dp[2]
         * 1+1
         * 2
         * ---------
         * dp[3]
         * 1+1+1
         * 2+1
         * 1+2
         * 3
         * ---------
         * dp[4]
         * 1+1+1+1
         * 2+1+1
         * 1+2+1
         * 3+1
         * 1+1+2
         * 2+2
         * 1+3
         *
         * dp[4] = dp[3]+dp[2]+dp[1]
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] dp = new int[11];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int j = 4; j <= N; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }

            System.out.println(dp[N]);
        }
    }
}