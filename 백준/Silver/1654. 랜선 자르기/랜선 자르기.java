import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long count,mid;

        long start = 1;
        long max = 0;

        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        while (start <= max) {
            count = 0;
            mid = (start + max) / 2;

            for(int i=0; i<K; i++){
                count += arr[i] / mid;
            }

            if (count < N) {
                max = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(max);
    }
}