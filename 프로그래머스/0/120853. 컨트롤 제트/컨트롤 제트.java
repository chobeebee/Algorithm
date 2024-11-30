import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split(" ");
        Stack<String> stack = new Stack<>();
        
        for(int i=0; i<str.length; i++){
            
            if(str[i].equals("Z")){
                stack.pop();
                continue;
                
            }else{
                
                stack.add(str[i]);
            }
        }
        
        while(!stack.isEmpty()){
            
            answer += Integer.parseInt(stack.pop());
        }
        
        return answer;
    }
}