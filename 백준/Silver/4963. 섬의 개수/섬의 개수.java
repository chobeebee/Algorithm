import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int[] dX={1,-1,0,0,1,-1,1,-1};
    static int[] dY={0,0,1,-1,1,-1,-1,1};

    public static void main(String[] args) throws IOException {
        /**
         * 조건 정리>>
         * 1:섬과 0:바다 / 섬의 개수를 찾아라
         * 가로, 세로 또는 대각선으로 갈 수 있다
         * 섬이 이어져 있어야 걸어갈 수 있음
         * 지도 밖으로 이동 X (범위를 벗아나면 안 됨)
         * 크기는 w,h <=50
         *
         * 사고 과정>>
         * 사방위 + 대각선 방향 설정하고
         * 방문 배열 만들어서 방문 체크
         * 1이고 체크 하지 않았다면 dfs 실행하여 count 세기..?
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            boolean[][] visited = new boolean[w][h];
            int count = 0;

            if (w == 0 && h == 0) {
                break;
            }

            //맵구성
            String[][] matrix = new String[w][h];

            for (int i = 0; i < w; i++) {
                String tmp = br.readLine();
                matrix[i] = tmp.split(" ");
            }

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (matrix[i][j].equals("1") && !visited[i][j]) {
                        bfs(matrix, visited, w, h,i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(String[][] matrix, boolean[][] visited, int w, int h, int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < dX.length; i++) {
                int newX = x + dX[i];
                int newY = y + dY[i];

                if (newX >= 0 && newY >= 0 && newX < w && newY < h && !visited[newX][newY]) {
                    if(matrix[newX][newY].equals("1")){
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}