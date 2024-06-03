import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        int[][] board = new int[9][9];
        int max = 0;
        int row=1, col=1;

        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == max) {
                    continue;
                }

                if(num > max) {
                    max = num;
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println(max);
        System.out.println(row +" "+ col);
    }
}