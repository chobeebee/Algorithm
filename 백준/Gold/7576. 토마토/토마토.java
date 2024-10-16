import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //4방향 : 왼쪽, 오른쪽, 앞, 뒤
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        /**
         * 토마토 격자 모양 상자 MxN 를 창고에 보관
         * 보관 후 하루가 지나면, 익은 토마토와 인접한 토마토는 익게 됨
         * 인접 4방향 : 왼쪽, 오른쪽, 앞, 뒤
         * 대각선 방향은 영향을 주지 않고 토마토는 저절로 익지 않음
         * 모든 토마토가 익게 되는지 최소 일수를 구하시오.
         *
         * 단, 상자 일부 칸에 토마토가 들어있지 않을 수도 있음
         *
         * 상자 크기 MxN
         * 익은 토마토 1, 익지 않은 토마토 0, 들어있지 않음 -1
         * 저장될 떄 부터 모두 익어있는 상태면 0을 출력, 모두 익지 못하는 상황이면 -1출력
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //가로
        int N = Integer.parseInt(st.nextToken()); //세로
        int[][] box = new int[N][M]; //박스의 토마토 상태
        Queue<Tomato> queue = new LinkedList<>();

        //상자에 든 토마토 상태 입력
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        //토마토가 익어있다면 queue에 담음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j]==1) {
                    queue.add(new Tomato(i,j));
                }
            }
        }
        System.out.println(bfs(box, queue,M, N));
    }

    private static int bfs(int[][] box, Queue<Tomato> queue, int M, int N) {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll(); //익은 토마토 하나 꺼내기

            int curX = tomato.x; //꺼낸 토마토의 x좌표
            int curY = tomato.y; //꺼낸 토마토의 y좌표

            //좌우 앞뒤
            for (int i = 0; i < 4; i++) {
                int newX = curX + dx[i]; //꺼낸 토마토의 좌우
                int newY = curY + dy[i]; //꺼낸 토마토의 앞뒤

                //영역을 벗어나지 않은 경우
                if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
                    //안 익은 토마토일 경우
                    if (box[newX][newY]==0) {
                        queue.add(new Tomato(newX, newY)); //queue에 좌표 넣기
                        box[newX][newY] = box[curX][curY]+1; //이전 토마토의 날짜+1
                    }
                }
            }
        }

        int date = Integer.MIN_VALUE; //날짜 최대값 구하기 위한 변수

        //박스 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //모두 안 익었을 경우 -1 출력
                if (box[i][j]==0) {
                    return -1;
                }

                //익었다면 제일 오래 걸린 날짜 출력
                date = Math.max(date, box[i][j]);
            }
        }

        //이미 모두 다 익어있었을 경우 0 출력
        if (date == 1) {
            return 0;
        }else{
            //아니라면 원래 익어있던 토마토가 1이었어서 -1해서 걸린 날짜 출력
            return date - 1;
        }
    }

    public static class Tomato{
        int x,y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}