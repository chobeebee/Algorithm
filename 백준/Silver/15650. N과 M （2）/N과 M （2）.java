import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        /**
         * 자연수 N과 M(수열의 길이)
         * - 1부터 N까지 자연수 중 중복 없이 M개를 고른 수열
         * - 수열은 오름차순
         *
         * 백트래킹
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //자연수
        M = Integer.parseInt(st.nextToken()); //수열의 길이
        arr = new int[N];
        sb = new StringBuilder();

        recur(1, 0);
        System.out.println(sb);
    }

    private static void recur(int num, int depth) {

        //M의 길이가 되면 출력 후 반환
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
            return;
        }

        //1부터 N까지 수열
        for (int i = num; i <= N; i++) {
            //현재 깊이 위치에 i를 담음
            arr[depth] = i;
            recur(i+1, depth+1);
        }
    }
}