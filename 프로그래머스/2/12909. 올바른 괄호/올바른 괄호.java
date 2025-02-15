import java.util.Stack;

class Solution {
    boolean solution(String s) {
        
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '(') {
                st.push(arr[i]);
            } else if(arr[i] == ')') {
                if(st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
        }

        return st.isEmpty();
    }
}