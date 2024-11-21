import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * N개국 여행, 최대한 적은 종류의 비행기를 타고 이동
         * 중간에 다른 국가 거쳐도 됨 (이미 거쳤갔던 곳도 됨)
         *
         * 테스트 케이스 수 <= 100, 2<= 국가 수 N <=1000, 1<= 비행기 종류 M <=10000
         * 왕복하는 비행기(a, b)
         *
         * 3국가 가려면 2번
         * 2국가 가려면 1번
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //국가 수
            int M = Integer.parseInt(st.nextToken()); //비행기 수

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
            }

            System.out.println(N-1);
        }
    }
}