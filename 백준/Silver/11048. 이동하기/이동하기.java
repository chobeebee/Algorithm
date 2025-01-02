import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * NxM 미로, 각 방에 사탕이 놓여져 있음
         * 미로의 가장 왼쪽 윗 방은 (1,1), 가장 오른쪽 아랫 방은(N,M)
         * (1,1)에서 (N, M)으로 이동하려고 함.
         * 현 위치가 (r,c)라고하면 (r+1, c), (r,c+1), (r+1, c+1)로 이동할 수 있음
         * 각 방을 방문할 때마다 사탕을 모두 가져갈 수 있고 미로 밖으로는 나갈 수 X
         * 준규가 가져올 수 있는 사탕의 개수 최댓값 구하기.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //가로
        int M = Integer.parseInt(st.nextToken()); //세로

        int[][] candyMap = new int[N][M]; //각 방의 사탕 개수 저장
        int[][] dp = new int[N][M]; //각 위치까지의 최대 사탕 개수 저장

        //각 방의 사탕 개수 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M; j++) {
                candyMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //(1,1)에서 시작
        dp[0][0] = candyMap[0][0];

        // 첫 번째 열 초기화(r+1, c)
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + candyMap[i][0];
        }
        //첫 번째 행 초기화(r, c+1)
        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j - 1] + candyMap[0][j];
        }

        //나머지 칸에 대해 dp 계산
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                //1) 왼쪽에서 오는 것과 대각선에서 오는 것 중 큰 값
                //2) 1번 값과 위에서 오는 것을 비교하여 큰 값
                //3) 현 위치까지 오면서 가지는 최대 사탕 개수 + 현재 방에 있는 사탕 개수 더하기
                dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1])) + candyMap[i][j];
            }
        }

        //최대 사탕 개수 출력
        System.out.println(dp[N - 1][M - 1]);
    }
}