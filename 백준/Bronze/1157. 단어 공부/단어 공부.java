import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String alpha = br.readLine().toUpperCase();
        HashMap<Character, Integer> countMap = new HashMap<>();

        for(char alphabet : alpha.toCharArray()){
            countMap.put(alphabet, countMap.getOrDefault(alphabet, 0) + 1);
        }

        int maxCount = Collections.max(countMap.values());

        List<Character> maxList = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            if(entry.getValue().equals(maxCount)){
                maxList.add(entry.getKey());
            }
        }

        if (maxList.size() > 1) {
            System.out.println("?");
        } else if (maxList.size() == 1) {
            System.out.println(maxList.get(0));
        }
    }
}