import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long max = 0;
    static int N;
    static int K;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        /**
         * 자연수 <= N, 집한 K의 원소로만 구성된 가장 큰 수 출력
         * 1<= K <=9
         * (10 ≤ N ≤ 100,000,000, 1 ≤ K의 원소의 개수 ≤ 3)
         *
         * 예시 >> N = 657일 때,
         * 111
         * 115
         * 117
         * 155
         * 157
         * 175
         * 177
         * 511
         * 515
         * ...
         * 577
         * 711 -> 자연수 657 초과
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //자연수
        K = Integer.parseInt(st.nextToken()); //원소 개수
        arr = br.readLine().split(" "); //입력 원소
        
        //재귀
        recur(0,"");
        
        //가장 큰 수 출력
        System.out.println(max);
    }

    private static void recur(long depth, String seq) {
        //원소 조합 후, N보다 작다면 max와 비교해서 저장하고 크다면 재귀 return
        if (depth > 0) {
            if(Long.parseLong(seq) <= N){
                max = Math.max(max, Long.parseLong(seq));
            }else if(Long.parseLong(seq) > N){
                return;
            }
        }
        
        //원소 조합
        for (int i = 0; i < K; i++) {
            recur(depth+1, seq+arr[i]);
        }
    }
}