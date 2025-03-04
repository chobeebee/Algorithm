import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
         * 오른쪽을 기준으로 정렬
         *
         * N(1 ≤ N ≤ 100)
         *
         *     *
         *    **
         *   ***
         *  ****
         * *****
         *
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //별 찍기
        for (int i = 0; i < N; i++) {
            //공백
            for (int j = 0; j < N-i-1; j++) {
                sb.append(" ");
            }
            //별
            for (int j = 0; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}