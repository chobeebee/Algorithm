import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while(N >  0) {
            if (N % 5 == 0) {
                count += N / 5;
                break;
            } else {
                N -= 3;
                count++;
            }
            if (N < 0) {
                count = -1;
            }
        }

        System.out.println(count);
    }
}