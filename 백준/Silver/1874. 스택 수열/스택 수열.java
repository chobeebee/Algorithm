import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int tmp = 1;

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            while (tmp <= num) {
                stack.push(tmp);
                tmp++;
                sb.append("+").append("\n");
            }

            if(stack.peek() == num){
                stack.pop();
                sb.append("-").append("\n");
            }else{
                sb = new StringBuilder();
                sb.append("NO").append("\n");
                break;
            }
        }
        System.out.println(sb);
    }
}