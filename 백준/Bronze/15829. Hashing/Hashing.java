import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int hash = 0;

        for (int i = 0; i < str.length(); i++) {
            int idx = alpha.indexOf(str.charAt(i)) + 1;
            hash += idx * Math.pow(31, i);
        }

        System.out.println(hash);
    }
}