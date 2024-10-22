import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int max = 0;
    static int[][] paper;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 모든 좌표에서 DFS 및 ㅗ모양 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs1(i, j, 1, paper[i][j]);
                visited[i][j] = false;

                checkTShape(i, j); // ㅗ 모양 체크
            }
        }

        System.out.println(max);
    }

    // DFS로 테트로미노 모양 4개를 선택
    public static void dfs1(int y, int x, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];

            if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs1(ny, nx, depth + 1, sum + paper[ny][nx]);
                visited[ny][nx] = false; // 백트래킹: 방문 해제
            }
        }
    }

    // ㅗ 모양 (ㅗ, ㅜ, ㅓ, ㅏ)를 체크하는 함수
    public static void checkTShape(int y, int x) {
        // ㅗ 모양의 가능한 4가지 경우를 정확한 조건으로 체크
        if (y - 1 >= 0 && x - 1 >= 0 && x + 1 < m) { // ㅗ 모양
            int sum = paper[y][x] + paper[y - 1][x] + paper[y][x - 1] + paper[y][x + 1];
            max = Math.max(max, sum);
        }

        if (y + 1 < n && x - 1 >= 0 && x + 1 < m) { // ㅜ 모양
            int sum = paper[y][x] + paper[y + 1][x] + paper[y][x - 1] + paper[y][x + 1];
            max = Math.max(max, sum);
        }

        if (y - 1 >= 0 && y + 1 < n && x + 1 < m) { // ㅏ 모양
            int sum = paper[y][x] + paper[y - 1][x] + paper[y + 1][x] + paper[y][x + 1];
            max = Math.max(max, sum);
        }

        if (y - 1 >= 0 && y + 1 < n && x - 1 >= 0) { // ㅓ 모양
            int sum = paper[y][x] + paper[y - 1][x] + paper[y + 1][x] + paper[y][x - 1];
            max = Math.max(max, sum);
        }
    }
}