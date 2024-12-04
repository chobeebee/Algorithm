import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 공연장 CxR 크기, 좌석 번호(x,y)
         * 좌석 배정 : 조측 하단(1,1) 좌석부터 시작하여 시계 방향으로 배부
         * ↑으로 올라가면서 자리가 없으면 →으로, →도 더이상 자리가 없으면 ↓,↓도 더이상 없으면 ↑의 반복
         * 대기 순서 K인 관객에게 배정될 좌석 번호를 찾으시오.
         *
         * 좌석을 배정할 수 없는 경우 0 출력
         *
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); //공연장 가로
        int R = Integer.parseInt(st.nextToken()); //공연장 세로
        int K = Integer.parseInt(br.readLine()); //대기 순서 K 관객
        int[][] seats = new int[R][C]; //좌석 번호

        // 전체 좌석 수보다 대기 순서가 많으면 0 출력
        if (K > C * R) {
            System.out.println(0);
            return;
        }

        // 방향(상, 우, 하, 좌)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        //(1,1) 시작점
        int x = R -1;
        int y = 0;

        int direction = 0; // 0: 상, 1: 하, 2: 좌, 3: 우
        int count = 1; //대기 번호

        while (count <= K) {

            //대기 순서 차례로 좌석 배부
            seats[x][y] = count;

            //횟수가 대기 순서 K와 같을 경우 종료
            if (count == K) {
                System.out.println((y + 1) + " " + (R - x));
                return;
            }

            //다음 좌석으로 이동
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            //공연장 범위를 벗어나거나 이미 배정된 좌석일 경우, 방향 변경
            if (nx < 0 || nx >= R || ny < 0 || ny >= C || seats[nx][ny] != 0) {
                direction = (direction + 1) % 4; //시계방향으로 변경
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            //다음 좌석
            x = nx;
            y = ny;
            count++; //다음 대기 번호
        }
    }
}