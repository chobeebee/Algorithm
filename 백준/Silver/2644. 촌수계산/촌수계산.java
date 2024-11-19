import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M,one, two;
    static int[] visited;

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
        visited = new int[N+1]; //각 부모의 방문 촌수

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
        
        //dfs로 촌수 탐색
        dfs(map);

        //찾으려는 두번째 사람의 촌수가 0보다 크면 촌수 출력, 아니면 -1
        System.out.println(visited[two] > 0 ? visited[two] : -1);
    }

    private static void dfs(Map<Integer, List<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(one); //큐에 찾으려는 첫번째 사람 넣기

        while (!queue.isEmpty()) {
            int current = queue.poll(); //큐에 있는 값 꺼내기

            if(current == two) return; //꺼낸 값이 두번째 사람이면 리턴

            //큐에서 꺼낸 값과 연관된 사람들 만큼 반복
            for (int m : map.get(current)) {
                //아직 탐색되지 않은 사람이면 현재 사람과 관계가 있으니 촌수+1
                if (visited[m] == 0) {
                    visited[m] = visited[current]+1;
                    queue.add(m); //큐에 넣기
                }
            }
        }
    }
}