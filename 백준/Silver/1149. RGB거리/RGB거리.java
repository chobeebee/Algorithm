import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * RGB거리에 집이 N개 있다. 거리는 선분, 1번~N번 집이 순서대로 있다.
         * 빨강, 초록, 파랑 중 하나의 색을 칠해야 함
         * 모든 집을 칠하는 최소 비용을 구하시오.
         *
         * - 1번 집의 색은 2번 집의 색과 같지 않아야 함
         * - N번 집 색은 N-1번 집 색과 같지 않아야 함
         * - i(2<=i<=N-1)번 집 색은 i-1번, i+1번 집 색과 같지 않아야 함
         *
         * 집을 칠하는 비용 <= 1000
         *
         * 3
         * R    G   B
         * 26   40  83 => 26
         * 49   60  57 => 60
         * 13   89  99 => 13
         *
         * 6
         * R    G   B
         * 30   19  5 => 5
         * 64   77  64 => 64
         * 15   19  97 => 19
         * 4    71  57 => 4
         * 90   86  84 => 84
         * 93   32  91 => 32
         *
         * i번째에서 가장 적은 비용으로 빨간색을 칠하는 경우는
         * dp[i][0]=Min(dp[i−1][1],dp[i−1][2])+price[i][0]가 되고,
         * 다른 색도 같은 방식으로 진행된다.(0 : R, 1 : G, 2 : B)
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //집의 수
        int[][] price = new int[N][3]; //색칠 가격

        //집마다 가격 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //R,G,B 각 점화식 적용
        for (int i = 1; i < N; i++) {
            price[i][0] += Math.min(price[i - 1][1], price[i - 1][2]); //R
            price[i][1] += Math.min(price[i - 1][0], price[i - 1][2]); //G
            price[i][2] += Math.min(price[i - 1][0], price[i - 1][1]); //B
        }

        //가장 작은 값 출력
        System.out.println(Math.min(price[N - 1][0], Math.min(price[N - 1][1], price[N - 1][2])));
    }
}