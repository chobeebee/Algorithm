import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        /**
         * 1~N까지 자연 수 중 M개를 고른 수열
         * 같은 수를 여러번 골라도 됨
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //자연수 개수
        M = Integer.parseInt(st.nextToken()); //수열 길이
        arr = new int[M];

        recur(0);
        System.out.println(sb);
    }

    private static void recur(int depth) {

        //M의 길이가 되면 출력 후 반환
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
            return;
        }

        //1부터 N까지 수열
        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            recur(depth+1);
        }
    }
}