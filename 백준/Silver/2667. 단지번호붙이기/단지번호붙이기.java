import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N; //지도 크기
    static String[][] map; //지도
    static boolean[][] visited; //방문체크
    static int[] dx = {-1, 1, 0, 0}; //좌우
    static int[] dy = {0, 0, -1, 1}; //상하
    static List<Integer> result;
    static int count;

    public static void main(String[] args) throws IOException {
        /**
         * 정사각형 지도, 1: 집, 0: 빈 곳
         * 연결된 집끼리 단지를 정의
         * 단지 수, 각 단지의 집 수를 오름차순 출력
         * 지도는 정사각형 5<=N<=25
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        result = new LinkedList<>();
        N = Integer.parseInt(br.readLine()); //지도 크기
        map = new String[N][N]; //지도
        visited = new boolean[N][N]; //방문체크
        count = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].equals("1") && !visited[i][j]){
                    dfs(i,j);
                    result.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int r : result) {
            System.out.println(r);
        }
    }

    private static void dfs(int startX, int startY) {
        visited[startX][startY] = true;
        for (int i = 0; i < dx.length; i++) {
            int newX = startX + dx[i];
            int newY = startY + dy[i];

            if (newX < N && newY < N && 0 <= newX && 0 <= newY && !visited[newX][newY] && map[newX][newY].equals("1")) {
                count++;
                dfs(newX, newY);
            }
        }
    }
}