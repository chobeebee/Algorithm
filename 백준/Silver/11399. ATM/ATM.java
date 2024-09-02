import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                sum += time[j];
            }
        }

        System.out.println(sum);
    }
}