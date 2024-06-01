import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        List<String> namelist = new ArrayList<String>();

        int i = 0;
        StringBuilder result = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        while (st.hasMoreTokens()) {
            namelist.add(st.nextToken());
        }

        while (i < namelist.size()){
            String name = namelist.get(i).substring(0,1);
            result.append(name);
            i++;
        }

        System.out.println(result);
    }
}