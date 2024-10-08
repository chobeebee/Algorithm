import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        eratos(M, N);
    }

    public static void eratos(int M, int N) {
        StringBuilder sb = new StringBuilder();
        int[] prime = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            prime[i] = i;
        }

        for (int i = 2; i < N + 1; i++) {
            if (prime[i] == 0) {
                continue;
            }

            for (int j = 2 * i; j < N + 1; j += i) {
                prime[j] = 0;
            }
        }

        for(int i = M; i <= N; i++){
            if(prime[i] != 0){
                sb.append(prime[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}