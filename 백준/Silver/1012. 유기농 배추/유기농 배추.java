import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int[] dX = {1,-1,0,0};
    static int[] dY = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        /**
         * 1. 배추 흰지렁이가 있으면 인접한 다른 배추로 이동할 수 있음
         * 2. 0: 배추 X , 1: 배추 O
         * 3. 필요한 흰지렁이 마리 수 출력
         *
         * 풀이 사고 >>
         * 인접한 1은 하나로 카운트
         * - 방문 체크 배열 필요
         * - 사방을 탐색 {0,1,-1,0}
         * - 탐색 시 1을 발견하면, 발견한 1을 방문으로 체크한 후 해당 위치로 이동하여 또 사방 탐색
         * - count 변수를 만들고 dfs() 실행 시, count++ 되도록
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); //테스트 수

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //행
            int M = Integer.parseInt(st.nextToken()); //열
            int K = Integer.parseInt(st.nextToken()); //배추 개수
            boolean[][] visited = new boolean[N][M]; //방문 체크
            int count = 0; //지렁이 수

            //맵 구성
            int[][] matrix = new int[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[x][y] = 1;
            }

            //총 지렁이 수 찾기
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(matrix[j][k] == 1 && !visited[j][k]){
                        bfs(matrix, visited, N, M, j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs(int[][] matrix, boolean[][] visited, int N, int M, int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < dX.length; i++) {
                int newX = x+dX[i];
                int newY = y+dY[i];

                if (newX >= 0 && newY >= 0 && newX < N && newY < M && !visited[newX][newY]) {
                    if(matrix[newX][newY] == 1){
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}