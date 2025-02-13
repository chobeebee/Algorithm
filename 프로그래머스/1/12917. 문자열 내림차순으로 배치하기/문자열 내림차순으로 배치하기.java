import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split("");
        String answer = "";
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        for(String a : arr) answer += a;
        
        return answer;
    }
}