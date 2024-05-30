import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long num = Long.parseLong(br.readLine());

        String[] fruits = {"STRAWBERRY", "BANANA", "LIME", "PLUM"};
        Map<String, Long> fruitsCount = new HashMap<>();

        for (String fruit : fruits) {
            fruitsCount.put(fruit, 0L);
        }

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            String fruit = st.nextToken();
            Long count = Long.parseLong(st.nextToken());

            if (fruitsCount.containsKey(fruit)) {
                fruitsCount.put(fruit, fruitsCount.get(fruit) + count);
            }
        }

        if(fruitsCount.containsValue(5L)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}