import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        Map<Long, String> schoolMap = new HashMap<>();

        for(int i = 0; i < test; i++){
            int schoolNum = Integer.parseInt(br.readLine());
            for(int j = 0; j < schoolNum; j++){
                st = new StringTokenizer(br.readLine());

                String school = st.nextToken();
                long alcohol = Long.parseLong(st.nextToken());

                schoolMap.put(alcohol, school);
            }

            long max = schoolMap.keySet().stream().max(Long::compareTo).get();

            System.out.println(schoolMap.get(max));
        }
    }
}