import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        ArrayList<Integer> seq = new ArrayList<>();
        int sum = 0;

        for (int i = 1; seq.size() < end; i++) {
            for (int j = 0; j < i; j++) {
                seq.add(i);
            }
        }

        for (int i = start - 1; i < end; i++) {
            sum += seq.get(i);
        }

        System.out.println(sum);
    }
}