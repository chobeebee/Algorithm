import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0) {
                break;
            }

            if(a * a + b * b == c * c) {
                System.out.println("right");
            }else if(a * a + c * c == b * b){
                System.out.println("right");
            } else if(c * c + b * b == a * a) {
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }
    }
}