import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 가중치 없는 방향 그래프 G
         * 정점의 개수 1<= N <= 100, (i,j)가 1이면 간선이 존재, 0이면 없다는 것
         * (i,i)는 항상 0임 : 자기 자신
         *
         * 0 1 0 [0,1]
         * 0 0 1 [1,2]
         * 1 0 0 [2,0]
         * 0 - 1 - 2 -0
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //간선 수
        int[][] graph = new int[N][N]; //인접 행렬 배열

        //인접 행렬 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //갈 수 있는 경로 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (graph[i][k] == 1 && graph[j][i] == 1) {
                        graph[j][k] = 1;
                    }
                }
            }
        }

        //경로 유무 체크
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}