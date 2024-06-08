import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int star = Integer.parseInt(br.readLine());

        for (int i =0; i < star; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = star; k-i > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}