import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        String[] str = my_string.split("");
        
        for(int j=0; j<indices.length; j++){
            str[indices[j]]="";
        }
        
        for(int k=0; k<str.length; k++){
            answer+=str[k];
        }
        
        return answer;
    }
}