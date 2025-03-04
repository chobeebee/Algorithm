import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 자연수 N
         * 1부터 N까지 한 줄에 하나씩 출력
         *
         * 자연수 N<=100,000
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int N = Integer.parseInt(br.readLine()); //자연수

        //1~N 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(i);
        }
    }
}