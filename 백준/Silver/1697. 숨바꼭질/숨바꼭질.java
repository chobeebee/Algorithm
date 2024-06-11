import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {
    static int[] move = new int[100001];
    static int subin, sister;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        subin = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());

        if (subin == sister) {
            System.out.println(0);
        } else{
            bfs(subin);
        }
    }

    private static void bfs(int subin) {
        Queue<Integer> queue = new LinkedList<>();
        move[subin]  = 1;
        queue.add(subin);

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int now = queue.poll();

                for (int j = 0; j < 3; j++) {
                    int walk;

                    if (j == 0) {
                        walk = now + 1;
                    } else if (j == 1) {
                        walk = now - 1;
                    } else {
                        walk = now * 2;
                    }

                    if (walk == sister) {
                        System.out.println(move[now]);
                        return;
                    }

                    if ( walk >= 0 && walk < move.length && move[walk] == 0 ) {
                        queue.add(walk);
                        move[walk] = move[now]+1;
                    }
                }
            }
        }
    }
}