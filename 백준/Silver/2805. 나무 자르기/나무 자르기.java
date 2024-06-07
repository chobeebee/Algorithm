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

        st = new StringTokenizer(br.readLine());
        int treeNum = Integer.parseInt(st.nextToken());
        int take = Integer.parseInt(st.nextToken());
        long[] trees = new long[treeNum];
        long max;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < treeNum; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }

        max = Arrays.stream(trees).max().orElseThrow();

        long start = 0;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for(int i = 0; i < treeNum; i++) {
                if(trees[i] > mid) {
                    sum+=trees[i] - mid;
                }
            }

            if (sum >= take) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}