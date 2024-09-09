import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int[] dX = {1, -1, 0, 0};
    static int[] dY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        /**
         * 1. NXM 크기의 배열의 미로 (2<= N, M <= 100)
         * 2. 1 : 이동할 수 있는 칸, 0: 이동할 수 X 칸
         * 3. (0,0)에서 출발 ~ (N-1,M-1)로 이동하는 최소의 칸 수
         * 4. 서로 인접한 칸으로만 이동 가능
         * 5. 칸을 셀 때, 시작위치, 도착위치 포함할 것
         *
         * 풀이 사고 >>
         * 1. 4방향으로 탐색
         * 2. 1을 발견하면 해당 위치로 좌표값 변경
         * 3. 갈 수 있는 방향이 2가지일 때, 각 루트 타서 개수 비교...
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[N][M]; //방문 체크

        //맵 구성
        char[][] matrix= new char[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            matrix[i] = tmp.toCharArray();
        }

        //출발점
        int startX = 0;
        int startY = 0;

        bfs(matrix, visited, N, M, startX, startY);
    }

    private static void bfs(char[][] matrix, boolean[][] visited, int N, int M, int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY,1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (x == N-1 && y == M-1) {
                System.out.println(count);
                return;
            }

            for (int j = 0; j < dX.length; j++) {
                int newX = x + dX[j];
                int newY = y + dY[j];

                if (newX >= 0 && newY >= 0 && newX < N && newY < M && !visited[newX][newY]) {
                    if(matrix[newX][newY] == '1'){
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY,count+1});
                    }
                }
            }
        }
    }
}