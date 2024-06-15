import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String[] phone1 = br.readLine().split("");
        String[] phone2 = br.readLine().split("");

        List<Integer> all = new ArrayList<>();

        for(int i = 0; i < phone1.length; i++){
            all.add(Integer.parseInt(phone1[i]));
            all.add(Integer.parseInt(phone2[i]));
        }

        while (all.size() > 2) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < all.size() -1; i++) {
                int sum = all.get(i) + all.get(i + 1);
                temp.add(sum % 10);
            }
            all = temp;
        }

        System.out.println(all.get(0)+""+all.get(1));
    }
}