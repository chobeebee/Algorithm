import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    //상하좌우
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        /**
         * 빙산의 각 부분별 높이 정보, 0(빈칸)은 바다
         * 빙산은 바닷물에 많이 접해있으면 빨리 줄어듦.
         * 빙산 높이는 1년마다 동서남북 4방향으로 붙어있는 0 개수 만큼 줄어듦.
         * 한 덩어리의 빙산이 두 덩어리 이상으로 분리되는 최초의 시간 구하기.
         * 전부 다 녹을 때까지 분리되지 않으면 0 출력.
         *
         * 3<= 행열 N,M <=300
         * 0<= 빙산 높이 <=10
         *
         * bfs 이용
         * 4가지 방향 변수 필요
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열
        map = new int[N][M]; //빙산 높이 배열
        visited = new boolean[N][M]; //방문 체크

        //빙산 높이 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0; //년수

        while (true) {
            int count = countIce(); //빙산 덩어리 개수

            //빙산이 분리된 경우
            if (count >= 2) {
                System.out.println(year);
                break;
            } else if (count == 0) {
                //모두 녹은 경우
                System.out.println(0);
                break;
            }

            //빙산을 녹인 후 1년 증가
            melt();
            year++;
        }
    }

    private static int countIce() {
        visited = new boolean[N][M];  // 방문 배열 초기화
        int count = 0;  // 빙산 덩어리 수

        //빙산 덩어리 탐색
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j);
                    count++; //새로운 빙산 덩어리 발견
                }
            }
        }
        return count;
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            //4방향 탐색
            for (int i = 0; i < dx.length; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                //지도 범위를 벗어나지 않고 방문하지 않은 빙산일 경우
                if (newX >= 0 && newX < N && newY >= 0 && newY < M){
                    if(map[newX][newY] > 0 && !visited[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }

    private static void melt() {
        //녹은 후, 상태 저장
        int[][] temp = new int[N][M];

        //녹는 높이 계산
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] > 0) {
                    int seaCount = 0;  //주변 바다 개수

                    //상하좌우의 바다 개수 세기
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            if(map[nx][ny] == 0) {
                                seaCount++;
                            }
                        }
                    }

                    //녹은 후, 높이 계산
                    temp[i][j] = Math.max(0, map[i][j] - seaCount);
                }
            }
        }

        //계산된 결과를 실제 지도에 반영
        for(int i = 0; i < N; i++) {
            map[i] = temp[i].clone();
        }
    }
}