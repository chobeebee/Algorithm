import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 버튼을 누르면 A -> 1번 클릭 : B, 2번 클릭 : BA, 3번 클릭 : BAB, 4번클릭 : BABBA 로 변함
         * B -> BA, A -> B
         *
         * K번 누를때 화면의 A와 B의 개수는?
         *
         * 1<=K<=45
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); //줄 수
        int[][] dp = new int[K+1][2];

        /**
         * B(n) = A(n-1)+B(n-1); A(n) = B(n-1)
         */

        //0번 클릭 : 문자열 A일때, A와 B 각 개수
        dp[0][0] = 1;
        dp[0][1] = 0;

        //K번 눌렀을 때, A와 B 각 개수
        for (int i = 1; i <= K; i++) {
            dp[i][1] = dp[i-1][0] + dp[i-1][1];
            dp[i][0] = dp[i-1][1];
        }

        System.out.println(dp[K][0]+ " " +dp[K][1]);
    }
}