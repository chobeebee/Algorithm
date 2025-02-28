import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int H,W,count;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        /**
         * 양 #, 풀. 양무리 ##
         * 모니터에 몇 개의 양무리가 있었는지 출력
         * 테스크 케이스 수 T, 그리드 높이 H, 그리드 너비 W
         * 0< T,H,W <=100
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수

        for (int i = 0; i <T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); //그리드 넓이
            W = Integer.parseInt(st.nextToken()); //그리드 높이
            grid = new char[H][W]; //그리드
            visited = new boolean[H][W]; //방문 체크
            count = 0; //양무리 수

            //그리드 입력
            for (int j = 0; j < H; j++) {
                grid[j] = br.readLine().toCharArray();
            }

            //그리드에서 양 무리 찾기
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    //양이면서 방문적 없을 경우 bfs로
                    if(grid[j][k] == '#'&& !visited[j][k]){
                        bfs(j, k);
                        count++;
                    }
                }
            }

            //양 무리 출력
            System.out.println(count);
        }

    }

    private static void bfs(int startH, int startW) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startH, startW}); //시작 위치 큐에 저장
        visited[startH][startW] = true; //시작 위치 방문 처리

        while (!queue.isEmpty()) {

            int[] curArr = queue.poll();
            int curH = curArr[0]; //현 위치 H
            int curW = curArr[1]; //현 위치 W

            //사방 탐색
            for (int i = 0; i < dx.length; i++) {

                int newH = curH + dx[i];
                int newW = curW + dy[i];

                //그리드를 벗어나지 않고 방문한적 없으며 양일 경우
                if (newH >= 0 && newH < H && newW >= 0 && newW < W && !visited[newH][newW] && grid[newH][newW]=='#') {
                    queue.add(new int[]{newH, newW}); //큐에 넣기
                    visited[newH][newW] = true; //방문 처리
                }
            }
        }
    }
}