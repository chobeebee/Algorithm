import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M,one, two;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        /**
         * 부모 자식들 간 관계 중 주어진 두 사람의 촌수를 계산
         * 사람들 1 <= n <= 100, 부모-자식 관계 [x,y]
         * 주어진 두 사람의 촌수를 구하시오.
         * 촌수를 계산할 수 없을 땐 -1 출력
         *
         * bfs로 풀어야 할 것 같다
         * Map으로 해서 key에 부모 번호를 넣고 그 아래 자식은 List로 받아야 겠음!
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); //전체 사람 수

        st = new StringTokenizer(br.readLine());
        one = Integer.parseInt(st.nextToken()); //촌수 계산해야하는 두 사람 중 한명
        two = Integer.parseInt(st.nextToken()); //촌수 계산해야하는 두 사람 중 한명

        M = Integer.parseInt(br.readLine()); //관계 개수
        Map<Integer, List<Integer>> map = new HashMap<>(); //관계
        dist = new int[N+1];
        visited = new boolean[N+1];

        //맵 초기화
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        //관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.get(x).add(y);
            map.get(y).add(x);
        }

        System.out.println(dfs(map));
    }

    private static int dfs(Map<Integer, List<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        dist[one] = 0;
        visited[one] = true;
        queue.offer(one);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < map.get(cur).size(); i++) {
                if (!visited[map.get(cur).get(i)]) {
                    dist[map.get(cur).get(i)] = dist[cur] + 1;
                    if (map.get(cur).get(i) == two) {
                        return dist[map.get(cur).get(i)];
                    }
                    queue.offer(map.get(cur).get(i));
                    visited[map.get(cur).get(i)] = true;
                }
            }
        }
        return -1;
    }
}