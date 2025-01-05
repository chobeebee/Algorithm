import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String str = String.valueOf(n);
        String[] strArr = str.split("");
        
        Arrays.sort(strArr, Collections.reverseOrder());
        
        str = "";
        for(String s : strArr){
            str += s;
        }
        
        answer = Long.parseLong(str);
        
        return answer;
    }
}