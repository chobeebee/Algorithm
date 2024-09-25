import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 방향 없는 그래프의 연결 요소의 개수를 구하시오.
         * 1<= 정점 개수 N <= 1000, 0<=간선 개수 M<=Nx(N-1)/2
         *
         * BFS로 풀자
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //정점 수
        int M = Integer.parseInt(st.nextToken()); //간선 수
        Map<Integer, List<Integer>> map = new HashMap<>(); //연결 관계 맵
        boolean[] visited = new boolean[N+1];
        int count = 0; //연결 요수 개수

        //맵 리스트 초기화
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        //맵 연결 정보 입력
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.get(x).add(y);
            map.get(y).add(x);
        }

        //노드를 넣으면서 방문하지 않았을 때. bfs로 연결된 그룹(요소) 개수 세기
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(map, visited, i);
                count++;
            }
        }

        //연결 요소 개수 출력
        System.out.println(count);
    }

    private static void bfs(Map<Integer, List<Integer>> map, boolean[] visited, int vert) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vert);
        visited[vert] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll(); //큐에 있는 노드 번호

            //연결된 노드들 방문 처리
            for (int m : map.get(current)) {
                if (!visited[m]) {
                    visited[m] = true;
                    queue.add(m);
                }
            }
        }
    }
}