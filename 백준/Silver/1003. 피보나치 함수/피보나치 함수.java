import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    static int[] arr1= new int[41];
    static int[] arr2= new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            fibonacci(N);
            sb.append(arr1[N]).append(" ").append(arr2[N]).append('\n');

        }
        System.out.println(sb);
    }

    private static void fibonacci(int N) {
        arr1[0] = 1;
        arr2[0] = 0;

        for(int i = 1; i <= N; i++) {
            arr1[i] = arr2[i - 1];
            arr2[i] = arr1[i] + arr1[i - 1];
        }
    }
}