import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 정수 X에 사용할 수 있는 연산 3가지
         * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다
         * 2. X가 2로 나누어 떨어지면, 2로 나눈다
         * 3. 1을 뺀다
         *
         * 정수 N을 위 연산을 사용하여 1을 만들려고 함
         * 연산 횟수의 최솟값 구하기.
         *
         * 1<= N <= 10^6
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //정수
        int[] dp = new int[N + 1]; //최소 연산 횟수
        int[] arr = new int[N + 1]; //연산 기록

        for (int i = 2; i <= N; i++) {

            //3. 1을 뺸다
            dp[i] = dp[i-1] + 1;
            arr[i] = i -1;

            //2. 2로 나눈다
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                arr[i] = i / 2;
            }

            //3. 3으로 나눈다
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                arr[i] = i / 3;
            }
        }

        //연산 최솟값 출력
        System.out.println(dp[N]);

        //연산 경로 역추적
        List<Integer> result = new ArrayList<>();
        for (int i = N; i != 0; i = arr[i]) {
            result.add(i);
        }

        //경로 출력
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}