import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    //상하좌우 방향
    static int[] dX = {1, -1, 0, 0};
    static int[] dY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        /**
         * 인접 배추에 배추흰지렁이가 살면 인접 다른 배추로 이동 가능
         * 상하좌우 4방향 다른 배추가 위치
         * 0: 배추가 없는 땅 / 1: 배추가 심어진 땅
         * 몇 마리 지렁이가 필요한가?
         * T : 테스트 수, M: 가로길이, N: 세로길이, K:심어진 위치 개수
         *
         * BFS
         * 1을 찾아서 지렁이+1하고 사방을 탐색하고 탐색된 땅은 visited로 설정
         * 또 1을 찾아서 탐색하는 방식으로!
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); //테스트 수

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] map = new int[M][N]; //땅 지도
            boolean[][] visited = new boolean[M][N]; //탐색 유무
            int count = 0; //지렁이 수

            //배추가 심어진 위치 입력
            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            //맵 탑색
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < N; k++) {
                    //배추가 심어졌고 아직 탐색되지 않은 땅일 때
                    if(map[j][k] == 1 && !visited[j][k]) {
                        count++; //지렁이 수 추가
                        bfs(map, visited, j, k, M, N);
                    }
                }
            }

            System.out.println(count);
        }

    }

    private static void bfs(int[][] map, boolean[][] visited, int j, int k, int M, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {j, k}); //탐색된 위치 큐에 추가
        visited[j][k] = true; //방문 표시

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            //사방 탐색
            for(int i = 0; i < 4; i++) {
                int newX = x + dX[i];
                int newY = y + dY[i];

                //영역을 벗어나지 않고 방문하지도 않았고 배추가 심어져있다면 (인접 배추)
                if(newX >= 0 && newY >= 0 && newX < M && newY < N && !visited[newX][newY] && map[newX][newY] == 1) {
                    visited[newX][newY] = true; //방문 표시
                    queue.add(new int[] {newX, newY}); //인접 배추 위치로 이동
                }
            }
        }
    }
}