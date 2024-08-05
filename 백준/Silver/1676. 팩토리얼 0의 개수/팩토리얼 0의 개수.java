import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * n! = 1*2*3*...*n
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine());
        BigInteger result = new BigInteger("1");

        while (true) {
            for (int i = 1; i <= N; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }

            String str = result.toString();

            for(int j=str.length(); j>0; j--) {
                if(str.charAt(j-1) != '0') {
                    System.out.println(str.length() - j);
                    break;
                }
            }

            break;
        }
    }
}