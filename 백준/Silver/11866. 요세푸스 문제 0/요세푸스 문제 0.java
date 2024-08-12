import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (list.size() != N) {
            for(int i=0; i<K; i++){
                if (i == K - 1) {
                    list.add(queue.poll());
                }else{
                    queue.add(queue.poll());
                }
            }
        }

        for(int i=0; i<N; i++){
            if(i != N - 1){
                sb.append(list.get(i)).append(", ");
            }else{
                sb.append(list.get(i));
            }
        }

        System.out.println("<"+ sb +">");
    }
}