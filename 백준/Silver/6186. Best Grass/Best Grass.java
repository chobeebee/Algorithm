import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static boolean[][] visited;
    static int count=0;
    public static void main(String[] args) throws IOException {
        /**
         * 1. 행 1<=N<=100 , 열 1<=M<=100
         * 2. 입력은 '.','#' 으로만
         * 3. 대긱선은 제외, 사방위에서 연속되는 #은 하나로 침
         *
         * BFS 사용!
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M]; //방문 체크

        //다이렉션
        int[] directX = {1, 0, -1, 0};
        int[] directY = {0, 1, 0, -1};

        //목초지
        char[][] matrix = new char[N][M];

        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                matrix[i][j] =  tmp.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == '#' && !visited[i][j]) {
                    dfs(directX, directY, matrix, N, M, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[] directX, int[] directY, char[][] matrix, int N, int M, int startX, int StartY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,StartY});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + directX[i];
                int newY = y + directY[i];

                if (newX >= 0 && newY >= 0 && newX < N && newY < M && !visited[newX][newY]) {
                    if(matrix[newX][newY]=='#'){
                        visited[newX][newY]=true;
                        queue.add(new int[]{newX,newY});
                    }
                }
            }
        }
    }
}