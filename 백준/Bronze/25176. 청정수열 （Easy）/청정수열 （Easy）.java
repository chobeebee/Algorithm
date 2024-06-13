import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int num = Integer.parseInt(br.readLine());
        int value = 1;

        for (int i = 1; i <= num; i++) {
            value *= i;
        }
        System.out.println(value);
    }
}