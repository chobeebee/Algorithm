import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static BigInteger[] dp;

    public static void main(String[] args) throws IOException {
        /*
         * 2xN 직사각형을 2x1, 2x2 타일로 채우는 방법 수 구하기.
         *
         * 점화식 dp[i] = dp[i-1] + dp[i-2]
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new BigInteger[251];

        dp[0] = BigInteger.ONE; //0x0 크기
        dp[1] = BigInteger.ONE; //2x1 크기
        dp[2] = new BigInteger("3");

        //DP 배열 채우기
        for (int i = 3; i <= 250; i++) {
            dp[i] = dp[i-1].add(dp[i-2].multiply(BigInteger.TWO));
        }

        //여러 테스트 케이스
        String input;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int N = Integer.parseInt(input);
            System.out.println(dp[N]);
        }

        br.close();
    }
}