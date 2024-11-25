import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, S, E;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] time;
    static int[] move = {-1, 1};  // x-1, x+1 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정거장 수
        M = Integer.parseInt(st.nextToken()); // 연결 정보 수
        graph = new ArrayList[N + 1];  // 정거장마다 연결된 리스트
        visited = new boolean[N + 1];
        time = new int[N + 1]; // 각 정거장에 도달하는 최소 시간

        // 각 정거장의 연결 정보는 리스트로 저장
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // 주예 위치
        E = Integer.parseInt(st.nextToken()); // 방주 위치

        // 텔레포트 연결 정보 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);  // x에서 y로 이동 가능
            graph[y].add(x);  // y에서 x로 이동 가능
        }

        // BFS로 최소 시간 계산
        bfs(S);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        time[start] = 0;  //시작 지점은 0초

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 방주가 있는 지점에 도착한 경우
            if (current == E) {
                System.out.println(time[current]);
                return;
            }

            // x+1, x-1로 이동
            for (int dir : move) {
                int next = current + dir;
                if (next >= 1 && next <= N && !visited[next]) {
                    visited[next] = true;
                    time[next] = time[current] + 1;
                    queue.add(next);
                }
            }

            // 텔레포트 가능한 정거장으로 이동
            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    time[next] = time[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}