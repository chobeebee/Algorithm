import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    * 다리 놓기
    * - 동쪽 서쪽 도시 사이 강이 있음
    * - 그 사이에 다리를 지으려고 함
    * - 사이트(N,M): 다리 짓기 적합한 곳
    * - 1개 사이트엔 1개 다리만 연결
    * - 서쪽 사이트(N) 만큼 다리를 지으려고 함 (겹치면 X)
    * 다리를 지을 수 있는 경우의 수 구하기
    *
    * 테스트 케이스의 개수 T
    * N, M (0 < N ≤ M < 30)
    *
    * ------------------------
    * 조합론
    * n개의 서로 다른 것 중에서 r개를 순서 없이 고르는 경우의 수
    * nCr = n! / (n-r)! * r!
    * C(n,r)=C(n−1,r−1)+C(n−1,r)
    * DP[n][r] = DP[n-1][r-1] + DP[n-1][r]
    * - dp[n][r]은 n개 중 r개를 고르는 경우의 수
    * - dp[n][0] = 1: 0개 고르는 경우는 무조건 1가지
    * - dp[n][n] = 1: 전부 고르는 경우도 1가지
    * * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] dp = new int[31][31]; // M,N 최대 30

        // DP 초기화
        for (int i = 0; i <= 30; i++) {
            dp[i][0] = 1; // 0개 고르는 경우는 무조건 1가지
            dp[i][i] = 1; // 전부 고르는 경우도 1가지

            // 점화식
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 서쪽 사이트 수
            int M = Integer.parseInt(st.nextToken()); // 동쪽 사이트 수

            // M개 중 N개를 고르는 경우의 수 출력
            System.out.println(dp[M][N]);
        }
    }
}