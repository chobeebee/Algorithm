import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] strArray = s.toCharArray();
        
        Arrays.sort(strArray);
        
        for(int i=0; i<s.length(); i++){
            
            int cnt = 0;
            
            for(int j=0; j<s.length(); j++){
                
                if(strArray[i] == strArray[j]){
                    cnt++;
                }
                
                if(cnt > 1) break;
            }
            
            if(cnt == 1){
                answer += strArray[i];
            }
        }
        
        return answer;
    }
}