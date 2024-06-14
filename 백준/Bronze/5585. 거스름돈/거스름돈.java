import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int price = Integer.parseInt(br.readLine());
        int[] coins = {500, 100, 50, 10, 5, 1};
        int changes = 1000 - price;
        int count = 0;

        for(int i = 0; i < coins.length; i++) {
            count += changes / coins[i];
            changes %= coins[i];
        }

        System.out.println(count);
    }
}