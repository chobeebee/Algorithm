import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        while(true){
            String str = br.readLine();
            if(str.equals(".")){
                break;
            }
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch == '(' || ch == '['){
                    stack.push(ch);
                }else if(ch == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        stack.push(ch);
                        break;
                    }
                    stack.pop();
                }else if(ch == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        stack.push(ch);
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}