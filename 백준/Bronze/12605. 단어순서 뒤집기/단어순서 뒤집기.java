import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        int lineNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < lineNum; i++) {
            String line = br.readLine();
            String wordArr[] = line.split(" ");

            System.out.print("Case #" + (i + 1) + ": ");

            for (int j = wordArr.length -1; j >= 0; j--) {
                System.out.print(wordArr[j] + " ");
            }
            System.out.println();
        }
    }
}