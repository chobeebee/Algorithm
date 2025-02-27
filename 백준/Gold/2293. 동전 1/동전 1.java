import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * n가지 동전, 각각 가치가 다름
         * 가치의 합이 k가 되도록 하는 경우의 수 구하기.
         * 동전의 구성은 같고 순서가 달라도 같은 경우 임
         *
         * 1<= n <= 100, 1<= k <=10,000
         * 동적의 가치 <- 100,000
         * 경우의 수 < 2^31
         *
         * ----
         * K=5 : 1 2 5
         * dp[0] = 1 : 0
         * dp[1] = dp[i-1] = dp[0]+1 : 1
         * dp[2] = dp[2-1] + dp[2-2] = dp[1] + dp[0] : 1+1, 2
         * dp[3] = dp[3-1] + dp[3-2] = dp[2] + dp[1] : 1+1+1, 1+2
         * dp[4] = dp[4-1] + dp[4-2] = dp[3] + dp[2] : 1+1+1+1, 1+1+2, 2+2
         * dp[5] = dp[5-1] + dp[5-2] + dp[5-5] = dp[4] + dp[3] + dp[0] : 1+1+1+1+1, 1+1+1+2, 1+2+2, 5
         *
         * dp[i] = dp[i] + dp[i - coin]
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //동전 개수
        int K = Integer.parseInt(st.nextToken()); //원하는 가치 값
        int[] coins = new int[N]; //동전 가치 배열
        int[] dp = new int[K+1]; //경우의 수

        //가치 입력
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1; //0을 만드는 법 : 1개

        for (int coin : coins) {
            //coin부터 K까지 각 가치 i에 대해
            for (int i = coin; i <= K; i++) {
                //coin 한 개를 추가하여 가치 i를 만드는 경우의 수
                dp[i] += dp[i - coin];
            }
        }

        //가치 K를 만드는 경우의 수 출력
        System.out.println(dp[K]);
    }
}
