import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            int start = 1;
            int end = 50;

            while(start <= end) {
                int mid = (start + end) / 2;
                sb.append(mid).append(" ");

                if (mid == N) {
                    sb.append("\n");
                    break;
                }else if(mid > N) {
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }

        }
        System.out.println(sb);
    }
}