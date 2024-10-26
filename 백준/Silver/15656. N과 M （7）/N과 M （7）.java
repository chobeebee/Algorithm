import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        /**
         * 자연수 N, 수열의 길이 M
         * -N개의 자연수 중에서 M개를 고른 수열 (오름차순)
         * -수열 중복 O
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //자연수 개수
        M = Integer.parseInt(st.nextToken()); //수열의 길이
        arr = new int[N]; //수열
        result = new int[N]; //출력 배열

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

        //자연수 개수 만큼 반복
        for (int i = 0; i < N; i++) {
            result[depth] = arr[i];
            recur(depth + 1); //재귀
        }
    }
}