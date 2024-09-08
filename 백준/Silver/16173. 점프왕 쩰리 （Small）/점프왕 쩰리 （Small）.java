import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 1. 범위를 벗어나면 안된다  0<=x,0<=y
         * 2. 출발점 0,0
         * 3. x{1, 0}, y{0, 1}
         * 4. x: n-1 , y: n-1 종료
         * 5. x< n, y< n
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(br.readLine());

        //디렉션 선언
        int[] directX = {1, 0};
        int[] directY = {0, 1};

        //맵 값 입력
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(map, directX, directY, n);
    }

    private static void bfs(int[][] map, int[] directX, int[] directY, int n) {
        //int sartX = 입력값;
        //int sartY = 입력값;
        //visited[sartX][sartY] = true;

        //좌표
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0,0});

        //방문 체크
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        //탐색
        while (!que.isEmpty()) {
            int[] current = que.poll(); //현재 위치 값

            for (int i = 0; i < 2; i++) {
                int newX = current[0] + directX[i] * map[current[0]][current[1]];
                int newY = current[1] + directY[i] * map[current[0]][current[1]];

                //범위를 넘어가지 않고 방문하지 않은 위치 탐색
                if(newX>=0 && newY>=0 && newX<n && newY<n && !visited[newX][newY]){
                    //원하는 조건
                    if (map[newX][newY] == map[n-1][n-1]) {
                        System.out.println("HaruHaru");
                        return;
                    }else{
                        //충족하지 못 했다면
                        visited[newX][newY] = true;
                        que.add(new int[]{newX, newY});
                    }
                }
            }
        }

        System.out.println("Hing");
    }
}