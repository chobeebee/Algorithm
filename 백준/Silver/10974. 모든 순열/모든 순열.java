import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb;
    static boolean[] visited;
    static int arr[];

    public static void main(String[] args) throws IOException {
        /**
         * 1~N까지의 순열을 사전순으로 출력
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        array(0);

        System.out.println(sb);
    }

    private static void array(int depth) {

        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                arr[depth] = i + 1;
                visited[i] = true;
                array(depth + 1);
                visited[i] = false;
            }
        }
    }
}