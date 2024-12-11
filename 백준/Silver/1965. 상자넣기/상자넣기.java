import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 앞에 있는 상자가 뒤에 있는 상자보다 크기가 작으면, 앞 상자를 뒤 상자에 넣을 수 있다
         * 한번에 넣을 수 있는 최대 상자 개수를 출력하시오.
         *
         * 1<= 상자개수 n <= 1000, 상자의 크기 <= 1000
         *
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //상자 개수
        int[] boxes = new int[N]; //상자 크기
        int[] dp = new int[N]; //각 상자의 담을 수 있는 최대 개수
        int max = 0; //한 번에 넣는 최대 상자 수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                //앞 상자가 작을 경우 최대 상자 수 바꾸기
                if (boxes[i] > boxes[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            //전체 최대 상자 수 바꾸기
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}