import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        /**
         * 트리의 루트 1일 때, 각 노드의 부모를 구하시오.
         * 2<= 노드 개수 N <=100,000
         * N-1개의 줄에 연결된 두 정점
         * 2번 노드부터 순서대로 출력
         *
         *     1
         *    ㅅ
         *   4   6
         *  /\   \
         *  2 7   3
         *        \
         *         5
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //노드 개수
        tree = new ArrayList<>(); //노드 관계 맵
        visited = new boolean[N+1]; //방문 체크
        parent = new int[N+1]; //부모 노드 저장 배열

        //맵 초기화
        for (int i = 1; i <= N+1; i++) {
            tree.add(new ArrayList<>());
        }

        //노드 연결 입력
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }

        //bfs
        bfs(1); //루트 1
    }

    private static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root); //루트 1
        visited[root] = true;

        while (!queue.isEmpty()) {
            int p = queue.remove();

            for (int node : tree.get(p))
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parent[node] = p; // 부모 노드 찾은 후 저장
                }
        }

        // 2번 노드부터 부모 노드 출력
        for (int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }
}