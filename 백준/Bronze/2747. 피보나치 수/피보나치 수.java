import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * Fn = Fn-1 + Fn-2 (n>=2)
         * 0,1,1,fn[n-1]+fn[n-2]
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1]; //dp 배열 선언

        dp[0] = 0; //0번째 값
        dp[1] = 1; //1번째 값

        //Fn = Fn-1 + Fn-2
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N]);
    }
}