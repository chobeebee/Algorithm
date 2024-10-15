import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx={-1,1,0,0,0,0};
    static int[] dy={0,0,-1,1,0,0};
    static int[] dz={0,0,0,0,-1,1};
    static int M,N,H;
    static int[][][] box;
    static Queue<Tomato> queue;

    public static void main(String[] args) throws IOException {
        /**
         * 토마토 격자 모양 상자를 수직으로 쌓아 올려서 창고에 보관
         * MxNxH
         * 보관 후 하루가 지나면, 익은 토마토와 인접한 토마토는 익게 됨
         * 인접 6방향 : 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
         * 대각선 방향은 영향을 주지 않고 토마토는 저절로 익지 않음
         * 모든 토마토가 익게 되는지 최소 일수를 구하시오.
         *
         * 단, 상자 일부 칸에 토마토가 들어있지 않을 수도 있음
         *
         * 상자 크기 MxN, 상자 수 H
         * 익은 토마토 1, 익지 않은 토마토 0, 들어있지 않음 -1
         * 저장될 떄 부터 모두 익어있는 상태면 0을 출력, 모두 익지 못하는 상황이면 -1출력
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //가로 길이
        N = Integer.parseInt(st.nextToken()); //세로 길이
        H = Integer.parseInt(st.nextToken()); //높이(상자 수)

        box = new int[H][N][M]; //토마토 박스
        queue = new LinkedList<>();

        //토마토 박스 상태 입력
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                    //익은 토마토일 경우 queue에 좌표 넣기
                    if (box[k][i][j] == 1) {
                        queue.add(new Tomato(i, j, k));
                    }
                }
            }
        }
        
        System.out.println(bfs());

    }

    private static int bfs() {

        while (!queue.isEmpty()) {
            //큐에서 좌표를 꺼냄
            Tomato tomato = queue.poll();

            int curX = tomato.x;
            int curY = tomato.y;
            int curZ = tomato.z;

            //상하 좌우 위아래 탐색
            for (int i = 0; i < 6; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];
                int newZ = curZ + dz[i];

                //범위를 벗어나지 않았을 경우
                if (newX >= 0 && newY >= 0 && newZ >= 0 && newX < N && newY < M && newZ < H) {
                    //안 익은 토마토인 경우
                    if (box[newZ][newX][newY]== 0) {
                        queue.add(new Tomato(newX, newY, newZ)); //큐에 좌표 넣기
                        box[newZ][newX][newY] = box[curZ][curX][curY]+1; //그전 토마토 날짜 +1
                    }
                }
            }
        }

        int date = Integer.MIN_VALUE; //최대 날짜 찾기 위한 변수

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    //익지 않은 토마토가 있을 경우
                    if (box[k][i][j] == 0) {
                        return -1;
                    }

                    //익은 토마토 값 중 큰 값으로 날짜 갱신
                    date = Math.max(date, box[k][i][j]);
                }
            }
        }

        //토마토가 모두 익었을 경우(저장될 때 부터 모두 익어있는 상태) 0리턴
        if (date == 1) {
            return 0;
        }else{
            //처음 익은 토마토 값이 1이었어서 날짜-1
            return date - 1;
        }
    }

    public static class Tomato{
        int x, y, z;

        public Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}