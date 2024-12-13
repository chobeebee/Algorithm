import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        String str = Arrays.toString(array);
        String[] arr = str.split("");
        
        for(String a : arr){
            if(a.equals("7")) answer++;
        }
        
        return answer;
    }
}