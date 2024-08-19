import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[15][15];

        for (int i = 0; i < 15; i++) {
            arr[0][i] = i;
            arr[i][1] = 1;
        }

        for (int i = 1; i < 15; i++) {
            for(int j=1; j <15; j++){
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }

        for(int i = 0; i < T; i++){
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[K][N]);
        }
    }
}