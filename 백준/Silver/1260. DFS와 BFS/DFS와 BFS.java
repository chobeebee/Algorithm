import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * DFS와 BFS 탐색 결과 출력
         * 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것 먼저 방문
         * 더 이상 방문할 수 있는 점이 었으면 종료
         * 정점 1<=N<=1000, 간선 1<=M<=10,000, 탐색 시작점 V
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(graph, visited, V);
        System.out.println();
        visited = new boolean[N + 1]; //방문 초기화
        bfs(graph, visited, V);
    }

    private static void dfs(int[][] graph, boolean[] visited, int start) {
        visited[start] = true; //시작 정점 방문 표시
        System.out.print(start + " ");

        for(int i = 1; i < graph.length; i++) {
            //인접하고 방문하지 않은 정점일 때
            if(graph[start][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    private static void bfs(int[][] graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true; //시작 정점 방문 표시

        System.out.print(start + " ");

        while(!queue.isEmpty()) {
            int vertex = queue.poll();

            //현재 정점과 인접한 모든 정점 확인
            for(int i = 1; i < graph.length; i++) {
                //인접하고 방문하지 않은 정점일 때
                if(graph[vertex][i] == 1 && !visited[i]) {
                    queue.offer(i); //해당 정점 큐에 추가
                    visited[i] = true; //정점 방문 표시
                    System.out.print(i + " ");
                }
            }
        }
    }
}