import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[] stores = new int[num];
        int count = 0;
        int drink = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            stores[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < num; i++) {
            if (stores[i] == drink) {
                count++;
                drink++;

                if(drink == 3) {
                    drink = 0;
                }
            }
        }

        System.out.println(count);
    }
}