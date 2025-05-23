import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    * <안전 영역>
    * - 어떤 지역의 높이 정보 파악
    * - 비의 양에 따라 물에 잠기지 않는 안전한 영역 개수가 다름
    * - 비 양에 따른 모든 경우를 다 조사
    * - 장마철 물에 잠기지 않는 안전 영역이 최대 몇 개?
    *
    * 2<= N(행,열 크기) <= 100
    *
    * ------------------------------
    * BFS
    * 최소 높이, 최대 높이를 파악 : 비의 양
    * 비의 양에 따라 안전 지역 개수 파악 필요
    * 최대 안전 지역 찾을 변수 필요 : BFS 진행할 때마다 안전 영역 개수 비교 후 최대 개수 갱신
    * 상하좌우 좌표 필요
    * 주어진 행열 크기를 벗어나면 안됨
    * */

    static int[] dx = {1, -1, 0, 0}; // 좌우
    static int[] dy = {0, 0, 1, -1}; // 상하
    static int N; // 행열 크기
    static int[][] map; // 지역 높이 정보
    static boolean[][] visited; // 방문 여부 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int maxHeight = Integer.MIN_VALUE; // 지도 내 최대 높이
        int maxSpace = 0; // 안전 영역 최대 수

        // 지역의 높이 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        // 비의 양에 따른 안전 영역 개수 파악
        for (int i = 0; i <= maxHeight; i++) {
            visited = new boolean[N][N]; // 비 양에 따라 방문 체크 초기화
            int safe = 0; // 현재 비 양에 따른 안전 영역 수

            // 지역 탐색
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // 방문하지 않았고 비 높이보다 클 경우
                    if (!visited[j][k] && map[j][k] > i) {
                        bfs(i, j, k); // 해당 지역에서 안전 영역 탐색
                        safe++; // 안전 영역 개수 늘리기
                    }

                }

            }

            // 최대 높이 갱신
            maxSpace = Math.max(maxSpace, safe);

        }

        // 최종 결과 출력
        System.out.println(maxSpace);
    }

    private static void bfs(int rainHeight, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y}); // 현재 위치 큐에 담기
        visited[x][y] = true; // 현재 위치 방문 체크

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            // 사방 탐색
            for (int i = 0; i < dx.length; i++) {
                int newX = current[0] + dx[i];
                int newY = current[1] + dy[i];

                // 지도 영역을 벗어나지 않고 방문하지 않았으며 비 양보다 높을 경우(잠기지 않음)
                if(newX >= 0 && newY >= 0 && newX < N && newY < N && !visited[newX][newY] && map[newX][newY] > rainHeight){
                    queue.add(new int[]{newX, newY}); // 큐에 넣기
                    visited[newX][newY] = true; // 방문체크
                }
            }
        }
    }
}