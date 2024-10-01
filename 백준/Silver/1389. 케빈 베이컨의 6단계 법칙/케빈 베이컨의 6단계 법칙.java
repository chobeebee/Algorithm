import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int minCount = Integer.MAX_VALUE;
    static int min = 0;
    public static void main(String[] args) throws IOException {
        /**
         * 최대 6단계 이내에 서로 아는 사람으로 연결 가능
         * 케빈 베이컨 게임 : 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는 지 계산하는 게임
         * 케빈 베이컨의 수가 가장 작은 사람은?
         *
         * 그래프
         * bfs 사용하면 될 듯!
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //유저의 수
        int M = Integer.parseInt(st.nextToken()); //친구 관계 수
        Map<Integer, List<Integer>> relation = new HashMap<>(); //친구 관계
        
        //친구 관계 초기화
        for (int i = 1; i <= N; i++) {
            relation.put(i, new ArrayList<>());
        }

        //연관 관계 입력
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            relation.get(one).add(two);
            relation.get(two).add(one);
        }

        //각 유저에 대한 bfs
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N+1];
            bfs(i, relation, visited);
        }
        
        //케빈 베이컨의 최솟값 출력
        System.out.println(min);
    }

    private static void bfs(int i, Map<Integer, List<Integer>> relation, boolean[] visited) {
        int count = 0; //관계 수
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,0});
        visited[i] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int root = current[1];
            count += root; //관계++
            List<Integer> users = relation.get(current[0]);

            //해당 유저에 대한 관계
            for (int f : users) {
                if (!visited[f]) {
                    visited[f] = true;
                    queue.add(new int[]{f, root+1}); //관계+1
                }
            }
        }
        
        if (minCount > count) {
            minCount = count;
            min = i;
        }else{
            min = Math.min(i, min);
        }
    }
}