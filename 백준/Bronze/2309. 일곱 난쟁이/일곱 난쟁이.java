import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dwarfs = new int[9];
        int sum =0;
        int remove1=0, remove2=0;

        for(int i = 0; i < dwarfs.length; i++){
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }

        Arrays.sort(dwarfs);

        for(int i = 0; i < dwarfs.length-1; i++){
            for (int j = i+1; j<dwarfs.length; j++){
                if(sum - dwarfs[i] - dwarfs[j] == 100){
                    remove1 = dwarfs[i];
                    remove2 = dwarfs[j];
                    break;
                }
            }
        }

        for(int i = 0; i < dwarfs.length; i++){
            if(dwarfs[i]== remove1 || dwarfs[i] == remove2) continue;
            System.out.println(dwarfs[i]);
        }
    }
}