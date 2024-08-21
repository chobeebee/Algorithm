import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine());
        int ex = (int) Math.round(N * 0.15); //(위, 아래)각 제외될 사람 수
        int sum = 0;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int j=ex; j<N-ex; j++){
            sum += arr[j];
        }
        System.out.println(Math.round( (float) sum/(N-(2*ex))));
    }
}