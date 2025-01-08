import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int N, M, MAX;
    static int[][] map;
    static int[][] distance;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        /**
         * NxM 크기 공간에 아기 상어 여러마리가 있음
         * 1x1 크기 정사각형 칸에 상어 1마리
         * 이동은 인접한 8방향(대각선 포함) 가능
         * 안전 거리가 가장 큰 칸을 구하기.
         *
         * 2<= N,M <= 50
         * 0은 빈칸, 1은 아기상어 칸
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        map = new int[N][M]; //공간 상태
        distance = new int[N][M]; //각 칸의 안전 거리

        Queue<int[]> queue = new LinkedList<>();

        //거리 배열 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], -1);
        }

        //공간 상태 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                //상어가 있는 경우, 상어 위치 큐에 저장하고 안전 거리 0
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }

        //bfs 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && distance[nx][ny] == -1) {
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        //최댓값 찾기
        int MAX = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                MAX = Math.max(MAX, distance[i][j]);
            }
        }

        System.out.println(MAX);
    }
}