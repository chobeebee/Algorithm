import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    * <최소, 최대>
    * 1 <= 정수 N개 <= 1,000,000
    * 최솟값, 최댓값 구하기.
    *
    * -1,000,000 <= 정수 <= 1,000,000
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 정수 개수
        int min = Integer.MAX_VALUE; // 최솟값
        int max = Integer.MIN_VALUE; // 최댓값

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        System.out.println(min + " " + max);
    }
}