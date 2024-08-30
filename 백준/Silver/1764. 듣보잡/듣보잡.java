import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> list = new HashSet<>();
        TreeSet<String> common = new TreeSet<>();

        for (int i =0; i < N; i++) {
            list.add(br.readLine());
        }

        for (int i =0; i < M; i++) {
            String name = br.readLine();
            if(list.contains(name)){
                common.add(name);
            }
        }

        System.out.println(common.size());

        Iterator iter = common.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}