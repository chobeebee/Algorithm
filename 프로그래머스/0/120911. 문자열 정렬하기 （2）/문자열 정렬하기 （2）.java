import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        String str = my_string.toLowerCase();
        String[] arr = str.split("");
        
        Arrays.sort(arr);
        
        for(String a : arr){
            answer += a;
        }        
        
        return answer;
    }
}