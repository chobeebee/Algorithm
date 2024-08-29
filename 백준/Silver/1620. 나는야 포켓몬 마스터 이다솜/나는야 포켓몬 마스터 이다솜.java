import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer,String> numMap = new HashMap<>();
        Map<String,Integer> nameMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            numMap.put(i+1, name);
            nameMap.put(name, i+1);
        }

        for (int i = 1; i <= M; i++) {
            String ex = br.readLine();

            if(Character.isDigit(ex.charAt(0))){
                sb.append(numMap.get(Integer.parseInt(ex))).append("\n");
            }else{
                sb.append(nameMap.get(ex)).append("\n");
            }
        }

        System.out.println(sb);
    }
}