import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            int maxLast = 0;
            int time = Integer.parseInt(br.readLine());

            for(int j = 0; j < time; j++){
                if (time >= j + (j * j)) {
                    maxLast = Math.max(maxLast, j);
                }
            }
            System.out.println(maxLast);
        }
    }
}