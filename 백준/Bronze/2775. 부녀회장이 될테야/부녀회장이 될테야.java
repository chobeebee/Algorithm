import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int test = Integer.parseInt(br.readLine());
        int[][] info = new int[15][15];

        for(int i = 0; i < 15; i++){
            info[0][i] = i;
            info[i][1] = 1;
        }

        for(int i = 0; i < test; i++){
            int floor = Integer.parseInt(br.readLine());
            int room = Integer.parseInt(br.readLine());

            for(int j = 1; j <= floor; j++){
                for(int k = 1; k <= room; k++){
                    info[j][k] = info[j][k-1] + info[j - 1][k];
                }
            }
            System.out.println(info[floor][room]);
        }
    }
}