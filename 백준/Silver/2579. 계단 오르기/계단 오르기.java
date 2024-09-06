import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int count = Integer.parseInt(br.readLine());
        int[] floors = new int[count+1];
        int[] scores = new int[count+1];

        for(int i=1; i<floors.length; i++){
            floors[i] = Integer.parseInt(br.readLine());
        }

        scores[1] = floors[1];

        if(count>1){
            scores[2] = floors[1]+floors[2];

            for (int i = 3; i < floors.length; i++) {
                scores[i] = Math.max(scores[i-3]+floors[i-1], scores[i-2]) + floors[i];
            }
        }
        System.out.println(scores[count]);
    }
}