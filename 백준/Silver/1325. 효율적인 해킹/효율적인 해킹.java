import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 해커 김지민이 어느 회사를 해킹하려 함. 회사에는 N개 컴퓨터가 있음.
         * 한번의 해킹으로 여러 개의 컴퓨터를 해킹할 수 있는 컴퓨터를 해킹하려 함.
         * 컴퓨터는 실뢰하는 관계와 신뢰하지 않는 관계로 이루어짐. A가 B를 신뢰하면 B해킹 시, A도 해킹 가능.
         * 컴퓨터 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터 번호를 출력하시오.(오름차순으로)
         *
         * N <= 10,000 / M <=100,000
         *
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //컴퓨터 수
        int M = Integer.parseInt(st.nextToken()); //관계 수
        List<Integer>[] relations = new ArrayList[N + 1]; //컴퓨터 신뢰 관계 배열
        int[] hackCount = new int[N+1]; //해킹할 수 있는 컴퓨터 수

        //초기화
        for (int i = 1; i <= N; i++) {
            relations[i] = new ArrayList<>();
        }

        //신뢰 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            relations[B].add(A);
        }

        //관계 탐색
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1]; //방문 체크
            hackCount[i] = bfs(i, relations, visited);
        }

        //가장 많이 해킹할 수 있는 컴퓨터 수
        int MAX = 0;
        for (int i = 1; i <= N; i++) {
            MAX = Math.max(MAX, hackCount[i]);
        }

        //가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터 번호 찾기
        for (int i = 1; i <= N; i++) {
            if (hackCount[i] == MAX) {
                sb.append(i).append(" ");
            }
        }

        //컴퓨터 번호 출력
        System.out.println(sb);
    }
    public static int bfs(int start, List<Integer>[] relations, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;  //현재 컴퓨터 해킹

            //관계된 컴퓨터 중 방문하지 않았을 경우
            for (int next : relations[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return count;
    }
}