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
         * N개의 자연수, 수열의 길이 M
         * 1<=M<=N<=8
         * 수열 중복 X, 수열은 사전 순으로 오름차순
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //자연수 개수
        M = Integer.parseInt(st.nextToken()); //수열의 길이
        arr = new int[N]; //수열
        result = new int[N]; //출력 배열
        visited = new boolean[N + 1]; //방문 배열

        //수열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순 정렬
        Arrays.sort(arr);

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

        int prev = 0; //이전 값

        //수열 배열 반복
        for (int i = 0; i < arr.length; i++) {
            //방문했었던 수열 값이면 넘김 (수열 중복 X을 위함)
            if(visited[i]){
                continue;
            }

            //이전 값과 동일하지 않을 경우
            if (prev != arr[i]) {
                //방문하지 않았다면 결과 배열에 수열 값을 넣고 방문 처리
                result[depth] = arr[i];
                visited[i] = true;
                prev = arr[i];
                recur(depth+1); //재귀
                visited[i] = false; //재귀가 다 끝난 후 다음 수열에도 사용해야하니까 방문 처리 해제
            }
        }
    }
}