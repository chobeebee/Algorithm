import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    static final int m = 1234567891;
    static final int r = 31;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while (true) {
            String str = br.readLine();
            char[] arr = str.toCharArray();
            char[] arr2 = new char[arr.length];

            if(str.equals("0")) {
                break;
            }

            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[arr.length - 1 - i];
            }

            if (String.valueOf(arr).equals(String.valueOf(arr2))) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}