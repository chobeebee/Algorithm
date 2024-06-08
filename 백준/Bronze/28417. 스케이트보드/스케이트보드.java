import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        int players = Integer.parseInt(br.readLine());
        int result=0;

        for (int i = 0; i < players; i++) {
            int[] scores = new int[7];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 7; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
            }

            int maxRun = Math.max(scores[0], scores[1]);

            int[] tricks = Arrays.copyOfRange(scores, 2, 7);
            Arrays.sort(tricks);
            int topTricks = tricks[3] + tricks[4];

            int finalScore = maxRun + topTricks;

            if(finalScore > result) {
                result = finalScore;
            }
        }

        System.out.println(result);
    }
}