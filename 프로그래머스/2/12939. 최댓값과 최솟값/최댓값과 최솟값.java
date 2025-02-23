import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int min =Integer.MAX_VALUE;
        int max =Integer.MIN_VALUE;
        
        for(String a : arr){
            int num = Integer.parseInt(a);
            
            min = Math.min(num,min);
            max = Math.max(num,max);
        }
        
        answer = min+ " " + max;
        
        return answer;
    }
}