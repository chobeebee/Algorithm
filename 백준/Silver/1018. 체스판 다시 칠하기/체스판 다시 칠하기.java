import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static boolean[][] board;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if(line.charAt(j) == 'W'){
                    board[i][j] = true;
                }else{
                    board[i][j] = false;
                }
            }
        }

        int tryN = N - 7;
        int tryM = M - 7;

        for (int i = 0; i < tryN; i++) {
            for(int j = 0; j < tryM; j++) {
                tryBoard(i, j);
            }
        }
        System.out.println(min);
    }

    public static void tryBoard(int x, int y) {
        int count = 0;
        boolean chk = board[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (board[i][j] != chk) {
                    count++;
                }
                chk = !chk;
            }
            chk = !chk;
        }
        count = Math.min(count, 64-count);
        min = Math.min(min, count);
    }
}