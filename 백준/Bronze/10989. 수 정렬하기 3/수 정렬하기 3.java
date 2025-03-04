import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬
         *
         * N(1 ≤ N ≤ 10,000,000)
         * 수는 10,000보다 작거나 같은 자연수
         *
         * ----
         * 시간초과 해결
         * > 카운팅 정렬 : 시간 복잡도가 O(N + K)
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //수의 개수
        int[] count = new int[10001]; //숫자 배열

        //N개 수 입력 : 숫자 카운팅
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            count[num]++;
        }

        //오름차순으로 숫자 출력
        for (int i = 1; i <= 10000; i++) {
            while (count[i] > 0) {
                sb.append(i).append("\n");
                count[i]--;
            }
        }

        System.out.print(sb);
    }
}