import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N+1];

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                sticker[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                sticker[1][j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 2; j <= N; j++) {
                sticker[0][j] += Math.max(sticker[1][j-1], sticker[1][j-2]);
                sticker[1][j] += Math.max(sticker[0][j-1], sticker[0][j-2]);
            }

            System.out.println(Math.max(sticker[0][N], sticker[1][N]));
        }
    }
}