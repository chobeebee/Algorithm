import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    * <이항 계수 1>
    * - 자연수 N, 정수 K가 주어졌을 때, 이항 계수 구하기
    * - N! / K!(N-K)!
    *
    * 1 <= N <= 10, 0 <= K <= N
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 자연수
        int K = Integer.parseInt(st.nextToken()); // 정수

        // 이항 계수
        int answer = facotrial(N) / (facotrial(K) * facotrial(N - K));
        System.out.println(answer);
    }

    public static int facotrial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}