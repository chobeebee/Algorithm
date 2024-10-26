import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        /**
         * 자연수 N, 수열의 길이 M
         * -N개의 자연수 중에서 M개를 고른 수열 (오름차순)
         * -수열 중복 X
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //자연수 개수
        M = Integer.parseInt(st.nextToken()); //수열의 길이
        arr = new int[N]; //수열
        result = new int[N]; //출력 배열
        visited = new boolean[N+1]; //방문 처리 배열

        //수열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        //재귀
        recur(0);

        System.out.println(sb);
    }

    private static void recur(int depth) {
        //길이가 M이 됐을 경우
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            //만약 방문했던 수열 값이라면 넘김
            if (visited[i]) continue;

            result[depth] = arr[i];

            if (depth > 0 && result[depth-1] > result[depth]) continue;

            visited[i] = true;
            recur(depth + 1); //재귀
            visited[i] = false; //재귀가 다 끝난 후 다음 수열에도 사용해야하니까 방문 처리 해제
        }
    }
}