import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int K = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < K; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                stack.pop();
            }else{
                stack.add(num);
            }
        }

        for(int i = 0; i < stack.size(); i++){
            sum += stack.get(i);
        }
        System.out.println(sum);
    }
}