import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[][] map;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};

    public static void main(String[] args) throws IOException {
        /**
         * 다이나믹 프로그래밍(동적 계획법)
         * 피보나치 수열은 F(n) = F(n-1) + F(n-2)로 정의
         *
         * 다차원 배열로도 가능
         * D[i][j] = D[i-1][j] + D[i][j-1]를 세워서 해결
         *
         * 1. →, ↓, ↘의 세 방향만 사용
         * 2. 한 번에 한 칸씩 이동
         * 3. 왼쪽 위 (1, 1)에서 출발 -> 오른쪽 아래 (n, m)에 도착하는 경우의 수 구하기
         *
         * 방향 변수 필요
         * x(→) : 1, y(↓) : 1, ↘ : x+1, y+1
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new long[N+1][M+1];
        map[1][1] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                move(i, j);
            }
        }

        System.out.println(map[N][M]);
    }

    private static void move(int x, int y) {

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX > 0 && newY > 0 && newX <= N && newY <= M) {
                map[newX][newY] = (map[newX - 1][newY] + map[newX][newY - 1] + map[newX-1][newY - 1]) % (int)(Math.pow(10, 9)+7);
            }
        }
    }
}