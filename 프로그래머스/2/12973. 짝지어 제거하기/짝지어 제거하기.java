import java.util.*;

class Solution{
    public int solution(String s){

        Stack<Character> stack = new Stack<>();
        
        //문자열 탐색
        for(char c : s.toCharArray()){
            
            //현재 문자가 stack에서 꺼낼 값과 같다면
            if(!stack.isEmpty() && stack.peek() == c){
                //stack에서 제거
                stack.pop();
                
            }else{
                //아니면 stack에 넣기
                stack.push(c);
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}