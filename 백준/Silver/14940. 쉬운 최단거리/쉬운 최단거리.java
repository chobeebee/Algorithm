import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int[] dX = {1, -1, 0, 0};
    static int[] dY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        /**
         * 목표 지점까지 가는 모든 루트를 세기
         * 방향은 가로와 세로로만
         * 지도의 크기는 n*m (2<=n,m<=1000)
         * 0 : 갈 수 없는 땅 , 1 : 땅, 2: 목표지점
         * 원래 갈 수 없는 땅인 위치는 0을 출력
         * 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력하다? : 1이지만 방문하지 않는건 -1을 출력하는 조건을 달아야??
         *
         * 사고 과정>>
         * bfs....고
         * 방문 배열 필요하고
         * queue에 x, y, count
         * root를 저장할 맵이 필요하네? : 방문 유무와 1인지 아닌지를 확인해서 -1을 출력하네 마네 해야겠네...?
         * root를 출력해야겠네?
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[N][M];
        int[][] newMatrix = new int[N][M];

        //맵 구성
        String[][] matrix = new String[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            matrix[i] = tmp.split(" ");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j].equals("2")){
                    bfs(matrix, newMatrix, visited, N, M, i, j);
                }
            }
        }
    }

    private static void bfs(String[][] matrix,int[][] newMatrix, boolean[][] visited, int N, int M, int startX, int startY) {
        StringBuilder sb = new StringBuilder();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int root = current[2];

            for (int i = 0; i < dX.length; i++) {
                int newX = x + dX[i];
                int newY = y + dY[i];

                if (newX >= 0 && newY >= 0 && newX < N && newY < M && !visited[newX][newY]) {
                    if(matrix[newX][newY].equals("1")){
                        visited[newX][newY] = true;
                        newMatrix[newX][newY] = root+1;
                        queue.add(new int[]{newX, newY, root + 1});
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j].equals("1") && visited[i][j] == false) {
                    sb.append("-1").append(" ");
                }else{
                    sb.append(newMatrix[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}