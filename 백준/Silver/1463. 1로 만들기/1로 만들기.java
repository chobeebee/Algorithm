import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        for(int i = 2; i <= N; i++) {
            //1을 빼는 경우
            arr[i] = arr[i-1] + 1;

            //2로 나누어 떨어지는 경우
            if(i %2 == 0) {
                arr[i] = Math.min(arr[i], arr[i/2] + 1);
            }
            //3로 나누어 떨어지는 경우
            if(i %3 == 0) {
                arr[i] = Math.min(arr[i], arr[i/3] + 1);
            }
        }

        System.out.println(arr[N]);
    }
}