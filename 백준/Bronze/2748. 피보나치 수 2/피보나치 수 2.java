import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * Fn = Fn-1 + Fn-2 (n>=2)
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        long[] dp = new long[(int) (N+1)]; //dp 배열 선언

        dp[0] = 0; //0번째 값
        dp[1] = 1; //1번째 값

        //Fn = Fn-1 + Fn-2
        for (long i = 2; i <= N; i++) {
            dp[(int) i] = dp[(int) (i - 1)] + dp[(int) (i - 2)];
        }

        System.out.println(dp[(int) N]);
    }
}