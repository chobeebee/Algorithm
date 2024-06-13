import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int[] scores = new int[10];
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < 10; i++) {
            sum += scores[i];

            if (Math.abs((sum - scores[i]) - 100) < sum - 100) {
                sum -= scores[i];
                break;
            }
        }
        System.out.println(sum);
    }
}