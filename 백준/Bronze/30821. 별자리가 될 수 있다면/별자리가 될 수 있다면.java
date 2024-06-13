import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(br.readLine());
        long result = 1;

        for (int i = 0; i < 5; i++) {
            result *= n - i;
        }

        for (int i = 0; i < 5; i++) {
            result /= (i + 1);
        }
        System.out.println(result);
    }
}