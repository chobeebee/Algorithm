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
         * -자기 자신 제외
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //자연수
        M = Integer.parseInt(st.nextToken()); //수열의 길이

        arr = new int[N]; //입력한 자연수 배열
        result = new int[N]; //출력 배열
        visited = new boolean[N]; //방문 체크 배열

        //자연수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순
        Arrays.sort(arr);

        //재귀
        recur(0);

        //출력
        System.out.println(sb);
    }

    private static void recur(int depth) {
        //M길이까지 했다면
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append("\n");
            return;
        }

        //수열 배열 반복
        for (int i = 0; i < arr.length; i++) {
            //방문했었던 수열 값이면 넘김 (수열 중복 X을 위함)
            if(visited[i]){
                continue;
            }

            //방문하지 않았다면 결과 배열에 수열 값을 넣고 방문 처리
            result[depth] = arr[i];
            visited[i] = true;
            recur(depth+1); //재귀
            visited[i] = false; //재귀가 다 끝난 후 다음 수열에도 사용해야하니까 방문 처리 해제
        }
    }
}