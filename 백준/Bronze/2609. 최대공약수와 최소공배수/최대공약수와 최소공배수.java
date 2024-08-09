import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int yak = getGcd(num1, num2);

        System.out.print(yak + " ");
        System.out.println((num1 * num2)/yak);
    }
    public static int getGcd(int num1, int num2) {
        if(num1 == 0) {
            return num2;
        }
        else {
            return getGcd(num2 % num1, num1);
        }
    }
}