import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int[] directX = {1, 0};
    static int[] directY = {0, 1};

    public static void main(String[] args) throws IOException {
        /**
         * <전형적인 BFS 문제>
         * 조건
         * 1. 도시 N, M 격자 모양으로 구성 됨 (1<=N,M<=300)
         * 2. 진우는 북서쪽 끝, 거래소는 남동쪽 끝에 위치
         * 3. 가는 길에 건물이 있어서 지나갈 수 없음 (1,0 중 0칸은 지나갈 수 없는 칸)
         * 4. 최대한 빨리 : 동쪽(오른쪾) || 남쪽(아래쪽)으로만 이동  => {1,0}만 사용
         * 진우가 거래소 갈 수 있으면 Yes, 아니면 No 출력
         *
         * 풀이 생각해보기.
         * BFS 사용
         * x,y를 0,1 방향을 사용
         * 방문 체크할 배열 만들고
         * 현재 위치 좌표에서 사방을 체크할 때, 1을 발견하면 1의 좌표로 이동하도록 하면 되지 않을까~~~
         * 거래소 도착하면 끝!
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[N][M];

        //맵 구성
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //진우 현 위치
        int startX=0;
        int startY=0;

        dfs(matrix, visited,N, M, startX, startY);

    }

    private static void dfs(int[][] matrix, boolean[][] visited, int N, int M, int StartX, int StartY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{StartX,StartY});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if(x == N-1 && y== M-1){
                System.out.println("Yes");
                return;
            }

            for (int i = 0; i < directX.length; i++) {
                int newX = x+directX[i];
                int newY = y+directY[i];

                if(newX >=0 && newY >=0 && newX < N && newY < M && !visited[newX][newY]){
                    if(matrix[newX][newY] == 1){
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        System.out.println("No");
    }
}