import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 마인크래프트 1x1x1(세로, 가로, 높이)
         * 집터 NxM(세로, 가로)
         * 1.좌표(i,j)의 가장 위에 있는 블록 제거 > 인벤토리에 넣음 : 2초
         * 2.인벤토리에서 블록 하나 꺼내서 좌표(i,j)의 가장 위에 있는 블록 위에 놓음 : 1초
         *
         * 동일한 높이로 땅 고르기 작업 : 최소 시간과 땅 높이 구하기
         * 빈 공간 X, 집터 바깥 블록 가져올 수 없음
         * 작업 시작할 때 인벤토리에 B개 블록이 있음
         * 땅 높이 < 256 (음수X)
         * (i+2)번째 줄 : (j+1)번쨰 수 = 좌표(i,j)에서의 땅의 높이
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //가로
        int M = Integer.parseInt(st.nextToken()); //세로
        int B = Integer.parseInt(st.nextToken()); //블록 수
        int[][] map = new int[N][M]; //땅 지도
        int max = 0; //최대 높이
        int min = 255; //최소 높이
        int minTime = Integer.MAX_VALUE;
        int height = 0;

        //땅 높이 지도
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        //최소 높이~최대 높이 탐색
        for (int i = min; i <= max; i++) {
            int time=0; //소요 시간
            int block = B; //인벤토리 블록 수

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    //높이가 커서 블록 제거할 경우
                    if (map[j][k] > i) {
                        time += (map[j][k] - i) * 2; //제거해야할 블럭 수 * 2초
                        block += (map[j][k] - i); //인벤토리에 제거한 블록 추가
                    } else if (map[j][k] < i) {
                        //높이가 작아서 추가할 경우
                        time += (i - map[j][k]); //추가할 블럭 수 만큼(1초)
                        block -= (i - map[j][k]); //인벤토리에 채운 블록 수 뺴기
                    }
                }
            }
            //인벤토리가 음수가 아니고 현재 시간이 적다면
            if (block >= 0 && minTime >= time) {
                minTime = time;
                height = i;
            }
        }

        //최소 시간, 높이 출력
        System.out.println(minTime + " " + height);
    }
}