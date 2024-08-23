import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int T;
    static int N;
    static int M;
    static Queue<Integer> level;
    static Queue<Integer> index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            level = new LinkedList<>();
            index = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                level.add(Integer.parseInt(st.nextToken()));
                index.add(j);
            }

            find();
        }
    }

    public static void eratos(int M, int N) {
        StringBuilder sb = new StringBuilder();
        int[] prime = new int[N + 1];
        
        for (int i = 2; i <= N; i++) {
            prime[i] = i;
        }
        
        for (int i = 2; i < N + 1; i++) {
            if (prime[i] == 0) {
                continue;
            }

            for (int j = 2 * i; j < N + 1; j += i) {
                prime[j] = 0;
            }
        }

        for(int i = M; i <= N; i++){
            if(prime[i] != 0){
                sb.append(prime[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void find() {
        int count = 1;

        while(!level.isEmpty()) {
            int max = Collections.max(level);
            int current = level.poll();
            int currentIdx = index.poll();

            if(current == max) {
                if(currentIdx == M) {
                    System.out.println(count);
                    break;
                }
                count++;

            } else {
                level.add(current);
                index.add(currentIdx);
            }
        }
    }
}