import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); //테스트 케이스

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); //레지스터 초기값
            int B = Integer.parseInt(st.nextToken()); //최종값

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000]; //방문 여부
            String[] result = new String[10000]; //정답 결과

            visited[A] = true; //초기값 방문 처리
            queue.add(A); //초기값 넣기
            Arrays.fill(result, ""); //정답 배열 초기화

            //큐가 비어있고 최종값에 도달할 때까지
            while (!queue.isEmpty() && !visited[B]) {
                int now = queue.poll(); //현재 값

                //연산
                int D = (now*2)%10000;
                int S = (now == 0) ? 9999 : now-1;
                int L = (now % 1000) * 10 + now/1000;
                int R = (now % 10) * 1000 + now/10;

                //각 연산을 한 결과 값이 방문한적이 없다면 큐에 넣고 방문처리 후 해당 위치 결과 배열에 넣기
                if (!visited[D]) {
                    queue.add(D);
                    visited[D] = true;
                    result[D]=result[now] + "D";
                }
                if (!visited[S]) {
                    queue.add(S);
                    visited[S] = true;
                    result[S]=result[now] + "S";
                }
                if (!visited[L]) {
                    queue.add(L);
                    visited[L] = true;
                    result[L]=result[now] + "L";
                }
                if (!visited[R]) {
                    queue.add(R);
                    visited[R] = true;
                    result[R]=result[now] + "R";
                }
            }
            sb.append(result[B] + "\n");
        }
        System.out.println(sb);
    }
}