import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //북(0), 동(1), 남(2), 서(3)
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};

    private static int N,M; //방 크기
    private static int[][] map; //방 지도
    private static boolean[][] visited; //방문 체크

    public static void main(String[] args) throws IOException {
        /**
         * 방 크기 NxM, 청소기 방향 동서남북, 방의 칸 좌표(r,c)
         * 1. 청소되지 않은 칸 청소한다
         * 2. 현재 칸에서 주변 4칸 다 청소된 칸일 경우,
         *      - 한 칸 후진 후, 1번으로 돌아감
         *      - 후진 할 수 없으면 작동을 멈춤
         * 3. 주변 4칸 중 청소되지 않은 빈 칸이 있을 경우,
         *      - 반 시계 방향으로 90도 회전
         *      - 바라보는 방향 기준 앞 칸이 청소되지 않은 빈칸 일 경우 전진
         *      - 1번으로 돌아감
         *
         * 3<=N,M<=50
         * 처음 로봇이 있는 칸 (r,c), 방향 d
         * 바라보는 방향 d : 북(0), 동(1), 남(2), 서(3)
         * 청소되지 않음(0), 벽(1)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()); //시작 위치 x
        int startY = Integer.parseInt(st.nextToken()); //시작 위치 y
        int startD = Integer.parseInt(st.nextToken()); //시작 방향

        //방 상태 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(startX,startY, startD);

    }

    private static void clean(int x,int y, int d) {

        int count = 0; //청소 칸 개수
        int direction = d;

        while (true) {

            //현재 위치 청소
            if (!visited[x][y]) {
                visited[x][y] = true;
                count++;
            }

            boolean cleaned = false; //주변 4칸 중 청소할 곳이 있는지 확인

            //네방향 탐색
            for (int i = 0; i < dx.length; i++) {

                direction = (direction + 3) % 4; //반 시계 방향 90도 회전

                int newX = x + dx[direction];
                int newY = y + dy[direction];

                //방을 벗어나지 않고 아직 청소하지 않았을 경우
                if (newX >= 0 && newY >= 0 && newX < N && newY < M && map[newX][newY] == 0 && !visited[newX][newY]) {
                    x = newX;
                    y = newY;
                    cleaned = true; //청소할 곳 있음
                    break;
                }
            }

            //주면 4칸이 다 청소할 곳이 없다면 후진
            if (!cleaned) {
                int backX = x - dx[direction];
                int backY = y - dy[direction];

                if(map[backX][backY] == 1) break; //후진할 수 없으면 종료

                x = backX;
                y = backY;
            }
        }

        System.out.println(count);
    }
}