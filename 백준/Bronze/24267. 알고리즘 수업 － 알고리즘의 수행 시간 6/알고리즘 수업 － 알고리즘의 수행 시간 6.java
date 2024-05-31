import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        long count = Long.parseLong(br.readLine());

        System.out.println((count * (count - 1) * (count - 2)) /6);
        System.out.println(3);

        br.close();
    }
}